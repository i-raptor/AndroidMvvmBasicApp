package com.onekosmos.mvvmappdemo.login.repository;

import android.app.Application;

import com.onekosmos.mvvmappdemo.login.model.LoginGetOTPResponceModel;
import com.onekosmos.mvvmappdemo.network.MethodApiInterface;
import com.onekosmos.mvvmappdemo.network.NetworkHelperBase;
import com.onekosmos.mvvmappdemo.utils.AppUrl;

import io.reactivex.Observable;


public class LoginSignUpRepository {

    private MethodApiInterface apiInterface;

    public LoginSignUpRepository() {

    }




    public Observable<LoginGetOTPResponceModel> getLoginOTPData(Application application, String userId) {
        Observable<LoginGetOTPResponceModel> otpResponceModelObservable=null;
        try {
            apiInterface = NetworkHelperBase.getClient(application).create(MethodApiInterface.class);
            otpResponceModelObservable = apiInterface.getLoginOTP(AppUrl.APP_ID_VALUE_POST, userId);
            return otpResponceModelObservable;
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            return otpResponceModelObservable;
        }
    }


}
