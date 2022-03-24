package com.demo.dubbo.mapper;

import com.demo.dubbo.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/23 下午8:52
 * @desc
 */
@Mapper
@Repository
public interface UserMapper {
    int register(UserDto user);

    UserDto queryByAccountId(@Param("accountId") String accountId);
}
