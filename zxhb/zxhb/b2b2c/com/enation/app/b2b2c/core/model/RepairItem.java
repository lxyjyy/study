package com.enation.app.b2b2c.core.model;

/**
 * @Description 保养项目
 *
 * @createTime 2016年8月26日 下午8:32:18
 *
 * @author <a href="mailto:wangqiang@trans-it.cn">wangqiang</a>
 */
public class RepairItem {
	private Integer id;
	private String itemname;//保养项目名称
	private Integer sort;//排序号
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@Override
	public String toString() {
		return "RepairItem [id=" + id + ", itemname=" + itemname + ", sort=" + sort + "]";
	}
}
