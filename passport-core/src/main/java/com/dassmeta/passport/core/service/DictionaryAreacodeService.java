package com.dassmeta.passport.core.service;

import java.util.List;

import com.dassmeta.passport.dal.dataobject.DictionaryAreacode;

public abstract interface DictionaryAreacodeService {
	public abstract List<DictionaryAreacode> getAreaByAreaCode(String paramString);

	public abstract List<DictionaryAreacode> getAjaxArea(String paramString1, String paramString2);
}
