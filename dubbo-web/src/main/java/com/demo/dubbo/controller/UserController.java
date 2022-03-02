package com.demo.dubbo.controller;

import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.service.user.IUserService;
import com.demo.dubbo.vo.ResultVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午4:01
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private IUserService userService;

    @PostMapping("register")
    public ResultVO<UserDto> register(@RequestBody UserDto userDto) throws Exception {
        UserDto user = userService.register(userDto);
        return ResultVO.success(user);
    }
}
