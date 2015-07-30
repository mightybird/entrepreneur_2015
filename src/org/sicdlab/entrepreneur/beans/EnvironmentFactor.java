package org.sicdlab.entrepreneur.beans;
// Generated 2015-7-27 16:33:46 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * EnvironmentFactor generated by hbm2java
 */
public class EnvironmentFactor implements java.io.Serializable {

	private String environmentFactorId;
	private float policySupport;
	private float resourceSupportDegree;
	private float economyBoomDegree;
	private float totalScore;
	private String comment;
	private Set projectIndexes = new HashSet(0);

	public EnvironmentFactor() {
	}

	public EnvironmentFactor(String environmentFactorId, float policySupport, float resourceSupportDegree,
			float economyBoomDegree, float totalScore) {
		this.environmentFactorId = environmentFactorId;
		this.policySupport = policySupport;
		this.resourceSupportDegree = resourceSupportDegree;
		this.economyBoomDegree = economyBoomDegree;
		this.totalScore = totalScore;
	}

	public EnvironmentFactor(String environmentFactorId, float policySupport, float resourceSupportDegree,
			float economyBoomDegree, float totalScore, String comment, Set projectIndexes) {
		this.environmentFactorId = environmentFactorId;
		this.policySupport = policySupport;
		this.resourceSupportDegree = resourceSupportDegree;
		this.economyBoomDegree = economyBoomDegree;
		this.totalScore = totalScore;
		this.comment = comment;
		this.projectIndexes = projectIndexes;
	}

	public String getEnvironmentFactorId() {
		return this.environmentFactorId;
	}

	public void setEnvironmentFactorId(String environmentFactorId) {
		this.environmentFactorId = environmentFactorId;
	}

	public float getPolicySupport() {
		return this.policySupport;
	}

	public void setPolicySupport(float policySupport) {
		this.policySupport = policySupport;
	}

	public float getResourceSupportDegree() {
		return this.resourceSupportDegree;
	}

	public void setResourceSupportDegree(float resourceSupportDegree) {
		this.resourceSupportDegree = resourceSupportDegree;
	}

	public float getEconomyBoomDegree() {
		return this.economyBoomDegree;
	}

	public void setEconomyBoomDegree(float economyBoomDegree) {
		this.economyBoomDegree = economyBoomDegree;
	}

	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set getProjectIndexes() {
		return this.projectIndexes;
	}

	public void setProjectIndexes(Set projectIndexes) {
		this.projectIndexes = projectIndexes;
	}

}
