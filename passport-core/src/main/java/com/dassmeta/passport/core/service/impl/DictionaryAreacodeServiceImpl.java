package com.dassmeta.passport.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dassmeta.passport.core.service.DictionaryAreacodeService;
import com.dassmeta.passport.dal.dataobject.DictionaryAreacode;
import com.dassmeta.passport.dal.ibatis.DictionaryAreacodeDao;

@Service("areacodeService")
public class DictionaryAreacodeServiceImpl implements DictionaryAreacodeService {

	@Autowired
	private DictionaryAreacodeDao areacodeDao;

	public List<DictionaryAreacode> getAreaByAreaCode(String areaCode) {
		return this.areacodeDao.getAreaByAreaCode(areaCode);
	}

	public List<DictionaryAreacode> getAjaxArea(String areaCode, String area) {
		return this.areacodeDao.getAjaxArea(areaCode, area, getNextArea(area));
	}

	public String getNextArea(String area) {
		String s = "province";
		if ("province".equals(area)) {
			s = "city";
		} else if ("city".equals(area)) {
			s = "county";
		} else if ("county".equals(area)) {
			s = "town";
		} else if ("town".equals(area)) {
			s = "village";
		} else if ("village".equals(area)) {
			s = "street";
		}
		return s;
	}
}
