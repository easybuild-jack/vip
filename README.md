# VIP 模块

基于 easyfk 架构规范构建的 VIP 会员模块。

## 模块结构

```
vip/
├── vip-api/                     # API层 - 接口契约定义
│   └── src/main/java/com/mcst/vip/api/
│       ├── IVipApi.java         # VIP业务接口
│       ├── dto/                 # 数据传输对象
│       ├── param/               # 查询/请求参数
│       └── enums/               # 业务枚举
│
├── vip-server/                  # 业务实现层
│   └── src/main/java/com/mcst/vip/server/
│       ├── persistence/         # 持久化层
│       │   ├── model/           # 实体类
│       │   └── mapper/          # MyBatis Mapper
│       ├── repository/          # 仓储层
│       ├── service/             # 业务逻辑层
│       └── impl/                # API实现
│
├── vip-prd/                     # 产品/接口层
│   ├── vip-prd-client/          # To C 客户端接口
│   └── vip-prd-bms/             # To B 管理后台接口
│
├── vip-remote/                  # 分布式/远程调用层
│   ├── vip-cloud-api/           # Spring Cloud Feign接口
│   ├── vip-cloud-provider/      # Spring Cloud 实现
│   ├── vip-dubbo-api/           # Dubbo接口
│   └── vip-dubbo-provider/      # Dubbo实现
│
└── doc/                         # 文档和脚本
    └── sql/                     # 数据库初始化脚本
```

## 快速开始

### 1. 初始化数据库

根据您的数据库类型，执行相应的初始化脚本：

- MySQL: `doc/sql/vip_mysql.sql`
- PostgreSQL: `doc/sql/vip_pg.sql`

### 2. Gradle 构建

```bash
# 在项目根目录执行
./gradlew build
```

### 3. 使用模块

在需要使用 VIP 模块的项目中添加依赖：

```gradle
dependencies {
    // 使用 API 层（推荐）
    implementation project(':vip-api')
    
    // 使用 Cloud 远程调用
    implementation project(':vip-cloud-api')
    
    // 使用 Dubbo 远程调用
    implementation project(':vip-dubbo-api')
}
```

## 功能说明

### VIP会员管理
- 开通VIP
- 续费VIP
- 查询VIP信息
- VIP等级管理

### 积分管理
- 积分获取
- 积分消费
- 积分记录查询

## API 接口

### 客户端接口 (To C)
| 接口 | 方法 | 说明 |
|-----|------|-----|
| `/api/customer/vip/myVip` | GET | 获取我的VIP信息 |
| `/api/customer/vip/info/{vipId}` | GET | 根据ID查询VIP信息 |
| `/api/customer/vip/open` | POST | 开通VIP |

### 管理后台接口 (To B)
| 接口 | 方法 | 说明 |
|-----|------|-----|
| `/api/bms/vip/page` | GET | 分页查询VIP列表 |
| `/api/bms/vip/info/{vipId}` | GET | 查询VIP详情 |
| `/api/bms/vip/add` | POST | 新增VIP |
| `/api/bms/vip/update` | PUT | 更新VIP |
| `/api/bms/vip/delete/{vipId}` | DELETE | 删除VIP |

## 技术栈

- Java 21
- Spring Boot 3.2.12
- MyBatis Plus
- MapStruct Plus
- Gradle

## 版本信息

- 版本: 3.2.12
- 作者: easyfk
