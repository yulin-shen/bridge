package com.example.springboot.controller;

import com.example.springboot.entity.SuperLogin;
import com.example.springboot.mapper.SuperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/super")
public class SuperController {

    @Autowired
    SuperMapper superMapper;

    @PostMapping("/superLogin")
    public boolean login(@RequestBody SuperLogin superLogin){

        String super_account= superLogin.getSuper_account();
        String super_pd = superLogin.getSuper_pd();

        // 根据用户名查询数据库中的密码
        SuperLogin user = superMapper.findBySuperAccount(super_account);

        return user != null && user.getSuper_pd().equals(super_pd);

    }

}
