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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Law generated by hbm2java
 */
@Entity
@Table(name = "law", catalog = "entrepreneur_2015")
public class Law implements java.io.Serializable {

	private String id;
	private Industry industry;
	private String title;
	private Date publishTime;
	private String content;
	private String type;
	private Integer readCount;
	private String projectStage;
	private String headImage;
	private Set lawLabels = new HashSet(0);

	public Law() {
	}

	public Law(String id, String title, Date publishTime, String content, String type) {
		this.id = id;
		this.title = title;
		this.publishTime = publishTime;
		this.content = content;
		this.type = type;
	}

	public Law(String id, Industry industry, String title, Date publishTime, String content, String type, Integer readCount, String projectStage, String headImage,
			Set lawLabels) {
		this.id = id;
		this.industry = industry;
		this.title = title;
		this.publishTime = publishTime;
		this.content = content;
		this.type = type;
		this.readCount = readCount;
		this.projectStage = projectStage;
		this.headImage = headImage;
		this.lawLabels = lawLabels;
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
	@JoinColumn(name = "industry_id")
	public Industry getIndustry() {
		return this.industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publish_time", nullable = false, length = 19)
	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "read_count")
	public Integer getReadCount() {
		return this.readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	@Column(name = "project_stage", length = 50)
	public String getProjectStage() {
		return this.projectStage;
	}

	public void setProjectStage(String projectStage) {
		this.projectStage = projectStage;
	}

	@Column(name = "head_image", length = 200)
	public String getHeadImage() {
		return this.headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "law")
	public Set getLawLabels() {
		return this.lawLabels;
	}

	public void setLawLabels(Set lawLabels) {
		this.lawLabels = lawLabels;
	}

}
