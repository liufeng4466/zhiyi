package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医院对象 hospital
 * 
 * @author ruoyi
 * @date 2024-12-02
 */
public class Hospital extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 医院名称 */
    @Excel(name = "医院名称")
    private String name;

    /** 医院电话 */
    @Excel(name = "医院电话")
    private String telephone;

    /** 医院地址 */
    @Excel(name = "医院地址")
    private String address;

    /** 医院简介 */
    @Excel(name = "医院简介")
    private String snapshot;

    /** 医院所在城市主键ID */
    @Excel(name = "医院所在城市")
    private String city;

    /** 经度 */
    @Excel(name = "经度")
    private String lng;

    /** 纬度 */
    @Excel(name = "纬度")
    private String lat;

    /** 病分类 */
    @Excel(name = "病分类")
    private String diseaseType;

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
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setSnapshot(String snapshot) 
    {
        this.snapshot = snapshot;
    }

    public String getSnapshot() 
    {
        return snapshot;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }

    public void setLng(String lng)
    {
        this.lng = lng;
    }

    public String getLng() 
    {
        return lng;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setDiseaseType(String diseaseType) 
    {
        this.diseaseType = diseaseType;
    }

    public String getDiseaseType() 
    {
        return diseaseType;
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
            .append("telephone", getTelephone())
            .append("address", getAddress())
            .append("snapshot", getSnapshot())
            .append("city", getCity())
            .append("lng", getLng())
            .append("lat", getLat())
            .append("diseaseType", getDiseaseType())
            .append("createUserId", getCreateUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateUserId", getUpdateUserId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
