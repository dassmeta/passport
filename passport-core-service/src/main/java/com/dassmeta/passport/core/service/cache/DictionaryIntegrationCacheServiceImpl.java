package com.dassmeta.passport.core.service.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dassmeta.passport.dal.dataobject.DictionaryIntegration;
import com.dassmeta.passport.dal.ibatis.DictionaryIntegrationDao;

/**
 * 字典缓存服务
 * 
 * @author chenxin@dassmeta.com
 * @creation 2017年2月21日
 */
@Service("dictionaryIntegrationCacheService")
public class DictionaryIntegrationCacheServiceImpl implements DictionaryIntegrationCacheService {

	private final static Logger logger = LoggerFactory.getLogger(DictionaryIntegrationCacheServiceImpl.class);

	/**
	 * 字典缓存
	 */
	private Map<String, Map<String, CacheModel>> dictionaryIntegrationCache = new ConcurrentHashMap<String, Map<String, CacheModel>>();

	@Autowired
	private DictionaryIntegrationDao dictionaryIntegrationDao;

	@Override
	public synchronized void init() {
		if (logger.isInfoEnabled()) {
			logger.info("Dictionary Integration init start!");
		}
		List<DictionaryIntegration> dis = dictionaryIntegrationDao.findAll();

		for (DictionaryIntegration di : dis) {
			CacheModel cacheModel = new CacheModel();
			cacheModel.setCode(di.getCode());
			cacheModel.setName(di.getName());
			cacheModel.setState(di.getState());
			cacheModel.setValue(di.getValue());
			if (!dictionaryIntegrationCache.containsKey(di.getName())) {
				Map<String, CacheModel> subCache = new HashMap<String, CacheModel>();
				dictionaryIntegrationCache.put(di.getName(), subCache);
			}
			dictionaryIntegrationCache.get(di.getName()).put(di.getCode(), cacheModel);
		}

		if (logger.isInfoEnabled()) {
			logger.info("Dictionary Integration init finished!");
		}
	}

	@Override
	public synchronized void reflush() {
		if (logger.isInfoEnabled()) {
			logger.info("Dictionary Integration reflush start!");
		}

		List<DictionaryIntegration> dis = dictionaryIntegrationDao.findAll();
		for (DictionaryIntegration di : dis) {
			CacheModel cacheModel = new CacheModel();
			cacheModel.setCode(di.getCode());
			cacheModel.setName(di.getName());
			cacheModel.setState(di.getState());
			cacheModel.setValue(di.getValue());
			if (!dictionaryIntegrationCache.containsKey(di.getName())) {
				Map<String, CacheModel> subCache = new HashMap<String, CacheModel>();
				dictionaryIntegrationCache.put(di.getName(), subCache);
			}
			dictionaryIntegrationCache.get(di.getName()).put(di.getCode(), cacheModel);
		}

		if (logger.isInfoEnabled()) {
			logger.info("Dictionary Integration reflush finished!");
		}
	}

	@Override
	public Map<String, Map<String, CacheModel>> get() {
		return this.dictionaryIntegrationCache;
	}

	@Override
	public Map<String, CacheModel> getDicByName(String name) {
		return this.dictionaryIntegrationCache.get(name);
	}

}
