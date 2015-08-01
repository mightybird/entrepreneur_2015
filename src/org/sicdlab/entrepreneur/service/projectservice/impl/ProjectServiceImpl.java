package org.sicdlab.entrepreneur.service.projectservice.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.DataDictionary;
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
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		List<DataDictionary> results=getCurrentSession().createCriteria(DataDictionary.class).
				add(Restrictions.eq("ddkey", "fund_lack")).list();
		ts.commit();
		return results;
		
		
	}
	
}
