package com.onekosmos.mvvmappdemo.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginGetOTPResponceModel {

    @SerializedName("data")
    @Expose
    private String otpDataModel;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("message")
    @Expose
    private String message;

    public String getOtpDataModel() {
        return otpDataModel;
    }

    public void setOtpDataModel(String otpDataModel) {
        this.otpDataModel = otpDataModel;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
