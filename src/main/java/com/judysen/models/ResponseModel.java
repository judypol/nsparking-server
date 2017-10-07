package com.judysen.models;

/**
 * Created by judysen on 2017/10/6.
 */
public class ResponseModel {
    Boolean success;
    Object data;
    String message;

    /**
     *
     */
    public ResponseModel(){
        success=false;
        //message="请求失败";
    }

    /**
     *
     * @param success
     * @param data
     * @param message
     */
    public ResponseModel(Boolean success,Object data,String message){
        this.success=success;
        this.data=data;
        this.message=message;
    }
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
