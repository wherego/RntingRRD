package com.better.rntingrrd.data.local;

import android.content.Context;

import com.better.rntingrrd.data.retrofit.PersistentCookie;
import com.better.rntingrrd.db.User;
import com.better.rntingrrd.db.UserDao;
import com.better.rntingrrd.util.SharedPreferencesUtil;

public class UserStorage {

  private Context mContext;
  private PersistentCookie mCookieJar;
  private UserDao mUserDao;

  public UserStorage(Context mContext, PersistentCookie cookieJar, UserDao userDao) {
    this.mContext = mContext;
    this.mCookieJar = cookieJar;
    this.mUserDao = userDao;
  }

  public void login() {
    SharedPreferencesUtil.cacheLoginFlag(mContext, true);
  }

  public void storeUser(User user){
    mUserDao.insertOrReplace(user);
  }

  public void logout() {
    SharedPreferencesUtil.cacheLoginFlag(mContext, false);
    mUserDao.deleteAll();
    removeCookie();
  }

  private void removeCookie() {
    mCookieJar.clear();
  }

  public boolean isLogin() {
    return SharedPreferencesUtil.getLoginFlag(mContext);
  }

}
