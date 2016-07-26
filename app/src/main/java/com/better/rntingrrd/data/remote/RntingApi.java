package com.better.rntingrrd.data.remote;

import com.better.rntingrrd.Config;
import com.better.rntingrrd.db.User;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by xiashuai on 15:34 2016/7/18.
 * Connection smay1227@163.com.
 */

public class RntingApi {

	private RntingService rntingService;

	public RntingApi(OkHttpClient mOkHttpClient){
		String BASE_URL = "http://120.26.116.79/zteitsrnt/";
		Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.client(mOkHttpClient)
				.baseUrl(BASE_URL)
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		rntingService = retrofit.create(RntingService.class);
	}

	/**
	 * 登录
	 * @param userName 用户名
	 * @param passWord 密码
	 */
	public Observable<Integer> login(String userName, String passWord){
		Map<String, String> params = new HashMap<>();
		params.put(Config.KEY_USERNAME, userName);
		params.put(Config.KEY_PASSWORD, passWord);
		return rntingService.login(params).subscribeOn(Schedulers.io());
	}

	/**
	 * 获取用户信息
	 */
	public Observable<User> getUserInfo(){
		return rntingService.getUserInfo().subscribeOn(Schedulers.io());
	}

	public Observable<Integer> logOut(){
		return rntingService.logOut().subscribeOn(Schedulers.io());
	}

}
