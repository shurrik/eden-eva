package com.eden.eva.jdbc.db;

import com.eden.eva.model.Database;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;



/**
 * @author lp 创建于 2015年6月11日
 */
public interface IDataSourceManager {

	public SingleConnectionDataSource newInstance(Database database) throws Exception;
}
