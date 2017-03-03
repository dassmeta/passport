package com.dassmeta.passport.core.service.cache;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")
public class DictionaryIntegrationCacheServiceTest {

	@Autowired
	private DictionaryIntegrationCacheService dictionaryIntegrationCacheService;

	@Test
	public void testInit() {
		dictionaryIntegrationCacheService.init();
		Assert.assertTrue(dictionaryIntegrationCacheService.get().size() > 0);
	}

	@Test
	public void testReflush() {
		dictionaryIntegrationCacheService.reflush();
		Assert.assertTrue(dictionaryIntegrationCacheService.get().size() > 0);
	}

	@Test
	public void testGet() {
		Assert.assertTrue(dictionaryIntegrationCacheService.get().size() > 0);
	}

	@Test
	public void testGetDicByName() {
		Map<String, CacheModel> genderDic = dictionaryIntegrationCacheService.getDicByName("GENDER");
		Assert.assertEquals(genderDic.get("1").getState(), "1");
	}

}
