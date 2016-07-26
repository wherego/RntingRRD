package com.better.rntingrrd.ui.IView;

import com.better.rntingrrd.base.IView;
import com.better.rntingrrd.db.User;

/**
 * Created by xiashuai on 15:29 2016/7/19.
 * Connection smay1227@163.com.
 */

public interface IViewMain extends IView{

	void showLoading();

	void hideLoading();

	void UserInfo(User user);

	void onLogout();

	void onError(String s);

}
