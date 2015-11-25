package com.eden.eva.model;
import com.eden.common.domain.BaseDomain;

import java.util.Date;

public class QueryJoin extends BaseDomain{
	private String qryId; //queryID
	private String tbNameL; //表名A
	private String colL; //列A
	private String tbNameR; //表名B
	private String colR; //列B
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
	public String getTbNameL() {
		return tbNameL;
	}
	public void setTbNameL(String tbNameL) {
		this.tbNameL = tbNameL;
	}
	public String getColL() {
		return colL;
	}
	public void setColL(String colL) {
		this.colL = colL;
	}
	public String getTbNameR() {
		return tbNameR;
	}
	public void setTbNameR(String tbNameR) {
		this.tbNameR = tbNameR;
	}
	public String getColR() {
		return colR;
	}
	public void setColR(String colR) {
		this.colR = colR;
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
