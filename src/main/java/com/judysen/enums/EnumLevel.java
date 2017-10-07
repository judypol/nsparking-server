package com.judysen.enums;

/**
 * Created by judysen on 2017/10/6.
 */
public enum EnumLevel {
    LevelOne("普通会员",50),
    LevelTwo("黄金会员",80),
    LevelThree("铂金会员",200),
    LevelFore("钻石会员",1000000)
    ;

    int score;
    String name;
    EnumLevel(String name,int score){
        this.name=name;
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
