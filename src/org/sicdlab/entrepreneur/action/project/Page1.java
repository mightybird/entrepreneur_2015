package org.sicdlab.entrepreneur.action.project;

import java.util.List;

import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.Tutor;

public class Page1 {
	//指定页面参数
		private int pageSize;// 每一页显示多少条
		private int currentPage; // 当前页
		//查询数据库	
		private int recordCount; // 总记录数
		private List<Project> recordList; // 本页的数据列表
		//计算
		private int pageCount; // 总页数
		private int beginPageIndex; // 页码列表开始索引
		private int endPageIndex; // 页码列表结束索引
		/**
		 * 接收前四个的值 ，计算出后三个的值
		 * @param pageSize
		 * @param currentPage
		 * @param recordCount
		 * @param recordList
		 */
		
		public Page1(int pageSize,int currentPage,int recordCount,List<Project> recordList){
			this.pageSize=pageSize;
			this.currentPage=currentPage;
			this.recordCount=recordCount;
			this.recordList=recordList;
			
			//计算总页码
			pageCount = (recordCount + pageSize - 1) / pageSize;
			
			// 计算开始索引和结束索引
			//总页数不多于5页，则全部显示
			if(pageCount<=5){
				beginPageIndex = 1;
				endPageIndex =pageCount;
			}
			//总页数大于5页，则显示附近的5个页码
			else{
			//前4+当前页+后5
				beginPageIndex = currentPage-2;
				endPageIndex = currentPage +3;
				
				//当前页码不足4个，显示前5	
				if(beginPageIndex<1){
					beginPageIndex = 1;
					endPageIndex = 5;
				}
				//当前页码不足5个，显示后5	
				if(endPageIndex>pageCount){
					beginPageIndex = pageCount - 5 +1;
					endPageIndex = pageCount;
				}
			
			}
		}
		
		
		
		
		//*************************
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getRecordCount() {
			return recordCount;
		}
		public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}
		
		public List<Project> getRecordList() {
			return recordList;
		}
		public void setRecordList(List<Project> recordList) {
			this.recordList = recordList;
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
}
