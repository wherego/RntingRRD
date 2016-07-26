package com.better.rntingrrd;

import android.content.Intent;
import android.widget.TextView;

import com.better.rntingrrd.base.BaseActivity;
import com.better.rntingrrd.db.User;
import com.better.rntingrrd.di.component.DaggerMainComponent;
import com.better.rntingrrd.presenter.MainPresenter;
import com.better.rntingrrd.ui.IView.IViewMain;
import com.better.rntingrrd.ui.activity.Login;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements IViewMain{
    @Bind(R.id.tv_user)
    TextView tv_user;

    @Inject
    MainPresenter mainPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
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
        startActivity(new Intent(MainActivity.this, Login.class));
    }

    @Override
    public void onError(String s) {
        showToast(Config.KEY_SERVERBUSY);
    }
}
