package com.demo.dubbo.service.user;

import com.demo.dubbo.entity.LoginHistoryEntity;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/27 上午9:59
 * @desc 登录历史服务
 */
public interface ILoginHistoryService {
    /**
     * 添加登录历史
     * @param entity
     * @return
     */
    int addHistory(LoginHistoryEntity entity);
}
