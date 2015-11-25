package com.eden.eva.model;
import com.eden.common.domain.BaseDomain;

import java.math.BigDecimal;
import java.util.Date;

public class ReportData extends BaseDomain{
	private String repId; //报表Id
	private String periodId; //报表周期Id
	private String repKey; //键
	private BigDecimal repVal; //值
	private Date createDate; //创建时间

	public String getRepId() {
		return repId;
	}
	public void setRepId(String repId) {
		this.repId = repId;
	}
	public String getPeriodId() {
		return periodId;
	}
	public void setPeriodId(String periodId) {
		this.periodId = periodId;
	}
	public String getRepKey() {
		return repKey;
	}
	public void setRepKey(String repKey) {
		this.repKey = repKey;
	}
	public BigDecimal getRepVal() {
		return repVal;
	}
	public void setRepVal(BigDecimal repVal) {
		this.repVal = repVal;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
