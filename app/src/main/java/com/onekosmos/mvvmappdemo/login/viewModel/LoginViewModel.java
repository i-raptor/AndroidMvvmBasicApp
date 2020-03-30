package com.onekosmos.mvvmappdemo.login.viewModel;

import android.app.Application;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onekosmos.mvvmappdemo.login.model.LoginGetOTPResponceModel;
import com.onekosmos.mvvmappdemo.login.repository.LoginSignUpRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class LoginViewModel extends ViewModel implements LifecycleObserver {

    public MutableLiveData<LoginGetOTPResponceModel> liveDataGetOTPLogin = new MutableLiveData<LoginGetOTPResponceModel>();

    public LoginViewModel() {

    }

    public void setDataForLogin(Application application, String userId) {
        LoginSignUpRepository loginSignUpRepository = new LoginSignUpRepository();
        loginSignUpRepository.getLoginOTPData(application, userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(loginGetOTPObserver);
    }


    private Observer<LoginGetOTPResponceModel> loginGetOTPObserver = new Observer<LoginGetOTPResponceModel>() {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(LoginGetOTPResponceModel responceModel) {
            liveDataGetOTPLogin.postValue(responceModel);
        }

        @Override
        public void onError(Throwable e) {
            e.getMessage();
            e.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    };

}
