package com.demo.dubbo.service;

import com.demo.dubbo.entity.LoginHistoryEntity;
import com.demo.dubbo.mapper.LoginHistoryMapper;
import com.demo.dubbo.service.user.ILoginHistoryService;
import com.demo.dubbo.utils.AssertUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/27 上午10:00
 * @desc 登录历史服务
 */
@Service
public class LoginHistoryServiceImpl implements ILoginHistoryService {
    @Autowired
    private LoginHistoryMapper loginHistoryMapper;

    /**
     * 添加登录历史
     * @param entity
     * @return
     */
    public int addHistory(LoginHistoryEntity entity) {
        // 参数判断
        AssertUtils.notNull(entity,entity.getUuid(),entity.getLoginIp(),
                entity.getLoginDevice(),entity.getDeviceType(),
                entity.getAccountId());
        return loginHistoryMapper.addHistory(entity);
    }
}
