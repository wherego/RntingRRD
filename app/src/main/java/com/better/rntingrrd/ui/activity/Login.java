package com.better.rntingrrd.ui.activity;

import android.widget.Button;
import android.widget.EditText;

import com.better.rntingrrd.Config;
import com.better.rntingrrd.R;
import com.better.rntingrrd.base.BaseActivity;
import com.better.rntingrrd.di.component.DaggerLoginComponent;
import com.better.rntingrrd.presenter.LoginPresenter;
import com.better.rntingrrd.ui.IView.IViewLogin;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class Login extends BaseActivity implements IViewLogin{
	@Bind(R.id.et_name)
	EditText et_name;
	@Bind(R.id.et_password)
	EditText et_password;
	@Bind(R.id.button)
	Button button;

	@Inject
	LoginPresenter loginPresenter;

	@OnClick(R.id.button)
	public void onClick(){
		loginPresenter.login("18262276782", "123456");
	}

	@Override
	public int getLayout() {
		return R.layout.activity_login;
	}

	@Override
	public void setupActivityComponent() {
		DaggerLoginComponent.builder()
				.rntingComponent(getApplicationComponent())
				.build()
				.inject(this);
	}

	@Override
	public void initUiAndListener() {
		loginPresenter.attachView(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		loginPresenter.detachView();
	}

	@Override
	public void showLoading() {
		showSpotDialog();
	}

	@Override
	public void hideLoading() {
		dismissSpotDialog();
	}

	@Override
	public void showUserNameError(String error) {
		showToast("用户名错误");
	}

	@Override
	public void showUserPasswordError(String error) {
		showToast("密码错误");
	}

	@Override
	public void loginSuccess() {
		showToast("登录成功");
		finish();
	}

	@Override
	public void loginError() {
		showToast(Config.KEY_SERVERBUSY);
	}
}
