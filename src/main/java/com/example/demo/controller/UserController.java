package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器，提供用户查询相关接口
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    /** 注入用户服务 */
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户列表
     *
     * @return 用户列表
     */
    @GetMapping
    public Result<List<User>> listUsers() {
        List<User> users = userService.findAll();
        return Result.success(users);
    }

    /**
     * 根据 ID 查询单个用户
     *
     * @param id 用户 ID
     * @return 用户信息，不存在时返回 404 错误
     */
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return Result.error(404, "用户不存在");
        }
        return Result.success(user);
    }
}
