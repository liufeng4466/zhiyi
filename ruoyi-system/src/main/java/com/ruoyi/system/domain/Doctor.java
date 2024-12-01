package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医生对象 doctor
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
public class Doctor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主建ID */
    private Long id;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String name;

    /** 医生手机号 */
    @Excel(name = "医生手机号")
    private Long phone;

    /** 医生简介 */
    @Excel(name = "医生简介")
    private String snapshot;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long departmentId;

    /** 科室名称 */
    @Excel(name = "科室名称")
    private String departmentName;

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
    public void setPhone(Long phone) 
    {
        this.phone = phone;
    }

    public Long getPhone() 
    {
        return phone;
    }
    public void setSnapshot(String snapshot) 
    {
        this.snapshot = snapshot;
    }

    public String getSnapshot() 
    {
        return snapshot;
    }
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() 
    {
        return departmentName;
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
            .append("phone", getPhone())
            .append("snapshot", getSnapshot())
            .append("departmentId", getDepartmentId())
            .append("departmentName", getDepartmentName())
            .append("createUserId", getCreateUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateUserId", getUpdateUserId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
