package com.example.springboot.mapper1;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.BridgeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 23092
 * @description 针对表【bridge】的数据库操作Mapper
 * @createDate 2024-04-23 22:15:14
 * @Entity com.example.dataalnalyse.entity.Bridge
 */
@Mapper
public interface BridgeInfoMapper extends BaseMapper<BridgeInfo> {
    /**
     * 查询桥梁列表
     */
    List<BridgeInfo> selectBridgeList();

    BridgeInfo getBridgeById(Integer id);
    List<BridgeInfo> getBridgeList();
    int getBridgeCountByType(Integer bridgeType);
}
