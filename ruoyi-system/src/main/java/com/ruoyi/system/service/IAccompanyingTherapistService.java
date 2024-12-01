package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AccompanyingTherapist;

/**
 * 陪诊师Service接口
 * 
 * @author ruoyi
 * @date 2024-12-01
 */
public interface IAccompanyingTherapistService 
{
    /**
     * 查询陪诊师
     * 
     * @param id 陪诊师主键
     * @return 陪诊师
     */
    public AccompanyingTherapist selectAccompanyingTherapistById(Long id);

    /**
     * 查询陪诊师列表
     * 
     * @param accompanyingTherapist 陪诊师
     * @return 陪诊师集合
     */
    public List<AccompanyingTherapist> selectAccompanyingTherapistList(AccompanyingTherapist accompanyingTherapist);

    /**
     * 新增陪诊师
     * 
     * @param accompanyingTherapist 陪诊师
     * @return 结果
     */
    public int insertAccompanyingTherapist(AccompanyingTherapist accompanyingTherapist);

    /**
     * 修改陪诊师
     * 
     * @param accompanyingTherapist 陪诊师
     * @return 结果
     */
    public int updateAccompanyingTherapist(AccompanyingTherapist accompanyingTherapist);

    /**
     * 批量删除陪诊师
     * 
     * @param ids 需要删除的陪诊师主键集合
     * @return 结果
     */
    public int deleteAccompanyingTherapistByIds(Long[] ids);

    /**
     * 删除陪诊师信息
     * 
     * @param id 陪诊师主键
     * @return 结果
     */
    public int deleteAccompanyingTherapistById(Long id);
}