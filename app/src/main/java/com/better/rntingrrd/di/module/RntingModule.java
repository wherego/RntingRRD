package com.better.rntingrrd.di.module;

import android.content.Context;

import com.better.rntingrrd.data.local.UserStorage;
import com.better.rntingrrd.data.retrofit.PersistentCookie;
import com.better.rntingrrd.data.retrofit.SharedPrefsPersistentCookie;
import com.better.rntingrrd.db.CookieDao;
import com.better.rntingrrd.db.UserDao;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by xiashuai on 2016/7/17.
 * Connection smay1227@163.com.
 */
@Module
public class RntingModule {
    private final Context context;

    public RntingModule (Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext(){
        return context.getApplicationContext();
    }

    @Provides
    @Singleton
    UserStorage provideUserStorage(Context mContext, PersistentCookie cookieJar, UserDao userDao) {
        return new UserStorage(mContext, cookieJar, userDao);
    }

    @Provides
    @Singleton
    PersistentCookie cookieJar(CookieDao cookieDao){
        return new PersistentCookie(new SetCookieCache(), new SharedPrefsPersistentCookie(cookieDao));
    }

    @Provides
    @Singleton
    @Named("api")
    OkHttpClient provideApiOkHttpClient(PersistentCookie cookieJar) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
        //builder.addInterceptor(mCookieInterceptor);
        builder.cookieJar(cookieJar);
        return builder.build();
    }

}
