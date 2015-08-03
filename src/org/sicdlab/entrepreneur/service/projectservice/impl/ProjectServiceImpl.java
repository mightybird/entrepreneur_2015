package org.sicdlab.entrepreneur.service.projectservice.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.Resource;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.service.projectservice.ProjectService;
import org.springframework.stereotype.Service;

@Service("ProjectServiceImpl")
public class ProjectServiceImpl extends BaseServiceImpl implements ProjectService {

	@Override
	public List<DataDictionary> getFundScope() {
		
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		List<DataDictionary> results=session.createCriteria(DataDictionary.class).
				add(Restrictions.eq("ddkey", "fund_scope")).list();
		ts.commit();
		
		
		return  results;
	}

	@Override
	public List<DataDictionary> getFundType() {
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		List<DataDictionary> results=getCurrentSession().createCriteria(DataDictionary.class).
				add(Restrictions.eq("ddkey", "fund_type")).list();
		ts.commit();
		return results;
	}

	@Override
	public List<DataDictionary> getFundLack() {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		List<DataDictionary> results=getCurrentSession().createCriteria(DataDictionary.class).
				add(Restrictions.eq("ddkey", "fund_lack")).list();
		ts.commit();
		return results;
	}

	@Override
	public boolean SaveProjectImagePath(String ownerid, String resourceType,String path) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		Resource resource= new Resource();
		resource.setOwnerId(ownerid);
		resource.setResourceType(resourceType);
		resource.setPath(path);
		boolean result=saveOrUpdate(resource);
		ts.commit();
		return result;
	}

	@Override
	public Entrepreneur getEntrepreneruById(String myUserId) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		Entrepreneur result= (Entrepreneur) getCurrentSession().createCriteria(Entrepreneur.class).
				add(Restrictions.eq("id", myUserId)).uniqueResult();
		return null;
	}

	
	
}
