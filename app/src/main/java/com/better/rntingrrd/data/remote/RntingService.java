package com.better.rntingrrd.data.remote;

import com.better.rntingrrd.db.User;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by xiashuai on 15:34 2016/7/18.
 * Connection smay1227@163.com.
 */

public interface RntingService {

	@FormUrlEncoded @POST("checkappLogin")
	Observable<Integer> login(@FieldMap Map<String, String> params);

	@GET("user/userinfo")
	Observable<User> getUserInfo();

	@GET("logoutapp")
	Observable<Integer> logOut();

}
