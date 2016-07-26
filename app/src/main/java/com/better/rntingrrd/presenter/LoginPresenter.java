package com.better.rntingrrd.presenter;

import android.text.TextUtils;

import com.better.rntingrrd.base.BasePresenter;
import com.better.rntingrrd.base.IView;
import com.better.rntingrrd.data.local.UserStorage;
import com.better.rntingrrd.data.remote.RntingApi;
import com.better.rntingrrd.ui.IView.IViewLogin;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by xiashuai on 16:23 2016/7/18.
 * Connection smay1227@163.com.
 */

public class LoginPresenter implements BasePresenter{

	private RntingApi mRntingApi;
	private UserStorage mUserStorage;

	private IViewLogin mViewLogin;
	private Subscription mSubscription;

	@Inject
	public LoginPresenter(RntingApi rntingApi, UserStorage userStorage){
		mRntingApi = rntingApi;
		mUserStorage = userStorage;
	}

	public void login(String userName, String passWord){
		if (TextUtils.isEmpty(userName)) {
			mViewLogin.showUserNameError("请输入用户名");
			return;
		}
		if (TextUtils.isEmpty(passWord)) {
			mViewLogin.showUserPasswordError("请输入密码");
			return;
		}
		mViewLogin.showLoading();
		mSubscription = mRntingApi.login(userName, passWord)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<Integer>() {
					@Override
					public void call(Integer integer) {
						mViewLogin.hideLoading();
						mUserStorage.login();
						mViewLogin.loginSuccess();
					}
				}, new Action1<Throwable>() {
					@Override
					public void call(Throwable throwable) {
						mViewLogin.hideLoading();
						mViewLogin.loginError();
					}
				});
	}

	@Override
	public void attachView(IView view) {
		mViewLogin = (IViewLogin) view;
	}

	@Override
	public void detachView() {
		if (mSubscription != null && !mSubscription.isUnsubscribed()) {
			mSubscription.unsubscribe();
		}
		mViewLogin = null;
	}
}
