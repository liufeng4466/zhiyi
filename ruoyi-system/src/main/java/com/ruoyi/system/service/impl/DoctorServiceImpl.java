package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DoctorMapper;
import com.ruoyi.system.domain.Doctor;
import com.ruoyi.system.service.IDoctorService;

/**
 * 医生Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
@Service
public class DoctorServiceImpl implements IDoctorService 
{
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * 查询医生
     * 
     * @param id 医生主键
     * @return 医生
     */
    @Override
    public Doctor selectDoctorById(Long id)
    {
        return doctorMapper.selectDoctorById(id);
    }

    /**
     * 查询医生列表
     * 
     * @param doctor 医生
     * @return 医生
     */
    @Override
    public List<Doctor> selectDoctorList(Doctor doctor)
    {
        return doctorMapper.selectDoctorList(doctor);
    }

    /**
     * 新增医生
     * 
     * @param doctor 医生
     * @return 结果
     */
    @Override
    public int insertDoctor(Doctor doctor)
    {
        doctor.setCreateTime(DateUtils.getNowDate());
        return doctorMapper.insertDoctor(doctor);
    }

    /**
     * 修改医生
     * 
     * @param doctor 医生
     * @return 结果
     */
    @Override
    public int updateDoctor(Doctor doctor)
    {
        doctor.setUpdateTime(DateUtils.getNowDate());
        return doctorMapper.updateDoctor(doctor);
    }

    /**
     * 批量删除医生
     * 
     * @param ids 需要删除的医生主键
     * @return 结果
     */
    @Override
    public int deleteDoctorByIds(Long[] ids)
    {
        return doctorMapper.deleteDoctorByIds(ids);
    }

    /**
     * 删除医生信息
     * 
     * @param id 医生主键
     * @return 结果
     */
    @Override
    public int deleteDoctorById(Long id)
    {
        return doctorMapper.deleteDoctorById(id);
    }
}
