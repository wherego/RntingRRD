package com.better.rntingrrd.presenter;

import com.better.rntingrrd.base.BasePresenter;
import com.better.rntingrrd.base.IView;
import com.better.rntingrrd.data.local.UserStorage;
import com.better.rntingrrd.data.remote.RntingApi;
import com.better.rntingrrd.db.User;
import com.better.rntingrrd.db.UserDao;
import com.better.rntingrrd.ui.IView.IViewMain;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by xiashuai on 15:21 2016/7/19.
 * Connection smay1227@163.com.
 */

public class MainPresenter implements BasePresenter{

	private RntingApi mRntingApi;
	private UserStorage mUserStorage;

	private IViewMain mViewMain;
	private Subscription mSubscription;

	@Inject
	public MainPresenter(RntingApi rntingApi, UserStorage userStorage){
		mRntingApi = rntingApi;
		mUserStorage = userStorage;
	}

	public void getUserInfo(){
		mViewMain.showLoading();
		mSubscription = mRntingApi.getUserInfo()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<User>() {
					@Override
					public void call(User user) {
						mViewMain.hideLoading();
						mUserStorage.storeUser(user);
						mViewMain.UserInfo(user);
					}
				}, new Action1<Throwable>() {
					@Override
					public void call(Throwable throwable) {
						mViewMain.hideLoading();
						if (throwable.toString().contains("JsonSyntaxException")){
							mUserStorage.logout();
							mViewMain.onLogout();
						}else {
							mViewMain.onError(throwable.toString());
						}
					}
				});

	}

	public void logOut(){
		mViewMain.showLoading();
		mSubscription = mRntingApi.logOut()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<Integer>() {
					@Override
					public void call(Integer integer) {
						mViewMain.hideLoading();
						if (integer == 0){
							mUserStorage.logout();
							mViewMain.onLogout();
						}else {
							mViewMain.onError("退出出错，稍后再试");
						}
					}
				}, new Action1<Throwable>() {
					@Override
					public void call(Throwable throwable) {
						mViewMain.hideLoading();
						mViewMain.onError(throwable.toString());
					}
				});
	}

	@Override
	public void attachView(IView view) {
		mViewMain = (IViewMain) view;
	}

	@Override
	public void detachView() {
		if (mSubscription != null && !mSubscription.isUnsubscribed()) {
			mSubscription.unsubscribe();
		}
		mViewMain = null;
	}
}
