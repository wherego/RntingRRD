package com.better.rntingrrd.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.better.rntingrrd.db.User;
import com.better.rntingrrd.db.Cookie;

import com.better.rntingrrd.db.UserDao;
import com.better.rntingrrd.db.CookieDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig cookieDaoConfig;

    private final UserDao userDao;
    private final CookieDao cookieDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        cookieDaoConfig = daoConfigMap.get(CookieDao.class).clone();
        cookieDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        cookieDao = new CookieDao(cookieDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Cookie.class, cookieDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        cookieDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public CookieDao getCookieDao() {
        return cookieDao;
    }

}