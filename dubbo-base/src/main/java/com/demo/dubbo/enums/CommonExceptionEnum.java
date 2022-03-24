package com.demo.dubbo.enums;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/2 下午12:06
 * @desc
 */
public enum CommonExceptionEnum {
    // ====== 系统错误 =====
    SYSTEM_ERROR(50000, "系统错误"),
    SYSTEM_BUSY(50001, "系统繁忙"),
    UNKNOWN_ERROR(50002, "未知错误"),
    INVALID_PARAMS(50003, "参数错误"),

    // ====== 账号相关 ======
    ACCOUNT_ERROR(30000, "账号错误"),
    PASSWORD_INVALID(30001, "密码不符合要求"),
    PASSWORD_ERROR(30002, "密码错误"),
    TOKEN_INVALID(30003, "Token错误"),
    TOKEN_EXPIRE(30004, "Token过期"),
    ACCOUNT_ALREADY_EXIST(30005, "账号已存在"),
    ACCOUNT_NOT_EXIST(30006, "账号不存在"),
    ACCOUNT_NOT_ENABLE(30007, "账号未生效"),
    ACCOUNT_DELETED(30008, "账号已被删除"),
    ACCOUNT_BE_BLOCKED(30009, "账号已被冻结"),
    LOGIN_ERROR(30010, "登录失败"),
    ;

    CommonExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
