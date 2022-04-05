package com.demo.dubbo.entity;

import com.demo.dubbo.constant.BaseConstant;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/27 上午9:45
 * @desc 登录历史
 */
public class LoginHistoryEntity implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 账号id
     */
    private String accountId;
    /**
     * 登录设备
     */
    private String loginDevice;
    /**
     * 登录设备 PC/APP
     */
    private String deviceType;
    /**
     * 登录ip
     */
    private String loginIp;
    /**
     * 登录时间
     */
    @JsonFormat(pattern = BaseConstant.PATTERN_A, timezone = BaseConstant.TIME_ZONE)
    private Date loginTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
