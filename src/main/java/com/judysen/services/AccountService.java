package com.judysen.services;

import com.judysen.enities.SignInfo;
import com.judysen.enums.EnumLevel;
import com.judysen.enities.UserInfo;
import com.judysen.repository.AccountRepository;
import com.judysen.repository.SignInfoRepository;
import com.judysen.utils.FriendException;
import org.apache.catalina.User;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by judysen on 2017/10/6.
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    SignInfoRepository signInfoRepository;

    /**
     * 注册用户
     * @param model
     * @return
     * @throws Exception
     */
    public UserInfo signUp(UserInfo model) throws Exception{
        UserInfo oldUser=accountRepository.findByMobile(model.getMobile());
        if(oldUser==null){
            UserInfo ui= accountRepository.save(model);
            ui.setPassword("");
            return ui;
        }else {
            throw new FriendException("此手机号码已经注册过了");
        }
    }

    /**
     *
     * @param mobile
     * @param password
     * @return
     * @throws Exception
     */
    public UserInfo signIn(String mobile,String password) throws Exception{
        UserInfo oldUser=accountRepository.findByMobile(mobile);
        if(oldUser==null){
            throw new FriendException("用户不存在，请先注册");
        }
        if(!oldUser.getPassword().equals(password)){
            throw new FriendException("密码不对");
        }
        oldUser.setPassword("");
        return oldUser;
    }

    /**
     * 更新积分
     * @param mobile
     * @param score
     * @return
     * @throws Exception
     */
    public UserInfo updateScore(String mobile,int score) throws Exception{
        UserInfo oldUser=accountRepository.findByMobile(mobile);
        if(oldUser==null){
            throw new FriendException("用户信息有误");
        }
        int levelScore=oldUser.getScore()+score;
        oldUser.setScore(levelScore);
        if(levelScore<EnumLevel.LevelOne.getScore()){
            oldUser.setLevel(EnumLevel.LevelOne.getName());
        }else if(levelScore<EnumLevel.LevelTwo.getScore()&&levelScore>EnumLevel.LevelOne.getScore()){
            oldUser.setLevel(EnumLevel.LevelTwo.getName());
        }else if(levelScore<EnumLevel.LevelThree.getScore()&&levelScore>EnumLevel.LevelTwo.getScore()){
            oldUser.setLevel(EnumLevel.LevelThree.getName());
        }else{
            oldUser.setLevel(EnumLevel.LevelFore.getName());
        }

        UserInfo newUser=accountRepository.save(oldUser);
        return oldUser;
    }

    /**
     * 签到
     * @param mobile
     * @return
     * @throws Exception
     */
    public UserInfo sign(String mobile) throws Exception{
        UserInfo oldUser=accountRepository.findByMobile(mobile);
        if(oldUser==null){
            throw new FriendException("用户信息有误");
        }

        SignInfo signInfo=getSignScore(oldUser.getUserInfoId());
        if(signInfo==null){
            throw new FriendException("今天已经签到过了");
        }
        int score=signInfo.getSignCnt()==7?3:1;
        UserInfo userInfo=updateScore(mobile,score);
        signInfoRepository.save(signInfo);
        return userInfo;
    }
    /**
     *
     * @param userInfoId
     * @return
     */
    public SignInfo getSignScore(String userInfoId){
        SignInfo signInfo=signInfoRepository.findOne(userInfoId);
        if(signInfo==null){
            signInfo=new SignInfo();
            signInfo.setStartDate(new Date());
            signInfo.setSignDate(new Date());
            signInfo.setSignCnt(1);
            signInfo.setUserInfoId(userInfoId);
        }else if(DateUtils.isSameDay(signInfo.getSignDate(),new Date())){
            signInfo=null;      //已经签到过了
        } else if(!DateUtils.isSameDay(DateUtils.addDays(signInfo.getStartDate(),signInfo.getSignCnt()),new Date())){
            signInfo.setSignCnt(1);                     //不是连续签到，从新开始
            signInfo.setSignDate(new Date());
            signInfo.setStartDate(new Date());
        }else if(signInfo.getSignCnt()==7){
            signInfo.setSignCnt(1);                     //已经连续签到了7天重新开始签到
            signInfo.setSignDate(new Date());
            signInfo.setStartDate(new Date());
        }else {
            signInfo.setSignCnt(signInfo.getSignCnt()+1);
            signInfo.setSignDate(new Date());
        }

        return signInfo;
    }

    /**
     * 保存签到信息
     * @param signInfo
     */
    public void saveSignInfo(SignInfo signInfo){
        signInfoRepository.save(signInfo);
    }
}
