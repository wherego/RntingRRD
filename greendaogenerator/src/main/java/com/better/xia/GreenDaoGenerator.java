package com.better.xia;

import java.io.File;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {
	private static final int VERSION = 2;
	private static final String GREEN_DAO_CODE_PATH = "../RntingRRD/app/src/main/java";

	public static void main(String[] args) throws Exception {

		Schema schema = new Schema(VERSION, "com.better.rntingrrd.db");

		addUser(schema);
		addCookie(schema);

		File f = new File(GREEN_DAO_CODE_PATH);
		if (!f.exists()) {
			f.mkdirs();
		}

		new DaoGenerator().generateAll(schema, f.getAbsolutePath());
	}

	private static void addUser(Schema schema){
		Entity user = schema.addEntity("User");
		user.addIdProperty();
		user.addStringProperty("phoneno");
		user.addStringProperty("username");
		user.addStringProperty("description");
		user.addStringProperty("email");
		user.addStringProperty("sex");
		user.addIntProperty("age");
		user.addStringProperty("address");
		user.addStringProperty("signature");
		user.addIntProperty("avlPoints");
		user.addIntProperty("haspasswd");
		user.addIntProperty("couponnum");
		user.addIntProperty("cardnum");
		user.addIntProperty("hasweixin");
		user.addIntProperty("hasqq");
		user.addIntProperty("hassina");
		user.addStringProperty("vehicleNo");
		user.addStringProperty("uid");
		user.addStringProperty("cookie");
	}

	private static void addCookie(Schema schema){
		Entity cookie = schema.addEntity("Cookie");
		cookie.addIdProperty();
		cookie.addStringProperty("cookie");
	}

}
