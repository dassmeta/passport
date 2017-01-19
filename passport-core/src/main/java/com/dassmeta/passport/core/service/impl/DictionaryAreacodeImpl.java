package com.dassmeta.passport.core.service.impl;

import cn.widewisdom.entity.areacode.DictionaryAreacode;
import cn.widewisdom.service.DictionaryAreacodeService;
import com.specter.dao.BaseDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class DictionaryAreacodeImpl implements DictionaryAreacodeService {
	@Autowired
	private BaseDao baseDao;

	public List<DictionaryAreacode> getAreaByAreaCode(String areaCode) {
		List<DictionaryAreacode> list = new ArrayList();
		String sql = "from DictionaryAreacode t where t.areaCode='" + areaCode + "' and t.state='1' ";
		list = this.baseDao.executeHQL(sql).list();
		return list;
	}

	public List<DictionaryAreacode> getAjaxArea(String areaCode, String area) {
		String nextArea = getNextArea(area);

		String sql = "from DictionaryAreacode t where t.areaCode like '";

		sql = sql + areaCode + "%' and t." + area + " is not null and t.";
		sql = sql + nextArea + " is null and t.state='1'";

		Query q = this.baseDao.executeHQL(sql);
		return q.list();
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
