package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Doctor;

/**
 * 医生Service接口
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
public interface IDoctorService 
{
    /**
     * 查询医生
     * 
     * @param id 医生主键
     * @return 医生
     */
    public Doctor selectDoctorById(Long id);

    /**
     * 查询医生列表
     * 
     * @param doctor 医生
     * @return 医生集合
     */
    public List<Doctor> selectDoctorList(Doctor doctor);

    /**
     * 新增医生
     * 
     * @param doctor 医生
     * @return 结果
     */
    public int insertDoctor(Doctor doctor);

    /**
     * 修改医生
     * 
     * @param doctor 医生
     * @return 结果
     */
    public int updateDoctor(Doctor doctor);

    /**
     * 批量删除医生
     * 
     * @param ids 需要删除的医生主键集合
     * @return 结果
     */
    public int deleteDoctorByIds(Long[] ids);

    /**
     * 删除医生信息
     * 
     * @param id 医生主键
     * @return 结果
     */
    public int deleteDoctorById(Long id);
}
