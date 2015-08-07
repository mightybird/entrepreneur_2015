package org.sicdlab.entrepreneur.service.user.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Friend;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Mail;
import org.sicdlab.entrepreneur.beans.Need;
import org.sicdlab.entrepreneur.beans.Notice;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.Role;
import org.sicdlab.entrepreneur.beans.Supply;
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
		String errmsg = checkRegister(user, passwordconfirm);
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
		String errmsg = checkRegister(user, passwordconfirm);
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
		String errmsg = checkRegister(user, passwordconfirm);
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
	public String checkRegister(User user, String passwordconfirm) {
		String checkPassword = checkPassword(user, passwordconfirm);
		if (!checkPassword.equals("success")) {
			return checkPassword;
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
	public String checkPassword(User user, String passwordconfirm) {
		if (!user.getPassword().equals(passwordconfirm)) {
			return "两次密码输入不一致";
		}
		return "success";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String checkLogin(String email, String password) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
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
		// TODO filter by status
		List ul = session.createCriteria(Entrepreneur.class).createAlias("user", "u").add(Restrictions.eq("u.id", user.getId())).list();
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
		// TODO filter by status
		List ul = session.createCriteria(Tutor.class).createAlias("user", "u").add(Restrictions.eq("u.id", user.getId())).list();
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
		// TODO filter by status
		List ul = session.createCriteria(Institution.class).createAlias("user", "u").add(Restrictions.eq("u.id", user.getId())).list();
		Institution institution = (Institution) ul.iterator().next();
		List list = session.createCriteria(Project.class).createAlias("projectInstitutions", "pi").add(Restrictions.eq("pi.institution", institution)).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findFriends(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<User> ferl = session.createCriteria(User.class).createAlias("friendsForFollowerId", "fer").add(Restrictions.eq("fer.userByFolloweeId", user))
				.add(Restrictions.eq("fer.status", "ack")).list();
		List<User> feel = session.createCriteria(User.class).createAlias("friendsForFolloweeId", "fee").add(Restrictions.eq("fee.userByFollowerId", user))
				.add(Restrictions.eq("fee.status", "ack")).list();
		tx.commit();
		ferl.addAll(feel);
		return ferl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findApplyingFriends(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<User> aferl = session.createCriteria(User.class).createAlias("friendsForFollowerId", "fer").add(Restrictions.eq("fer.userByFolloweeId", user))
				.add(Restrictions.eq("fer.status", "apl")).list();
		tx.commit();
		return aferl;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Supply> findSupplyByUser(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Supply.class).add(Restrictions.eq("user", user)).list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Supply supply = (Supply) iterator.next();
			// 在持久化状态下的双向N端，只要get一下内部关联实体的非被引用属性，就能得到一个完整的内部关联实体。（注意：必须是N端，并且在事务之内）
			supply.getIndustry().getName();
		}
		tx.commit();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Need> findNeedByUser(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Need.class).add(Restrictions.eq("user", user)).list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Need need = (Need) iterator.next();
			// 在持久化状态下的双向N端，只要get一下内部关联实体的非被引用属性，就能得到一个完整的内部关联实体。（注意：必须是N端，并且在事务之内）
			need.getIndustry().getName();
		}
		tx.commit();
		return list;
	}

	@Override
	public void addVisitedCount(String userid) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.createCriteria(User.class).add(Restrictions.eq("id", userid)).list().iterator().next();
		user.setVisitedCount(user.getVisitedCount() + 1);
		session.update(user);
		tx.commit();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String applyFriend(String followerId, String followeeId) {
		User follower = getByStringProperty(User.class, "id", followerId).iterator().next();
		User followee = getByStringProperty(User.class, "id", followeeId).iterator().next();
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Friend.class).add(Restrictions.eq("userByFollowerId", follower)).add(Restrictions.eq("userByFolloweeId", followee)).list();
		tx.commit();
		if (!list.isEmpty()) {
			return "alreadyFriendOrApplying";
		}
		if (!save(new Friend(UUIDGenerator.randomUUID(), follower, followee, "apl"))) {
			return "dberror";
		}
		return "success";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String acceptFriend(String followerId, String followeeId) {
		User follower = getByStringProperty(User.class, "id", followerId).iterator().next();
		User followee = getByStringProperty(User.class, "id", followeeId).iterator().next();
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Friend.class).add(Restrictions.eq("userByFollowerId", follower)).add(Restrictions.eq("userByFolloweeId", followee))
				.add(Restrictions.eq("status", "apl")).list();
		tx.commit();
		if (list.isEmpty()) {
			return "noApplication";
		}
		Friend friend = (Friend) list.iterator().next();
		friend.setStatus("ack");
		if (!update(friend)) {
			return "dberror";
		}
		return "success";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String deleteFriend(String followerId, String followeeId) {
		User follower = getByStringProperty(User.class, "id", followerId).iterator().next();
		User followee = getByStringProperty(User.class, "id", followeeId).iterator().next();
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Friend.class).add(Restrictions.eq("userByFollowerId", follower)).add(Restrictions.eq("userByFolloweeId", followee))
				.add(Restrictions.eq("status", "ack")).list();
		if (list.isEmpty()) {
			list = session.createCriteria(Friend.class).add(Restrictions.eq("userByFolloweeId", follower)).add(Restrictions.eq("userByFollowerId", followee))
					.add(Restrictions.eq("status", "ack")).list();
		}
		tx.commit();
		Friend friend = (Friend) list.iterator().next();

		if (!delete(friend)) {
			return "dberror";
		}
		return "success";
	}

	@Override
	public String sendMail(String senderId, String receiverId, String title, String content) {
		User sender = getByStringProperty(User.class, "id", senderId).iterator().next();
		User receiver = getByStringProperty(User.class, "id", receiverId).iterator().next();
		Mail mail = new Mail(UUIDGenerator.randomUUID(), sender, receiver, title, content, new Date(System.currentTimeMillis()), "unread");
		if (!save(mail)) {
			return "dberror";
		}
		return "success";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Mail> getSentMail(User sessionuser) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Mail.class).createAlias("userBySenderId", "s").add(Restrictions.eq("s.id", sessionuser.getId())).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Mail> getSentMail(User sessionuser, Integer pageSize, int firstMail) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Mail.class).createAlias("userByReceiverId", "r").createAlias("userBySenderId", "s")
				.add(Restrictions.eq("s.id", sessionuser.getId())).addOrder(Order.desc("sendTime")).setMaxResults(pageSize).setFirstResult(firstMail).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Mail> getReceivedMail(User sessionuser) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Mail.class).createAlias("userByReceiverId", "r").add(Restrictions.eq("r.id", sessionuser.getId())).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Mail> getReceivedMail(User sessionuser, Integer pageSize, int firstMail) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Mail.class).createAlias("userBySenderId", "s").createAlias("userByReceiverId", "r")
				.add(Restrictions.eq("r.id", sessionuser.getId())).addOrder(Order.desc("sendTime")).setMaxResults(pageSize).setFirstResult(firstMail).list();
		tx.commit();
		return list;
	}

	@Override
	public Mail getMail(String mailId) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		Mail mail = (Mail) session.createCriteria(Mail.class).add(Restrictions.eq("id", mailId)).list().iterator().next();
		mail.getUserByReceiverId().getName();
		mail.getUserBySenderId().getName();
		tx.commit();
		return mail;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int getUnreadMail(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Mail.class).add(Restrictions.eq("status", "unread")).createAlias("userByReceiverId", "u").add(Restrictions.eq("u.id", user.getId()))
				.list();
		tx.commit();
		return list.size();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Notice> getNotice(User sessionuser, Integer pageSize, int firstNotice) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Notice.class).createAlias("user", "u").add(Restrictions.eq("u.id", sessionuser.getId())).addOrder(Order.desc("sendTime"))
				.setMaxResults(pageSize).setFirstResult(firstNotice).list();
		tx.commit();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Notice> getNotice(User sessionuser) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Notice.class).createAlias("user", "u").add(Restrictions.eq("u.id", sessionuser.getId())).list();
		tx.commit();
		return list;
	}

	@Override
	public Notice getNotice(String noticeId) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		Notice notice = (Notice) session.createCriteria(Notice.class).add(Restrictions.eq("id", noticeId)).createCriteria("user").list().iterator().next();
		tx.commit();
		return notice;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int getUnreadNotice(User user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		List list = session.createCriteria(Notice.class).add(Restrictions.eq("status", "unread")).createAlias("user", "u").add(Restrictions.eq("u.id", user.getId())).list();
		tx.commit();
		return list.size();
	}

}
