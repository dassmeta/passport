package com.dassmeta.passport.core.service.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 字典缓存
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月24日
 */
public class DictionatryIntegrationCache {

	private final static Map<String, Map<String, CacheModel>> DIC_CACHE = new ConcurrentHashMap<String, Map<String, CacheModel>>();

	public static Map<String, Map<String, CacheModel>> get() {
		return DIC_CACHE;
	}

}
