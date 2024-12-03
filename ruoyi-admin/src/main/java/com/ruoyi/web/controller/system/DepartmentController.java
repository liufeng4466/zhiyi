package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.Hospital;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Department;
import com.ruoyi.system.service.IDepartmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科室Controller
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
@RestController
@RequestMapping("/system/department")
public class DepartmentController extends BaseController
{
    @Autowired
    private IDepartmentService departmentService;

    /**
     * 查询科室列表
     */
    @PreAuthorize("@ss.hasPermi('system:department:list')")
    @GetMapping("/list")
    public TableDataInfo list(Department department)
    {
        startPage();
        List<Department> list = departmentService.selectDepartmentList(department);
        return getDataTable(list);
    }

    /**
     * 获取科室选择框列表
     */
    @GetMapping("/departmentselect")
    public AjaxResult departmentselect()
    {
        List<Department> departments = departmentService.selectDepartmentAll();
        return success(departments);
    }

    /**
     * 导出科室列表
     */
    @PreAuthorize("@ss.hasPermi('system:department:export')")
    @Log(title = "科室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Department department)
    {
        List<Department> list = departmentService.selectDepartmentList(department);
        ExcelUtil<Department> util = new ExcelUtil<Department>(Department.class);
        util.exportExcel(response, list, "科室数据");
    }

    /**
     * 获取科室详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:department:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(departmentService.selectDepartmentById(id));
    }

    /**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('system:department:add')")
    @Log(title = "科室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Department department)
    {
        department.setCreateBy(getUsername());
        return toAjax(departmentService.insertDepartment(department));
    }

    /**
     * 修改科室
     */
    @PreAuthorize("@ss.hasPermi('system:department:edit')")
    @Log(title = "科室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Department department)
    {
        department.setUpdateBy(getUsername());
        return toAjax(departmentService.updateDepartment(department));
    }

    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('system:department:remove')")
    @Log(title = "科室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(departmentService.deleteDepartmentByIds(ids));
    }
}
