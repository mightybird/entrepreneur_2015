package org.sicdlab.entrepreneur.service.projectservice.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Label;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectInstitution;
import org.sicdlab.entrepreneur.beans.ProjectLabel;
import org.sicdlab.entrepreneur.beans.Resource;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.service.projectservice.ProjectService;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;

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
	public Entrepreneur getEntrepreneruById(String UserId) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		Entrepreneur result= (Entrepreneur) getCurrentSession().createCriteria(Entrepreneur.class).
				add(Restrictions.eq("id", UserId)).uniqueResult();
		ts.commit();
		return result;
	}

	@Override
	public User getUserById(String userid) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		User result= (User) getCurrentSession().createCriteria(User.class).
				add(Restrictions.eq("id", userid)).uniqueResult();
		ts.commit();
		return result;
		
	}

	@Override
	public Institution getInstitutionById(String userid) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		Institution result= (Institution) getCurrentSession().createCriteria(Institution.class).
				add(Restrictions.eq("id", userid)).uniqueResult();
		ts.commit();
		return result;
	}

	@Override
	public ProjectInstitution getPIByProjectAndInstitution(Project p, Institution i) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();	
		ProjectInstitution result=(ProjectInstitution)getCurrentSession()
				.createCriteria(ProjectInstitution.class)
				.add(Restrictions.eq("TInstitution", i))
				.add(Restrictions.eq("TProject", p))
				.uniqueResult();
		ts.commit();
		return result;
	}

	@Override
	public Project getProjectById(String projectid) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();	
		Project result=(Project) getCurrentSession().createCriteria(Project.class).
				add(Restrictions.eq("id", projectid)).uniqueResult();
		ts.commit();
		return result;
	}

	@Override
	public Resource getResourceByOwnid(String ownid) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		Resource result=(Resource) getCurrentSession().createCriteria(Resource.class).
				add(Restrictions.eq("ownerId",ownid )).uniqueResult();
		ts.commit();
		return result;
	}

	@Override
	public Label FindLabelByName(String name) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		Label result=(Label) getCurrentSession().createCriteria(Label.class).
				add(Restrictions.eq("name", name)).uniqueResult();
		ts.commit();
		return result;
	}

	@Override
	public List<String> getLabelsByProjectId(String id) {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		Project project=(Project) getCurrentSession().createCriteria(Project.class).
				add(Restrictions.eq("id", id)).uniqueResult();
		Set<ProjectLabel> projectlabel=project.getProjectLabels();
		int i=0;
		List<String> results= new ArrayList<>();
		for (Iterator iterator = projectlabel.iterator(); iterator.hasNext();) {
			ProjectLabel projectLabel2 = (ProjectLabel) iterator.next();
			Label label = projectLabel2.getLabel();
			results.add(label.getName());
			System.out.println(results.get(i++));
		}
		
		ts.commit();
		return results;
	}

	
	
}
