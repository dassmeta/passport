package com.dassmeta.passport.util;

public class IbatisMapperNameSpaceUtil {

	public static String getMethodPath(Class<?> clazz, String id) {
		String classPathName = clazz.getInterfaces()[0].getName();
		int index = classPathName.lastIndexOf(".");
		String daoName = classPathName.substring(index + 1);
		String name = daoName.substring(0, daoName.indexOf("Impl"));
		return classPathName.substring(0, index) + "." + name + "." + id;
	}

}
