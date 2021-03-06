package org.sicdlab.entrepreneur.beans;
// Generated 2015-8-5 16:28:47 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * NoticeTemplate generated by hbm2java
 */
@Entity
@Table(name = "notice_template", catalog = "entrepreneur_2015")
public class NoticeTemplate implements java.io.Serializable {

	private String id;
	private String title;
	private String content;
	private Date sendTime;
	private String noticeType;

	public NoticeTemplate() {
	}

	public NoticeTemplate(String id) {
		this.id = id;
	}

	public NoticeTemplate(String id, String title, String content, Date sendTime, String noticeType) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.sendTime = sendTime;
		this.noticeType = noticeType;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_time", length = 19)
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "notice_type", length = 30)
	public String getNoticeType() {
		return this.noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

}
