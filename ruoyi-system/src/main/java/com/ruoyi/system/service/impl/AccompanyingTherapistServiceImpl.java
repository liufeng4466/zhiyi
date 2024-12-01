package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AccompanyingTherapistMapper;
import com.ruoyi.system.domain.AccompanyingTherapist;
import com.ruoyi.system.service.IAccompanyingTherapistService;

/**
 * 陪诊师Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
@Service
public class AccompanyingTherapistServiceImpl implements IAccompanyingTherapistService 
{
    @Autowired
    private AccompanyingTherapistMapper accompanyingTherapistMapper;

    /**
     * 查询陪诊师
     * 
     * @param id 陪诊师主键
     * @return 陪诊师
     */
    @Override
    public AccompanyingTherapist selectAccompanyingTherapistById(Long id)
    {
        return accompanyingTherapistMapper.selectAccompanyingTherapistById(id);
    }

    /**
     * 查询陪诊师列表
     * 
     * @param accompanyingTherapist 陪诊师
     * @return 陪诊师
     */
    @Override
    public List<AccompanyingTherapist> selectAccompanyingTherapistList(AccompanyingTherapist accompanyingTherapist)
    {
        return accompanyingTherapistMapper.selectAccompanyingTherapistList(accompanyingTherapist);
    }

    /**
     * 新增陪诊师
     * 
     * @param accompanyingTherapist 陪诊师
     * @return 结果
     */
    @Override
    public int insertAccompanyingTherapist(AccompanyingTherapist accompanyingTherapist)
    {
        accompanyingTherapist.setCreateTime(DateUtils.getNowDate());
        return accompanyingTherapistMapper.insertAccompanyingTherapist(accompanyingTherapist);
    }

    /**
     * 修改陪诊师
     * 
     * @param accompanyingTherapist 陪诊师
     * @return 结果
     */
    @Override
    public int updateAccompanyingTherapist(AccompanyingTherapist accompanyingTherapist)
    {
        accompanyingTherapist.setUpdateTime(DateUtils.getNowDate());
        return accompanyingTherapistMapper.updateAccompanyingTherapist(accompanyingTherapist);
    }

    /**
     * 批量删除陪诊师
     * 
     * @param ids 需要删除的陪诊师主键
     * @return 结果
     */
    @Override
    public int deleteAccompanyingTherapistByIds(Long[] ids)
    {
        return accompanyingTherapistMapper.deleteAccompanyingTherapistByIds(ids);
    }

    /**
     * 删除陪诊师信息
     * 
     * @param id 陪诊师主键
     * @return 结果
     */
    @Override
    public int deleteAccompanyingTherapistById(Long id)
    {
        return accompanyingTherapistMapper.deleteAccompanyingTherapistById(id);
    }
}
