package cn.zhou.page;

import java.lang.reflect.Field;

public class DivisionPage {

	private Integer pageNo; // 页号,当前的页面页数****
	private Integer totalPages; // 总页数，根据总记录数和每页显示的数计算得出的
	private Integer total; // 数据库数据的总记录数 ******
	private Integer limit = 5; // 每页需要显示的数据的条数,默认每次查询数据条数限制在５条
	private Integer startIndex; // 每页数据的第一条索引

	private Integer previousPage; // 当前页的前一页
	private Integer nextPage; // 当前页的下一页

	private Class<Object> c;

	public DivisionPage() {
		super();

	}

	public DivisionPage(Integer pageNo, Integer total) {
		super();
		this.pageNo = pageNo;
		this.total = total;

		divide(pageNo, total);
	}

	public DivisionPage(Integer pageNo, Integer total, Integer limit) {
		super();
		this.pageNo = pageNo;
		this.total = total;
		this.limit = limit;

		divide(pageNo, total);
	}

	public DivisionPage(Integer pageNo, Integer totalPages, Integer total, Integer limit, Integer startIndex,
			Integer previousPage, Integer nextPage) {
		super();
		this.pageNo = pageNo;
		this.totalPages = totalPages;
		this.total = total;
		this.limit = limit;
		this.startIndex = startIndex;
		this.previousPage = previousPage;
		this.nextPage = nextPage;

		divide(pageNo, total);
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	// 处理分页数据
	public void divide(Integer pageNo, Integer total) {

		this.totalPages = (int) Math.ceil(total / this.limit); // 通过总记录数和限制数计算总页数

		if (pageNo == null || pageNo <= 1) {// 判断当前页码数的合法性
			pageNo = 1;
		}

		if (pageNo >= this.totalPages) {
			pageNo = this.totalPages;

		}
		this.startIndex = (pageNo - 1) * this.limit; // 通过当前页码和限制数计算每页第一条记录的索引
		this.pageNo = pageNo;

		System.out.println("*****************************totalPages=" + this.totalPages);

		Field[] fields = c.getFields();
		c.getMethods();
	}

	public Class<Object> getC() {
		return c;
	}

	public void setC(Class<Object> c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "DivisionPage [pageNo=" + pageNo + ", totalPages=" + totalPages + ", total=" + total + ", limit=" + limit
				+ ", startIndex=" + startIndex + ", previousPage=" + previousPage + ", nextPage=" + nextPage + "]";
	}

}
