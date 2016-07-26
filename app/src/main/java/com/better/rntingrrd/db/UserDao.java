package com.better.rntingrrd.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.better.rntingrrd.db.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Phoneno = new Property(1, String.class, "phoneno", false, "PHONENO");
        public final static Property Username = new Property(2, String.class, "username", false, "USERNAME");
        public final static Property Description = new Property(3, String.class, "description", false, "DESCRIPTION");
        public final static Property Email = new Property(4, String.class, "email", false, "EMAIL");
        public final static Property Sex = new Property(5, String.class, "sex", false, "SEX");
        public final static Property Age = new Property(6, Integer.class, "age", false, "AGE");
        public final static Property Address = new Property(7, String.class, "address", false, "ADDRESS");
        public final static Property Signature = new Property(8, String.class, "signature", false, "SIGNATURE");
        public final static Property AvlPoints = new Property(9, Integer.class, "avlPoints", false, "AVL_POINTS");
        public final static Property Haspasswd = new Property(10, Integer.class, "haspasswd", false, "HASPASSWD");
        public final static Property Couponnum = new Property(11, Integer.class, "couponnum", false, "COUPONNUM");
        public final static Property Cardnum = new Property(12, Integer.class, "cardnum", false, "CARDNUM");
        public final static Property Hasweixin = new Property(13, Integer.class, "hasweixin", false, "HASWEIXIN");
        public final static Property Hasqq = new Property(14, Integer.class, "hasqq", false, "HASQQ");
        public final static Property Hassina = new Property(15, Integer.class, "hassina", false, "HASSINA");
        public final static Property VehicleNo = new Property(16, String.class, "vehicleNo", false, "VEHICLE_NO");
        public final static Property Uid = new Property(17, String.class, "uid", false, "UID");
        public final static Property Cookie = new Property(18, String.class, "cookie", false, "COOKIE");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'PHONENO' TEXT," + // 1: phoneno
                "'USERNAME' TEXT," + // 2: username
                "'DESCRIPTION' TEXT," + // 3: description
                "'EMAIL' TEXT," + // 4: email
                "'SEX' TEXT," + // 5: sex
                "'AGE' INTEGER," + // 6: age
                "'ADDRESS' TEXT," + // 7: address
                "'SIGNATURE' TEXT," + // 8: signature
                "'AVL_POINTS' INTEGER," + // 9: avlPoints
                "'HASPASSWD' INTEGER," + // 10: haspasswd
                "'COUPONNUM' INTEGER," + // 11: couponnum
                "'CARDNUM' INTEGER," + // 12: cardnum
                "'HASWEIXIN' INTEGER," + // 13: hasweixin
                "'HASQQ' INTEGER," + // 14: hasqq
                "'HASSINA' INTEGER," + // 15: hassina
                "'VEHICLE_NO' TEXT," + // 16: vehicleNo
                "'UID' TEXT," + // 17: uid
                "'COOKIE' TEXT);"); // 18: cookie
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String phoneno = entity.getPhoneno();
        if (phoneno != null) {
            stmt.bindString(2, phoneno);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(3, username);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(4, description);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(5, email);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(6, sex);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(7, age);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(8, address);
        }
 
        String signature = entity.getSignature();
        if (signature != null) {
            stmt.bindString(9, signature);
        }
 
        Integer avlPoints = entity.getAvlPoints();
        if (avlPoints != null) {
            stmt.bindLong(10, avlPoints);
        }
 
        Integer haspasswd = entity.getHaspasswd();
        if (haspasswd != null) {
            stmt.bindLong(11, haspasswd);
        }
 
        Integer couponnum = entity.getCouponnum();
        if (couponnum != null) {
            stmt.bindLong(12, couponnum);
        }
 
        Integer cardnum = entity.getCardnum();
        if (cardnum != null) {
            stmt.bindLong(13, cardnum);
        }
 
        Integer hasweixin = entity.getHasweixin();
        if (hasweixin != null) {
            stmt.bindLong(14, hasweixin);
        }
 
        Integer hasqq = entity.getHasqq();
        if (hasqq != null) {
            stmt.bindLong(15, hasqq);
        }
 
        Integer hassina = entity.getHassina();
        if (hassina != null) {
            stmt.bindLong(16, hassina);
        }
 
        String vehicleNo = entity.getVehicleNo();
        if (vehicleNo != null) {
            stmt.bindString(17, vehicleNo);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(18, uid);
        }
 
        String cookie = entity.getCookie();
        if (cookie != null) {
            stmt.bindString(19, cookie);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // phoneno
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // username
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // description
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // email
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // sex
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // age
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // address
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // signature
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // avlPoints
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // haspasswd
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // couponnum
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // cardnum
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13), // hasweixin
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // hasqq
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15), // hassina
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // vehicleNo
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // uid
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18) // cookie
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPhoneno(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUsername(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDescription(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEmail(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSex(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAge(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setAddress(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setSignature(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAvlPoints(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setHaspasswd(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setCouponnum(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setCardnum(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setHasweixin(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
        entity.setHasqq(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setHassina(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
        entity.setVehicleNo(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setUid(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setCookie(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}