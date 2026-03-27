package com.example.demo.model;

/**
 * 用户实体类
 */
public class User {

    /** 用户 ID */
    private Long id;

    /** 用户名 */
    private String username;

    /** 邮箱 */
    private String email;

    /** 年龄 */
    private Integer age;

    /** 创建时间 */
    private String createTime;

    /** 无参构造函数 */
    public User() {
    }

    /** 全参构造函数 */
    public User(Long id, String username, String email, Integer age, String createTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
