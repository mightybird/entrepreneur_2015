package org.sicdlab.entrepreneur.beans;
// Generated 2015-8-5 16:28:47 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProductTechnologyFactor generated by hbm2java
 */
@Entity
@Table(name = "product_technology_factor", catalog = "entrepreneur_2015")
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

	public ProductTechnologyFactor(String productTechnologyFactorId, float technologySpecificality, float technologyPreventImitativeness, float technologyBreakthrough,
			float technologySubstitutability, float technologyIndustrializationDegree, float technologyMarketMatchDegree, float totalScore) {
		this.productTechnologyFactorId = productTechnologyFactorId;
		this.technologySpecificality = technologySpecificality;
		this.technologyPreventImitativeness = technologyPreventImitativeness;
		this.technologyBreakthrough = technologyBreakthrough;
		this.technologySubstitutability = technologySubstitutability;
		this.technologyIndustrializationDegree = technologyIndustrializationDegree;
		this.technologyMarketMatchDegree = technologyMarketMatchDegree;
		this.totalScore = totalScore;
	}

	public ProductTechnologyFactor(String productTechnologyFactorId, float technologySpecificality, float technologyPreventImitativeness, float technologyBreakthrough,
			float technologySubstitutability, float technologyIndustrializationDegree, float technologyMarketMatchDegree, float totalScore, String comment,
			Set projectIndexes) {
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

	@Id

	@Column(name = "PRODUCT_TECHNOLOGY_FACTOR_ID", unique = true, nullable = false, length = 32)
	public String getProductTechnologyFactorId() {
		return this.productTechnologyFactorId;
	}

	public void setProductTechnologyFactorId(String productTechnologyFactorId) {
		this.productTechnologyFactorId = productTechnologyFactorId;
	}

	@Column(name = "TECHNOLOGY_SPECIFICALITY", nullable = false, precision = 10)
	public float getTechnologySpecificality() {
		return this.technologySpecificality;
	}

	public void setTechnologySpecificality(float technologySpecificality) {
		this.technologySpecificality = technologySpecificality;
	}

	@Column(name = "TECHNOLOGY_PREVENT_IMITATIVENESS", nullable = false, precision = 10)
	public float getTechnologyPreventImitativeness() {
		return this.technologyPreventImitativeness;
	}

	public void setTechnologyPreventImitativeness(float technologyPreventImitativeness) {
		this.technologyPreventImitativeness = technologyPreventImitativeness;
	}

	@Column(name = "TECHNOLOGY_BREAKTHROUGH", nullable = false, precision = 10)
	public float getTechnologyBreakthrough() {
		return this.technologyBreakthrough;
	}

	public void setTechnologyBreakthrough(float technologyBreakthrough) {
		this.technologyBreakthrough = technologyBreakthrough;
	}

	@Column(name = "TECHNOLOGY_SUBSTITUTABILITY", nullable = false, precision = 10)
	public float getTechnologySubstitutability() {
		return this.technologySubstitutability;
	}

	public void setTechnologySubstitutability(float technologySubstitutability) {
		this.technologySubstitutability = technologySubstitutability;
	}

	@Column(name = "TECHNOLOGY_INDUSTRIALIZATION_DEGREE", nullable = false, precision = 10)
	public float getTechnologyIndustrializationDegree() {
		return this.technologyIndustrializationDegree;
	}

	public void setTechnologyIndustrializationDegree(float technologyIndustrializationDegree) {
		this.technologyIndustrializationDegree = technologyIndustrializationDegree;
	}

	@Column(name = "TECHNOLOGY_MARKET_MATCH_DEGREE", nullable = false, precision = 10)
	public float getTechnologyMarketMatchDegree() {
		return this.technologyMarketMatchDegree;
	}

	public void setTechnologyMarketMatchDegree(float technologyMarketMatchDegree) {
		this.technologyMarketMatchDegree = technologyMarketMatchDegree;
	}

	@Column(name = "TOTAL_SCORE", nullable = false, precision = 10)
	public float getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	@Column(name = "COMMENT", length = 65535)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productTechnologyFactor")
	public Set getProjectIndexes() {
		return this.projectIndexes;
	}

	public void setProjectIndexes(Set projectIndexes) {
		this.projectIndexes = projectIndexes;
	}

}
