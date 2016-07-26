package com.better.rntingrrd.ui.IView;

import com.better.rntingrrd.base.IView;

/**
 * Created by xiashuai on 16:50 2016/7/18.
 * Connection smay1227@163.com.
 */

public interface IViewLogin extends IView{

	void showLoading();

	void hideLoading();

	void showUserNameError(String error);

	void showUserPasswordError(String error);

	void loginSuccess();

	void loginError();

}
