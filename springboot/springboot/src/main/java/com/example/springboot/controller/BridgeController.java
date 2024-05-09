package com.example.springboot.controller;

import com.example.springboot.entity.Bridge;
import com.example.springboot.mapper.BridgeMapper;
import com.example.springboot.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bridge")
public class BridgeController {
    @Autowired
    BridgeMapper bridgeMapper;
    @Autowired
    BridgeService bridgeService;

    @GetMapping
    List<Bridge> findAll(){

        return bridgeMapper.findall();
    }

    @GetMapping("/bridge_page")
    public Map<String,Object> findPage (@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String bridge_name,
                                        @RequestParam(required = false) Integer bridge_id
    ) {
        pageNum=(pageNum-1) * pageSize;
        List<Bridge> data ;
        Integer total;
        if (bridge_id != null) {
            data = bridgeMapper.selectPageWithId(pageNum, pageSize, bridge_name, bridge_id);
            total = bridgeMapper.selectTotalWithId(bridge_name, bridge_id);
            System.out.println("!!!!!!!");
            System.out.println(data);
        } else {
            data = bridgeMapper.selectPage(pageNum, pageSize, bridge_name);
            total = bridgeMapper.selectTotal(bridge_name);
        }

        Map<String,Object> res=new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        System.out.println("*******");
        System.out.println(res);
        return res;
    }

    @PostMapping
    public Integer save(@RequestBody Bridge bridge){
        return bridgeService.save(bridge);
    }


    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable Integer id){
        return bridgeMapper.deleteById(id);
    }
}

