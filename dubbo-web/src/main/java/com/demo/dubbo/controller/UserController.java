package com.demo.dubbo.controller;

import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.service.user.IUserService;
import com.demo.dubbo.vo.ResultVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
    public ResultVO<UserDto> register(@RequestBody @Validated UserDto userDto) {
        UserDto user = userService.register(userDto);
        return ResultVO.success(user);
    }

    @PostMapping("login")
    public ResultVO<UserDto> queryAll(@RequestParam("accountId") String accountId,
                                      @RequestParam("password") String password) {
        UserDto dto = userService.login(accountId,password);
        return ResultVO.success(dto);
    }

    @PostMapping("testValidate")
    public ResultVO<UserDto> validate(@RequestBody @Validated UserDto userDto) {
        System.out.println(userDto.toString());
        return ResultVO.success();
    }
}
