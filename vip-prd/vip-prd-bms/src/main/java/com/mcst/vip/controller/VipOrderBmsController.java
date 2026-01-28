package com.mcst.vip.controller;

import com.mcst.vip.api.response.VipOrderResp;
import com.mcst.vip.api.request.VipOrderReq;
import com.mcst.vip.api.request.VipOrderEditReq;
import com.mcst.vip.api.IVipOrderApi;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.builders.MRPBuilder;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.easyfk.core.builders.RRBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mcst.easyfk.core.dto.request.BatchBasicReq;
import com.mcst.easyfk.core.utils.common.SplitUtil;
import jakarta.annotation.Resource;
import java.util.List;


/**
* VIP订单相关接口
* @author liu yijun
* @since 2026-01-28
*/
@Tag(name = "VIP订单相关接口", description = "VIP订单相关接口")
@RestController
@RequestMapping("/api/bms/vip/vipOrder")
public class VipOrderBmsController {
    @Resource
    private IVipOrderApi vipOrderApi;

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<VipOrderResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.vipOrderApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<VipOrderResp>> queryPage(@Validated VipOrderReq vipOrderReq) {
        SRPBuilder<VipOrderReq> builder = SRPBuilder.<VipOrderReq>builder().example(vipOrderReq);
        return RRBuilder.buildBodyByPageResult(this.vipOrderApi.queryByPage(builder.build()));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody VipOrderEditReq vipOrderEditReq) {
        ModifyRequest<VipOrderReq> requestParam = MRPBuilder.buildRequest(vipOrderEditReq, VipOrderReq.class);
        return RRBuilder.buildBodyByBaseResult(this.vipOrderApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<VipOrderReq> requestParam = MRPBuilder.<VipOrderReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.vipOrderApi.delete(requestParam));
    }

}
