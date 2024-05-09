package com.example.springboot.service;

import com.example.springboot.entity.Bridge;
import com.example.springboot.mapper.BridgeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BridgeService {
    @Autowired
    BridgeMapper bridgeMapper;

    public int save(Bridge bridge){
        if(bridge.getBridge_id()== null){
            return bridgeMapper.save(bridge);
        }else{
            return bridgeMapper.update(bridge);
        }
    }
}
