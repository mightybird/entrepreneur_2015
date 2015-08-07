package org.sicdlab.entrepreneur.action.tutor;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectEntrepreneur;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.tutor.impl.TutorServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller("DetailAction")
@Scope("prototype")
public class DetailAction {
	private String tutorId;
	private String userId;
	private String projectId;
	
	private String tutorComment;
	@Resource(name="TutorServiceImpl")
	private TutorServiceImpl tutorServiceImpl;
	
	
	private List<Tutor> tutors;
	private List<ProjectEntrepreneur> projects;	
	
	public TutorServiceImpl getTutorServiceImpl() {
		return tutorServiceImpl;
	}

	public void setTutorServiceImpl(TutorServiceImpl tutorServiceImpl) {
		this.tutorServiceImpl = tutorServiceImpl;
	}
	
	
	

	public List<ProjectEntrepreneur> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEntrepreneur> projects) {
		this.projects = projects;
	}

	public List<Tutor> getTutors() {
		return tutors;
	}
	
	public String getTutorComment() {
		return tutorComment;
	}
	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	public void setTutorComment(String tutorComment) {
		this.tutorComment = tutorComment;
	}
	
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}
	public String detail(){
		
		//System.out.println(tutorId+"4444444");
		ActionContext.getContext().getSession().put("tutorId", tutorId);
		User user=(User) ActionContext.getContext().getSession().get("user");	
		if(user==null){
			System.out.println("hello!!!!");
		}else {
			String userId=user.getId();
			if(user.getRole().getId().equals("1")){
				System.out.println(userId);
				setProjects(tutorServiceImpl.selectProject(userId));
			}else{
				System.out.println("抱歉你不是创业者");
			}
			
		}
		setTutors(tutorServiceImpl.detailUser(tutorId));
		
		return "success";
	}
	public String apply(){
		System.out.println(tutorId+"**********");
		System.out.println(userId+"kkkk");
		System.out.println(projectId+"hhhhh");
		if(tutorId==null||userId==null||projectId==null){
			System.out.println("数据为非法数据");
		}else{
			tutorServiceImpl.saveProjectEntrepreneur(userId, tutorId, projectId);
		}
		return "success";
	}
}
