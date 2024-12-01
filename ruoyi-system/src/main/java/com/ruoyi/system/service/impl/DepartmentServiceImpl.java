package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DepartmentMapper;
import com.ruoyi.system.domain.Department;
import com.ruoyi.system.service.IDepartmentService;

/**
 * 科室Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService 
{
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询科室
     * 
     * @param id 科室主键
     * @return 科室
     */
    @Override
    public Department selectDepartmentById(Long id)
    {
        return departmentMapper.selectDepartmentById(id);
    }

    /**
     * 查询科室列表
     * 
     * @param department 科室
     * @return 科室
     */
    @Override
    public List<Department> selectDepartmentList(Department department)
    {
        return departmentMapper.selectDepartmentList(department);
    }

    /**
     * 新增科室
     * 
     * @param department 科室
     * @return 结果
     */
    @Override
    public int insertDepartment(Department department)
    {
        department.setCreateTime(DateUtils.getNowDate());
        return departmentMapper.insertDepartment(department);
    }

    /**
     * 修改科室
     * 
     * @param department 科室
     * @return 结果
     */
    @Override
    public int updateDepartment(Department department)
    {
        department.setUpdateTime(DateUtils.getNowDate());
        return departmentMapper.updateDepartment(department);
    }

    /**
     * 批量删除科室
     * 
     * @param ids 需要删除的科室主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentByIds(Long[] ids)
    {
        return departmentMapper.deleteDepartmentByIds(ids);
    }

    /**
     * 删除科室信息
     * 
     * @param id 科室主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentById(Long id)
    {
        return departmentMapper.deleteDepartmentById(id);
    }
}
