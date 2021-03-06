package org.sicdlab.entrepreneur.beans;
// Generated 2015-8-5 16:28:47 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "entrepreneur_2015")
public class User implements java.io.Serializable {

	private String id;
	private Role role;
	private String name;
	private String contact;
	private Date birth;
	private String introduce;
	private String email;
	private String password;
	private String headImage;
	private String gender;
	private String address;
	private String status;
	private Date registerTime;
	private Integer visitedCount;
	private Institution institution;
	private Set mailsForSenderId = new HashSet(0);
	private Set supplies = new HashSet(0);
	private Entrepreneur entrepreneur;
	private Tutor tutor;
	private Set mailsForReceiverId = new HashSet(0);
	private Set friendsForFollowerId = new HashSet(0);
	private Set operationLogs = new HashSet(0);
	private Set friendsForFolloweeId = new HashSet(0);
	private Set notices = new HashSet(0);
	private Set needs = new HashSet(0);
	private Set userLabels = new HashSet(0);

	public User() {
	}

	public User(String id, Role role, String email, String password) {
		this.id = id;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	public User(String id, Role role, String name, String contact, Date birth, String introduce, String email, String password, String headImage, String gender,
			String address, String status, Date registerTime, Integer visitedCount, Institution institution, Set mailsForSenderId, Set supplies, Entrepreneur entrepreneur,
			Tutor tutor, Set mailsForReceiverId, Set friendsForFollowerId, Set operationLogs, Set friendsForFolloweeId, Set notices, Set needs, Set userLabels) {
		this.id = id;
		this.role = role;
		this.name = name;
		this.contact = contact;
		this.birth = birth;
		this.introduce = introduce;
		this.email = email;
		this.password = password;
		this.headImage = headImage;
		this.gender = gender;
		this.address = address;
		this.status = status;
		this.registerTime = registerTime;
		this.visitedCount = visitedCount;
		this.institution = institution;
		this.mailsForSenderId = mailsForSenderId;
		this.supplies = supplies;
		this.entrepreneur = entrepreneur;
		this.tutor = tutor;
		this.mailsForReceiverId = mailsForReceiverId;
		this.friendsForFollowerId = friendsForFollowerId;
		this.operationLogs = operationLogs;
		this.friendsForFolloweeId = friendsForFolloweeId;
		this.notices = notices;
		this.needs = needs;
		this.userLabels = userLabels;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "contact", length = 32)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birth", length = 19)
	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Column(name = "introduce", length = 500)
	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "head_image", length = 200)
	public String getHeadImage() {
		return this.headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	@Column(name = "gender", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_time", length = 19)
	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "visited_count")
	public Integer getVisitedCount() {
		return this.visitedCount;
	}

	public void setVisitedCount(Integer visitedCount) {
		this.visitedCount = visitedCount;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userBySenderId")
	public Set getMailsForSenderId() {
		return this.mailsForSenderId;
	}

	public void setMailsForSenderId(Set mailsForSenderId) {
		this.mailsForSenderId = mailsForSenderId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set getSupplies() {
		return this.supplies;
	}

	public void setSupplies(Set supplies) {
		this.supplies = supplies;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public Entrepreneur getEntrepreneur() {
		return this.entrepreneur;
	}

	public void setEntrepreneur(Entrepreneur entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByReceiverId")
	public Set getMailsForReceiverId() {
		return this.mailsForReceiverId;
	}

	public void setMailsForReceiverId(Set mailsForReceiverId) {
		this.mailsForReceiverId = mailsForReceiverId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByFollowerId")
	public Set getFriendsForFollowerId() {
		return this.friendsForFollowerId;
	}

	public void setFriendsForFollowerId(Set friendsForFollowerId) {
		this.friendsForFollowerId = friendsForFollowerId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set getOperationLogs() {
		return this.operationLogs;
	}

	public void setOperationLogs(Set operationLogs) {
		this.operationLogs = operationLogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByFolloweeId")
	public Set getFriendsForFolloweeId() {
		return this.friendsForFolloweeId;
	}

	public void setFriendsForFolloweeId(Set friendsForFolloweeId) {
		this.friendsForFolloweeId = friendsForFolloweeId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set getNotices() {
		return this.notices;
	}

	public void setNotices(Set notices) {
		this.notices = notices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set getNeeds() {
		return this.needs;
	}

	public void setNeeds(Set needs) {
		this.needs = needs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set getUserLabels() {
		return this.userLabels;
	}

	public void setUserLabels(Set userLabels) {
		this.userLabels = userLabels;
	}

}
