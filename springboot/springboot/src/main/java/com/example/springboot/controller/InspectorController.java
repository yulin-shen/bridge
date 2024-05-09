package com.example.springboot.controller;

import com.example.springboot.entity.Bridge;
import com.example.springboot.entity.Inspector;
import com.example.springboot.mapper.BridgeMapper;
import com.example.springboot.mapper.InspectorMapper;
import com.example.springboot.service.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inspector")
public class InspectorController {
    @Autowired
    InspectorMapper inspectorMapper;

    @Autowired
    BridgeMapper bridgeMapper;
    @Autowired
    InspectorService inspectorService;
    @GetMapping
    List<Inspector> findAll(){

        return inspectorMapper.finall();
    }

    @GetMapping("/inspector_page")
    public Map<String,Object> findPage (@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String inspector_name,
                                        @RequestParam(required = false) Integer inspector_id
    ) {
         pageNum=(pageNum-1) * pageSize;
        List<Inspector> data;
        Integer total;
        if (inspector_id != null) {
            data = inspectorMapper.selectPageWithId(pageNum, pageSize, inspector_name, inspector_id);
            total = inspectorMapper.selectTotalWithId(inspector_name, inspector_id);
        } else {
            data = inspectorMapper.selectPage(pageNum, pageSize, inspector_name);
            total = inspectorMapper.selectTotal(inspector_name);
        }
        Map<String,Object> res=new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    //新增以及修改
    @PostMapping
    public Integer save(@RequestBody Inspector inspector){
            return inspectorService.save(inspector);
    }
    //通过id删除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return inspectorMapper.deleteById(id);
    }

    //查看所属管辖的桥梁
    @GetMapping("/bridgeinfo")
    public Map<String,Object> findbridgePage (@RequestParam Integer pageNum,
                                               @RequestParam Integer pageSize,
                                               @RequestParam Integer inspector_id
    ) {
        pageNum=(pageNum-1) * pageSize;
        List<Bridge> data = inspectorMapper.selectPageOnlyId(pageNum, pageSize,inspector_id);
        Integer total=inspectorMapper.selectTotalOnlyId(inspector_id);
        Map<String,Object> res=new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}
