package com.better.rntingrrd.di.module;

import com.better.rntingrrd.data.remote.RntingApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by xiashuai on 10:30 2016/7/19.
 * Connection smay1227@163.com.
 */
@Module
public class ApiModule {

	@Provides
	@Singleton
	RntingApi provideGameApi(@Named("api") OkHttpClient okHttpClient) {
		return new RntingApi(okHttpClient);
	}

}
