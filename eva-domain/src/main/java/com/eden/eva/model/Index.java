package com.eden.eva.model;
import com.eden.common.domain.BaseDomain;

import java.util.Date;

public class Index extends BaseDomain{
	private String qryId; //queryID
	private String indexX; //维度列
	private String indexY; //指标列
	private String func; //函数
	private String createrId; //创建人ID
	private String createrName; //创建人名
	private String updaterId; //更新人ID
	private String updaterName; //更新人名
	private Date createDate; //创建时间
	private Date updateDate; //更新时间

	public String getQryId() {
		return qryId;
	}
	public void setQryId(String qryId) {
		this.qryId = qryId;
	}
	public String getIndexX() {
		return indexX;
	}
	public void setIndexX(String indexX) {
		this.indexX = indexX;
	}
	public String getIndexY() {
		return indexY;
	}
	public void setIndexY(String indexY) {
		this.indexY = indexY;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getUpdaterId() {
		return updaterId;
	}
	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}
	public String getUpdaterName() {
		return updaterName;
	}
	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
