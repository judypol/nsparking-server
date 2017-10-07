package com.judysen.controller;

import com.judysen.models.ResponseModel;
import com.judysen.enities.UserInfo;
import com.judysen.models.SignModel;
import com.judysen.services.AccountService;
import com.judysen.utils.FriendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by judysen on 2017/10/5.
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController {
    @Autowired
    AccountService accountService;

    /**
     * @param userInfo
     * @return
     */
    @RequestMapping("/login")
    public @ResponseBody
    ResponseModel login(@RequestBody UserInfo userInfo) {
        ResponseModel responseModel = new ResponseModel();
        try {
            UserInfo ui = accountService.signIn(userInfo.getMobile(), userInfo.getPassword());
            responseModel.setSuccess(true);
            ui.setPassword("");
            responseModel.setData(ui);
        } catch (FriendException fe) {
            responseModel.setMessage(fe.getMessage());
        } catch (Exception ex) {
            responseModel.setMessage("登录失败!");
        }

        return responseModel;
    }

    /**
     * 注册一个用户
     *
     * @param userInfo
     * @return
     */
    @RequestMapping("/signup")
    public @ResponseBody
    ResponseModel signUp(@Valid UserInfo userInfo, BindingResult result) {
        ResponseModel responseModel = new ResponseModel();
        String errs = getModelErrors(result);
        if (!StringUtils.isEmpty(errs)) {
            responseModel.setMessage(errs);
            responseModel.setSuccess(false);
            return responseModel;
        }
        try {
            UserInfo ui = accountService.signUp(userInfo);
            ui.setPassword("");
            responseModel.setSuccess(true);
            responseModel.setData(ui);
        } catch (FriendException fe) {
            responseModel.setMessage(fe.getMessage());
        } catch (Exception ex) {
            responseModel.setMessage("注册失败!");
        }

        return responseModel;
    }

    /**
     * 每日签到，积分会增加
     *
     * @return
     */
    @RequestMapping("/sign")
    public @ResponseBody ResponseModel sign(@RequestBody SignModel model) {
        ResponseModel responseModel = new ResponseModel();
        try{
            UserInfo ui=accountService.updateScore(model.getMobile(),model.getScore());
            ui.setPassword("");
            responseModel.setSuccess(true);
            responseModel.setData(ui);
        }catch (FriendException fe){
            responseModel.setMessage(fe.getMessage());
        }catch (Exception ex){
            responseModel.setMessage("签到失败");
        }
        return responseModel;
    }
}
