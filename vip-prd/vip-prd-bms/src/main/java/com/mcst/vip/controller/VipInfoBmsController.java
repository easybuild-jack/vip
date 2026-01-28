package com.mcst.vip.controller;

import com.mcst.core.entity.PageResult;
import com.mcst.core.entity.ResponseResult;
import com.mcst.service.core.prd.RRBuilder;
import com.mcst.vip.api.IVipApi;
import com.mcst.vip.api.dto.VipInfoResp;
import com.mcst.vip.api.param.VipInfoParam;
import com.mcst.vip.api.param.VipInfoReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * VIP会员 管理后台控制器 (To B)
 *
 * @author easyfk
 */
@Tag(name = "VIP会员管理接口")
@RestController
@RequestMapping("/api/bms/vip")
public class VipInfoBmsController {

    @Resource
    private IVipApi vipApi;

    @Operation(summary = "分页查询VIP列表")
    @GetMapping("/page")
    public ResponseResult<PageResult<VipInfoResp>> page(VipInfoParam param) {
        return RRBuilder.buildSuccessBody(this.vipApi.pageByParam(param));
    }

    @Operation(summary = "根据ID查询VIP详情")
    @GetMapping("/info/{vipId}")
    public ResponseResult<VipInfoResp> info(@PathVariable String vipId) {
        return RRBuilder.buildSuccessBody(this.vipApi.queryById(vipId));
    }

    @Operation(summary = "新增VIP")
    @PostMapping("/add")
    public ResponseResult<VipInfoResp> add(@RequestBody VipInfoReq req) {
        return RRBuilder.buildSuccessBody(this.vipApi.add(req));
    }

    @Operation(summary = "更新VIP")
    @PutMapping("/update")
    public ResponseResult<VipInfoResp> update(@RequestBody VipInfoReq req) {
        return RRBuilder.buildSuccessBody(this.vipApi.update(req));
    }

    @Operation(summary = "删除VIP")
    @DeleteMapping("/delete/{vipId}")
    public ResponseResult<Boolean> delete(@PathVariable String vipId) {
        return RRBuilder.buildSuccessBody(this.vipApi.deleteById(vipId));
    }
}
