package com.dassmeta.passport.dal.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public abstract class AbstractBaseRedisDao<K, V> implements IRedisBaseDao<K, V> {

	@Autowired
	private RedisTemplate<K, V> redisTemplate;

	public Boolean add(final K k, final V v) throws DataAccessException {
		return (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(k.toString());
				byte[] name = serializer.serialize(v.toString());
				return connection.setNX(key, name);
			}
		});

	}

	public Boolean add(List<?> list) throws DataAccessException {
		return true;

	}

	public Boolean update(final K k, final V v) throws DataAccessException {
		return true;
	}

	public void remove(final K k) throws DataAccessException {

	}

	/**
	 * 获取 RedisSerializer <br>
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}

	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

}