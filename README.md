# VIP 会员等级模块

> 基于 `easyfk` 基础框架的 **C 端会员等级与付费套餐**管理模块，提供 VIP 等级、套餐定价（原价 / 首购价 / 活动价）、VIP 订单与自动续期能力，同时支持 **Spring Cloud（Feign）** 与 **Apache Dubbo** 两种远程调用方式，方便单体或微服务架构集成。

- **项目版本**：`<latest>`（请以实际发布的最新版本为准）
- **Maven Group**：`com.mcst`
- **构建工具**：Gradle（版本以根 `gradle/wrapper/gradle-wrapper.properties` 为准）
- **JDK**：Java 21+
- **框架**：Spring Boot 3.x、Spring Cloud OpenFeign、Apache Dubbo 3.x
- **辅助工具**：Lombok、MapStruct Plus、Hutool

---

## 一、项目主要功能

1. **VIP 等级**
   - 自定义会员等级（等级编码、名称、权益介绍）。

2. **套餐管理**
   - 每个等级可配置多个套餐，支持原价、首购价、活动价三种定价。

3. **VIP 订单**
   - VIP 购买与续费的订单记录。
   - VIP 订单写入前先检查订单号是否已存在，防止重复创建（幂等保护）。

4. **自动续期**
   - 支付成功后自动延长有效期，支持永久会员（days=-1）。
   - VIP 有效期智能累加，续费时在当前到期时间基础上叠加，避免用户损失剩余时长。

5. **智能定价**
   - 自动识别新老用户——新用户显示首购价，老用户显示活动价或原价。

6. **与 User 模块协同**
   - 支付成功后自动调用 User 模块更新用户 VIP 状态与过期时间。

7. **多租户与数据隔离**
   - 内置 `agentId` / `merchantId` 字段，自动按代理商 / 商户维度过滤数据。

8. **国际化与可配置**
   - 多语言错误码（基于 `i18n/vipMessage_*.properties`）。

---

## 二、项目架构设计

### 2.1 模块划分

```
vip
├── vip-api          接口契约层：DTO / Req / Resp / Param / VO / Service API
├── vip-server       服务实现层：Service + ApiServer 实现 + 工具类 + 配置 + 单测
├── vip-prd          Web 表现层：Spring Boot Controller
│   ├── vip-prd-client     C 端接口
│   └── vip-prd-bms        后台管理接口
├── vip-orm          持久化层
│   ├── vip-orm-api         仓储接口定义（IRepository）
│   ├── vip-orm-plus        MyBatis-Plus 实现
│   ├── vip-orm-flex        MyBatis-Flex 实现
│   └── vip-orm-hibernate   Hibernate/JPA 实现
├── vip-remote       远程调用层（可选接入）
│   ├── vip-cloud-api         Spring Cloud 客户端：Feign 接口 + Api 适配
│   ├── vip-cloud-provider    Spring Cloud 服务端：暴露 /remote/vip/** 的 Controller
│   ├── vip-dubbo-api         Dubbo 接口 + Api 适配
│   └── vip-dubbo-provider    Dubbo 服务端实现
└── doc               数据库脚本与映射规范说明
    ├── sql/vip_mysql.sql
    └── sql/vip_postgresql.sql
```

### 2.2 层次与调用关系

