package org.sicdlab.entrepreneur.beans;
// Generated 2015-8-5 16:28:47 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * NeedLabel generated by hbm2java
 */
@Entity
@Table(name = "need_label", catalog = "entrepreneur_2015")
public class NeedLabel implements java.io.Serializable {

	private String id;
	private Label label;
	private Need need;

	public NeedLabel() {
	}

	public NeedLabel(String id, Label label, Need need) {
		this.id = id;
		this.label = label;
		this.need = need;
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
	@JoinColumn(name = "label_id", nullable = false)
	public Label getLabel() {
		return this.label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "need_id", nullable = false)
	public Need getNeed() {
		return this.need;
	}

	public void setNeed(Need need) {
		this.need = need;
	}

}
