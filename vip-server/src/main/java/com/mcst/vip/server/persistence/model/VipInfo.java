package com.mcst.vip.server.persistence.model;

import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mcst.vip.api.dto.VipInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;

/**
* 作者: liu yijun
* 日期: 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("vip_info")
@AutoMapper(target = VipInfoDto.class)
public class VipInfo extends BaseMyBatisPlusEntity<VipInfo> {


    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "VIP信息ID")
    private String vipInfoId;

    /**
     * VIP编号
     */
    @Column(comment = "VIP编号")
    private String vipCode;

    /**
     * VIP名称
     */
    @Column(comment = "VIP名称")
    private String vipName;

    /**
     * 禁用状态 0可用，1禁用
     */
    @Column(comment = "禁用状态 0可用，1禁用")
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;

    /**
     * 介绍
     */
    @Column(comment = "介绍")
    private String description;
}