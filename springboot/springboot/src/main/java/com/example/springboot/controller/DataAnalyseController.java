package com.example.springboot.controller;



import com.example.springboot.DTO.DiseaseCountDTO;
import com.example.springboot.entity.BridgeDisease;
import com.example.springboot.entity.BridgeInfo;
import com.example.springboot.service.BridgeDiseaseService;
import com.example.springboot.service.BridgeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 23092
 */
@RestController
@RequestMapping("/dataAnalyse")
public class DataAnalyseController {
    @Autowired
    private BridgeInfoService bridgeInfoService;
    @Autowired
    private BridgeDiseaseService bridgeDiseaseService;

    /**
     * 获取桥梁信息
     *
     * @param bridgeId 桥梁ID
     * @return 桥梁信息
     */
    @GetMapping("/getBridge")
    public BridgeInfo getBridge(@RequestParam Integer bridgeId) {

        BridgeInfo bridge = new BridgeInfo();
        bridge = bridgeInfoService.getBridge(bridgeId);
        System.out.println("输出桥梁信息");
        System.out.println(bridge);
        return bridge;
    }

    /**
     * 获取桥梁列表
     *
     * @return 桥梁列表
     */
    @GetMapping("/selectBridges")
    public List<Map<String, Object>> selectBridges() {
        // 增加空值检查
        List<BridgeInfo> bridgeList = bridgeInfoService.getBridgeList();
        if (bridgeList == null) {
            throw new IllegalArgumentException("Bridge list cannot be null");
        }

        List<Map<String, Object>> result = new ArrayList<>();
        try {
            for (BridgeInfo bridge : bridgeList) {
                Map<String, Object> bridgeData = new HashMap<>();
                bridgeData.put("id", bridge.getId());
                bridgeData.put("value", bridge.getName());
                result.add(bridgeData);
            }
        } catch (Exception e) {
            // 处理可能的异常，例如日志记录、转换为业务异常等
            // 这里只是做一个示例，实际应用中需要根据具体情况来处理
            throw new RuntimeException("Error while processing bridges", e);
        }
        return result;
    }

    /**
     * 获取桥梁某种发现病害-时间
     */
    @GetMapping("/selectDiseaseCount")
    public List<DiseaseCountDTO> selectDiseaseCount(@RequestParam Integer bridgeId, @RequestParam Integer diseaseType) {
        System.out.println("=====");
        System.out.println(bridgeId);
        System.out.println(diseaseType);
        List<DiseaseCountDTO> diseaseCountDTOList = bridgeDiseaseService.getDiseaseCount(bridgeId, diseaseType);
        System.out.println("输出桥梁病害信息");
        System.out.println(diseaseCountDTOList);
        return diseaseCountDTOList;
    }

    /**
     *
     */
    @GetMapping("/selectDiseaseCountAll")
    public List<DiseaseCountDTO> selectDiseaseCountAll(@RequestParam Integer bridgeId, @RequestParam Integer diseaseType) {
        List<DiseaseCountDTO> diseaseCountDTOList = bridgeDiseaseService.getDiseaseCountAll(bridgeId, diseaseType);
        return diseaseCountDTOList;
    }
    /**
    *某一病害数量
     */
    @GetMapping("/selectCountAll")
    public Integer selectCountAll(@RequestParam Integer bridgeId, @RequestParam Integer diseaseType) {
        return bridgeDiseaseService.getCountAll(bridgeId, diseaseType);
    }
    /**
    *病害列表
     */
    @GetMapping("/selectDiseaseList")
    public List<BridgeDisease> selectDiseaseList(@RequestParam Integer bridgeId) {
        List<BridgeDisease> bridgeDiseaseList = bridgeDiseaseService.getDiseaseList(bridgeId);
        return bridgeDiseaseList;
    }
    /**
    *病害评估图
     */
    @GetMapping("/selectDiseaseEvaluate")
    public  double[] selectDiseaseEvaluate(@RequestParam Integer bridgeId, @RequestParam Integer diseaseType) {
        return bridgeDiseaseService.getDiseaseEvaluate(bridgeId, diseaseType);
    }
    /**
     * 桥梁列表信息
     */
    @GetMapping("/getBridgeList")
    public List<BridgeInfo> getBridgeList() {
        return bridgeInfoService.selectBridgeList();
    }
    /**
     * 获取某类型桥梁数
     */
    @GetMapping("/getBridgeCountByType")
    public Integer getBridgeCountByType(@RequestParam Integer bridgeType) {
        return bridgeInfoService.getBridgeCountByType(bridgeType);
    }
    /**
     * 获取一种类型桥梁的一种病害数量
     */
    @GetMapping("/getDiseaseCountByType")
    public Integer getDiseaseCountByType(@RequestParam Integer bridgeType, @RequestParam Integer diseaseType) {
        return bridgeDiseaseService.getDiseaseCountByType(bridgeType, diseaseType);
    }
}



