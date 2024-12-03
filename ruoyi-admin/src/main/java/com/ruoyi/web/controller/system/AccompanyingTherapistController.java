package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.AccompanyingTherapist;
import com.ruoyi.system.service.IAccompanyingTherapistService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 陪诊师Controller
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
@RestController
@RequestMapping("/system/therapist")
public class AccompanyingTherapistController extends BaseController
{
    @Autowired
    private IAccompanyingTherapistService accompanyingTherapistService;

    /**
     * 查询陪诊师列表
     */
    @PreAuthorize("@ss.hasPermi('system:therapist:list')")
    @GetMapping("/list")
    public TableDataInfo list(AccompanyingTherapist accompanyingTherapist)
    {
        startPage();
        List<AccompanyingTherapist> list = accompanyingTherapistService.selectAccompanyingTherapistList(accompanyingTherapist);
        return getDataTable(list);
    }

    /**
     * 导出陪诊师列表
     */
    @PreAuthorize("@ss.hasPermi('system:therapist:export')")
    @Log(title = "陪诊师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AccompanyingTherapist accompanyingTherapist)
    {
        List<AccompanyingTherapist> list = accompanyingTherapistService.selectAccompanyingTherapistList(accompanyingTherapist);
        ExcelUtil<AccompanyingTherapist> util = new ExcelUtil<AccompanyingTherapist>(AccompanyingTherapist.class);
        util.exportExcel(response, list, "陪诊师数据");
    }

    /**
     * 获取陪诊师详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:therapist:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(accompanyingTherapistService.selectAccompanyingTherapistById(id));
    }

    /**
     * 新增陪诊师
     */
    @PreAuthorize("@ss.hasPermi('system:therapist:add')")
    @Log(title = "陪诊师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AccompanyingTherapist accompanyingTherapist)
    {
        accompanyingTherapist.setCreateBy(getUsername());
        return toAjax(accompanyingTherapistService.insertAccompanyingTherapist(accompanyingTherapist));
    }

    /**
     * 修改陪诊师
     */
    @PreAuthorize("@ss.hasPermi('system:therapist:edit')")
    @Log(title = "陪诊师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AccompanyingTherapist accompanyingTherapist)
    {
        accompanyingTherapist.setUpdateBy(getUsername());
        return toAjax(accompanyingTherapistService.updateAccompanyingTherapist(accompanyingTherapist));
    }

    /**
     * 删除陪诊师
     */
    @PreAuthorize("@ss.hasPermi('system:therapist:remove')")
    @Log(title = "陪诊师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(accompanyingTherapistService.deleteAccompanyingTherapistByIds(ids));
    }
}
