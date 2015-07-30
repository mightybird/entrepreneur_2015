package org.sicdlab.entrepreneur.action.project;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.service.projectservice.ProjectService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("ProjectAction")
@Scope("prototype")
@Namespace(value = "/project")
public class ProjectAction extends ActionSupport {
	private int projectid;
	private String projectname; 
	private String startTime;
	private  String fundtype;
	private String fundamount;
	private String fundlack;
	private String contact;
	private String province;
    private String city;
    private String county;
    private String industry;        // 所属行业
    private String[] labels;      //我的标签
    private String introduce;     //项目介绍   
    
    private File uploadfile;          //项目附件文件
    private String filename;    //附件文件名
    
    @Resource(name="ProjectServiceImpl")
    private ProjectService projectservice;
   // private ProjectService projectservie;
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
		
		
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFundtype() {
		return fundtype;
	}
	public void setFundtype(String fundtype) {
		this.fundtype = fundtype;
	}
	public String getFundamount() {
		return fundamount;
	}
	public void setFundamount(String fundamount) {
		this.fundamount = fundamount;
	}
	public String getFundlack() {
		return fundlack;
	}
	public void setFundlack(String fundlack) {
		this.fundlack = fundlack;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String[] getLabels() {
		return labels;
	}
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
    
	
	public ProjectService getProjectservice() {
		return projectservice;
	}
	
	public void setProjectservice(ProjectService projectservice) {
		this.projectservice = projectservice;
	}
			
	
	
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	@Action(value = "ShowProjectCreatePage", results = { @Result(name = "success", 
			location = "/jsp/Project/projectcreate.jsp")}, className = "ProjectAction")
    public String ShowProjectCreatePage(){
		HttpServletRequest request= ServletActionContext.getRequest();
		List<DataDictionary> FundScope= projectservice.getFundScope();
		List<DataDictionary>  FundType=projectservice.getFundType();
		List<DataDictionary>  FundLack=projectservice.getFundLack();
		request.setAttribute("fundscope", FundScope);  		
		request.setAttribute("fundtype", FundType);
		request.setAttribute("fundlack", FundLack);
		
		
		
		return "success";
		
	}
	
	
	
	
	
	public String createProjectSubmit(){
		
		
		return "success";
	}
	
	
	public String showProjectInfoPage(){
		
		
		return "success";
	}
}
