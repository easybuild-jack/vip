package com.mcst.vip.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.vip.api.dto.VipInfoDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

/**
* 作者: liu yijun
* 日期: 2026-01-28
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "vip_info")
@AutoMapper(target = VipInfoDto.class)
public class VipInfo extends BaseHibernateEntity {

    /**
     * VIP信息ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "vip_info_id")
    private String vipInfoId;

    /**
     * VIP编号
     */
    @Column(name = "vip_code")
    private String vipCode;

    /**
     * VIP名称
     */
    @Column(name = "vip_name")
    private String vipName;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    @Column(name = "forbidden_flag")
    private Integer forbiddenFlag;

    /**
     * 介绍
     */
    @Column(name = "description")
    private String description;
}
