package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科室对象 department
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
public class Department extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 科室名称 */
    @Excel(name = "科室名称")
    private String name;

    /** 科室简介 */
    @Excel(name = "科室简介")
    private String snapshot;

    /** 医院ID */
    @Excel(name = "医院ID")
    private Long hospitalId;

    /** 医院名称 */
    @Excel(name = "医院名称")
    private String hospitalName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

    /** 修改人ID */
    @Excel(name = "修改人ID")
    private Long updateUserId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSnapshot(String snapshot) 
    {
        this.snapshot = snapshot;
    }

    public String getSnapshot() 
    {
        return snapshot;
    }
    public void setHospitalId(Long hospitalId) 
    {
        this.hospitalId = hospitalId;
    }

    public Long getHospitalId() 
    {
        return hospitalId;
    }
    public void setHospitalName(String hospitalName) 
    {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() 
    {
        return hospitalName;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }
    public void setUpdateUserId(Long updateUserId) 
    {
        this.updateUserId = updateUserId;
    }

    public Long getUpdateUserId() 
    {
        return updateUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("snapshot", getSnapshot())
            .append("hospitalId", getHospitalId())
            .append("hospitalName", getHospitalName())
            .append("createUserId", getCreateUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateUserId", getUpdateUserId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
