package com.dassmeta.passport.dal.ibatis;

import java.util.List;

import com.dassmeta.passport.dal.IBaseDao;
import com.dassmeta.passport.dal.dataobject.DictionaryAreacode;

public interface DictionaryAreacodeDao extends IBaseDao<DictionaryAreacode> {

	List<DictionaryAreacode> getAreaByAreaCode(String areaCode);

	List<DictionaryAreacode> getAjaxArea(String areaCode, String area, String nextArea);

}