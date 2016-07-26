package com.better.rntingrrd.di.component;

import android.content.Context;

import com.better.rntingrrd.RntingApplication;
import com.better.rntingrrd.base.BaseActivity;
import com.better.rntingrrd.data.local.UserStorage;
import com.better.rntingrrd.data.remote.RntingApi;
import com.better.rntingrrd.data.retrofit.PersistentCookie;
import com.better.rntingrrd.db.UserDao;
import com.better.rntingrrd.di.module.ApiModule;
import com.better.rntingrrd.di.module.DBModule;
import com.better.rntingrrd.di.module.RntingModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xiashuai on 2016/7/17.
 * Connection smay1227@163.com.
 */
@Singleton
@Component(modules = {RntingModule.class, ApiModule.class, DBModule.class})
public interface RntingComponent {

    void inject(RntingApplication rntingApplication);

    void inject(BaseActivity mBaseActivity);

    Context application();

    RntingApi getRntingApi();

    UserStorage getUserStorage();

}
