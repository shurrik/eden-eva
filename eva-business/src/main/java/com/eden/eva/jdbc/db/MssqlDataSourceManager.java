package com.eden.eva.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.eden.eva.model.Database;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;



/**
 * @author lp 创建于 2015年6月15日
 */
public class MssqlDataSourceManager implements IDataSourceManager{

	@Override
	public SingleConnectionDataSource newInstance(Database db)
			throws Exception {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://"+db.getDbServer()+":"+db.getDbPort()+";databasename="+db.getDbName();
	        String user= db.getDbUser();
	        String password = db.getDbPw();
	        Connection c = DriverManager.getConnection(url, user, password);
	        
	        return new SingleConnectionDataSource(c, true);
	}

}
