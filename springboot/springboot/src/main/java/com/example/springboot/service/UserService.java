package com.example.springboot.service;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public int save(User user) {
        System.out.println(user.getAdmin_id());
        if (user.getAdmin_id() == null) {  // user没有id，则表示是新增
            return userMapper.insert(user);
        } else { // 否则为更新
            return userMapper.update(user);
        }
    }
}
