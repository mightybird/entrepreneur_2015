package org.sicdlab.entrepreneur.beans;
// Generated 2015-7-27 16:33:46 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Tutor generated by hbm2java
 */
public class Tutor implements java.io.Serializable {

	private String id;
	private User user;
	private String type;
	private String experience;
	private String occupation;
	private String tutorship;
	private Float averageScore;
	private Set projectTutors = new HashSet(0);

	public Tutor() {
	}

	public Tutor(User user) {
		this.user = user;
	}

	public Tutor(User user, String type, String experience, String occupation, String tutorship, Float averageScore,
			Set projectTutors) {
		this.user = user;
		this.type = type;
		this.experience = experience;
		this.occupation = occupation;
		this.tutorship = tutorship;
		this.averageScore = averageScore;
		this.projectTutors = projectTutors;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getTutorship() {
		return this.tutorship;
	}

	public void setTutorship(String tutorship) {
		this.tutorship = tutorship;
	}

	public Float getAverageScore() {
		return this.averageScore;
	}

	public void setAverageScore(Float averageScore) {
		this.averageScore = averageScore;
	}

	public Set getProjectTutors() {
		return this.projectTutors;
	}

	public void setProjectTutors(Set projectTutors) {
		this.projectTutors = projectTutors;
	}

}
