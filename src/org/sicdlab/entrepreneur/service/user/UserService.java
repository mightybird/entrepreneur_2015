package org.sicdlab.entrepreneur.service.user;

import java.util.List;

import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Mail;
import org.sicdlab.entrepreneur.beans.Need;
import org.sicdlab.entrepreneur.beans.Notice;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.Supply;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.BaseService;

public interface UserService extends BaseService {
	public String registerEntrepreneur(User user, Entrepreneur entrepreneur, String passwordconfirm);

	public String registerTutor(User user, Tutor tutor, String passwordconfirm);

	public String registerInstitution(User user, Institution institution, String passwordconfirm);

	public String checkRegister(User user, String passwordconfirm);

	public String checkLogin(String email, String password);

	public List<Project> findProjectByEntrepreneur(User user);

	public List<Project> findProjectByTutor(User user);

	public List<Project> findProjectByInstitution(User user);

	public List<User> findFriends(User user);

	public List<Supply> findSupplyByUser(User user);

	public List<Need> findNeedByUser(User user);

	public String checkPassword(User user, String passwordconfirm);

	public void addVisitedCount(String userid);

	public List<User> findApplyingFriends(User user);

	public String applyFriend(String followerId, String followeeId);

	public String acceptFriend(String followerId, String followeeId);

	public String deleteFriend(String followerId, String followeeId);

	public String sendMail(String senderId, String receiverId, String title, String content);

	public List<Mail> getSentMail(User sessionuser);

	public List<Mail> getSentMail(User sessionuser, Integer pageSize, int firstMail);

	public List<Mail> getReceivedMail(User sessionuser);

	public List<Mail> getReceivedMail(User sessionuser, Integer pageSize, int firstMail);

	public Mail getMail(String mailId);

	public int getUnreadMail(User user);

	public List<Notice> getNotice(User sessionuser, Integer pageSize, int firstNotice);

	public List<Notice> getNotice(User sessionuser);

	public Notice getNotice(String noticeId);

	public int getUnreadNotice(User user);

}
