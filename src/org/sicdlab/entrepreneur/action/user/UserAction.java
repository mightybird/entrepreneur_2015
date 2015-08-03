package org.sicdlab.entrepreneur.action.user;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.infinispan.configuration.parsing.Namespace;
import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Industry;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Need;
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

	private String role;
	private String name;
	private String email;
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
	private List<DataDictionary> tutortype;
	private List<DataDictionary> institutiontype;
	private List<Industry> industrylist;
	private List<Project> projectlist;
	private List<User> friendlist;
	private List<Supply> supplylist;
	private List<Need> needlist;

	@SuppressWarnings("unchecked")
	@Action(value = "applyregister", results = { @Result(name = "success", location = "/jsp/user/register.jsp") }, className = "UserAction")
	public String applyRegister() {
		System.out.println(getRole());
		if (getRole().equals("tutor")) {
			setTutortype(userservice.getType("tutor_type"));
		}
		if (getRole().equals("institution")) {
			institutiontype = userservice.getType("institution_type");
			setIndustrylist(userservice.getAll(Industry.class));
		}
		return SUCCESS;
	}

	@Action(value = "register", results = { @Result(name = "success", location = "/jsp/user/login.jsp"),
			@Result(name = "error", type = "chain", location = "applyregister") }, className = "UserAction")

	public String register() throws ServletException, IOException, ParseException {

		System.out.println(getBirth());
		User user = new User();
		user.setName(getName());
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		user.setContact(getContact());
		user.setAddress(getAddress());
		user.setIntroduce(getIntroduce());
		user.setGender(getGender());
		user.setBirth(DateUtil.strToDate(getBirth()));
		if (getRole().equals("entrepreneur")) {
			Entrepreneur entrepreneur = new Entrepreneur();
			entrepreneur.setDegree(getDegree());
			entrepreneur.setMajor(getMajor());
			entrepreneur.setExperience(getExperience());
			setErrmsg(userservice.registerEntrepreneur(user, entrepreneur, getPasswordconfirm()));
			System.out.println(getErrmsg());
		}
		if (getRole().equals("tutor")) {
			Tutor tutor = new Tutor();
			tutor.setType(getTtype());
			tutor.setOccupation(getOccupation());
			tutor.setTutorship(getTutorship());
			tutor.setExperience(getExperience());
			setErrmsg(userservice.registerTutor(user, tutor, getPasswordconfirm()));
			System.out.println(getErrmsg());
		}
		if (getRole().equals("institution")) {
			Institution institution = new Institution();
			institution.setType(getInstype());
			institution.setPrincipal(getPrincipal());
			institution.setScale(getScale());
			institution.setService(getService());
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
			return SUCCESS;
		}
	}

	@Action(value = "logout", results = { @Result(name = "success", location = "/jsp/homepage.jsp") }, className = "UserAction")
	public String logout() {
		ActionContext.getContext().getSession().put("user", null);
		ActionContext.getContext().getSession().put("role", null);
		return SUCCESS;
	}

	@Action(value = "personalhome", results = { @Result(name = "success", location = "/jsp/user/personalhome.jsp"),
			@Result(name = "error", type = "chain", location = "applylogin") }, className = "UserAction")
	public String personalHome() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			return ERROR;
		}
		Role role = (Role) ActionContext.getContext().getSession().get("role");
		switch (role.getName()) {
		case "entrepreneur":
			setProjectlist(userservice.findProjectByEntrepreneur(user));
			break;
		case "tutor":
			setProjectlist(userservice.findProjectByTutor(user));
			break;
		case "institution":
			setProjectlist(userservice.findProjectByInstitution(user));
			break;
		default:
			return ERROR;
		}
		setFriendlist(userservice.findFriends(user));
		setSupplylist(userservice.findSupplyByUser(user));
		setNeedlist(userservice.findNeedByUser(user));
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

}
