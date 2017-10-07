package com.judysen.enities;

import com.judysen.enums.EnumLevel;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

/**
 * Created by judysen on 2017/10/6.
 */
public class UserInfo {
    @Id
    String userInfoId;
    @NotEmpty(message="用户名不能空")
    String userName;
    @NotEmpty(message="手机号不能空")
    String mobile;
    boolean sex;
    @NotEmpty(message="密码不能空")
    String password;
    int score;
    String level;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        userInfoId = userInfoId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
