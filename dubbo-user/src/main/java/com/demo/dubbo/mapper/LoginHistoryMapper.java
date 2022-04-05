package com.demo.dubbo.mapper;

import com.demo.dubbo.entity.LoginHistoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/27 上午9:55
 * @desc
 */
@Mapper
@Repository
public interface LoginHistoryMapper {
    /**
     * 添加登录历史
     * @param entity
     * @return
     */
    int addHistory(LoginHistoryEntity entity);
}
