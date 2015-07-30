package org.sicdlab.entrepreneur.beans;
// Generated 2015-7-27 16:33:46 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * ProductTechnologyFactor generated by hbm2java
 */
public class ProductTechnologyFactor implements java.io.Serializable {

	private String productTechnologyFactorId;
	private float technologySpecificality;
	private float technologyPreventImitativeness;
	private float technologyBreakthrough;
	private float technologySubstitutability;
	private float technologyIndustrializationDegree;
	private float technologyMarketMatchDegree;
	private float totalScore;
	private String comment;
	private Set projectIndexes = new HashSet(0);

	public ProductTechnologyFactor() {
	}

	public ProductTechnologyFactor(String productTechnologyFactorId, float technologySpecificality,
			float technologyPreventImitativeness, float technologyBreakthrough, float technologySubstitutability,
			float technologyIndustrializationDegree, float technologyMarketMatchDegree, float totalScore) {
		this.productTechnologyFactorId = productTechnologyFactorId;
		this.technologySpecificality = technologySpecificality;
		this.technologyPreventImitativeness = technologyPreventImitativeness;
		this.technologyBreakthrough = technologyBreakthrough;
		this.technologySubstitutability = technologySubstitutability;
		this.technologyIndustrializationDegree = technologyIndustrializationDegree;
		this.technologyMarketMatchDegree = technologyMarketMatchDegree;
		this.totalScore = totalScore;
	}

	public ProductTechnologyFactor(String productTechnologyFactorId, float technologySpecificality,
			float technologyPreventImitativeness, float technologyBreakthrough, float technologySubstitutability,
			float technologyIndustrializationDegree, float technologyMarketMatchDegree, float totalScore,
			String comment, Set projectIndexes) {
		this.productTechnologyFactorId = productTechnologyFactorId;
		this.technologySpecificality = technologySpecificality;
		this.technologyPreventImitativeness = technologyPreventImitativeness;
		this.technologyBreakthrough = technologyBreakthrough;
		this.technologySubstitutability = technologySubstitutability;
		this.technologyIndustrializationDegree = technologyIndustrializationDegree;
		this.technologyMarketMatchDegree = technologyMarketMatchDegree;
		this.totalScore = totalScore;
		this.comment = comment;
		this.projectIndexes = projectIndexes;
	}

	public String getProductTechnologyFactorId() {
		return this.productTechnologyFactorId;
	}

	public void setProductTechnologyFactorId(String productTechnologyFactorId) {
		this.productTechnologyFactorId = productTechnologyFactorId;
	}

	public float getTechnologySpecificality() {
		return this.technologySpecificality;
	}

	public void setTechnologySpecificality(float technologySpecificality) {
		this.technologySpecificality = technologySpecificality;
	}

	public float getTechnologyPreventImitativeness() {
		return this.technologyPreventImitativeness;
	}

	public void setTechnologyPreventImitativeness(float technologyPreventImitativeness) {
		this.technologyPreventImitativeness = technologyPreventImitativeness;
	}

	public float getTechnologyBreakthrough() {
		return this.technologyBreakthrough;
	}

	public void setTechnologyBreakthrough(float technologyBreakthrough) {
		this.technologyBreakthrough = technologyBreakthrough;
	}

	public float getTechnologySubstitutability() {
		return this.technologySubstitutability;
	}

	public void setTechnologySubstitutability(float technologySubstitutability) {
		this.technologySubstitutability = technologySubstitutability;
	}

	public float getTechnologyIndustrializationDegree() {
		return this.technologyIndustrializationDegree;
	}

	public void setTechnologyIndustrializationDegree(float technologyIndustrializationDegree) {
		this.technologyIndustrializationDegree = technologyIndustrializationDegree;
	}

	public float getTechnologyMarketMatchDegree() {
		return this.technologyMarketMatchDegree;
	}

	public void setTechnologyMarketMatchDegree(float technologyMarketMatchDegree) {
		this.technologyMarketMatchDegree = technologyMarketMatchDegree;
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
