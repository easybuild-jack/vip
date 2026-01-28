package com.mcst.vip.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.core.params.PrimaryKey;
import com.mcst.orm.mybatis.core.BaseMyBatisPlusEntity;
import com.mcst.vip.api.dto.VipInfoDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * VIP信息
 *
 * @author easyfk
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("vip_info")
@AutoMapper(target = VipInfoDto.class)
public class VipInfo extends BaseMyBatisPlusEntity<VipInfo> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String vipId;

    /**
     * VIP编号
     */
    private String vipCode;

    /**
     * VIP名称
     */
    private String vipName;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;

    /**
     * 介绍
     */
    private String description;

}
