package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springboot.DTO.DiseaseCountDTO;
import com.example.springboot.entity.BridgeDisease;
import com.example.springboot.mapper1.BridgeDiseaseMapper;
import com.example.springboot.service.BridgeDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 23092
 * @description 针对表【bridgedisease】的数据库操作Service实现
 * @createDate 2024-04-25 15:57:24
 */
@Service
public class BridgeDiseaseServiceImpl extends ServiceImpl<BridgeDiseaseMapper, BridgeDisease> implements BridgeDiseaseService {
    @Autowired
    private BridgeDiseaseMapper bridgeDiseaseMapper;

    /**
     * 获取病害数量时间
     *
     * @param bridgeId
     * @param diseaseType
     * @return
     */
    public List<DiseaseCountDTO> getDiseaseCount(Integer bridgeId, Integer diseaseType) {
        System.out.println("*******");
        System.out.println(bridgeId);
        System.out.println(diseaseType);
        return bridgeDiseaseMapper.selectDiseaseCount(bridgeId, diseaseType);
    }

    public List<DiseaseCountDTO> getDiseaseCountAll(Integer bridgeId, Integer diseaseType) {
        List<DiseaseCountDTO> list = bridgeDiseaseMapper.selectDiseaseCountAll(bridgeId, diseaseType);
        for (int i = 1; i < list.size(); i++) {
            DiseaseCountDTO current = list.get(i);
            DiseaseCountDTO previous = list.get(i - 1);
            current.setCount(current.getCount() + previous.getCount());
        }
        return list;
    }

    public Integer getCountAll(Integer bridgeId, Integer diseaseType) {
        return bridgeDiseaseMapper.getDiseaseCountAll(bridgeId, diseaseType);
    }

    public List<BridgeDisease> getDiseaseList(Integer bridgeId) {
        return bridgeDiseaseMapper.selectDiseaseList(bridgeId);
    }

    /**
     * 获取数量，程度，增长速率
     *
     * @param bridgeId
     * @param diseaseType
     * @return
     */
    public double[] getDiseaseEvaluate(Integer bridgeId, Integer diseaseType) {
        int diseaseCount = getCountAll(bridgeId, diseaseType);
        double[] result = new double[5];
        result[0] = diseaseCount;
        double x = 0.2, y = 0.3, z = 0.5, k;
        int number1, number2, number3;
        number1 = bridgeDiseaseMapper.getCountByLevel(bridgeId, diseaseType, 1);
        number2 = bridgeDiseaseMapper.getCountByLevel(bridgeId, diseaseType, 2);
        number3 = bridgeDiseaseMapper.getCountByLevel(bridgeId, diseaseType, 3);
        k = (number1 * x + number2 * y + number3 * z) / ((number1 + number2 + number3) * z);
        k = k * 100;
        result[1] = k;
        List<DiseaseCountDTO> list = getDiseaseCount(bridgeId, diseaseType);
        //计算年平均增长速度
        if (list == null || list.size() < 2) {
            throw new IllegalArgumentException("List should have at least two elements");
        }

        DiseaseCountDTO prevDto = list.get(0);
        double prevCount = prevDto.getCount();
        double growthRateSum = 0;

        for (int i = 1; i < list.size(); i++) {
            DiseaseCountDTO currentDto = list.get(i);
            int currentCount = currentDto.getCount();

            // 计算增长率：(当前年 - 前一年) / 前一年
            double growthRate = (double) (currentCount - prevCount) / prevCount;

            // 如果增长率是负数，使用绝对值，避免了负增长率的问题
            growthRate = Math.abs(growthRate);

            // 累加增长率
            growthRateSum += growthRate;

            // 更新前一年的值
            prevCount = currentCount;
            prevDto = currentDto;
        }

        // 计算平均增长率
        double averageGrowthRate = growthRateSum / (list.size() - 1);
        result[2] = averageGrowthRate;

        return result;
    }

    public int getDiseaseCountByType(Integer bridgeType, Integer diseaseType) {
        return bridgeDiseaseMapper.getCountByType(bridgeType, diseaseType);
    }
}




