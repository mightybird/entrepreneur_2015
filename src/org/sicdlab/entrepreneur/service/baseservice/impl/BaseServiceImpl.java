package org.sicdlab.entrepreneur.service.baseservice.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.service.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl implements BaseService {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Boolean save(Object object) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<DataDictionary> getType(String ddkey) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(DataDictionary.class).add(Restrictions.eq("ddkey", ddkey)).list();
		tx.commit();
		// for (Object i : list) {
		// DataDictionary dd = (DataDictionary) i;
		// System.out.println(dd.getDdvalue());
		// }
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findById(Object object, String id) {
		// TODO Auto-generated method stub
		Transaction tx = getCurrentSession().beginTransaction();
		List list = getCurrentSession().createCriteria(object.getClass()).add(Restrictions.eq("id", id)).list();
		tx.commit();
		return list;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAll(Object object) {
		// TODO Auto-generated method stub
		Transaction tx = getCurrentSession().beginTransaction();
		List list = getCurrentSession().createCriteria(object.getClass()).list();
		tx.commit();
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getByStringProperty(Class<T> entityClass, String propertyName, String propertyValue) {
		// TODO Auto-generated method stub
		Transaction tx = getCurrentSession().beginTransaction();
		List<T> list = getCurrentSession().createCriteria(entityClass).add(Restrictions.eq(propertyName, propertyValue)).list();
		tx.commit();
		return list;
	}

	@Override
	public void uploadfile(File file, String filename)  throws Exception {
		// TODO Auto-generated method stub
		
		FileInputStream fi=new FileInputStream(file);
		FileOutputStream fo=new FileOutputStream(new File("D:\\附件", filename));
		byte[] buffer=new byte[4096];
		int len=0;
		while((len=fi.read(buffer))>=0){
			fo.write(buffer, 0, len);
		}
		fo.close();
		fi.close();		
		
	}

}
