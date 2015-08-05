package org.sicdlab.entrepreneur.action.tutor;

import java.util.List;

import javax.annotation.Resource;

import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.common.page.Page;
import org.sicdlab.entrepreneur.service.tutor.impl.TutorServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
/**
 * @version
 * @author lzc
 *
 */
@Controller("TutorAction")
@Scope("prototype")
public class TutorAction {
	private List<Tutor> tutor1s;
	@Resource(name="TutorServiceImpl")
	private TutorServiceImpl tutorServiceImpl;
	private List<Tutor> tutors;
	//实现的分页的参数
	private Page page;
	private int currentPage;
	private int pageSize;
	private int recordCount;
	private int pageCount; 
	private int beginPageIndex; 
	private int endPageIndex; 
	
	public List<Tutor> getTutor1s() {
		return tutor1s;
	}
	public void setTutor1s(List<Tutor> tutor1s) {
		this.tutor1s = tutor1s;
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
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Tutor> getTutors() {
		return tutors;
	}
	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}
	public TutorServiceImpl getTutorServiceImpl() {
		return tutorServiceImpl;
	}
	
	public void setTutorServiceImpl(TutorServiceImpl tutorServiceImpl) {
		this.tutorServiceImpl = tutorServiceImpl;
	}
	//实现分页并显示所有的导师信息
	public String list(){
		//获得分页参数以及对各参数的处理
		
		setTutors(tutorServiceImpl.selectAll());
		//tutors=tutorServiceImpl.select();
		page=new Page(3, currentPage, tutors.size(), tutors);
		//tutor1s=tutorServiceImpl.select(3,currentPage);
		//通过Spring初始化
		
		setTutor1s(tutorServiceImpl.selectAll(3, currentPage));
		//ActionContext.getContext().getSession().put("name", tutor.getUser().getName());
		
		pageCount=page.getPageCount();
		recordCount=page.getRecordCount();
		pageSize=page.getPageSize();
		currentPage=page.getCurrentPage();
		beginPageIndex=page.getBeginPageIndex();
		endPageIndex=page.getEndPageIndex();
		return "success";
	}
}
