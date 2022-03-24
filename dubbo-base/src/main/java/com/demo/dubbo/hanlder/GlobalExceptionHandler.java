package com.demo.dubbo.hanlder;

import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import com.demo.dubbo.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/2 下午12:40
 * @desc 全局错误处理
 */
@RestControllerAdvice()
public class GlobalExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 form data方式调用接口校验失败抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public ResultVO<List<String>> bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> errors = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        ResultVO<List<String>> result = new ResultVO<>(CommonExceptionEnum.INVALID_PARAMS.getCode(), "参数错误");
        result.setData(errors);
        return result;
    }

    /**
     * 处理 json 请求体调用接口校验失败抛出的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<List<String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> errors = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        ResultVO<List<String>> result = new ResultVO<>(CommonExceptionEnum.INVALID_PARAMS.getCode(), "请求数据错误");
        result.setData(errors);
        return result;
    }

    /**
     * 处理单个参数校验失败抛出的异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO<List<String>> constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> errors = constraintViolations.stream()
                .map(o -> o.getMessage())
                .collect(Collectors.toList());
        ResultVO<List<String>> result = new ResultVO<>(CommonExceptionEnum.INVALID_PARAMS.getCode(), "参数错误");
        result.setData(errors);
        return result;
    }

    @ExceptionHandler(CommonException.class)
    public ResultVO<String> exception(CommonException exception) {
        return ResultVO.fail(exception.getException());
    }

//    @ExceptionHandler(Exception.class)
//    public ResultVO<String> exception(Exception exception) {
//        LOGGER.error("未知错误", exception);
//        return ResultVO.fail(CommonExceptionEnum.UNKNOWN_ERROR);
//    }

}
