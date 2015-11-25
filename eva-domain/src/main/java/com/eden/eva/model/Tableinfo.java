package com.eden.eva.model;

public class Tableinfo {
	/**
	 * 是否为空
	 * 1  null  0 not null
	 */
	private int nullable;//
	/**
	 * 字段类型
	 */
	private String type;
	/**
	 * 字段名称
	 */
	private String columnname;
	/**
	 * 字段长度
	 */
	private int datasize;
	/**
	 * 主键
	 * 1代表主键0不是主键
	 */
	private String pk;
	/**
	 * 字段注释
	 * @return
	 */
	private String colcomment;
	
	public int getNullable() {
		return nullable;
	}
	public void setNullable(int nullable) {
		this.nullable = nullable;
	}
	public int getDatasize() {
		return datasize;
	}
	public void setDatasize(int datasize) {
		this.datasize = datasize;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColumnname() {
		return columnname;
	}
	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getColcomment() {
		return colcomment;
	}
	public void setColcomment(String colcomment) {
		this.colcomment = colcomment;
	}
	
}
