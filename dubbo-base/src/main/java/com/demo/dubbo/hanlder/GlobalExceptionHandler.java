package com.demo.dubbo.hanlder;

import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import com.demo.dubbo.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/2 下午12:40
 * @desc 全局错误处理
 */
@RestControllerAdvice()
public class GlobalExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ExceptionHandler(CommonException.class)
    public ResultVO exception(CommonException exception) {
        return ResultVO.fail(exception.getException());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO exception(Exception exception) {
        LOGGER.error("未知错误", exception);
        return ResultVO.fail(CommonExceptionEnum.UNKNOWN_ERROR);
    }

}
