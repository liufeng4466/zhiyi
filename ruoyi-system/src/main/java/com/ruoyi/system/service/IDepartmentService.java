package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Department;
import com.ruoyi.system.domain.Hospital;

/**
 * 科室Service接口
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
public interface IDepartmentService 
{
    /**
     * 查询科室
     * 
     * @param id 科室主键
     * @return 科室
     */
    public Department selectDepartmentById(Long id);

    /**
     * 查询科室列表
     * 
     * @param department 科室
     * @return 科室集合
     */
    public List<Department> selectDepartmentList(Department department);

    /**
     * 查询所有科室
     *
     * @return 科室列表
     */
    public List<Department> selectDepartmentAll();

    /**
     * 新增科室
     * 
     * @param department 科室
     * @return 结果
     */
    public int insertDepartment(Department department);

    /**
     * 修改科室
     * 
     * @param department 科室
     * @return 结果
     */
    public int updateDepartment(Department department);

    /**
     * 批量删除科室
     * 
     * @param ids 需要删除的科室主键集合
     * @return 结果
     */
    public int deleteDepartmentByIds(Long[] ids);

    /**
     * 删除科室信息
     * 
     * @param id 科室主键
     * @return 结果
     */
    public int deleteDepartmentById(Long id);
}
