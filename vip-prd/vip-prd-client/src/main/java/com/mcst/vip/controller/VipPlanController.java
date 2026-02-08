package com.mcst.vip.controller;

import com.mcst.vip.api.response.VipPlanResp;
import com.mcst.vip.api.request.VipPlanReq;
import com.mcst.vip.api.request.VipPlanEditReq;
import com.mcst.vip.api.IVipPlanApi;
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
* VIP套餐相关接口
* @author liu yijun
* @since 2026-01-28
*/
@Tag(name = "VIP套餐相关接口", description = "VIP套餐相关接口")
@ResponseBody
@RequestMapping("/api/vip/vipPlan")
public class VipPlanController {
    @Resource
    private IVipPlanApi vipPlanApi;


    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<VipPlanResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.vipPlanApi.queryById(id));
    }
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<VipPlanResp>> queryPage(@Validated VipPlanReq vipPlanReq) {
        SearchRequest<VipPlanReq> requestParam = SRPBuilder.buildRequest(vipPlanReq);
        return RRBuilder.buildBodyByPageResult(this.vipPlanApi.queryByPage(requestParam));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody VipPlanEditReq vipPlanEditReq) {
        ModifyRequest<VipPlanReq> requestParam = MRPBuilder.buildRequest(vipPlanEditReq,VipPlanReq.class);
        return RRBuilder.buildBodyByBaseResult(this.vipPlanApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<VipPlanReq> requestParam = MRPBuilder.<VipPlanReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.vipPlanApi.delete(requestParam));
    }

}
