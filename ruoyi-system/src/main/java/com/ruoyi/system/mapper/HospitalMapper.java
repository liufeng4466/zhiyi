package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Hospital;

/**
 * 医院Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-02
 */
public interface HospitalMapper 
{
    /**
     * 查询医院
     * 
     * @param id 医院主键
     * @return 医院
     */
    public Hospital selectHospitalById(Long id);

    /**
     * 查询医院列表
     * 
     * @param hospital 医院
     * @return 医院集合
     */
    public List<Hospital> selectHospitalList(Hospital hospital);

    /**
     * 查询所有医院
     *
     * @return 医院列表
     */
    public List<Hospital> selectHospitalAll();

    /**
     * 新增医院
     * 
     * @param hospital 医院
     * @return 结果
     */
    public int insertHospital(Hospital hospital);

    /**
     * 修改医院
     * 
     * @param hospital 医院
     * @return 结果
     */
    public int updateHospital(Hospital hospital);

    /**
     * 删除医院
     * 
     * @param id 医院主键
     * @return 结果
     */
    public int deleteHospitalById(Long id);

    /**
     * 批量删除医院
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHospitalByIds(Long[] ids);
}
