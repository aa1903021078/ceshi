package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务层，使用内存数据结构模拟数据库
 */
@Service
public class UserService {

    /** 模拟数据库的用户列表，保持插入顺序 */
    private final List<User> userList = new ArrayList<>();

    /** 按 ID 索引的用户 Map，支持 O(1) 查询 */
    private final Map<Long, User> userMap = new HashMap<>();

    /**
     * 初始化预置 5 条假数据
     * 在 Bean 实例化完成后自动执行
     */
    @PostConstruct
    public void init() {
        addUser(new User(1L, "张三", "zhangsan@example.com", 25, "2024-01-01 10:00:00"));
        addUser(new User(2L, "李四", "lisi@example.com", 30, "2024-02-15 14:30:00"));
        addUser(new User(3L, "王五", "wangwu@example.com", 28, "2024-03-20 09:15:00"));
        addUser(new User(4L, "赵六", "zhaoliu@example.com", 22, "2024-04-10 16:45:00"));
        addUser(new User(5L, "孙七", "sunqi@example.com", 35, "2024-05-05 11:20:00"));
    }

    /** 将用户同时存入列表和 Map */
    private void addUser(User user) {
        userList.add(user);
        userMap.put(user.getId(), user);
    }

    /**
     * 查询所有用户
     *
     * @return 不可修改的用户列表
     */
    public List<User> findAll() {
        return Collections.unmodifiableList(userList);
    }

    /**
     * 根据 ID 查询单个用户（O(1) 查询）
     *
     * @param id 用户 ID
     * @return 用户对象，不存在则返回 null
     */
    public User findById(Long id) {
        return userMap.get(id);
    }
}
