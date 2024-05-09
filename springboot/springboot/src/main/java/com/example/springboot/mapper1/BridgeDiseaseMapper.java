package com.example.springboot.mapper1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.DTO.DiseaseCountDTO;
import com.example.springboot.entity.BridgeDisease;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 23092
 * @description 针对表【bridgedisease】的数据库操作Mapper
 * @createDate 2024-04-25 15:57:24
 * @Entity com.example.dataalnalyse.entity.Bridgedisease
 */
@Mapper
public interface BridgeDiseaseMapper extends BaseMapper<BridgeDisease> {
    /**
     * 查询某一病害发现数量和时间
     */
    List<DiseaseCountDTO> selectDiseaseCount(@Param("bridgeId") Integer bridgeId,@Param("diseaseType") Integer diseaseType);
    /**
     * 查询某一病害总数和时间
     */
    List<DiseaseCountDTO> selectDiseaseCountAll(@Param("bridgeId") Integer bridgeId, @Param("diseaseType") Integer diseaseType);
    /**
     * 查询病害总数
     */
    Integer getDiseaseCountAll(@Param("bridgeId") Integer bridgeId  , @Param("diseaseType") Integer diseaseType);
    /**
     * 查询病害列表
     */
    List<BridgeDisease> selectDiseaseList(Integer bridgeId);
    /**
     * 查询一座桥梁某种病害等级的数量
     */
    int getCountByLevel(@Param("bridgeId") Integer bridgeId, @Param("diseaseType") Integer diseaseType, @Param("level") Integer level);
    /**
     * 查询一种桥梁某种病害的数量
     */
    int getCountByType(@Param("bridgeType") Integer bridgeType, @Param("diseaseType") Integer diseaseType);
}




