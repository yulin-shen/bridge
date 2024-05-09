package com.example.springboot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.entity.BridgeInfo;

import java.util.List;

/**
 * @author 23092
 * @description 针对表【bridge】的数据库操作Service
 * @createDate 2024-04-23 22:15:14
 */
public interface BridgeInfoService extends IService<BridgeInfo> {
    List<BridgeInfo> getBridgeList();

    BridgeInfo getBridge(Integer bridgeId);
    List<BridgeInfo> selectBridgeList();
    Integer getBridgeCountByType(Integer bridgeType);
}
