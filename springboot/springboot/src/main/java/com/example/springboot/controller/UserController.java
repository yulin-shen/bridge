package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.entity.UserLogin;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//将数据以json格式返回
@RequestMapping("/admin_user")//统一给接口加前缀
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/login")
    public boolean login(UserLogin userLogin){
        String admin_account = userLogin.getAdmin_account();
        String admin_pd = userLogin.getAdmin_pd();

        System.out.println("_______________________________________");
        System.out.println(admin_account);
        System.out.println(admin_pd);
        UserLogin user=userMapper.findBySuperAccount(admin_account);
        return user != null && user.getAdmin_pd().equals(admin_pd);

    }

    // 新增和修改
    @PostMapping("/change")
    public Integer save(@RequestBody User user) {
        // 新增或者更新
        return userService.save(user);
    }
    // 检查账号是否存在的接口方法
    @GetMapping("/checkAccount")
    public boolean checkAccountExists(@RequestParam String admin_account) {
        // 调用 Mapper 的方法查询数据库
        Integer count = userMapper.checkAccountExists(admin_account);
        // 如果账号存在（count 大于0），返回 true；否则返回 false
        return count > 0;
    }


    // 查询所有数据
    @GetMapping
    public List<User> index() {
        List<User> all = userMapper.findAll();
        return all;
    }
    //删除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
    //分页查询以及前端展示
    @GetMapping("/page")
    public Map<String,Object> findpage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam String admin_name,
                                       @RequestParam(required = false) Integer admin_id) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data;
        Integer total;
        if (admin_id != null) {
            data = userMapper.selectPageWithId(pageNum, pageSize, admin_name, admin_id);
            total = userMapper.selectTotalWithId(admin_name, admin_id);
        } else {
            data = userMapper.selectPage(pageNum, pageSize, admin_name);
            total = userMapper.selectTotal(admin_name);
        }
        Map<String,Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}
