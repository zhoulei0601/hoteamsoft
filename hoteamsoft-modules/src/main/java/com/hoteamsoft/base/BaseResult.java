package com.hoteamsoft.base;

/**
 * @author zhoul
 * @version 1.0
 * @description: TODO
 * @date 2022/4/29 8:49
 */
public class BaseResult<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

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

    public BaseResult() {
    }

    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 返回成功
     * @param message 信息
     * @return 公共返回类
     */
    public static <T> BaseResult<T> ok(String message){
        return new BaseResult<>(ECode.OK, message);
    }

    /**
     * 返回成功
     * @param data 信息
     * @return 公共返回类
     */
    public static <T> BaseResult<T> ok( T data){
        return new BaseResult<>(ECode.OK, data);
    }

    /**
     * 返回成功
     * @param message 信息
     * @param <T> 数据
     * @return 公共返回类
     */
    public static <T> BaseResult<T> ok(String message, T data){
        return new BaseResult<>(ECode.OK, message, data);
    }

    /**
     * 返回失败
     * @param message 信息
     * @return 公共返回类
     */
    public static <T> BaseResult<T> fail(String message){
        return new BaseResult<>(ECode.FAIL, message);
    }


    /**
     * 返回失败
     * @param message 信息
     * @param <T> 数据
     * @return 公共返回类
     */
    public static <T> BaseResult<T> fail(String message, T data){
        return new BaseResult<>(ECode.FAIL, message, data);
    }
}
