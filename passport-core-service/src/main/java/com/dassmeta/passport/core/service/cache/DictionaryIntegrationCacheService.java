package com.dassmeta.passport.core.service.cache;

import java.util.Map;

/**
 * 字典缓存服务
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月21日
 */
public interface DictionaryIntegrationCacheService {

	/**
	 * 从DB初始化
	 */
	void init();

	/**
	 * 刷新
	 */
	void reflush();

	/**
	 * 获取字典缓存
	 * 
	 * @return
	 */
	Map<String, Map<String, CacheModel>> get();

	/**
	 * 根据key获取字典缓存
	 * 
	 * @param name
	 * @return
	 */
	Map<String, CacheModel> getDicByName(String name);

}
