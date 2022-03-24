package com.demo.dubbo.dto;

import com.demo.dubbo.constant.BaseConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午3:58
 * @desc
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
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
    @NotEmpty(message = "账号不能为空")
    private String accountId;
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
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
    @NotNull(message = "性别不能为空")
    private Integer gender;
    /**
     * 注册时间
     */
    @JsonFormat(pattern = BaseConstant.PATTERN_A, timezone = BaseConstant.TIME_ZONE)
    private Date registerTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = BaseConstant.PATTERN_A, timezone = BaseConstant.TIME_ZONE)
    private Date updateTime;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    @Email(message = "邮箱不合法")
    private String email;
    /**
     * 密码（加密）
     */
    @NotEmpty(message = "密码不能为空")
    private String password;
    /**
     * 生日
     */
    @Past(message = "不能穿越")
    @JsonFormat(pattern = BaseConstant.PATTERN_C, timezone = BaseConstant.TIME_ZONE)
    private Date birthday;
    /**
     * 账号状态 0 申请中 1有效 2删除 3封号
     */
    private Integer status;

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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "uuid='" + uuid + '\'' +
                ", accountId='" + accountId + '\'' +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
