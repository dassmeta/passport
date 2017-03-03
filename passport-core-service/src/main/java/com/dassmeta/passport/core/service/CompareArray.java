package com.dassmeta.passport.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareArray {
	public static Map<Object, Object> compLineArray(String[] srcArray, String[] nowArray) {
		Map<Object, Object> map = new HashMap();

		Boolean t = Boolean.valueOf(false);
		List<Object> add = new ArrayList();
		List<Object> del = new ArrayList();
		List<Object> numd = new ArrayList();
		for (int i = 0; i < nowArray.length; i++) {
			t = Boolean.valueOf(false);
			for (int j = 0; j < srcArray.length; j++) {
				if (nowArray[i].equals(srcArray[j])) {
					numd.add(nowArray[i]);
					t = Boolean.valueOf(true);
					break;
				}
			}
			if (!t.booleanValue()) {
				add.add(nowArray[i]);
			}
		}
		for (int j = 0; j < srcArray.length; j++) {
			t = Boolean.valueOf(false);
			for (int i = 0; i < nowArray.length; i++) {
				if ((nowArray[i].equals(srcArray[j])) || ("".equals(srcArray[j]))) {
					t = Boolean.valueOf(true);
					break;
				}
			}
			if (!t.booleanValue()) {
				del.add(srcArray[j]);
			}
		}
		map.put("add", add);

		map.put("del", del);

		map.put("numd", numd);
		return map;
	}
}
