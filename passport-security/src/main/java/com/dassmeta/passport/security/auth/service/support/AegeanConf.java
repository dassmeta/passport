package com.dassmeta.passport.security.auth.service.support;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dassmeta.passport.security.util.XMLConfigLoader;

public class AegeanConf {
	protected static Logger log = LoggerFactory.getLogger(AegeanConf.class);
	private String filePath;
	private Map<String, Service> services = new HashMap<String, AegeanConf.Service>();

	public AegeanConf(String filePath) {
		this.filePath = filePath;
		init();
	}

	private void init() {
		log.debug("读取WebService配置文件：" + this.filePath);

		Element root = XMLConfigLoader.getRootElement(this.filePath);
		Element servicesGroup = root.element("services-group");
		for (Iterator<Element> i = servicesGroup.elementIterator(); i.hasNext();) {
			Element e = i.next();
			String name = e.attribute("name").getValue();

			Service s = new Service();
			s.setName(name);
			s.setWsdl(e.element("wsdl").getTextTrim());
			s.setUserName(e.element("username").getTextTrim());
			s.setPassword(e.element("password").getTextTrim());

			this.services.put(name, s);
		}
	}

	public class Service {
		private String name;
		private String wsdl;
		private String userName;
		private String password;

		public Service() {
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getWsdl() {
			return this.wsdl;
		}

		public void setWsdl(String wsdl) {
			this.wsdl = wsdl;
		}

		public String getUserName() {
			return this.userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

	public Map<String, Service> getServices() {
		return this.services;
	}

	public void setServices(Map<String, Service> services) {
		this.services = services;
	}

	public static void main(String[] args) {
		String f = "classpath:/aegean-conf.xml";
		AegeanConf conf = new AegeanConf(f);
		Service s = (Service) conf.getServices().get("certification");

		System.out.println(s.getName());
		System.out.println(s.getWsdl());
		System.out.println(s.getUserName());
		System.out.println(s.getPassword());
	}
}
