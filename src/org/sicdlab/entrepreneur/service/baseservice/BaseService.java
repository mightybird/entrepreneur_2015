package org.sicdlab.entrepreneur.service.baseservice;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.sicdlab.entrepreneur.beans.DataDictionary;

public interface BaseService {
	public Boolean save(Object object);

	public Boolean merge(Object object);

	public Boolean update(Object object);

	public Boolean saveOrUpdate(Object object);

	public Boolean delete(Object object);

	@SuppressWarnings("rawtypes")
	public List findById(Object object, String id);

	public <T> List<T> getAll(Class<?> clazz);

	public <T> List<T> getByStringProperty(Class<T> entityClass, String propertyName, String propertyValue);

	public <T> List<T> getByStringProperty(Class<T> entityClass, String propertyName, String propertyValue, Order order, int maxResult, int firstResult);

	public <T> List<T> getByEntity(Class<T> entityClass, String entityPropertyName, Object entity);

	public <T> List<T> getByEntity(Class<T> entityClass, String entityPropertyName, Object entity, Order order, int maxResult, int firstResult);

	public List<DataDictionary> getType(String ddkey);

	public Session getCurrentSession();

	public void uploadfile(File file, String filename) throws Exception;

}
