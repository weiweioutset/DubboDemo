package com.demo.dubbo.exception;

import com.demo.dubbo.enums.CommonExceptionEnum;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/2 下午12:14
 * @desc
 */
public class CommonException extends RuntimeException {
    private CommonExceptionEnum exception;

    public CommonException(CommonExceptionEnum exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    public CommonException() {
        super();
    }

    public CommonExceptionEnum getException() {
        return exception;
    }

    public void setException(CommonExceptionEnum exception) {
        this.exception = exception;
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }
}
