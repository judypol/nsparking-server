package com.judysen.models;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by judysen on 2017/10/7.
 */
public class SignModel {
    @NotEmpty(message = "手机号不能为空!")
    String mobile;

    int score;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
