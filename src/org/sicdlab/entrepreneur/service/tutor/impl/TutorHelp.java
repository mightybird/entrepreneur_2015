package org.sicdlab.entrepreneur.service.tutor.impl;

import java.util.Date;

import org.sicdlab.entrepreneur.beans.Role;
import org.sicdlab.entrepreneur.beans.User;

public class TutorHelp {
	private String id;
	private User user;
	private String type;
	private String experience;
	private String occupation;
	private Float averageScore;
	private Role role;
	private String name;
	private String contact;
	private Date birth;
	private String introduce;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Float getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Float averageScore) {
		this.averageScore = averageScore;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
