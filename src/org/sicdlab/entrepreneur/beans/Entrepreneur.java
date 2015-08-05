package org.sicdlab.entrepreneur.beans;
// Generated 2015-8-5 16:28:47 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Entrepreneur generated by hbm2java
 */
@Entity
@Table(name = "entrepreneur", catalog = "entrepreneur_2015")
public class Entrepreneur implements java.io.Serializable {

	private String id;
	private User user;
	private String degree;
	private String major;
	private String experience;
	private String resumePath;
	private Set projectEntrepreneurs = new HashSet(0);

	public Entrepreneur() {
	}

	public Entrepreneur(User user) {
		this.user = user;
	}

	public Entrepreneur(User user, String degree, String major, String experience, String resumePath, Set projectEntrepreneurs) {
		this.user = user;
		this.degree = degree;
		this.major = major;
		this.experience = experience;
		this.resumePath = resumePath;
		this.projectEntrepreneurs = projectEntrepreneurs;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user") )
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "degree", length = 45)
	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "major", length = 200)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "experience", length = 65535)
	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Column(name = "resume_path", length = 200)
	public String getResumePath() {
		return this.resumePath;
	}

	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entrepreneur")
	public Set getProjectEntrepreneurs() {
		return this.projectEntrepreneurs;
	}

	public void setProjectEntrepreneurs(Set projectEntrepreneurs) {
		this.projectEntrepreneurs = projectEntrepreneurs;
	}

}
