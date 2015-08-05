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
@Controller("TechniqueAction")
@Scope("prototype")
public class TechniqueAction {
	private Tutor tutor;
	private List<Tutor> technique1s;
	@Resource(name="TutorServiceImpl")
	private TutorServiceImpl tutorServiceImpl;
	private List<Tutor> techniques;
	//实现的分页的参数
	private Page page;
	private int currentPage;
	private int pageSize;
	private int recordCount;
	private int pageCount; 
	private int beginPageIndex; 
	private int endPageIndex; 
	
	


	public List<Tutor> getTechnique1s() {
		return technique1s;
	}
	public void setTechnique1s(List<Tutor> technique1s) {
		this.technique1s = technique1s;
	}
	public List<Tutor> getTechniques() {
		return techniques;
	}
	public void setTechniques(List<Tutor> techniques) {
		this.techniques = techniques;
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
	public String technique(){
		//获得分页参数以及对各参数的处理
		setTechniques(tutorServiceImpl.selectTechnique());
		
		page=new Page(3, currentPage, techniques.size(), techniques);
		//tutor1s=tutorServiceImpl.select(3,currentPage);
		setTechnique1s(tutorServiceImpl.selectTechnique(3, currentPage));
		pageCount=page.getPageCount();
		recordCount=page.getRecordCount();
		pageSize=page.getPageSize();
		currentPage=page.getCurrentPage();
		beginPageIndex=page.getBeginPageIndex();
		endPageIndex=page.getEndPageIndex();
		return "success";
	}
}
