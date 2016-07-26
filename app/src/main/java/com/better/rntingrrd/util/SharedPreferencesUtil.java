package com.better.rntingrrd.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import com.better.rntingrrd.Config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xiashuai on 10:48 2016/7/19.
 * Connection smay1227@163.com.
 */

public class SharedPreferencesUtil {

	public static void cacheLoginFlag(Context context, Boolean loginFlag){
		Editor e = context.getSharedPreferences(Config.APP_ID, Context.MODE_PRIVATE).edit();
		e.putBoolean(Config.KEY_ISLOGIN, loginFlag);
		e.apply();
	}

	public static Boolean getLoginFlag(Context context){
		return context.getSharedPreferences(Config.APP_ID, Context.MODE_PRIVATE).getBoolean(Config.KEY_ISLOGIN, false);
	}

}
