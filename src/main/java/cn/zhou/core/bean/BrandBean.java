package cn.zhou.core.bean;

import cn.zhou.common.ImgServerUrl;

public class BrandBean {

	private Integer id; // 品牌id
	private String name; // 品牌名称
	private String description; // 品牌描述
	private String imageUrl; // 图片地址
	private String webSite;// 网页地址
	private Integer sort; // 排序
	private Integer isDisplay; // 是否显示，０否，１是

	// 用于显示的图片的地址
	private String picUrl;

	public BrandBean() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return ImgServerUrl.URL + getImageUrl(); // picUrl
	}

	/*
	 * *****************************************************************************
	 * ************************* 分页数据******************************************
	 * *****************************************************************************
	 */

	private Integer pageCode;// 当前页的页码***************
	private Integer totalRecord; // 总记录数**************
	private Integer pageSize = 5;// 页面显示记录数**
	private Integer totalPages; // 总页数,不由外部设置，根据总记录数和每页显示记录数计算得出
	private Integer startIndex; // 每页第一条数据的索引

	public void setPageCode(Integer pageCode) {

		if (pageCode == null || pageCode <= 0) {
			this.pageCode = 1;
		} else
			this.pageCode = pageCode;
	}

	public Integer getPageCode() {
		return pageCode;
	}

	// 总记录数
	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

//	public void setTotalPages(Integer totalPages) {
//		this.totalPages = totalPages;
//	}
	// 总页数,由内部计算出来的，不能外部设置
	public Integer getTotalPages() {// totalPages

		System.out.println("getTotalRecord()= " + totalRecord);
		System.out.println(" getPageSize()= " + getPageSize());

		// return totalRecord / pageSize == 0 ? totalRecord / pageSize : totalRecord /
		// pageSize + 1; // totalPages
		return getTotalRecord() / getPageSize() == 0 ? getTotalRecord() / getPageSize()
				: getTotalRecord() / getPageSize() + 1;
	}

	// 页面显示尺寸
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		// this.totalPages = totalRecord / pageSize == 0 ? totalRecord / pageSize :
		// totalRecord / pageSize + 1;
		this.pageSize = pageSize;
	}

//	// 每页起始数据索引也是内部计算得出的
//	public void setStartIndex(Integer startIndex) {
//		this.startIndex = startIndex;
//	}
//
//	public Integer getStartIndex() {
//		return (getPageCode() - 1) * getPageSize();
//	}

//	public void setPageSize(Integer pageSize) {
//		this.pageSize = pageSize;
//	}

	/**
	 * 
	 * @return Integer
	 */
	public Integer getStartIndex() {
		return (this.pageCode - 1) * this.pageSize;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	@Override
	public String toString() {
		return "BrandBean [id=" + id + ", name=" + name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", webSite=" + webSite + ", sort=" + sort + ", isDisplay=" + isDisplay + ", pageSize=" + pageSize
				+ ", startIndex=" + startIndex + ", picUrl=" + picUrl + "]";
	}

}
