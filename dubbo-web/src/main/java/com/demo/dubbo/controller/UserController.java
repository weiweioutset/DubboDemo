package com.demo.dubbo.controller;

import com.demo.dubbo.annotation.PublicAPI;
import com.demo.dubbo.dto.LoginInfo;
import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.service.user.IUserService;
import com.demo.dubbo.utils.UserLoginUtils;
import com.demo.dubbo.vo.ResultVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    @PublicAPI
    public ResultVO<UserDto> register(@RequestBody @Validated UserDto userDto) {
        UserDto user = userService.register(userDto);
        return ResultVO.success(user);
    }

    @PostMapping("login")
    @PublicAPI
    public ResultVO<UserDto> queryAll(@RequestParam("accountId") String accountId,
                                      @RequestParam("password") String password,
                                      HttpServletResponse response) {
        UserDto dto = userService.login(accountId, password);
        UserLoginUtils.login(response, dto);
        return ResultVO.success(dto);
    }


    @GetMapping("getInfo")
    public ResultVO<LoginInfo> getInfo() {
        LoginInfo info = UserLoginUtils.loginInfo();
        return ResultVO.success(info);
    }
}
