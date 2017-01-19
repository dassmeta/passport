package com.dassmeta.passport.web.home.report;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	public static void main(String[] args) {
		List<Map<String, String>> list = new ArrayList();
		SAXReader reader = new SAXReader();
		Document doc = null;
		Element root = null;
		try {
			doc = reader.read(new File("F://user-system.xml"));
		} catch (DocumentException e) {
			System.out.println("文件读取异常");
			e.printStackTrace();
		}
		if (doc != null) {
			root = doc.getRootElement();
			List<Element> l = root.elements();
			for (int i = 0; i < l.size(); i++) {
				Map<String, String> m = new HashMap();
				List<Element> l1 = ((Element) l.get(i)).elements();
				for (int j = 0; j < l1.size(); j++) {
					System.out.println(((Element) l1.get(j)).getName() + "-------" + ((Element) l1.get(j)).getText());
					m.put(((Element) l1.get(j)).getName(), ((Element) l1.get(j)).getText());
				}
				list.add(m);
			}
		}
	}
}
