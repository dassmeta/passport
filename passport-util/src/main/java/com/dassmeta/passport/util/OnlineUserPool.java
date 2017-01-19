package com.dassmeta.passport.util;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OnlineUserPool implements Serializable {
	private static final long serialVersionUID = 1201554877658761938L;

	public static synchronized OnlineUserPool getInstance() {
		return OnlineUserPoolHolder.instance;
	}

	public synchronized OnlineUser addUser(OnlineUser user) {
		return OnlineUserPoolHolder.pool.putIfAbsent(user.getSessionId(), user);
	}

	public synchronized OnlineUser updateUser(OnlineUser user) {
		return OnlineUserPoolHolder.pool.replace(user.getSessionId(), user);
	}

	public synchronized void removeUser(String sessionid) {
		OnlineUserPoolHolder.pool.remove(sessionid);
	}

	public synchronized OnlineUser getUserOnlineBySessionid(String sessionid) {
		return OnlineUserPoolHolder.pool.get(sessionid);
	}

	private static class OnlineUserPoolHolder {
		private static final OnlineUserPool instance = new OnlineUserPool();
		private static ConcurrentMap<String, OnlineUser> pool = new ConcurrentHashMap<String, OnlineUser>();
	}
}
