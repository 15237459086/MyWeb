package com.lyh.cust.pojo;

/**
 * 
 * 自定义分页
 * @author lyh
 *
 */
public class Page {

	private Integer totalItemCount = 0; //总条数
	
	private Integer totalPageCount = 0;//总页数
	
	private Integer pageSize=1; //每页条数
	
	private Integer currentPage=1; //当前页
	
	private Integer currentStartNum=0; //当前

	public Integer getCurrentStartNum() {
		currentStartNum = (currentPage.intValue()-1)*pageSize.intValue();
		return currentStartNum;
	}


	

	public Integer getTotalItemCount() {
		return totalItemCount;
	}




	public void setTotalItemCount(Integer totalItemCount) {
		this.totalItemCount = totalItemCount;
	}




	public Integer getTotalPageCount() {
		totalPageCount = totalItemCount.intValue()%pageSize.intValue()==0?totalItemCount.intValue()/pageSize.intValue():(totalItemCount.intValue()/pageSize.intValue())+1;
		return  totalPageCount;
	}


	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
