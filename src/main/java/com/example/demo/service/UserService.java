package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务层，使用内存 ArrayList 模拟数据库
 */
@Service
public class UserService {

    /** 模拟数据库的用户列表 */
    private final List<User> userList = new ArrayList<>();

    /**
     * 初始化预置 5 条假数据
     * 在 Bean 实例化完成后自动执行
     */
    @PostConstruct
    public void init() {
        userList.add(new User(1L, "张三", "zhangsan@example.com", 25, "2024-01-01 10:00:00"));
        userList.add(new User(2L, "李四", "lisi@example.com", 30, "2024-02-15 14:30:00"));
        userList.add(new User(3L, "王五", "wangwu@example.com", 28, "2024-03-20 09:15:00"));
        userList.add(new User(4L, "赵六", "zhaoliu@example.com", 22, "2024-04-10 16:45:00"));
        userList.add(new User(5L, "孙七", "sunqi@example.com", 35, "2024-05-05 11:20:00"));
    }

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    public List<User> findAll() {
        return userList;
    }

    /**
     * 根据 ID 查询单个用户
     *
     * @param id 用户 ID
     * @return 用户对象，不存在则返回 null
     */
    public User findById(Long id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
