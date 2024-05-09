package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springboot.entity.BridgeInfo;
import com.example.springboot.mapper1.BridgeInfoMapper;
import com.example.springboot.service.BridgeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 23092
 * @description 针对表【bridge】的数据库操作Service实现
 * @createDate 2024-04-23 22:15:14
 */
@Service
public class BridgeServiceImpl extends ServiceImpl<BridgeInfoMapper, BridgeInfo> implements BridgeInfoService {
    @Autowired
    private BridgeInfoMapper bridgeInfoMapper;

    //搜索建议
    public List<BridgeInfo> getBridgeList() {
        return bridgeInfoMapper.selectBridgeList();
    }
    public BridgeInfo getBridge(Integer id) {
        return bridgeInfoMapper.getBridgeById(id);
    }
    /**
     * 获取桥列表信息
     */

    public List<BridgeInfo> selectBridgeList(){
        return bridgeInfoMapper.getBridgeList();

    }
    /**
     * 获取某类型桥梁数
     */
    public Integer getBridgeCountByType(Integer bridgeType){
        return bridgeInfoMapper.getBridgeCountByType(bridgeType);
    }



}




