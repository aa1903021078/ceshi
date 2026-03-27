package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
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

    /** 用户服务 */
    private final UserService userService;

    /** 构造函数注入 */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询所有用户列表
     *
     * @return 用户列表结果
     */
    @GetMapping
    public Result<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return Result.success(users);
    }

    /**
     * 根据 ID 查询单个用户
     *
     * @param id 用户 ID
     * @return 用户信息结果
     */
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return Result.error("用户不存在，ID：" + id);
        }
        return Result.success(user);
    }
}
