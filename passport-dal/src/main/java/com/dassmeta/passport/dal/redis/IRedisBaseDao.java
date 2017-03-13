package com.dassmeta.passport.dal.redis;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IRedisBaseDao<K, V> {

	Boolean add(final K k, final V v) throws DataAccessException;

	Boolean add(List<?> list) throws DataAccessException;

	Boolean update(final K k, final V v) throws DataAccessException;

	void remove(final K k) throws DataAccessException;

}