```
┌──────────────────────────────────────────────────────────────────────┐
│  客户端 / 调用方                                                       │
└──────────────────────────────────────────────────────────────────────┘
            │                           │                        │
            ▼                           ▼                        ▼
     ┌────────────┐               ┌────────────┐           ┌────────────┐
     │  vip-prd   │               │  vip-      │           │  vip-      │
     │ -client/-  │               │ cloud-api  │           │ dubbo-api  │
     │  bms       │               │ (Feign 客  │           │ (Dubbo 消  │
     │(Controller │               │ 户端+Api)  │           │ 费端+Api)  │
     └────────────┘               └────────────┘           └────────────┘
            │                           │                        │
            │                           │ HTTP                   │ Dubbo RPC
            ▼                           ▼                        ▼
                          ┌──────────────────────────────────────┐
                          │ vip-cloud-provider / vip-dubbo-       │
                          │ provider （统一委托给 vip-server）    │
                          └──────────────────────────────────────┘
                                              │
                                              ▼
                              ┌──────────────────────────────┐
                              │          vip-server           │
                              │   Service + ApiServer 实现   │
                              └──────────────────────────────┘
                                              │
            ┌─────────────────────────────────┼────────────────────────┐
            ▼                                 ▼                        ▼
     ┌────────────┐                   ┌────────────┐           ┌────────────┐
     │   User     │                   │  Payment   │           │  Trading   │
     │（更新 VIP  │                   │ （支付     │           │ （下单/    │
     │  状态/过期 │                   │  回调）    │           │  回调）    │
     │   时间）   │                   │            │           │            │
     └────────────┘                   └────────────┘           └────────────┘
                                              │
                                              ▼
                              ┌──────────────────────────────┐
                              │  vip-orm-*（Plus/Flex/Hib）  │
                              │   仓储接口 + 持久化实现        │
                              └──────────────────────────────┘
                                              │
                                              ▼
                                          数据库
```

### 2.3 关键设计点

- **接口与实现分离**：`vip-api` 只暴露接口与数据模型；`vip-server` 提供本地默认实现，通过 Spring Boot 自动装配以 `@ConditionalOnMissingBean` 形式暴露为 Bean，便于上层覆盖。
- **多 ORM 适配**：`vip-orm` 把仓储接口抽到 `vip-orm-api`，底层分别在 `vip-orm-plus / vip-orm-flex / vip-orm-hibernate` 中提供实现，业务侧按需引入对应依赖即可切换 ORM。
- **远程调用可插拔**：`vip-remote` 同时提供 Feign 和 Dubbo 两套客户端，每套又拆出 `-api`（消费端）与 `-provider`（服务端）。消费端把 `IVipApi`、`IVipOrderApi`、`IVipComboApi` 等适配到远程 `Remote`，再通过 `@AutoConfiguration` 注册到容器；服务端把 `vip-server` 的 `Service` 透出成 HTTP / Dubbo 接口。
- **统一参数模型**：遵循 `doc/实体对象映射关系调整指南.md` 中约定的流向（`Sub → Req → Dto → Entity` / `Entity → Dto → Resp`），结合 MapStruct Plus 的 `@AutoMapper` 自动转换。
- **智能定价**：自动识别新老用户——新用户显示首购价，老用户显示活动价或原价。
- **幂等保护**：VIP 订单写入前先检查订单号是否已存在，防止重复创建。
- **有效期智能累加**：续费时在当前到期时间基础上叠加，避免用户损失剩余时长；支持永久会员（days=-1）。
- **声明式权限控制**：BMS 端通过 `@AuthResource` / `@ResourceController` 注解自动注册菜单与按钮权限，与 Auth 模块联动。

### 2.4 数据模型

| 表名 | 说明 |
| --- | --- |
| `vip_level` | VIP 等级表，含等级编码、名称、权益介绍、排序、租户等 |
| `vip_combo` | VIP 套餐表，含等级编码、原价、首购价、活动价、有效天数、状态等 |
| `vip_order` | VIP 订单表，含订单号、用户、套餐、金额、支付状态、有效期等 |

完整建表脚本见 [doc/sql/vip_mysql.sql](doc/sql/vip_mysql.sql)、[doc/sql/vip_postgresql.sql](doc/sql/vip_postgresql.sql)。

---

## 三、模块详细说明

### 3.1 `vip-api`
- 定义业务接口：`IVipApi`、`IVipComboApi`、`IVipOrderApi` 等，并继承 `IBaseApi` 提供通用 CRUD。
- 维护所有数据传输对象：`dto/`、`request/`/`response/`/`param/`/`vo/`。
- 业务接口方法示例：`queryLevels`、`queryCombos`、`computePrice`、`createOrder`、`payCallback`、`renew`、`queryByPage` 等。

