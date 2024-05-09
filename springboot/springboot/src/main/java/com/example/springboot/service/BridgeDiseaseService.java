package com.example.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.example.springboot.DTO.DiseaseCountDTO;
import com.example.springboot.entity.BridgeDisease;

import java.util.List;

/**
* @author 23092
* @description 针对表【bridgedisease】的数据库操作Service
* @createDate 2024-04-25 15:57:24
*/
public interface BridgeDiseaseService extends IService<BridgeDisease> {

    List<DiseaseCountDTO> getDiseaseCount(Integer bridgeId, Integer diseaseType);
    List<DiseaseCountDTO> getDiseaseCountAll(Integer bridgeId, Integer diseaseType);
    Integer getCountAll(Integer bridgeId, Integer diseaseType);
    List<BridgeDisease> getDiseaseList(Integer bridgeId);

    double[] getDiseaseEvaluate(Integer bridgeId, Integer diseaseType);
    int getDiseaseCountByType(Integer bridgeType, Integer diseaseType);
}
