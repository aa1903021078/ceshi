package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务层，使用内存数据模拟数据库操作
 */
@Service
public class UserService {

    /** 内存用户数据列表，保持插入顺序 */
    private final List<User> userList = new ArrayList<>();

    /** 用户 ID 索引，提供 O(1) 查询效率 */
    private final Map<Long, User> userMap = new HashMap<>();

    /**
     * 初始化预置用户假数据
     * 在 Bean 初始化完成后自动执行
     */
    @PostConstruct
    public void init() {
        addUser(new User(1L, "张三", "zhangsan@example.com", 25, "2024-01-01 10:00:00"));
        addUser(new User(2L, "李四", "lisi@example.com", 30, "2024-02-15 14:30:00"));
        addUser(new User(3L, "王五", "wangwu@example.com", 28, "2024-03-20 09:15:00"));
        addUser(new User(4L, "赵六", "zhaoliu@example.com", 22, "2024-04-10 16:45:00"));
        addUser(new User(5L, "陈七", "chenqi@example.com", 35, "2024-05-05 11:20:00"));
    }

    /** 添加用户到列表和索引 */
    private void addUser(User user) {
        userList.add(user);
        userMap.put(user.getId(), user);
    }

    /**
     * 查询所有用户
     *
     * @return 用户列表（副本，防止外部修改内部数据）
     */
    public List<User> findAll() {
        return new ArrayList<>(userList);
    }

    /**
     * 根据 ID 查询单个用户（O(1) 时间复杂度）
     *
     * @param id 用户 ID
     * @return 用户对象，若不存在则返回 null
     */
    public User findById(Long id) {
        return userMap.get(id);
    }
}
