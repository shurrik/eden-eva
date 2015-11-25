package com.eden.eva.jdbc;

import com.eden.eva.jdbc.db.MysqlDataSourceManager;
import com.eden.eva.jdbc.db.OracleDataSourceManager;
import com.eden.eva.jdbc.db.MssqlDataSourceManager;
import com.eden.eva.model.Database;
import com.eden.jdbc.util.DataSourceConstants;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;



/**
 * @author lp 创建于 2015年6月11日
 */
public class JdbcTemplateFactory {
    
//    public static JdbcTemplate createJdbcTemplate(Database database) throws Exception
//    {
//    	SingleConnectionDataSource ds = getDataSource(database);
//    	
//        IDatabasePlatform mysqlDatabasePlatform = JdbcDatabasePlatformFactory.createNewPlatformInstance(DataSourceConstants.MYSQL, ds);
//        JdbcTemplate jdbcTemplate = mysqlDatabasePlatform.getJdbcTemplate();
//        return jdbcTemplate;
//    }
    
    public static SingleConnectionDataSource getDataSource(Database database) throws Exception
    {
    	if(database.getDbType().equals(DataSourceConstants.MSSQL))
    	{
    		return new MssqlDataSourceManager().newInstance(database);
    	}
    	else if(database.getDbType().equals(DataSourceConstants.ORACLE))
    	{
    		return new OracleDataSourceManager().newInstance(database);
    	}
    	else
    	{
    		return new MysqlDataSourceManager().newInstance(database);
    	}
    	
    }
}
