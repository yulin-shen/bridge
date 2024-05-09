package com.example.springboot.service;

import com.example.springboot.entity.Inspector;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.InspectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectorService {
    @Autowired
    InspectorMapper inspectorMapper;


    public int save(Inspector inspector) {
        System.out.println(inspector.getInspector_id());
        if (inspector.getInspector_id() == null) {  // user没有id，则表示是新增
            return inspectorMapper.insert(inspector);
        } else { // 否则为更新
            return inspectorMapper.update(inspector);
        }
    }
}
