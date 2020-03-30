package com.onekosmos.mvvmappdemo.network;


import com.onekosmos.mvvmappdemo.login.model.LoginGetOTPResponceModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface MethodApiInterface {


    @FormUrlEncoded
    @POST(UrlConstant.LOGIN_VIA_OTP)
    Observable<LoginGetOTPResponceModel> getLoginOTP(@Field("appId") String appID, @Field("mobile") String mobile);


}
