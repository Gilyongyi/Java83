package mini.common;

import java.util.ArrayList;

public class Search {
	
	///Field
	private int curruntPage;
	private String searchCondition;
	private String searchKeyword;
	private int pageSize;
	private ArrayList<String> userId;
	private String order;
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	///Constructor
	public Search() {
	}
	
	///Method
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int paseSize) {
		this.pageSize = paseSize;
	}
	
	public int getCurrentPage() {
		return curruntPage;
	}
	public void setCurrentPage(int curruntPage) {
		this.curruntPage = curruntPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
 
	public ArrayList<String> getUserId() {
		return userId;
	}

	public void setUserId(ArrayList<String> userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Search [curruntPage=" + curruntPage + ", searchCondition="
				+ searchCondition + ", searchKeyword=" + searchKeyword
				+ ", pageSize=" + pageSize + "]";
	}
}