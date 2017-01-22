package com.dassmeta.passport.security.auth.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.dassmeta.passport.security.auth.URIPreProcessProvider;
import com.dassmeta.passport.security.auth.URIPreProcessor;
import com.dassmeta.passport.security.auth.exception.AuthenticationException;

public class URIPreProcessProviderImpl implements URIPreProcessProvider, InitializingBean {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private URIPreProcessor[] processors;
	private List<Pattern> patterns;

	public String process(String url) {
		List<Integer> indexList = new ArrayList();
		String retUrl = url;
		Pattern each;
		for (int i = 0; i < this.patterns.size(); i++) {
			each = (Pattern) this.patterns.get(i);
			Matcher matcher = each.matcher(url);
			if (matcher.matches()) {
				indexList.add(Integer.valueOf(i));
			}
		}
		for (Integer idx : indexList) {
			URIPreProcessor pro = this.processors[idx.intValue()];
			try {
				retUrl = pro.process(retUrl);
			} catch (Exception e) {
				this.logger.error(e.getMessage(), e);
				if (pro.isIgnoreException()) {
					this.logger.info("{} ignoreException=true", pro.getClass().getSimpleName());
				} else {
					throw new AuthenticationException("url process error!");
				}
			}
		}
		return retUrl;
	}

	public void setProcessors(URIPreProcessor[] processors) {
		this.processors = processors;
	}

	public void afterPropertiesSet() throws Exception {
		this.patterns = new ArrayList();
		if ((this.processors != null) && (this.processors.length > 0)) {
			URIPreProcessor[] arrayOfURIPreProcessor;
			int j = (arrayOfURIPreProcessor = this.processors).length;
			for (int i = 0; i < j; i++) {
				URIPreProcessor each = arrayOfURIPreProcessor[i];
				String patt = each.getPattern();
				Pattern p = Pattern.compile(patt);

				this.patterns.add(p);
			}
		}
	}
}
