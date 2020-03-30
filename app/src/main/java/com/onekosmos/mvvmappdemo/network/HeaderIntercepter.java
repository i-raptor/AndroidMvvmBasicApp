package com.onekosmos.mvvmappdemo.network;


import android.app.Application;

import com.onekosmos.mvvmappdemo.utils.AppUrl;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderIntercepter implements Interceptor {
    private String authToken = "null";
    private Application application;

    public HeaderIntercepter(Application application) {
        this.application = application;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("authorization", AppUrl.BASIC + authToken)
                .addHeader("Content-Type", AppUrl.CONTENT_TYPE)
                .method(original.method(), original.body());
        Request request = requestBuilder.build();
        Response response = chain.proceed(request);
        return response;
    }

}
