package org.sicdlab.entrepreneur.action.user;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.infinispan.configuration.parsing.Namespace;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Industry;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Mail;
import org.sicdlab.entrepreneur.beans.Need;
import org.sicdlab.entrepreneur.beans.Notice;
import org.sicdlab.entrepreneur.beans.Page;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.Role;
import org.sicdlab.entrepreneur.beans.Supply;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.user.UserService;
import org.sicdlab.entrepreneur.utils.DateUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("UserAction")
@Scope("prototype")
@Namespace(root = "/user")
public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7909218059980123104L;

	@Resource(name = "UserServiceImpl")
	UserService userservice;

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	private String userid;
	private String role;
	private String name;
	private String email;
	private String originalPassword;
	private String password;
	private String passwordconfirm;
	private String contact;
	private String address;
	private String introduce;
	private String gender;
	private String birth;
	private String degree;
	private String major;
	private String experience;
	private String errmsg;
	private String ttype;
	private String itype;
	private String occupation;
	private String tutorship;
	private String instype;
	private String principal;
	private String scale;
	private String service;
	private String fosterIndustry;
	private User nuser;
	private Role crole;
	private List<DataDictionary> tutortype;
	private List<DataDictionary> institutiontype;
	private List<Industry> industrylist;
	private List<Project> projectlist;
	private List<User> friendlist;
	private List<User> applyingFriendlist;
	private String friendstatus;
	private List<Supply> supplylist;
	private List<Need> needlist;
	private String title;
	private String content;
	private Page<Mail> receivedMail;
	private Page<Mail> sentMail;
	private Mail mail;
	private Page<Notice> noticePage;
	private Notice notice;

	@Action(value = "applyregister", results = { @Result(name = "success", location = "/jsp/user/register.jsp") }, className = "UserAction")
	public String applyRegister() {
		System.out.println(getRole());
		if (getRole().equals("tutor")) {
			setTutortype(userservice.getType("tutor_type"));
		}
		if (getRole().equals("institution")) {
			setInstitutiontype(userservice.getType("institution_type"));
			List<Industry> il = userservice.getAll(Industry.class);
			setIndustrylist(il);
		}
		return SUCCESS;
	}

	@Action(value = "register", results = { @Result(name = "success", location = "/jsp/user/login.jsp"),
			@Result(name = "error", type = "chain", location = "applyregister") }, className = "UserAction")

	public String register() throws ServletException, IOException, ParseException {
		User user = new User();
		user.setName(getName() == null ? "未填写" : getName());
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		user.setContact(getContact() == null ? "未填写" : getContact());
		user.setAddress(getAddress() == null ? "未填写" : getAddress());
		user.setIntroduce(getIntroduce() == null ? "未填写" : getIntroduce());
		user.setGender(getGender() == null ? "未填写" : getGender());
		user.setBirth(DateUtil.strToDate(getBirth()));
		user.setHeadImage("head_image_default.png");
		if (getRole().equals("entrepreneur")) {
			Entrepreneur entrepreneur = new Entrepreneur();
			entrepreneur.setDegree(getDegree());
			entrepreneur.setMajor(getMajor() == null ? "未填写" : getMajor());
			entrepreneur.setExperience(getExperience() == null ? "未填写" : getExperience());
			setErrmsg(userservice.registerEntrepreneur(user, entrepreneur, getPasswordconfirm()));
			System.out.println(getErrmsg());
		}
		if (getRole().equals("tutor")) {
			Tutor tutor = new Tutor();
			tutor.setType(getTtype());
			tutor.setOccupation(getOccupation() == null ? "未填写" : getOccupation());
			tutor.setTutorship(getTutorship() == null ? "未填写" : getTutorship());
			tutor.setExperience(getExperience() == null ? "未填写" : getExperience());
			setErrmsg(userservice.registerTutor(user, tutor, getPasswordconfirm()));
			System.out.println(getErrmsg());
		}
		if (getRole().equals("institution")) {
			Institution institution = new Institution();
			institution.setType(getInstype());
			institution.setPrincipal(getPrincipal() == null ? "未填写" : getPrincipal());
			institution.setScale(getScale() == null ? "未填写" : getScale());
			institution.setService(getService() == null ? "未填写" : getService());
			institution.setFosterIndustry(getFosterIndustry());
			setErrmsg(userservice.registerInstitution(user, institution, getPasswordconfirm()));
			System.out.println(getErrmsg());
		}
		if (!getErrmsg().equals("success")) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	@Action(value = "applylogin", results = { @Result(name = "success", location = "/jsp/user/login.jsp"), }, className = "UserAction")
	public String applyLogin() {
		setErrmsg(null);
		return SUCCESS;
	}

	@Action(value = "login", results = { @Result(name = "success", type = "chain", location = "personalhome"),
			@Result(name = "error", location = "/jsp/user/login.jsp") }, className = "UserAction")
	public String login() {
		setErrmsg(userservice.checkLogin(getEmail(), getPassword()));
		if (!getErrmsg().equals("success")) {
			return ERROR;
		} else {
			List<User> list = userservice.getByStringProperty(User.class, "email", getEmail());
			User user = list.iterator().next();
			if (user.getName() == null || user.getName().equals("")) {
				user.setName(user.getEmail());
			}
			ActionContext.getContext().getSession().put("user", user);
			List<Role> lrole = userservice.getByStringProperty(Role.class, "id", user.getRole().getId());
			ActionContext.getContext().getSession().put("role", lrole.iterator().next());
			int unreadMail = userservice.getUnreadMail(user);
			ActionContext.getContext().getSession().put("unreadmail", unreadMail);
			int unreadNotice = userservice.getUnreadNotice(user);
			ActionContext.getContext().getSession().put("unreadnotice", unreadNotice);
			ServletActionContext.getRequest().setAttribute("userid", user.getId());
			return SUCCESS;
		}
	}

	@Action(value = "logout", results = { @Result(name = "success", type = "chain", location = "applylogin") }, className = "UserAction")
	public String logout() {
		ActionContext.getContext().getSession().put("user", null);
		ActionContext.getContext().getSession().put("role", null);
		return SUCCESS;
	}

	@Action(value = "personalhome", results = { @Result(name = "success", location = "/jsp/user/personalhome.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String personalHome() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String userid = ServletActionContext.getRequest().getParameter("userid");
		if (userid == null || userid.isEmpty()) {
			userid = (String) ServletActionContext.getRequest().getAttribute("userid");
		}
		List<User> ul = userservice.getByStringProperty(User.class, "id", userid);
		User currentuser = ul.iterator().next();
		Role currentrole = userservice.getByStringProperty(Role.class, "id", currentuser.getRole().getId()).iterator().next();
		setCrole(currentrole);
		switch (currentrole.getName()) {
		case "entrepreneur":
			setProjectlist(userservice.findProjectByEntrepreneur(currentuser));
			break;
		case "tutor":
			setProjectlist(userservice.findProjectByTutor(currentuser));
			break;
		case "institution":
			setProjectlist(userservice.findProjectByInstitution(currentuser));
			break;
		default:
			return ERROR;
		}
		if (currentuser.getName() == null || currentuser.getName().isEmpty()) {
			currentuser.setName(currentuser.getEmail());
		}
		setFriendlist(userservice.findFriends(currentuser));
		setApplyingFriendlist(userservice.findApplyingFriends(currentuser));
		if (!sessionuser.getId().equals(currentuser.getId())) {
			userservice.addVisitedCount(currentuser.getId());
			friendstatus = "stranger";
			Iterator<User> fit = friendlist.iterator();
			while (fit.hasNext()) {
				User u = (User) fit.next();
				if (u.getId().equals(sessionuser.getId())) {
					friendstatus = "friend";
					break;
				}
			}
			if (friendstatus.equals("stranger")) {
				Iterator<User> ait = applyingFriendlist.iterator();
				while (ait.hasNext()) {
					User u = (User) ait.next();
					if (u.getId().equals(sessionuser.getId())) {
						friendstatus = "applyee";
						break;
					}
				}
			}
			if (friendstatus.equals("stranger")) {
				List<User> applyingFriendsOfSessionUser = userservice.findApplyingFriends(sessionuser);
				Iterator<User> asuit = applyingFriendsOfSessionUser.iterator();
				while (asuit.hasNext()) {
					User u = (User) asuit.next();
					if (u.getId().equals(currentuser.getId())) {
						friendstatus = "applyer";
						break;
					}
				}
			}
		}
		setSupplylist(userservice.findSupplyByUser(currentuser));
		setNeedlist(userservice.findNeedByUser(currentuser));
		setUser(currentuser);
		return SUCCESS;

	}

	@Action(value = "applyEditPersonalInfo", results = { @Result(name = "success", location = "/jsp/user/editpersonalinfo.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String applyEditPersonalInfo() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String rolename = ((Role) ActionContext.getContext().getSession().get("role")).getName();
		if (rolename.equals("entrepreneur")) {
			Entrepreneur entrepreneur = userservice.getByStringProperty(Entrepreneur.class, "id", sessionuser.getId()).iterator().next();
			sessionuser.setEntrepreneur(entrepreneur);
		}
		if (rolename.equals("tutor")) {
			setTutortype(userservice.getType("tutor_type"));
			Tutor tutor = userservice.getByStringProperty(Tutor.class, "id", sessionuser.getId()).iterator().next();
			sessionuser.setTutor(tutor);
		}
		if (rolename.equals("institution")) {
			setInstitutiontype(userservice.getType("institution_type"));
			List<Industry> il = userservice.getAll(Industry.class);
			setIndustrylist(il);
			Institution institution = userservice.getByStringProperty(Institution.class, "id", sessionuser.getId()).iterator().next();
			sessionuser.setInstitution(institution);
		}
		setBirth(DateUtil.dateToStr(sessionuser.getBirth()));
		setUser(sessionuser);
		return SUCCESS;
	}

	@Action(value = "editPersonalInfo", results = { @Result(name = "success", type = "chain", location = "personalhome"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String editPersonalInfo() throws ParseException {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		List<User> ul = userservice.getByStringProperty(User.class, "id", sessionuser.getId());
		setNuser(ul.iterator().next());
		nuser.setName(getName() == null ? "未填写" : getName());
		nuser.setContact(getContact() == null ? "未填写" : getContact());
		nuser.setAddress(getAddress() == null ? "未填写" : getAddress());
		nuser.setIntroduce(getIntroduce() == null ? "未填写" : getIntroduce());
		nuser.setGender(getGender() == null ? "未填写" : getGender());
		nuser.setBirth(DateUtil.strToDate(getBirth()));
		String rolename = ((Role) ActionContext.getContext().getSession().get("role")).getName();
		switch (rolename) {
		case "entrepreneur":
			List<Entrepreneur> el = userservice.getByStringProperty(Entrepreneur.class, "id", nuser.getId());
			Entrepreneur entrepreneur = el.iterator().next();
			entrepreneur.setDegree(getDegree());
			entrepreneur.setMajor(getMajor() == null ? "未填写" : getMajor());
			entrepreneur.setExperience(getExperience() == null ? "未填写" : getExperience());
			userservice.update(entrepreneur);
			userservice.update(nuser);
			break;
		case "tutor":
			List<Tutor> tl = userservice.getByStringProperty(Tutor.class, "id", nuser.getId());
			Tutor tutor = tl.iterator().next();
			tutor.setType(getTtype());
			tutor.setOccupation(getOccupation() == null ? "未填写" : getOccupation());
			tutor.setTutorship(getTutorship() == null ? "未填写" : getTutorship());
			tutor.setExperience(getExperience() == null ? "未填写" : getExperience());
			userservice.update(tutor);
			userservice.update(nuser);
			break;
		case "institution":
			List<Institution> il = userservice.getByStringProperty(Institution.class, "id", nuser.getId());
			Institution institution = il.iterator().next();
			institution.setType(getInstype());
			institution.setPrincipal(getPrincipal());
			institution.setScale(getScale());
			institution.setService(getService());
			institution.setFosterIndustry(getFosterIndustry());
			userservice.update(institution);
			userservice.update(nuser);
			break;
		default:
			return ERROR;
		}
		ActionContext.getContext().getSession().put("user", nuser);
		ActionContext.getContext().getParameters().put("userid", nuser.getId());
		return SUCCESS;
	}

	@Action(value = "applyFriend", results = { @Result(name = "success", type = "chain", location = "personalhome"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String applyFriend() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String followerId = sessionuser.getId();
		String followeeId = ServletActionContext.getRequest().getParameter("id");
		System.out.println(userservice.applyFriend(followerId, followeeId).equals("success"));
		ServletActionContext.getRequest().setAttribute("userid", followeeId);
		return SUCCESS;
	}

	@Action(value = "acceptFriend", results = { @Result(name = "success", type = "chain", location = "personalhome"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String acceptFriend() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String followeeId = sessionuser.getId();
		String followerId = ServletActionContext.getRequest().getParameter("id");
		System.out.println(userservice.acceptFriend(followerId, followeeId));
		ServletActionContext.getRequest().setAttribute("userid", followerId);
		return SUCCESS;

	}

	@Action(value = "deleteFriend", results = { @Result(name = "success", type = "chain", location = "personalhome"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String deleteFriend() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String followerId = sessionuser.getId();
		String followeeId = ServletActionContext.getRequest().getParameter("id");
		System.out.println(userservice.deleteFriend(followerId, followeeId));
		ServletActionContext.getRequest().setAttribute("userid", followerId);
		return SUCCESS;

	}

	@Action(value = "applyChangePassword", results = { @Result(name = "success", location = "/jsp/user/changepassword.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String applyChangePassword() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		setErrmsg(null);
		return SUCCESS;
	}

	@Action(value = "changePassword", results = { @Result(name = "success", type = "chain", location = "logout"),
			@Result(name = "error", type = "chain", location = "applylogin"), @Result(name = "input", location = "/jsp/user/changepassword.jsp") }, className = "UserAction")
	public String changePassword() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String checkLogin = userservice.checkLogin(sessionuser.getEmail(), originalPassword);
		if (!checkLogin.equals("success")) {
			setErrmsg(checkLogin.replaceAll("密码", "原密码"));
			return INPUT;
		}
		if (password.equals(originalPassword) || passwordconfirm.equals(originalPassword)) {
			setErrmsg("新密码与原密码相同！请重试");
			return INPUT;
		}
		sessionuser.setPassword(password);
		String checkPassword = userservice.checkPassword(sessionuser, passwordconfirm);
		if (!checkPassword.equals("success")) {
			setErrmsg(checkPassword.replaceAll("密码", "新密码"));
			return INPUT;
		}
		if (!userservice.update(sessionuser)) {
			setErrmsg("未知错误！请重试");
			return INPUT;
		}
		setErrmsg("密码修改成功！请重新登录");
		return SUCCESS;
	}

	@Action(value = "sendMail", results = { @Result(name = "success", type = "chain", location = "personalhome"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String sendMail() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String senderId = sessionuser.getId();
		String receiverId = ServletActionContext.getRequest().getParameter("id");
		System.out.println(userservice.sendMail(senderId, receiverId, title, content));
		ServletActionContext.getRequest().setAttribute("userid", receiverId);
		return SUCCESS;
	}

	@Action(value = "mailList", results = { @Result(name = "success", location = "/jsp/user/maillist.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String mailList() throws IOException {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		Integer rcurrentPage = Integer.parseInt(ServletActionContext.getRequest().getParameter("rcurrentpage"));
		Integer scurrentPage = Integer.parseInt(ServletActionContext.getRequest().getParameter("scurrentpage"));
		Integer pageSize = 10;
		List<Mail> rmail = userservice.getReceivedMail(sessionuser, pageSize, pageSize * (rcurrentPage - 1));
		Iterator<Mail> rit = rmail.iterator();
		while (rit.hasNext()) {
			Mail mail = (Mail) rit.next();
			int length = mail.getTitle().length();
			mail.setTitle(length > 20 ? mail.getTitle().substring(0, 16) + "..." : mail.getTitle());
			mail.setContent(mail.getContent().length() > 50 ? mail.getContent().substring(0, 46) + "..." : mail.getContent());
		}
		setReceivedMail(new Page<Mail>(pageSize, rcurrentPage, userservice.getReceivedMail(sessionuser).size(), rmail));
		List<Mail> smail = userservice.getSentMail(sessionuser, pageSize, pageSize * (scurrentPage - 1));
		Iterator<Mail> sit = smail.iterator();
		while (sit.hasNext()) {
			Mail mail = (Mail) sit.next();
			mail.setTitle(mail.getTitle().length() > 20 ? mail.getTitle().substring(0, 16) + "..." : mail.getTitle());
			mail.setContent(mail.getContent().length() > 50 ? mail.getContent().substring(0, 46) + "..." : mail.getContent());
		}
		setSentMail(new Page<Mail>(pageSize, scurrentPage, userservice.getSentMail(sessionuser).size(), smail));
		return SUCCESS;
	}

	@Action(value = "mail", results = { @Result(name = "success", location = "/jsp/user/mail.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String mail() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String mailId = ServletActionContext.getRequest().getParameter("mailid");
		setMail(userservice.getMail(mailId));
		if (mail.getUserByReceiverId().getId().equals(sessionuser.getId()) && mail.getStatus().equals("unread")) {
			mail.setStatus("read");
			userservice.update(mail);
			int unreadmail = (int) ActionContext.getContext().getSession().get("unreadmail");
			ActionContext.getContext().getSession().put("unreadmail", unreadmail - 1);
		}
		return SUCCESS;
	}

	@Action(value = "noticeList", results = { @Result(name = "success", location = "/jsp/user/noticelist.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String noticeList() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		Integer currentPage = Integer.parseInt(ServletActionContext.getRequest().getParameter("currentpage"));
		Integer pageSize = 10;
		List<Notice> noticep = userservice.getNotice(sessionuser, pageSize, pageSize * (currentPage - 1));
		Iterator<Notice> nit = noticep.iterator();
		while (nit.hasNext()) {
			Notice notice = (Notice) nit.next();
			int length = notice.getTitle().length();
			notice.setTitle(length > 30 ? notice.getTitle().substring(0, 26) + "..." : notice.getTitle());
			notice.setContent(notice.getContent().length() > 60 ? notice.getContent().substring(0, 56) + "..." : notice.getContent());
		}
		setNoticePage(new Page<Notice>(pageSize, currentPage, userservice.getNotice(sessionuser).size(), noticep));
		return SUCCESS;
	}

	@Action(value = "notice", results = { @Result(name = "success", location = "/jsp/user/notice.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String notice() {
		User sessionuser = (User) ActionContext.getContext().getSession().get("user");
		if (sessionuser == null) {
			return ERROR;
		}
		String noticeId = ServletActionContext.getRequest().getParameter("noticeid");
		setNotice(userservice.getNotice(noticeId));
		if (notice.getUser().getId().equals(sessionuser.getId()) && notice.getStatus().equals("unread")) {
			notice.setStatus("read");
			userservice.update(notice);
			int unreadnotice = (int) ActionContext.getContext().getSession().get("unreadnotice");
			ActionContext.getContext().getSession().put("unreadnotice", unreadnotice - 1);
		}
		return SUCCESS;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordconfirm() {
		return passwordconfirm;
	}

	public void setPasswordconfirm(String passwordconfirm) {
		this.passwordconfirm = passwordconfirm;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public List<DataDictionary> getTutortype() {
		return tutortype;
	}

	public void setTutortype(List<DataDictionary> tutortype) {
		this.tutortype = tutortype;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getTutorship() {
		return tutorship;
	}

	public void setTutorship(String tutorship) {
		this.tutorship = tutorship;
	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
	}

	public List<DataDictionary> getInstitutiontype() {
		return institutiontype;
	}

	public void setInstitutiontype(List<DataDictionary> institutiontype) {
		this.institutiontype = institutiontype;
	}

	public String getInstype() {
		return instype;
	}

	public void setInstype(String instype) {
		this.instype = instype;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getFosterIndustry() {
		return fosterIndustry;
	}

	public void setFosterIndustry(String fosterIndustry) {
		this.fosterIndustry = fosterIndustry;
	}

	public List<Industry> getIndustrylist() {
		return industrylist;
	}

	public void setIndustrylist(List<Industry> industrylist) {
		this.industrylist = industrylist;
	}

	public List<Project> getProjectlist() {
		return projectlist;
	}

	public void setProjectlist(List<Project> projectlist) {
		this.projectlist = projectlist;
	}

	public List<User> getFriendlist() {
		return friendlist;
	}

	public void setFriendlist(List<User> friendlist) {
		this.friendlist = friendlist;
	}

	public List<Supply> getSupplylist() {
		return supplylist;
	}

	public void setSupplylist(List<Supply> supplylist) {
		this.supplylist = supplylist;
	}

	public List<Need> getNeedlist() {
		return needlist;
	}

	public void setNeedlist(List<Need> needlist) {
		this.needlist = needlist;
	}

	public User getUser() {
		return nuser;
	}

	public void setUser(User user) {
		this.nuser = user;
	}

	public Role getCrole() {
		return crole;
	}

	public void setCrole(Role crole) {
		this.crole = crole;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOriginalPassword() {
		return originalPassword;
	}

	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}

	public User getNuser() {
		return nuser;
	}

	public void setNuser(User nuser) {
		this.nuser = nuser;
	}

	public String getFriendstatus() {
		return friendstatus;
	}

	public void setFriendstatus(String friendstatus) {
		this.friendstatus = friendstatus;
	}

	public List<User> getApplyingFriendlist() {
		return applyingFriendlist;
	}

	public void setApplyingFriendlist(List<User> applyingFriendlist) {
		this.applyingFriendlist = applyingFriendlist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Page<Mail> getReceivedMail() {
		return receivedMail;
	}

	public void setReceivedMail(Page<Mail> receivedMail) {
		this.receivedMail = receivedMail;
	}

	public Page<Mail> getSentMail() {
		return sentMail;
	}

	public void setSentMail(Page<Mail> sentMail) {
		this.sentMail = sentMail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public Mail getMail() {
		return mail;
	}

	public Page<Notice> getNoticePage() {
		return noticePage;
	}

	public void setNoticePage(Page<Notice> noticePage) {
		this.noticePage = noticePage;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

}
