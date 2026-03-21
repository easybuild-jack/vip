package com.mcst.vip.orm.plus.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.repository.persistence.annotation.EntityColumn;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.vip.api.dto.VipInfoDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    @EntityColumn(comment = "VIP信息ID")
    private String vipInfoId;

    /**
     * VIP编号
     */
    @EntityColumn(comment = "VIP编号")
    private String vipCode;

    /**
     * VIP名称
     */
    @EntityColumn(comment = "VIP名称")
    private String vipName;

    /**
     * 禁用状态 0可用，1禁用
     */
    @EntityColumn(comment = "禁用状态 0可用，1禁用")
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;

    /**
     * 介绍
     */
    @EntityColumn(comment = "介绍")
    private String description;
}
