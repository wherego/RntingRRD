package com.better.rntingrrd.di.module;

import android.content.Context;

import com.better.rntingrrd.db.CookieDao;
import com.better.rntingrrd.db.DaoMaster;
import com.better.rntingrrd.db.DaoSession;
import com.better.rntingrrd.db.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xiashuai on 11:35 2016/7/19.
 * Connection smay1227@163.com.
 */
@Module
public class DBModule {

	@Provides
	@Singleton
	DaoMaster.DevOpenHelper provideDevOpenHelper(Context context) {
		return new DaoMaster.DevOpenHelper(context, "app.db", null);
	}

	@Provides
	@Singleton
	DaoMaster provideDaoMaster(DaoMaster.DevOpenHelper helper) {
		return new DaoMaster(helper.getWritableDatabase());
	}

	@Provides
	@Singleton
	DaoSession provideDaoSession(DaoMaster master) {
		return master.newSession();
	}

	@Provides
	@Singleton
	UserDao provideUserDao(DaoSession session) {
		return session.getUserDao();
	}

	@Provides
	@Singleton
	CookieDao provideCookieDao(DaoSession session) {
		return session.getCookieDao();
	}

}
