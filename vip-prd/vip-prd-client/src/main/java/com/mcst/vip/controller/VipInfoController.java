package com.mcst.vip.controller;

import com.mcst.vip.api.response.VipInfoResp;
import com.mcst.vip.api.request.VipInfoReq;
import com.mcst.vip.api.request.VipInfoEditReq;
import com.mcst.vip.api.IVipInfoApi;
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
* VIP信息相关接口
* @author liu yijun
* @since 2026-01-28
*/
@Tag(name = "VIP信息相关接口", description = "VIP信息相关接口")
@RestController
@RequestMapping("/api/vip/vipInfo")
public class VipInfoController {
    @Resource
    private IVipInfoApi vipInfoApi;


    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<VipInfoResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.vipInfoApi.queryById(id));
    }
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<VipInfoResp>> queryPage(@Validated VipInfoReq vipInfoReq) {
        SearchRequest<VipInfoReq> requestParam = SRPBuilder.buildRequest(vipInfoReq);
        return RRBuilder.buildBodyByPageResult(this.vipInfoApi.queryByPage(requestParam));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody VipInfoEditReq vipInfoEditReq) {
        ModifyRequest<VipInfoReq> requestParam = MRPBuilder.buildRequest(vipInfoEditReq,VipInfoReq.class);
        return RRBuilder.buildBodyByBaseResult(this.vipInfoApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<VipInfoReq> requestParam = MRPBuilder.<VipInfoReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.vipInfoApi.delete(requestParam));
    }

}
