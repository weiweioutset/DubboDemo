package com.demo.dubbo.dto;

import java.io.Serializable;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/26 上午10:41
 * @desc 用户登录信息
 */
public class LoginInfo implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 账号
     */
    private String accountId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 英文名
     */
    private String englishName;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 账号状态 0 申请中 1有效 2删除 3封号
     */
    private Integer status;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 头像缩略图地址
     */
    private String thumbnailAvatar;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getThumbnailAvatar() {
        return thumbnailAvatar;
    }

    public void setThumbnailAvatar(String thumbnailAvatar) {
        this.thumbnailAvatar = thumbnailAvatar;
    }

    /**
     * 初始化登录信息
     * @param user
     * @return
     */
    public static LoginInfo init(UserDto user) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(user.getId());
        loginInfo.setAccountId(user.getAccountId());
        loginInfo.setUuid(user.getUuid());
        loginInfo.setUserName(user.getUserName());
        loginInfo.setRealName(user.getRealName());
        loginInfo.setEnglishName(user.getEnglishName());
        loginInfo.setGender(user.getGender());
        loginInfo.setPhone(user.getPhone());
        loginInfo.setEmail(user.getEmail());
        loginInfo.setStatus(user.getStatus());
        loginInfo.setAvatar(user.getAvatar());
        loginInfo.setThumbnailAvatar(user.getThumbnailAvatar());
        return loginInfo;
    }
}
