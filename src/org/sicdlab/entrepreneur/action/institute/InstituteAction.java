package org.sicdlab.entrepreneur.action.institute;

import java.util.List;

import javax.annotation.Resource;

import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.service.institute.impl.InstituteServiceImpl;
import org.sicdlab.entrepreneur.service.institute.impl.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("InstituteAction")
@Scope("prototype")
public class InstituteAction {
		private List<Institution> institution1s;
		private List<Institution> institution2s;
		@Resource(name="InstituteServiceImpl")
		private InstituteServiceImpl instituteServiceImpl;
		private List<Institution> institutions;
		private List<DataDictionary> dataDictionaries;
		
		
		//实现的分页的参数
		private Page page;
		private int currentPage;
		private int pageSize;
		private int recordCount;
		private int pageCount; 
		private int beginPageIndex; 
		private int endPageIndex; 
		
		
		
		
		public List<DataDictionary> getDataDictionaries() {
			return dataDictionaries;
		}
		public void setDataDictionaries(List<DataDictionary> dataDictionaries) {
			this.dataDictionaries = dataDictionaries;
		}
		public List<Institution> getInstitution2s() {
			return institution2s;
		}
		public void setInstitution2s(List<Institution> institution2s) {
			this.institution2s = institution2s;
		}
		public List<Institution> getInstitution1s() {
			return institution1s;
		}
		public void setInstitution1s(List<Institution> institution1s) {
			this.institution1s = institution1s;
		}
		public InstituteServiceImpl getInstituteServiceImpl() {
			return instituteServiceImpl;
		}
		public void setInstituteServiceImpl(InstituteServiceImpl instituteServiceImpl) {
			this.instituteServiceImpl = instituteServiceImpl;
		}
		
		public List<Institution> getInstitutions() {
			return institutions;
		}
		public void setInstitutions(List<Institution> institutions) {
			this.institutions = institutions;
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
		
		
		//实现分页并显示所有的机构信息
		public String list(){
			
			//查询侧面导航栏信息
			setInstitution2s(instituteServiceImpl.selectRec());
			setInstitutions(instituteServiceImpl.selectAll());
			page=new Page(3, currentPage, institutions.size(), institutions);
			
			setInstitution1s(instituteServiceImpl.selectAll(3, currentPage));
			
			//ActionContext.getContext().getSession().put("name", tutor.getUser().getName());
			
			pageCount=page.getPageCount();
			recordCount=page.getRecordCount();
			pageSize=page.getPageSize();
			currentPage=page.getCurrentPage();
			beginPageIndex=page.getBeginPageIndex();
			endPageIndex=page.getEndPageIndex();
			return "success";
		}
		public String finace(){
			//查询侧面导航栏信息
			String finaceParameter="融资借贷";
			setInstitution2s(instituteServiceImpl.selectRec());
			setInstitutions(instituteServiceImpl.select(finaceParameter));
			page=new Page(3, currentPage, institutions.size(), institutions);
			
			setInstitution1s(instituteServiceImpl.select(3, currentPage,finaceParameter));
			
			//ActionContext.getContext().getSession().put("name", tutor.getUser().getName());
			
			pageCount=page.getPageCount();
			recordCount=page.getRecordCount();
			pageSize=page.getPageSize();
			currentPage=page.getCurrentPage();
			beginPageIndex=page.getBeginPageIndex();
			endPageIndex=page.getEndPageIndex();
			return "success";
		}
		
		public String talent(){
			//查询侧面导航栏信息
			
			String finaceParameter="人才培训";
			setInstitution2s(instituteServiceImpl.selectRec());
			setInstitutions(instituteServiceImpl.select(finaceParameter));
			page=new Page(3, currentPage, institutions.size(), institutions);
			
			setInstitution1s(instituteServiceImpl.select(3, currentPage,finaceParameter));
			
			//ActionContext.getContext().getSession().put("name", tutor.getUser().getName());
			
			pageCount=page.getPageCount();
			recordCount=page.getRecordCount();
			pageSize=page.getPageSize();
			currentPage=page.getCurrentPage();
			beginPageIndex=page.getBeginPageIndex();
			endPageIndex=page.getEndPageIndex();
			return "success";
		}
		
		public String market(){
			//查询侧面导航栏信息
			
			String finaceParameter="市场咨询";
			setInstitution2s(instituteServiceImpl.selectRec());
			setInstitutions(instituteServiceImpl.select(finaceParameter));
			page=new Page(3, currentPage, institutions.size(), institutions);
			
			setInstitution1s(instituteServiceImpl.select(3, currentPage,finaceParameter));
			
			//ActionContext.getContext().getSession().put("name", tutor.getUser().getName());
			
			pageCount=page.getPageCount();
			recordCount=page.getRecordCount();
			pageSize=page.getPageSize();
			currentPage=page.getCurrentPage();
			beginPageIndex=page.getBeginPageIndex();
			endPageIndex=page.getEndPageIndex();
			return "success";
		}
		public String finaceCounce(){
			//查询侧面导航栏信息
			
			String finaceParameter="财务咨询";
			setInstitution2s(instituteServiceImpl.selectRec());
			setInstitutions(instituteServiceImpl.select(finaceParameter));
			page=new Page(3, currentPage, institutions.size(), institutions);
			
			setInstitution1s(instituteServiceImpl.select(3, currentPage,finaceParameter));
			
			//ActionContext.getContext().getSession().put("name", tutor.getUser().getName());
			
			pageCount=page.getPageCount();
			recordCount=page.getRecordCount();
			pageSize=page.getPageSize();
			currentPage=page.getCurrentPage();
			beginPageIndex=page.getBeginPageIndex();
			endPageIndex=page.getEndPageIndex();
			return "success";
		}
		
		public String place(){
			//查询侧面导航栏信息
			
			String finaceParameter="场地租赁";
			setInstitution2s(instituteServiceImpl.selectRec());
			setInstitutions(instituteServiceImpl.select(finaceParameter));
			page=new Page(3, currentPage, institutions.size(), institutions);
			
			setInstitution1s(instituteServiceImpl.select(3, currentPage,finaceParameter));
			
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
