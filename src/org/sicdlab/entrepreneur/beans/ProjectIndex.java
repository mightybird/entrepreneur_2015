package org.sicdlab.entrepreneur.beans;
// Generated 2015-7-27 16:33:46 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProjectIndex generated by hbm2java
 */
public class ProjectIndex implements java.io.Serializable {

	private String projectIndexId;
	private EnvironmentFactor environmentFactor;
	private FinanceFactor financeFactor;
	private ManagementTeam managementTeam;
	private MarketAssessFactor marketAssessFactor;
	private ProductTechnologyFactor productTechnologyFactor;
	private Project project;
	private String createType;
	private String tutorId;
	private String comment;
	private float totalScore;
	private Date questionnaireTime;
	private Set projectTutors = new HashSet(0);

	public ProjectIndex() {
	}

	public ProjectIndex(String projectIndexId, EnvironmentFactor environmentFactor, FinanceFactor financeFactor,
			ManagementTeam managementTeam, MarketAssessFactor marketAssessFactor,
			ProductTechnologyFactor productTechnologyFactor, Project project, String createType, float totalScore,
			Date questionnaireTime) {
		this.projectIndexId = projectIndexId;
		this.environmentFactor = environmentFactor;
		this.financeFactor = financeFactor;
		this.managementTeam = managementTeam;
		this.marketAssessFactor = marketAssessFactor;
		this.productTechnologyFactor = productTechnologyFactor;
		this.project = project;
		this.createType = createType;
		this.totalScore = totalScore;
		this.questionnaireTime = questionnaireTime;
	}

	public ProjectIndex(String projectIndexId, EnvironmentFactor environmentFactor, FinanceFactor financeFactor,
			ManagementTeam managementTeam, MarketAssessFactor marketAssessFactor,
			ProductTechnologyFactor productTechnologyFactor, Project project, String createType, String tutorId,
			String comment, float totalScore, Date questionnaireTime, Set projectTutors) {
		this.projectIndexId = projectIndexId;
		this.environmentFactor = environmentFactor;
		this.financeFactor = financeFactor;
		this.managementTeam = managementTeam;
		this.marketAssessFactor = marketAssessFactor;
		this.productTechnologyFactor = productTechnologyFactor;
		this.project = project;
		this.createType = createType;
		this.tutorId = tutorId;
		this.comment = comment;
		this.totalScore = totalScore;
		this.questionnaireTime = questionnaireTime;
		this.projectTutors = projectTutors;
	}

	public String getProjectIndexId() {
		return this.projectIndexId;
	}

	public void setProjectIndexId(String projectIndexId) {
		this.projectIndexId = projectIndexId;
	}

	public EnvironmentFactor getEnvironmentFactor() {
		return this.environmentFactor;
	}

	public void setEnvironmentFactor(EnvironmentFactor environmentFactor) {
		this.environmentFactor = environmentFactor;
	}

	public FinanceFactor getFinanceFactor() {
		return this.financeFactor;
	}

	public void setFinanceFactor(FinanceFactor financeFactor) {
		this.financeFactor = financeFactor;
	}

	public ManagementTeam getManagementTeam() {
		return this.managementTeam;
	}

	public void setManagementTeam(ManagementTeam managementTeam) {
		this.managementTeam = managementTeam;
	}

	public MarketAssessFactor getMarketAssessFactor() {
		return this.marketAssessFactor;
	}

	public void setMarketAssessFactor(MarketAssessFactor marketAssessFactor) {
		this.marketAssessFactor = marketAssessFactor;
	}

	public ProductTechnologyFactor getProductTechnologyFactor() {
		return this.productTechnologyFactor;
	}

	public void setProductTechnologyFactor(ProductTechnologyFactor productTechnologyFactor) {
		this.productTechnologyFactor = productTechnologyFactor;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getCreateType() {
		return this.createType;
	}

	public void setCreateType(String createType) {
		this.createType = createType;
	}

	public String getTutorId() {
		return this.tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public Date getQuestionnaireTime() {
		return this.questionnaireTime;
	}

	public void setQuestionnaireTime(Date questionnaireTime) {
		this.questionnaireTime = questionnaireTime;
	}

	public Set getProjectTutors() {
		return this.projectTutors;
	}

	public void setProjectTutors(Set projectTutors) {
		this.projectTutors = projectTutors;
	}

}
