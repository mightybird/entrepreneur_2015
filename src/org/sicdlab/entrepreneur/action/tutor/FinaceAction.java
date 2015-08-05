package org.sicdlab.entrepreneur.action.tutor;

import java.util.List;

import javax.annotation.Resource;

import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.common.page.Page;
import org.sicdlab.entrepreneur.service.tutor.impl.TutorServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
/**
 * @version
 * @author lzc
 *
 */
@Controller("FinaceAction")
@Scope("prototype")
public class FinaceAction {
	private Tutor tutor;
	private List<Tutor> finace1s;
	@Resource(name="TutorServiceImpl")
	private TutorServiceImpl tutorServiceImpl;
	private List<Tutor> finaces;
	//实现的分页的参数
	private Page page;
	private int currentPage;
	private int pageSize;
	private int recordCount;
	private int pageCount; 
	private int beginPageIndex; 
	private int endPageIndex; 
	
	

	public List<Tutor> getFinace1s() {
		return finace1s;
	}
	public void setFinace1s(List<Tutor> finace1s) {
		this.finace1s = finace1s;
	}
	public List<Tutor> getFinaces() {
		return finaces;
	}
	public void setFinaces(List<Tutor> finaces) {
		this.finaces = finaces;
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
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public TutorServiceImpl getTutorServiceImpl() {
		return tutorServiceImpl;
	}
	
	public void setTutorServiceImpl(TutorServiceImpl tutorServiceImpl) {
		this.tutorServiceImpl = tutorServiceImpl;
	}
	//实现分页财务导师信息
	public String finace(){
		//获得分页参数以及对各参数的处理
		setFinaces(tutorServiceImpl.selectFinace());
		
		page=new Page(3, currentPage, finaces.size(), finaces);
		//tutor1s=tutorServiceImpl.select(3,currentPage);
		
		setFinace1s(tutorServiceImpl.selectFinace(3, currentPage));
		
		pageCount=page.getPageCount();
		recordCount=page.getRecordCount();
		pageSize=page.getPageSize();
		currentPage=page.getCurrentPage();
		beginPageIndex=page.getBeginPageIndex();
		endPageIndex=page.getEndPageIndex();
		return "success";
	}
}
