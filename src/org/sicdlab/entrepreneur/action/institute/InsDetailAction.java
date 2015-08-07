package org.sicdlab.entrepreneur.action.institute;

import java.util.List;

import javax.annotation.Resource;

import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.ProjectEntrepreneur;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.institute.impl.InstituteServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller("InsDetailAction")
@Scope("prototype")
public class InsDetailAction {
	private List<Institution> institutions;
	private List<ProjectEntrepreneur> projects;
	@Resource(name="InstituteServiceImpl")
	private InstituteServiceImpl instituteServiceImpl;
	//获的相关变量的Id	
	private String instituteId;
	private String projectId;
	private String userId;
	
	
	//各变量的get、set方法
	
	public String getInstituteId() {
		return instituteId;
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
	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}
	//存放所有查询到的ProjectEntrepreneur值
	public List<ProjectEntrepreneur> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectEntrepreneur> projects) {
		this.projects = projects;
	}
	public List<Institution> getInstitutions() {
		return institutions;
	}
	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}
	public InstituteServiceImpl getInstituteServiceImpl() {
		return instituteServiceImpl;
	}
	public void setInstituteServiceImpl(InstituteServiceImpl instituteServiceImpl) {
		this.instituteServiceImpl = instituteServiceImpl;
	}
	
	public String list(){
		//System.out.println(instituteId+"*****************");
		//将机构的Id存在session中以备后面使用
		ActionContext.getContext().getSession().put("instituteId", instituteId);
		User user= (User) ActionContext.getContext().getSession().get("user");
		if(user==null){
			System.out.println("请登录后再试");
		}else{
			String userId=user.getId();
			if(user.getRole().getId().equals("1")){
				System.out.println(userId);
				setProjects(instituteServiceImpl.selectProject(userId));
			}else{
				System.out.println("抱歉你不是一个创业者");
			}
		}
		setInstitutions(instituteServiceImpl.detailInstitution(instituteId));
		return "success";
	}
	public String apply(){
		//多重保障存入的数据的合法性
		if(userId==null||projectId==null||instituteId==null){
			System.out.println("数据为非法数据");
		}else{
			System.out.println("恭喜你棒棒糖");
			instituteServiceImpl.saveProjectInstitution(userId, instituteId, projectId);
		}
		return "success";
	}
}
