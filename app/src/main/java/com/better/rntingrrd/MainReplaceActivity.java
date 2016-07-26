package com.better.rntingrrd;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.better.rntingrrd.base.BaseActivity;
import com.better.rntingrrd.db.User;
import com.better.rntingrrd.di.component.DaggerMainComponent;
import com.better.rntingrrd.presenter.MainPresenter;
import com.better.rntingrrd.ui.IView.IViewMain;
import com.better.rntingrrd.ui.activity.Login;

import javax.inject.Inject;

import butterknife.Bind;

public class MainReplaceActivity extends BaseActivity implements IViewMain{
	@Bind(R.id.toolbar)
	Toolbar toolbar;
	@Bind(R.id.fab)
	FloatingActionButton fab;
	@Bind(R.id.tv_user)
	TextView tv_user;

	@Inject
	MainPresenter mainPresenter;

	@Override
	public int getLayout() {
		return R.layout.activity_main_replace;
	}

	@Override
	public void setupActivityComponent() {
		DaggerMainComponent.builder()
				.rntingComponent(getApplicationComponent())
				.build()
				.inject(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		mainPresenter.getUserInfo();
	}

	@Override
	public void initUiAndListener() {
		mainPresenter.attachView(this);

		setSupportActionBar(toolbar);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case R.id.list:
				showToast("获取列表");
				break;
			case R.id.logout:
				mainPresenter.logOut();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mainPresenter.detachView();
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
	public void UserInfo(User user) {
		tv_user.setText(user.getPhoneno());
	}

	@Override
	public void onLogout() {
		startActivity(new Intent(MainReplaceActivity.this, Login.class));
	}

	@Override
	public void onError(String s) {
		showToast(Config.KEY_SERVERBUSY);
	}
}
