package com.dassmeta.passport.security.util;

import java.io.File;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class XMLConfigLoader {
	protected static Logger logger = LoggerFactory.getLogger(XMLConfigLoader.class);

	public static Element getRootElement(String path) {
		Element root = null;
		File file = new File(path);
		if (!file.isFile()) {
			if (path.startsWith("classpath:")) {
				path = path.substring(10);
			}
			ClassPathResource r = new ClassPathResource(path, XMLConfigLoader.class);
			try {
				file = r.getFile();
			} catch (IOException e1) {
				logger.error(path + "：不是文件，读取配置文件错误！");
				e1.printStackTrace();
				return null;
			}
		}
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(file);
			root = doc.getRootElement();
		} catch (DocumentException e) {
			logger.error("配置文件解析错误！", e);
			e.printStackTrace();
		}
		return root;
	}
}
