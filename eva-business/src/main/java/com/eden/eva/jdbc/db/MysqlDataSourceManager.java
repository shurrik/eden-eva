package com.eden.eva.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.eden.eva.model.Database;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;



/**
 * @author lp 创建于 2015年6月11日
 */
public class MysqlDataSourceManager implements IDataSourceManager{

	@Override
	public SingleConnectionDataSource newInstance(Database db) throws Exception {
		// TODO Auto-generated method stub
		
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://"+db.getDbServer()+":"+db.getDbPort()+"/"+db.getDbName()+"?useUnicode=true&characterEncoding=UTF-8";
        String user= db.getDbUser();
        String password = db.getDbPw();
        Connection c = DriverManager.getConnection(url, user, password);
        
        return new SingleConnectionDataSource(c, true);
	}

}
