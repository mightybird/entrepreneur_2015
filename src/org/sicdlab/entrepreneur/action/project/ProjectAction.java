package org.sicdlab.entrepreneur.action.project;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectEntrepreneur;
import org.sicdlab.entrepreneur.service.baseservice.BaseService;
import org.sicdlab.entrepreneur.service.baseservice.impl.BaseServiceImpl;
import org.sicdlab.entrepreneur.service.projectservice.ProjectService;
import org.sicdlab.entrepreneur.utils.DateUtil;
import org.sicdlab.entrepreneur.utils.FileUpload;
import org.sicdlab.entrepreneur.utils.UUIDGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller("ProjectAction")
@Scope("prototype")
@Namespace("/project")
public class ProjectAction extends ActionSupport {
	private String projectid;
	private String projectname; 
	private String startTime;
	private  String fundtype;
	private String fundscope;
	private String fundlack;
	private String contact;
	private String province;
    private String city;
    private String county;
    private String industry;      // 所属行业
    private String txtTags;      //我的标签
    private String introduce;     //项目介绍   
    
    private File upload;            //文件
    private String uploadFileName;    //和jsp的name属性对应
    
    
    private String imageUrl;  //
    
    
    @Resource(name="ProjectServiceImpl")
    private ProjectService projectservice;
    @Resource(name="BaseServiceImpl")
    private BaseService baseservice;
    
    
    
    
	public ProjectService getProjectservice() {
		return projectservice;
	}
	public void setProjectservice(ProjectService projectservice) {
		this.projectservice = projectservice;
	}
	public BaseService getBaseservice() {
		return baseservice;
	}
	public void setBaseservice(BaseService baseservice) {
		this.baseservice = baseservice;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
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
	
	public String getFundscope() {
		return fundscope;
	}
	public void setFundscope(String fundscope) {
		this.fundscope = fundscope;
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
	
	public String getTxtTags() {
		return txtTags;
	}
	public void setTxtTags(String txtTags) {
		this.txtTags = txtTags;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
    
	
	
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	@Action(value = "UploadAccessary", className = "ProjectAction")
	public  String UploadAccessary(){
		HttpServletRequest request= ServletActionContext.getRequest();
		String filename=getUploadFileName();
		try {
			baseservice.uploadfile(getUpload(), filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;	
	}
	@Action(value="createProjectSubmit",
	results={@Result(name="success",type="redirectAction",location="showProjectInfoPage",params={"projectId","%{projectId}"})}
	,className="ProjectAction")
	public String createProjectSubmit() throws ParseException{	
		HttpServletRequest request=ServletActionContext.getRequest();
		ActionContext.getContext().getSession().put("userid", "1");
		String myUserId=ActionContext.getContext().getSession().get("userid").toString();
		Project project=new Project();
		projectid=UUIDGenerator.randomUUID();
		project.setId(projectid);;
		project.setName(projectname);
		project.setStartTime(DateUtil.strToDate(startTime));
		project.setFundType(fundtype);
		project.setMemberNumber(1);
		project.setContact(contact);
		project.setVisitorNumber(0);
		project.setIntroduce(introduce);
		BigDecimal fundLackLower = new BigDecimal(fundlack.split("-")[0]);
		BigDecimal fundLackUpper = new BigDecimal(fundlack.split("-")[1]);
		BigDecimal projectFundAmountLower = new BigDecimal(fundscope.split("-")[0]);
		BigDecimal projectFundAmountUpper = new BigDecimal(fundscope.split("-")[1]);
	
		project.setFundLackLower(fundLackLower);
		project.setFundLackUpper(fundLackUpper);
		project.setFundAmountLower(projectFundAmountLower);
		project.setFundAmountUpper(projectFundAmountUpper);
		
		System.out.println(txtTags);
		String[] labels=txtTags.split("|");          //数据字典存项目标签
		DataDictionary dd=new DataDictionary();
		for(int i=0;i<labels.length;i++){
			dd.setId(UUIDGenerator.randomUUID());
			dd.setDdkey("项目标签");
			dd.setDdvalue(labels[i]);
			System.out.println(labels[i]);
			//projectservice.save(dd);
		}
		projectservice.save(project);
		ProjectEntrepreneur pe=new ProjectEntrepreneur();         //创业者项目表
		Entrepreneur en=projectservice.getEntrepreneruById(myUserId);
		pe.setId(UUIDGenerator.randomUUID());
		pe.setEntrepreneur(en);
		pe.setProject(project);
		//projectservice.save(pe);
		
		return "success";
	}		
	
	@Action(value="showProjectInfoPage",results={
	@Result(name="success",location="/jsp/projectJsp/project_info.jsp"),
	@Result(name="SUCCESS_CREATOR",location="/jsp/projectJsp/my_project_info.jsp")
	},className="ProjectAction")
	public String showProjectInfoPage(){
		
		
		
		return "success";
	}
	
	
	@Action(value="modifyProjectImage",className="ProjectAction")
	public String modifyProjectImage() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
	  	String pathType=request.getParameter("pathType");
	  	String projectId=request.getParameter("projectId");
	  	
	  	PrintWriter out = null; 
	  	HttpServletResponse response = ServletActionContext.getResponse();
	  	response.setCharacterEncoding("gbk"); 
	  	out = response.getWriter();  	  	
	  	
	  	String savePath = ServletActionContext.getServletContext().getRealPath("/images/"); // 获取项目根路径

	  	String result=FileUpload.uploadFile(uploadFileName,savePath,upload);
	  	if(result.equals("FILE_TYPE_ERROR"))
	  	{
	  		result="<font color='red'>" + uploadFileName+ "修改失败!</font>";
	  	}
	  	else if(result.equals("FILE_UPLOAD_ERROR"))
	  	{
	  		result="<font color='red'>" + uploadFileName+ "修改失败!</font>" ;
	  	}
	  	else
	  	{
	  		
	  		projectservice.SaveProjectImagePath(projectId, "项目图片",result);
			result="<font color='red'>" + "项目图标修改成功!</font>#" + result + "#" + uploadFileName;
	  	}
		out.print(result);  
		return NONE;
	}

	@Action(value="showImage",className="ProjectAction")
	 public String showImage() throws Exception {  
	        // 根据图片地址构造file对象  
	        File file = new File(imageUrl);  
	        InputStream is = new FileInputStream(file);  
	        Image image = ImageIO.read(is);// 读图片  
	        String imageType = imageUrl.substring(imageUrl.lastIndexOf(".") + 1);  
	        RenderedImage img = (RenderedImage) image;  
	    	HttpServletResponse response = ServletActionContext.getResponse();
	        OutputStream out = response.getOutputStream();  
	        ImageIO.write(img, imageType, out);  
	        out.flush();  
	        out.close();  
	        return null;      
	    }
}