### 3.2 `vip-server`
- `service/`：业务 Service 接口与实现（`VipServiceImpl`、`VipComboServiceImpl`、`VipOrderServiceImpl`）。
- `impl/`：`ApiServer` 实现，继承 `BaseApiServiceImpl`，把 Service 暴露为对应 API。
- `util/`：价格计算、有效期计算、用户新老识别等工具类。
- `properties/`：`VipProperties`（`easyfk.config.vip`）。
- `config/VipServerConfig`：Spring Boot 自动装配入口。
- `src/test/`：基于 JUnit 5 的单元测试。

### 3.3 `vip-prd`
- 基于 `easyfk-web-prd` 的 Spring Boot Web 控制器层。
- 控制器清单：
  - `VipClientController`：`/api/client/vip/**`（等级列表、套餐列表、价格计算、开通 / 续费）
  - `VipBmsController`：`/api/bms/vip/**`（等级、套餐、订单完整管理）
- 通过 `@AuthResource` / `@ResourceController` 注解自动注册权限元数据。

### 3.4 `vip-orm`
- `vip-orm-api`：仓储接口（`IVipLevelRepository`、`IVipComboRepository`、`IVipOrderRepository`）。
- `vip-orm-plus`：基于 MyBatis-Plus 的实现 + 自动装配。
- `vip-orm-flex`：基于 MyBatis-Flex 的实现 + 自动装配。
- `vip-orm-hibernate`：基于 Hibernate/JPA 的实现 + 自动装配。

> 三个 ORM 实现互斥，按需在业务工程中只引入其中一个，避免冲突。

### 3.5 `vip-remote`
- `vip-cloud-api`：`FeignClient` 接口 + 继承 `BaseApiRemoteImpl` 的 `Api` 实现；通过 `VipApiProperties`（`easyfk.config.remote.vip.service-id/base-path`）读取服务地址。
- `vip-cloud-provider`：`@RestController` 把 `vip-server` 的 `Service` 暴露为 `/remote/vip/**`。
- `vip-dubbo-api`：Dubbo 接口 + `Api` 适配实现。
- `vip-dubbo-provider`：Dubbo 服务实现。

### 3.6 `doc`
- `实体对象映射关系调整指南.md`：DTO/Entity/Req/Resp/Param/Sub 之间的 `@AutoMapper` 使用规范。
- `sql/`：MySQL、PostgreSQL 建表脚本。

---

## 四、使用方式

### 4.1 构建与发布

```bash
# 清理并编译全部模块
./gradlew clean build

# 发布到本地 Maven 仓库
./gradlew publishToMavenLocal

# 发布到远程 Nexus（在 build.gradle 中已配置 NexusRepository）
./gradlew publish
```

> Windows 环境可直接使用 `gradlew.bat`。模块统一版本：`<latest>`。

### 4.2 单体应用集成（最简方式）

```groovy
dependencies {
    implementation 'com.mcst:vip-api:<latest>'
    implementation 'com.mcst:vip-server:<latest>'
    // 选择一种 ORM：
    implementation 'com.mcst:vip-orm:vip-orm-plus:<latest>'
    // implementation 'com.mcst:vip-orm:vip-orm-flex:<latest>'
    // implementation 'com.mcst:vip-orm:vip-orm-hibernate:<latest>'

    // 暴露 HTTP 接口（按端选择）
    implementation 'com.mcst:vip-prd:vip-prd-bms:<latest>'
    implementation 'com.mcst:vip-prd:vip-prd-client:<latest>'
}
```

`vip-server` 会通过 Spring Boot 自动装配把 `IVipApi`、`IVipComboApi`、`IVipOrderApi` 等 Bean 注册到容器，Controller 可直接 `@Resource` 注入使用。

### 4.3 微服务集成（Spring Cloud）

**消费端：**

```groovy
dependencies {
    implementation 'com.mcst:vip-api:<latest>'
    implementation 'com.mcst:vip-remote:vip-cloud-api:<latest>'
}
```

```yaml
easyfk:
  config:
    remote:
      vip:
        service-id: vip-server          # 对应服务在注册中心的服务名
        base-path: /remote              # 可选，默认 /remote
```

**服务端：** 启动 `vip-server` 并加入 `vip-remote:vip-cloud-provider`，即可对外提供 `/remote/vip/**` 接口。

