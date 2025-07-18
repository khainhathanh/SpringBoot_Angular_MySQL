package perfume.entity;

import java.util.List;

public class PagePerfume<T> {
	private int currentPage;
	private int totalPage;
	private List<T> listItem;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getListItem() {
		return listItem;
	}
	public void setListItem(List<T> listItem) {
		this.listItem = listItem;
	}
	
}
