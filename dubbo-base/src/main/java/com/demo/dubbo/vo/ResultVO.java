package com.demo.dubbo.vo;

import com.demo.dubbo.enums.CommonExceptionEnum;

import java.io.Serializable;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午3:54
 * @desc
 */
public class ResultVO<T> implements Serializable {
    /**
     * 结果码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public ResultVO() {
    }

    public ResultVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> result = new ResultVO<>(200,"success");
        result.setData(data);
        return result;
    }

    public static ResultVO<String> fail(int code, String message) {
        return new ResultVO<>(code,message);
    }

    public static ResultVO<String> fail(CommonExceptionEnum exception) {
        return new ResultVO<>(exception.getCode(),exception.getMessage());
    }
}