### 4.4 微服务集成（Apache Dubbo）

```groovy
// 消费端
dependencies {
    implementation 'com.mcst:vip-api:<latest>'
    implementation 'com.mcst:vip-remote:vip-dubbo-api:<latest>'
}

// 服务端
dependencies {
    implementation 'com.mcst:vip-server:<latest>'
    implementation 'com.mcst:vip-remote:vip-dubbo-provider:<latest>'
}
```

### 4.5 关键配置项

| 配置项 | 含义 | 默认值 |
| --- | --- | --- |
| `easyfk.config.vip.first-purchase.enabled` | 是否启用首购价 | `true` |
| `easyfk.config.remote.vip.service-id` | 远程调用目标服务名 | `vip-server` |
| `easyfk.config.remote.vip.base-path` | 远程调用基础路径 | `/remote` |

### 4.6 初始化数据库

```bash
# MySQL
mysql -u <user> -p <database> < doc/sql/vip_mysql.sql

# PostgreSQL
psql -U <user> -d <database> -f doc/sql/vip_postgresql.sql
```

### 4.7 主要 REST 接口一览

| 端 | 路径 | 方法 | 说明 |
| --- | --- | --- | --- |
| Client | `/api/client/vip/levels` | GET | C 端等级列表 |
| Client | `/api/client/vip/combos` | GET | C 端套餐列表 |
| Client | `/api/client/vip/computePrice` | GET | 计算应付价格 |
| Client | `/api/client/vip/open` | POST | 开通 VIP |
| Client | `/api/client/vip/renew` | POST | 续费 VIP |
| Client | `/api/client/vip/myVip` | GET | 当前用户 VIP 信息 |
| BMS | `/api/bms/vip/level/queryPage` | GET | 等级分页 |
| BMS | `/api/bms/vip/level/addOrEdit` | POST | 等级新增 / 编辑 |
| BMS | `/api/bms/vip/combo/queryPage` | GET | 套餐分页 |
| BMS | `/api/bms/vip/combo/addOrEdit` | POST | 套餐新增 / 编辑 |
| BMS | `/api/bms/vip/order/queryPage` | GET | 订单分页 |

> 接口均通过 Swagger OpenAPI 注解描述，可在启动后访问 `/swagger-ui.html` 查看完整文档。

---

## 五、扩展指引

- **新增业务字段**：在 `vip-api` 的 `Dto` 中新增字段 → 在 `Entity` 中同步 → 选择对应 ORM 模块更新映射 → 视情况更新 `Resp`、`Req`、`VO`。
- **新增定价策略**：在 `PriceStrategyEnum` 中新增策略 → 在 `PriceCalculator` 中实现对应计算逻辑。
- **新增业务接口**：在 `vip-api` 暴露方法 → 在 `vip-server` 的 `Service` 与 `ApiServer` 中实现 → 选择在 `vip-prd` 增加 Controller 或在 `vip-remote` 暴露远程能力。
- **切换 ORM**：只保留目标 ORM 模块的依赖（如只想用 MyBatis-Plus，则移除 `vip-orm-flex`、`vip-orm-hibernate` 依赖）。
- **国际化**：在 `vip-server/src/main/resources/i18n/` 下追加语言键值即可。

---

## 六、目录速览

```
vip
├── build.gradle                根构建脚本（统一版本、Java 21、Lombok、MapStruct Plus）
├── settings.gradle             多模块声明
├── gradle/, gradlew, gradlew.bat
├── vip-api/                    接口契约
├── vip-server/                 服务实现 + 单测
├── vip-prd/
│   ├── vip-prd-client/
│   └── vip-prd-bms/
├── vip-orm/
│   ├── vip-orm-api/
│   ├── vip-orm-plus/
│   ├── vip-orm-flex/
│   └── vip-orm-hibernate/
├── vip-remote/
│   ├── vip-cloud-api/
│   ├── vip-cloud-provider/
│   ├── vip-dubbo-api/
│   └── vip-dubbo-provider/
└── doc/
    └── sql/
```
