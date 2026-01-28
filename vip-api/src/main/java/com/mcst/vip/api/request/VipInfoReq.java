package com.mcst.vip.api.request;

import com.mcst.core.entity.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * VIP会员请求对象
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "VIP会员请求对象")
@SuperBuilder
@NoArgsConstructor
public class VipInfoReq extends BaseReq {

    @Schema(description = "VIP会员ID")
    private String vipId;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "VIP等级ID")
    private String levelId;

    @Schema(description = "到期时间")
    private LocalDateTime expireTime;
}
