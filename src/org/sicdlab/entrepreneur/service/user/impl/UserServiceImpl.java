package org.sicdlab.entrepreneur.service.user.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.Role;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.service.user.UserService;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@SuppressWarnings("rawtypes")
	@Override
	public String registerEntrepreneur(User user, Entrepreneur entrepreneur, String passwordconfirm) {
		String errmsg = checkPassword(user, passwordconfirm);
		if (!errmsg.equals("success")) {
			return errmsg;
		}
		user.setStatus("激活");
		user.setRegisterTime(new Date(System.currentTimeMillis()));
		user.setVisitedCount(0);
		user.setId(UUIDGenerator.randomUUID());
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list2 = session.createCriteria(Role.class).add(Restrictions.eq("name", "entrepreneur")).list();
		tx.commit();
		user.setRole((Role) list2.iterator().next());
		entrepreneur.setUser(user);
		if (!save(user)) {
			return "未知错误，注册失败";
		}
		if (!save(entrepreneur)) {
			return "未知错误，注册失败";
		}
		return "success";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String registerTutor(User user, Tutor tutor, String passwordconfirm) {
		String errmsg = checkPassword(user, passwordconfirm);
		if (!errmsg.equals("success")) {
			return errmsg;
		}
		user.setStatus("激活");
		user.setRegisterTime(new Date(System.currentTimeMillis()));
		user.setVisitedCount(0);
		user.setId(UUIDGenerator.randomUUID());
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list2 = session.createCriteria(Role.class).add(Restrictions.eq("name", "tutor")).list();
		tx.commit();
		user.setRole((Role) list2.iterator().next());
		tutor.setUser(user);
		if (!save(user)) {
			return "未知错误，注册失败";
		}
		if (!save(tutor)) {
			return "未知错误，注册失败";
		}
		return "success";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String registerInstitution(User user, Institution institution, String passwordconfirm) {
		String errmsg = checkPassword(user, passwordconfirm);
		if (!errmsg.equals("success")) {
			return errmsg;
		}
		user.setStatus("激活");
		user.setRegisterTime(new Date(System.currentTimeMillis()));
		user.setVisitedCount(0);
		user.setId(UUIDGenerator.randomUUID());
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list2 = session.createCriteria(Role.class).add(Restrictions.eq("name", "institution")).list();
		tx.commit();
		user.setRole((Role) list2.iterator().next());
		institution.setUser(user);
		if (!save(user)) {
			return "未知错误，注册失败";
		}
		if (!save(institution)) {
			return "未知错误，注册失败";
		}
		return "success";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String checkPassword(User user, String passwordconfirm) {
		if (!user.getPassword().equals(passwordconfirm)) {
			return "两次密码输入不一致";
		}
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(User.class).add(Restrictions.eq("email", user.getEmail())).list();
		tx.commit();
		if (!list.isEmpty()) {
			return "该邮箱已经被注册";
		}
		return "success";
	}

	@Override
	public String checkLogin(String email, String password) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List list = session.createCriteria(User.class).add(Restrictions.eq("email", email)).list();
		tx.commit();
		if (list.isEmpty()) {
			return "该用户未注册";
		}
		User user = (User) list.iterator().next();
		if (!user.getPassword().equals(password)) {
			return "密码不正确";
		}
		return "success";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Project> findProjectByEntrepreneur(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List ul = session.createCriteria(Entrepreneur.class).add(Restrictions.eq("user", user)).list();
		Entrepreneur entrepreneur = (Entrepreneur) ul.iterator().next();
		List list = session.createCriteria(Project.class).createAlias("projectEntrepreneurs", "pe").add(Restrictions.eq("pe.entrepreneur", entrepreneur)).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Project> findProjectByTutor(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List ul = session.createCriteria(Tutor.class).add(Restrictions.eq("user", user)).list();
		Tutor tutor = (Tutor) ul.iterator().next();
		List list = session.createCriteria(Project.class).createAlias("projectTutors", "pt").add(Restrictions.eq("pt.tutor", tutor)).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Project> findProjectByInstitution(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List ul = session.createCriteria(Institution.class).add(Restrictions.eq("user", user)).list();
		Institution institution = (Institution) ul.iterator().next();
		List list = session.createCriteria(Project.class).createAlias("projectInstitutions", "pi").add(Restrictions.eq("pi.institution", institution)).list();
		tx.commit();
		return list;
	}

}
