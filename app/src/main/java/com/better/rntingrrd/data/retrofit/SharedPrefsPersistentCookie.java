package com.better.rntingrrd.data.retrofit;

import com.better.rntingrrd.db.CookieDao;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.franmontiel.persistentcookiejar.persistence.SerializableCookie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import okhttp3.Cookie;

/**
 * Created by xiashuai on 14:19 2016/7/20.
 * Connection smay1227@163.com.
 */

public class SharedPrefsPersistentCookie implements CookiePersistor {
	private CookieDao mCookieDao;

	public SharedPrefsPersistentCookie(CookieDao cookieDao) {
		mCookieDao = cookieDao;
	}

	public List<Cookie> loadAll() {
		List<Cookie> cookies = new ArrayList<>();
		List<com.better.rntingrrd.db.Cookie> dbCookies = mCookieDao.loadAll();
		for (com.better.rntingrrd.db.Cookie cookie: dbCookies){
			cookies.add((new SerializableCookie()).decode(cookie.getCookie()));
		}

		return cookies;
	}

	public void saveAll(Collection<Cookie> cookies) {
		String cookieSerializable;
		com.better.rntingrrd.db.Cookie dbCookie;
		for (Cookie cookie: cookies){
			cookieSerializable = (new SerializableCookie()).encode(cookie);
			dbCookie = new com.better.rntingrrd.db.Cookie();
			dbCookie.setCookie(cookieSerializable);
			mCookieDao.insertOrReplace(dbCookie);
		}

	}

	public void removeAll(Collection<Cookie> cookies) {
		String cookieSerializable;
		com.better.rntingrrd.db.Cookie dbCookie;
		for (Cookie cookie: cookies){
			cookieSerializable = (new SerializableCookie()).encode(cookie);
			dbCookie = new com.better.rntingrrd.db.Cookie();
			dbCookie.setCookie(cookieSerializable);
			mCookieDao.delete(dbCookie);
		}
	}

	public void clear() {
		mCookieDao.deleteAll();
	}
}
