package org.sicdlab.entrepreneur.action.project;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.sicdlab.entrepreneur.beans.Label;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.projectservice.ProjectService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller("ProjectListAction")
@Scope("prototype")
@Namespace("/projectlist")
public class ProjectListAction {

	private List<Project> project1s; // 当前项目列表
	@Resource(name = "ProjectServiceImpl")
	private ProjectService projectservice;
	private List<Project> projects; // 总的项目列表
	private List<Label> projectlabels;

	// 实现的分页的参数
	private Page1 page1;
	private int currentPage;
	private int pageSize;
	private int recordCount;
	private int pageCount;
	private int beginPageIndex;
	private int endPageIndex;
	//显示项目详情的参数
	private String projectId;
	private Project project;

	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Project> getProject1s() {
		return project1s;
	}

	public void setProject1s(List<Project> project1s) {
		this.project1s = project1s;
	}

	public ProjectService getProjectservice() {
		return projectservice;
	}

	public void setProjectservice(ProjectService projectservice) {
		this.projectservice = projectservice;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Page1 getPage1() {
		return page1;
	}

	public void setPage1(Page1 page1) {
		this.page1 = page1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public List<Label> getProjectlabels() {
		return projectlabels;
	}

	public void setProjectlabels(List<Label> projectlabels) {
		this.projectlabels = projectlabels;
	}

	@Action(value = "ShowProjectList", results = {
			@Result(name = "success", location = "/jsp/Project/project_list.jsp") }, className = "ProjectListAction")
	public String ShowProjectList() {
		// 获得分页参数以及对各参数的处理

		for (int i = 0; i < projectservice.selectAll().size(); i++) {
			List<Project> project = projectservice.selectAll();
			setProjectlabels(projectservice.selectAllLabels(project.get(i)));
		}
		setProjects(projectservice.selectAll());
		// tutors=tutorServiceImpl.select();
		page1 = new Page1(3, currentPage, projects.size(), projects);
		// tutor1s=tutorServiceImpl.select(3,currentPage);
		// 通过Spring初始化

		setProject1s(projectservice.selectAll(3, currentPage));
		// ActionContext.getContext().getSession().put("name",
		// tutor.getUser().getName());

		pageCount = page1.getPageCount();
		recordCount = page1.getRecordCount();
		pageSize = page1.getPageSize();
		currentPage = page1.getCurrentPage();
		beginPageIndex = page1.getBeginPageIndex();
		endPageIndex = page1.getEndPageIndex();
		return "success";
	}

	@Action(value = "ShowProjectDetail", results = {
			@Result(name = "success", location = "/jsp/Project/project_info.jsp") }, className = "ProjectListAction")
	public String ShowProjectDetail() {
		Project project=projectservice.getProjectById(getProjectId());
		System.out.println("项目的id"+getProjectId());
		setProject(project);
		
		User user=(User) ActionContext.getContext().getSession().get("user");	
		String role_id=null;
		if(user==null){
			role_id="0";
		}else{
			role_id=user.getRole().getId();
		}
		
		System.out.println("角色id是"+role_id);
		List<Label> labels=projectservice.selectAllLabels(project);
		System.out.println("标签数"+labels.size());
		HttpServletRequest request=  ServletActionContext.getRequest();
		request.setAttribute("role_id", role_id);
		request.setAttribute("user", user);
		request.setAttribute("labels", labels);
		return "success";
	}

}
