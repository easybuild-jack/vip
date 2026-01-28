package com.mcst.vip.controller;

import com.mcst.core.entity.ResponseResult;
import com.mcst.service.core.prd.RRBuilder;
import com.mcst.vip.api.IVipApi;
import com.mcst.vip.api.dto.VipInfoResp;
import com.mcst.vip.api.param.VipInfoReq;
import com.mcst.web.annotation.LoginResource;
import com.mcst.web.context.UserDataContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * VIP会员 客户端控制器 (To C)
 *
 * @author easyfk
 */
@Tag(name = "VIP会员接口")
@RestController
@RequestMapping("/api/customer/vip")
public class VipInfoController {

    @Resource
    private IVipApi vipApi;

    @LoginResource
    @Operation(summary = "获取我的VIP信息")
    @GetMapping("/myVip")
    public ResponseResult<VipInfoResp> myVip() {
        String userId = UserDataContext.getUserData().getUserId();
        return RRBuilder.buildSuccessBody(this.vipApi.queryByUserId(userId));
    }

    @LoginResource
    @Operation(summary = "根据ID查询VIP信息")
    @GetMapping("/info/{vipId}")
    public ResponseResult<VipInfoResp> info(@PathVariable String vipId) {
        return RRBuilder.buildSuccessBody(this.vipApi.queryVipInfo(vipId));
    }

    @LoginResource
    @Operation(summary = "开通VIP")
    @PostMapping("/open")
    public ResponseResult<VipInfoResp> openVip(@RequestBody VipInfoReq req) {
        // 设置当前用户ID
        req.setUserId(UserDataContext.getUserData().getUserId());
        return RRBuilder.buildSuccessBody(this.vipApi.add(req));
    }
}
