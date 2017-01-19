package com.dassmeta.passport.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Constants {
	public static final String USER_RIGHT_ASSIGNED = "1";
	public static final String USER_RIGHT_OWN = "2";
	public static final String IS_ACTIVE = "1";
	public static final String IS_NOT_ACTIVE = "2";
	public static final String KEY_SESSION_ONLINE_USER = "SSH_ONLINE_USER";
	public static final String KEY_SESSION_RANDIMAGE = "RANDIMAGE";
	public static final String KEY_COOKIE_TOKEN = "cn.bornsoft.sso.token";
	public static boolean CREATE_INDEX = false;

	public static String randomizer() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		String yy = calendar.get(1) + "";
		yy = yy + (calendar.get(2) + 1 > 9 ? calendar.get(2) + 1 : new StringBuilder("0").append(calendar.get(2) + 1).toString());
		yy = yy + (calendar.get(5) + 1 > 9 ? calendar.get(5) + 1 : new StringBuilder("0").append(calendar.get(5) + 1).toString());
		yy = yy + (calendar.get(11) + 1 > 9 ? calendar.get(11) + 1 : new StringBuilder("0").append(calendar.get(11) + 1).toString());
		yy = yy + (calendar.get(12) + 1 > 9 ? calendar.get(12) + 1 : new StringBuilder("0").append(calendar.get(12) + 1).toString());
		yy = yy + (calendar.get(14) + 1 > 9 ? calendar.get(14) + 1 : new StringBuilder("0").append(calendar.get(14) + 1).toString());
		yy = yy + (int) (Math.random() * 100.0D);
		return yy;
	}

	// public static Map userMap = new HashMap();
	public static List<String> userList = new ArrayList<String>();

	static {
		userList.add("gsq");
		userList.add("bjq");
	}

	public boolean verifyUser(Object user) {
		return userList.contains(user);
	}
}
