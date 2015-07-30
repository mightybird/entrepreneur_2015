package org.sicdlab.entrepreneur.service.user.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Industry;
import org.sicdlab.entrepreneur.beans.Institution;
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
		// TODO Auto-generated method stub
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DataDictionary> getIndustry() {
		// TODO Auto-generated method stub
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Industry.class).list();
		tx.commit();
		return list;
	}

	@Override
	public String checkLogin(String email, String password) {
		// TODO Auto-generated method stub
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


	/*
	 * @Override public List<DataDictionary> getTutorType() { // TODO
	 * Auto-generated method stub List list =
	 * getCurrentSession().createCriteria(DataDictionary.class).add(Restrictions
	 * .eq("ddkey", "tutor_type")) .list(); for (Object i : list) {
	 * DataDictionary dd = (DataDictionary) i;
	 * System.out.println(dd.getDdvalue()); } return list; }
	 * 
	 * @Override public List<DataDictionary> getInstitutionType() { // TODO
	 * Auto-generated method stub List list =
	 * getCurrentSession().createCriteria(DataDictionary.class).add(Restrictions
	 * .eq("ddkey", "institution_type")) .list(); for (Object i : list) {
	 * DataDictionary dd = (DataDictionary) i;
	 * System.out.println(dd.getDdvalue()); } return list; }
	 */
}
