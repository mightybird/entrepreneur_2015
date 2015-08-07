package org.sicdlab.entrepreneur.service.tutor.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectEntrepreneur;
import org.sicdlab.entrepreneur.beans.ProjectTutor;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.stereotype.Service;
@Service("TutorServiceImpl")
public class TutorServiceImpl extends BaseServiceImpl{
	@SuppressWarnings("unchecked")
	public List<Tutor> selectAll() {
		Session session = getCurrentSession();
		session.beginTransaction();
//		Query q= session.createCriteria(Tutor.class).createCriteria(User.class).;
		List<Tutor> tutors=session.createCriteria(Tutor.class).createCriteria("user").add(Restrictions.eq("role.id", "2")).list();
		session.getTransaction().commit();
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> selectRec() {
		Session session = getCurrentSession();
		session.beginTransaction();
//		Query q= session.createCriteria(Tutor.class).createCriteria(User.class).;
		Criteria q=(Criteria) session.createCriteria(Tutor.class).addOrder(Order.desc("averageScore")).createCriteria("user").add(Restrictions.eq("role.id", "2"));
		q.setMaxResults(3);
		List<Tutor> tutors=q.list();
		session.getTransaction().commit();
		return tutors;
	}
	//每一页显示的条数
	@SuppressWarnings("unchecked")
	public List<Tutor> selectAll(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		//Query q=(Query) session.createQuery("from Tutor");
		Criteria q=session.createCriteria(Tutor.class).createCriteria("user").add(Restrictions.eq("role.id", "2"));
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=q.list();
		session.getTransaction().commit();
		return tutors;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Tutor> selectManage(){
		Session session = getCurrentSession();
		session.beginTransaction();
		/*Query q=(Query) session.createQuery("from Tutor where type='经营管理导师'");
		List<Tutor> tutors=(List<Tutor>)q.list();*/
		
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "经营管理导师")).createCriteria("user");
		List<Tutor> tutors=q.list();
		session.getTransaction().commit();
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> selectManage(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		//Query q=(Query) session.createQuery("from Tutor where type='经营管理导师'");
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "经营管理导师")).createCriteria("user");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=q.list();
		session.getTransaction().commit();
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> selectFinace(){
		Session session = getCurrentSession();
		session.beginTransaction();
		
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "财务导师")).createCriteria("user");
		List<Tutor> tutors=q.list();
		
		session.getTransaction().commit();
		return tutors;
	}	
	@SuppressWarnings("unchecked")
	public List<Tutor> selectFinace(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "财务导师")).createCriteria("user");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=q.list();
		
		session.getTransaction().commit();
		System.out.println(tutors.size());
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> selectTechnique(){
		Session session = getCurrentSession();
		session.beginTransaction();
		
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "技术指导导师")).createCriteria("user");
		List<Tutor> tutors=q.list();
		
		session.getTransaction().commit();
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> selectTechnique(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "技术指导导师")).createCriteria("user");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=q.list();
		
		session.getTransaction().commit();
		System.out.println(tutors.size());
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> selectMarket(){
		Session session = getCurrentSession();
		session.beginTransaction();
		
		
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "市场环境导师")).createCriteria("user");
		List<Tutor> tutors=q.list();
		
		
		session.getTransaction().commit();		
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> selectMarket(int pageSize,int currentPage){
		Session session = getCurrentSession();
		session.beginTransaction();
		
		
		Criteria q=(Criteria) session.createCriteria(Tutor.class).add(Restrictions.eq("type", "市场环境导师")).createCriteria("user");
		q.setMaxResults(pageSize);
		q.setFirstResult((currentPage-1)*pageSize);
		List<Tutor> tutors=q.list();
			
		session.getTransaction().commit();
		return tutors;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> select(String parameterType){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from Tutor where type like:name");
		q.setParameter("name", parameterType);
		List<Tutor> tutors=(List<Tutor>)q.list();
		session.getTransaction().commit();
		return tutors;
	}
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
	public List<DataDictionary> selectDictionary(){
		Session session = getCurrentSession();
		session.beginTransaction();
		Query q=(Query) session.createQuery("from DataDictionary where ddkey='tutor_type'");
		List<DataDictionary> dataDictionaries=(List<DataDictionary>)q.list();
		session.getTransaction().commit();
		return dataDictionaries;
	}
	@SuppressWarnings("unchecked")
	public List<Tutor> detailUser(String id){
		Session session = getCurrentSession();
		session.beginTransaction();
			
		//Criteria q=(Criteria) session.createCriteria(Tutor.class).createCriteria("user").add(Restrictions.eq("id", id));
		Criteria q=(Criteria) session.createCriteria(User.class).add(Restrictions.eq("id", id)).createCriteria("tutor");
		List<Tutor> tutors=q.list();
		
		session.getTransaction().commit();
		
		
		return tutors;
	}
	/*public List<ProjectEntrepreneur> selectProject(String entrepreneurId){
		Session session = getCurrentSession();
		session.beginTransaction();
		Criteria q=session.createCriteria(ProjectEntrepreneur.class).createCriteria("entrepreneur").add(Restrictions.eq("id", entrepreneurId));
		List<ProjectEntrepreneur> projects=(List<ProjectEntrepreneur>)q.list();
		session.getTransaction().commit();
		return projects;
	}*/
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
	public void saveProjectEntrepreneur(String userId,String tutorId,String projectId){
		Session session = getCurrentSession();
		session.beginTransaction();
		ProjectTutor proT=new ProjectTutor();
		Tutor t=(Tutor) session.load(Tutor.class, tutorId);
		t.getId();
		Project p=(Project) session.load(Project.class, projectId);
		p.getId();
		
		
		proT.setId(UUIDGenerator.randomUUID());
		System.out.println(t.getId()+"***"+p.getId()+"****"+proT.getId());
		proT.setTutor(t);
		proT.setProject(p);
		
		//防止重复
		Query q=session.createQuery("from ProjectTutor");
		List<ProjectTutor> search=(List<ProjectTutor>)q.list();
		
		//判断数据库中要存的数据是否已经存在
		if(search.size()==0){
			session.save(proT);
		}else{
			for(ProjectTutor prot:search){
				if(prot.getProject().getId().equals(p.getId())){
					break;
				}else{
					session.save(proT);
				}
			}	
		}			
		session.getTransaction().commit();
		
	}
}
