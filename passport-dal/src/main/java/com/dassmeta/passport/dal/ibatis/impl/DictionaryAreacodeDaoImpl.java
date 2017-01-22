package com.dassmeta.passport.dal.ibatis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dassmeta.passport.dal.IBatisBaseDao;
import com.dassmeta.passport.dal.dataobject.DictionaryAreacode;
import com.dassmeta.passport.dal.ibatis.DictionaryAreacodeDao;

public class DictionaryAreacodeDaoImpl extends IBatisBaseDao<DictionaryAreacode> implements DictionaryAreacodeDao {

	public List<DictionaryAreacode> getAreaByAreaCode(String areaCode) {
		return getSqlSession().selectList("com.dassmeta.passport.dal.ibatis.impl.DictionaryAreacodeDaoImpl.getAreaByAreaCode", areaCode);
	}

	public List<DictionaryAreacode> getAjaxArea(String areaCode, String area, String nextArea) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("areaCode", areaCode);
		params.put("area", area);
		params.put("nextArea", nextArea);
		return getSqlSession().selectList("com.dassmeta.passport.dal.ibatis.impl.DictionaryAreacodeDaoImpl.getAjaxArea", params);
	}
}
