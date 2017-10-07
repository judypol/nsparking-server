package com.judysen.enities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 签到信息表
 * Created by judysen on 2017/10/7.
 */
@Setter
@Getter
public class SignInfo {
    @Id
    String signInfoId;
    Date startDate;
    Date signDate;
    int signCnt;
    String userInfoId;

    public String getSignInfoId() {
        return signInfoId;
    }

    public void setSignInfoId(String signInfoId) {
        this.signInfoId = signInfoId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public int getSignCnt() {
        return signCnt;
    }

    public void setSignCnt(int signCnt) {
        this.signCnt = signCnt;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }
}
