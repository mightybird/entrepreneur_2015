package org.sicdlab.entrepreneur.beans;
// Generated 2015-7-27 16:33:46 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Industry generated by hbm2java
 */
public class Industry implements java.io.Serializable {

	private String id;
	private String name;
	private String saturation;
	private String entryBarrier;
	private String maturity;
	private String scale;
	private String future;
	private String description;
	private Set laws = new HashSet(0);
	private Set knowledges = new HashSet(0);
	private Set supplies = new HashSet(0);
	private Set policies = new HashSet(0);
	private Set needs = new HashSet(0);
	private Set projects = new HashSet(0);

	public Industry() {
	}

	public Industry(String id, String name, String saturation, String entryBarrier, String maturity, String scale,
			String future) {
		this.id = id;
		this.name = name;
		this.saturation = saturation;
		this.entryBarrier = entryBarrier;
		this.maturity = maturity;
		this.scale = scale;
		this.future = future;
	}

	public Industry(String id, String name, String saturation, String entryBarrier, String maturity, String scale,
			String future, String description, Set laws, Set knowledges, Set supplies, Set policies, Set needs,
			Set projects) {
		this.id = id;
		this.name = name;
		this.saturation = saturation;
		this.entryBarrier = entryBarrier;
		this.maturity = maturity;
		this.scale = scale;
		this.future = future;
		this.description = description;
		this.laws = laws;
		this.knowledges = knowledges;
		this.supplies = supplies;
		this.policies = policies;
		this.needs = needs;
		this.projects = projects;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSaturation() {
		return this.saturation;
	}

	public void setSaturation(String saturation) {
		this.saturation = saturation;
	}

	public String getEntryBarrier() {
		return this.entryBarrier;
	}

	public void setEntryBarrier(String entryBarrier) {
		this.entryBarrier = entryBarrier;
	}

	public String getMaturity() {
		return this.maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}

	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getFuture() {
		return this.future;
	}

	public void setFuture(String future) {
		this.future = future;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getLaws() {
		return this.laws;
	}

	public void setLaws(Set laws) {
		this.laws = laws;
	}

	public Set getKnowledges() {
		return this.knowledges;
	}

	public void setKnowledges(Set knowledges) {
		this.knowledges = knowledges;
	}

	public Set getSupplies() {
		return this.supplies;
	}

	public void setSupplies(Set supplies) {
		this.supplies = supplies;
	}

	public Set getPolicies() {
		return this.policies;
	}

	public void setPolicies(Set policies) {
		this.policies = policies;
	}

	public Set getNeeds() {
		return this.needs;
	}

	public void setNeeds(Set needs) {
		this.needs = needs;
	}

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

}
