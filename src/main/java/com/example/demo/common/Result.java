package com.example.demo.common;

/**
 * 统一返回结果封装类
 *
 * @param <T> 数据类型
 */
public class Result<T> {

    /** 响应状态码 */
    private Integer code;

    /** 响应消息 */
    private String message;

    /** 响应数据 */
    private T data;

    /** 无参构造函数 */
    public Result() {
    }

    /** 全参构造函数 */
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据
     * @param <T>  数据类型
     * @return 成功结果对象
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    /**
     * 失败返回结果
     *
     * @param message 错误消息
     * @param <T>     数据类型
     * @return 失败结果对象
     */
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
