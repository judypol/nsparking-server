package com.judysen.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * Created by judysen on 2017/10/6.
 */
public class BaseController {
    /**
     * 获取模型验证信息
     * @param result
     * @return
     */
    protected String getModelErrors(BindingResult result){
        String strErr=null;
        if(result.hasErrors()){
            StringBuilder sb=new StringBuilder();
            for (FieldError error:result.getFieldErrors()){
                sb.append(error.getDefaultMessage()+"\r\n");
            }
            strErr=sb.toString();
        }
        return strErr;
    }
}
