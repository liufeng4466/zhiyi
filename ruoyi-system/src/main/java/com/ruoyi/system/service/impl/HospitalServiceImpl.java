package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HospitalMapper;
import com.ruoyi.system.domain.Hospital;
import com.ruoyi.system.service.IHospitalService;

/**
 * 医院Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-02
 */
@Service
public class HospitalServiceImpl implements IHospitalService 
{
    @Autowired
    private HospitalMapper hospitalMapper;

    /**
     * 查询医院
     * 
     * @param id 医院主键
     * @return 医院
     */
    @Override
    public Hospital selectHospitalById(Long id)
    {
        return hospitalMapper.selectHospitalById(id);
    }

    /**
     * 查询医院列表
     * 
     * @param hospital 医院
     * @return 医院
     */
    @Override
    public List<Hospital> selectHospitalList(Hospital hospital)
    {
        return hospitalMapper.selectHospitalList(hospital);
    }

    /**
     * 新增医院
     * 
     * @param hospital 医院
     * @return 结果
     */
    @Override
    public int insertHospital(Hospital hospital)
    {
        hospital.setCreateTime(DateUtils.getNowDate());
        return hospitalMapper.insertHospital(hospital);
    }

    /**
     * 修改医院
     * 
     * @param hospital 医院
     * @return 结果
     */
    @Override
    public int updateHospital(Hospital hospital)
    {
        hospital.setUpdateTime(DateUtils.getNowDate());
        return hospitalMapper.updateHospital(hospital);
    }

    /**
     * 批量删除医院
     * 
     * @param ids 需要删除的医院主键
     * @return 结果
     */
    @Override
    public int deleteHospitalByIds(Long[] ids)
    {
        return hospitalMapper.deleteHospitalByIds(ids);
    }

    /**
     * 删除医院信息
     * 
     * @param id 医院主键
     * @return 结果
     */
    @Override
    public int deleteHospitalById(Long id)
    {
        return hospitalMapper.deleteHospitalById(id);
    }
}
