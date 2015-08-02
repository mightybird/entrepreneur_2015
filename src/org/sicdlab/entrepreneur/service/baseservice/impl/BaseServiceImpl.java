package org.sicdlab.entrepreneur.service.baseservice.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl implements BaseService {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Boolean save(Object object) {
		Transaction tx = getCurrentSession().beginTransaction();
		getCurrentSession().save(object);
		tx.commit();
		if (tx.wasCommitted()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean merge(Object object) {
		Transaction tx = getCurrentSession().beginTransaction();
		getCurrentSession().merge(object);
		tx.commit();
		if (tx.wasCommitted()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(Object object) {
		Transaction tx = getCurrentSession().beginTransaction();
		getCurrentSession().update(object);
		tx.commit();
		if (tx.wasCommitted()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean saveOrUpdate(Object object) {
		Transaction tx = getCurrentSession().beginTransaction();
		getCurrentSession().saveOrUpdate(object);
		tx.commit();
		if (tx.wasCommitted()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean delete(Object object) {
		Transaction tx = getCurrentSession().beginTransaction();
		getCurrentSession().delete(object);
		tx.commit();
		if (tx.wasCommitted()) {
			return true;
		}
		return false;
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DataDictionary> getType(String ddkey) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(DataDictionary.class).add(Restrictions.eq("ddkey", ddkey)).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findById(Object object, String id) {
		Transaction tx = getCurrentSession().beginTransaction();
		List list = getCurrentSession().createCriteria(object.getClass()).add(Restrictions.eq("id", id)).list();
		tx.commit();
		return list;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAll(Object object) {
		Transaction tx = getCurrentSession().beginTransaction();
		List list = getCurrentSession().createCriteria(object.getClass()).list();
		tx.commit();
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getByStringProperty(Class<T> entityClass, String propertyName, String propertyValue) {
		Transaction tx = getCurrentSession().beginTransaction();
		List<T> list = getCurrentSession().createCriteria(entityClass).add(Restrictions.eq(propertyName, propertyValue)).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getByStringProperty(Class<T> entityClass, String propertyName, String propertyValue, Order order, int maxResult, int firstResult) {
		Transaction tx = getCurrentSession().beginTransaction();
		List<T> list = getCurrentSession().createCriteria(entityClass).add(Restrictions.eq(propertyName, propertyValue)).addOrder(order)
				.setMaxResults(maxResult).setFirstResult(firstResult).list();
		tx.commit();
		return list;
	}

	@Override
	public void uploadfile(File file, String filename) throws Exception {

		FileInputStream fi = new FileInputStream(file);
		FileOutputStream fo = new FileOutputStream(new File("D:\\附件", filename));
		byte[] buffer = new byte[4096];
		int len = 0;
		while ((len = fi.read(buffer)) >= 0) {
			fo.write(buffer, 0, len);
		}
		fo.close();
		fi.close();

	}

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public <T> List<T> getByEntity(Class<T> entityClass, String entityPropertyName, Object entity) {
		Transaction tx = getCurrentSession().beginTransaction();
		List<T> list = getCurrentSession().createCriteria(entityClass).add(Restrictions.eq(entityPropertyName, entity)).list();
		tx.commit();
		return null;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public <T> List<T> getByEntity(Class<T> entityClass, String entityPropertyName, Object entity, Order order, int maxResult, int firstResult) {
		Transaction tx = getCurrentSession().beginTransaction();
		List<T> list = getCurrentSession().createCriteria(entityClass).add(Restrictions.eq(entityPropertyName, entity)).addOrder(order).setMaxResults(maxResult)
				.setFirstResult(firstResult).list();
		tx.commit();
		return null;
	}

}
