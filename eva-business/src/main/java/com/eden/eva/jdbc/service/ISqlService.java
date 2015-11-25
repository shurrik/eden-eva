package com.eden.eva.jdbc.service;

import com.eden.eva.model.Tableinfo;

import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * @author lp 创建于 2015年6月11日
 */
public interface ISqlService {

	public List<Map<String, Object>> queryForList(String sql) throws Exception;

//	public Integer insertBulk(String tableName, List<Map> datas)
//			throws Exception;
	public void insert(String sql) throws Exception;

	public List<String> getTableNames() throws Exception;

	public Date getMaxDate(String tableName, String dateColumn)
			throws Exception;

	public List<Tableinfo> find_tableInfo(String tablename) throws Exception;
	
	public List<Tableinfo> findPksByColumns(List<Tableinfo> columns);
	public List<Tableinfo> findPks(String tablename) throws Exception;
}
