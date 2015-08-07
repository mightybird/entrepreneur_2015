package org.sicdlab.entrepreneur.service.institute.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectEntrepreneur;
import org.sicdlab.entrepreneur.beans.ProjectInstitution;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.stereotype.Service;

@Service("InstituteServiceImpl")
public class InstituteServiceImpl extends BaseServiceImpl{
	
	@SuppressWarnings("unchecked")
	public List<Institution> selectAll(){
		Session session = getCurrentSession();
		session.beginTransaction();
		List<Institution> institutions=session.createCriteria(Institution.class).createCriteria("user").add(Restrictions.eq("role.id", "3")).list();
		session.getTransaction().commit();
		return institutions;
	}
	@SuppressWarnings("unchecked")
	public List<Institution> selectRec(){
		Session session = getCurrentSession();
		session.beginTransaction();
		Criteria q=(Criteria) session.createCriteria(Institution.class).createCriteria("user").add(Restrictions.eq("role.id", "3")).addOrder(Order.desc("visitedCount"));
		q.setMaxResults(3);
		List<Institution> institutions=q.list();
		session.getTransaction().commit();
		return institutions;
	}
	
	@SuppressWarnings("unchecked")
	public List<Institution> selectAll(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		Criteria q=session.createCriteria(Institution.class).createCriteria("user").add(Restrictions.eq("role.id", "3"));
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		
		List<Institution> institutions=(List<Institution>)q.list();
		session.getTransaction().commit();
		return institutions;
	}
	
	@SuppressWarnings("unchecked")
	public List<Institution> select(String parameter){
		Session session = getCurrentSession();
		session.beginTransaction();
		List<Institution> institutions=session.createCriteria(Institution.class).add(Restrictions.eq("type", parameter)).createCriteria("user").add(Restrictions.eq("role.id", "3")).list();
		session.getTransaction().commit();
		return institutions;
	}
	@SuppressWarnings("unchecked")
	public List<Institution> select(int pageSize,int currentPage,String parameter){
		Session session = getCurrentSession();
		session.beginTransaction();
		Criteria q=(Criteria) session.createCriteria(Institution.class).add(Restrictions.eq("type", parameter)).createCriteria("user").add(Restrictions.eq("role.id", "3"));
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		
		List<Institution> institutions=(List<Institution>)q.list();
		session.getTransaction().commit();
		return institutions;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectEntrepreneur> selectProject(String entrepreneurId){
		Session session = getCurrentSession();
		session.beginTransaction();
		Criteria q=session.createCriteria(ProjectEntrepreneur.class).add(Restrictions.eq("entrepreneur.id", entrepreneurId)).createCriteria("project");
		List<ProjectEntrepreneur> projects=(List<ProjectEntrepreneur>)q.list();
		session.getTransaction().commit();
		return projects;
	}
	
	@SuppressWarnings("unchecked")
	public List<Institution> detailInstitution(String id){
		Session session = getCurrentSession();
		session.beginTransaction();
			
		//Criteria q=(Criteria) session.createCriteria(Tutor.class).createCriteria("user").add(Restrictions.eq("id", id));
		Criteria q=(Criteria) session.createCriteria(User.class).add(Restrictions.eq("id", id)).createCriteria("institution");
		List<Institution> institutions=q.list();		
		session.getTransaction().commit();		
		return institutions;
	}
	
	@SuppressWarnings("unchecked")
	public void saveProjectInstitution(String userId,String instituteId,String projectId){
		Session session = getCurrentSession();
		session.beginTransaction();
		ProjectInstitution proI=new ProjectInstitution();
		Institution institution=(Institution) session.load(Institution.class, instituteId);
		institution.getId();
		Project p=(Project) session.load(Project.class, projectId);
		p.getId();
		
		
		proI.setId(UUIDGenerator.randomUUID());
		System.out.println(institution.getId()+"***"+p.getId()+"****"+proI.getId());
		proI.setInstitution(institution);
		proI.setProject(p);
		
		//防止重复
		Query q=session.createQuery("from ProjectInstitution");
		List<ProjectInstitution> search=(List<ProjectInstitution>)q.list();
		System.out.println(search.size()+"**********");
		
		//判断数据库中要存的数据是否已经存在
		if(search.size()==0){
			session.save(proI);
		}else{
			for(ProjectInstitution prot:search){
				if(prot.getProject().getId().equals(p.getId())){
					System.out.println("11111");
					break;
				}else{
					System.out.println("*******7898");
					session.save(proI);
				}
			}		
		}
		session.getTransaction().commit();
		
	}
}
