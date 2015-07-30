package org.sicdlab.entrepreneur.action.tutor;

import java.util.List;

import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.common.page.Page;
import org.sicdlab.entrepreneur.service.tutor.impl.TutorServiceImpl;
/**
 * @version
 * @author lzc
 *
 */
public class TutorAction {
	private Tutor tutor;
	private List<Tutor> tutor1s;
	private TutorServiceImpl tutorServiceImpl=new TutorServiceImpl();
	private List<Tutor> tutors=tutorServiceImpl.select();
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
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
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
		page=new Page(3, currentPage, tutors.size(), tutors);
		tutor1s=tutorServiceImpl.select(3,currentPage);
		pageCount=page.getPageCount();
		recordCount=page.getRecordCount();
		pageSize=page.getPageSize();
		currentPage=page.getCurrentPage();
		beginPageIndex=page.getBeginPageIndex();
		endPageIndex=page.getEndPageIndex();
		return "success";
	}
	public String manager(){
		
		return "success";
	}
}
