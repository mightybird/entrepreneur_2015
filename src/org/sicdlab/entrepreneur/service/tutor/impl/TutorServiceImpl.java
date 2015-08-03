package org.sicdlab.entrepreneur.service.tutor.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
@Service("TutorServiceImpl")
public class TutorServiceImpl extends BaseServiceImpl{
	public List<Tutor> selectAll() {
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor");
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	//每一页显示的条数
	public List<Tutor> selectAll(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<Tutor> selectManage(){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='经营管理导师'");
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<Tutor> selectManage(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='经营管理导师'");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<Tutor> selectFinace(){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='财务导师'");
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<Tutor> selectFinace(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='财务导师'");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		System.out.println(tutors.size());
		return tutors;
	}
	public List<Tutor> selectTechnique(){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='技术指导导师'");
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<Tutor> selectTechnique(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='技术指导导师'");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		System.out.println(tutors.size());
		return tutors;
	}
	public List<Tutor> selectMarket(){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='市场环境导师'");
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<Tutor> selectMarket(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type='市场环境导师'");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		System.out.println(tutors.size());
		return tutors;
	}
	public List<Tutor> select(String parameterType){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type like:name");
		q.setParameter("name", parameterType);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<Tutor> select(int pageSize,int currentPage,String parameterType){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type like:name");
		q.setParameter("name", parameterType);
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	public List<DataDictionary> selectDictionary(){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from DataDictionary where ddkey='tutor_type'");
		List<DataDictionary> dataDictionaries=(List<DataDictionary>)q.list();
		session.getTransaction().commit();
		return dataDictionaries;
	}
	
}
