package com.judysen.services;

import com.judysen.enums.EnumLevel;
import com.judysen.enities.UserInfo;
import com.judysen.repository.AccountRepository;
import com.judysen.utils.FriendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by judysen on 2017/10/6.
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

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
}
