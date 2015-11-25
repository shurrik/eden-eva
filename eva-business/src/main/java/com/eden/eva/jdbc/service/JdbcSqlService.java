package com.eden.eva.jdbc.service;

import com.eden.eva.jdbc.JdbcTemplateFactory;
import com.eden.eva.model.Database;
import com.eden.eva.model.Tableinfo;
import com.eden.jdbc.platform.IDatabasePlatform;
import com.eden.jdbc.platform.JdbcDatabasePlatformFactory;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



/**
 * @author lp 创建于 2015年6月11日
 */
public class JdbcSqlService implements ISqlService {
	public static String COLUMN_IS_PK = "1";
	public static String COLUMN_NOT_PK = "0";
	private SingleConnectionDataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private Database database;

	public SingleConnectionDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(SingleConnectionDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	private JdbcSqlService(Database database) throws Exception {
		setDatabase(database);
		SingleConnectionDataSource ds = JdbcTemplateFactory
				.getDataSource(database);
		setDataSource(ds);
		IDatabasePlatform databasePlatform = JdbcDatabasePlatformFactory
				.createNewPlatformInstance(database.getDbType(), ds);
		JdbcTemplate jdbcTemplate = databasePlatform.getJdbcTemplate();
		setJdbcTemplate(jdbcTemplate);
	}

	public static JdbcSqlService newInstance(Database db) throws Exception {
		return new JdbcSqlService(db);
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql) throws Exception {
		List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
		getDataSource().destroy();
		return list;
	}

//	@Override
//	public Integer insertBulk(String tableName, List<Map> datas)
//			throws Exception {
//
//		for (Map data : datas) {
//			String[] columns = new String[data.keySet().size()];
//			Object[] values = new Object[data.keySet().size()];
//			columns = (String[]) data.keySet().toArray(columns);
//			int i = 0;
//			for (String column : columns) {
//				Object value = data.get(column);
//				values[i] = value;
//				i++;
//			}
//
//			try {
//				getJdbcTemplate().execute(
//						SqlBuilder.buildInsertSql(tableName, columns, values));
//			} catch (Exception e) {
//				//异常日志记录
//				System.out.println(e.toString());
//			}
//
//		}
//
//		getDataSource().destroy();
//		return datas.size();
//	}
//	@SuppressWarnings("null")
//	public Integer updateBulk(String prek,String tableName, List<Map> datas)
//			throws Exception {
//		
//		for (Map data : datas) {
//			String[] columns = new String[data.keySet().size()];
//			Object[] values = new Object[data.keySet().size()];
//			columns = (String[]) data.keySet().toArray(columns);
//			int i = 0;
//			String where="";
//			String[] col=null;
//			String[] val=null;
//			int m=0;
//			for (String column : columns) {
//				Object value = data.get(column);
//				if(prek.equals(column)){
//					where = " "+prek+"= '"+data.get(column)+"'";
//				}else{
////					col[m]= column.toString();
////					val[m]= data.get(column).toString();
//					values[i] = value;
//				}
//				m++;
//				i++;
//			}
////			System.out.println(SqlBuilder.buildUpdateSql(tableName, columns, values, where));
//			try {
//				getJdbcTemplate().execute(
//						SqlBuilder.buildUpdateSql(tableName, columns, values, where));
//			} catch (Exception e) {
//				//异常日志记录
//				System.out.println(e.toString());
//			}
//			
//		}
//		
//		getDataSource().destroy();
//		return datas.size();
//	}
	
	@SuppressWarnings("null")
//	public Integer updateBulk(String prek,String tableName, List<Map> datas)
//			throws Exception {
//
//		for (Map data : datas) {
//			String[] columns = new String[data.keySet().size()];
//			Object[] values = new Object[data.keySet().size()];
//			columns = (String[]) data.keySet().toArray(columns);
//			int i = 0;
////			String where="";
//			String[] col=null;
//			String[] val=null;
//			int m=0;
//			for (String column : columns) {
//				Object value = data.get(column);
//				values[i] = value;
////				if(prek.equals(column)){
////					where = " "+prek+"= '"+data.get(column)+"'";
////				}else{
//////					col[m]= column.toString();
//////					val[m]= data.get(column).toString();
////					values[i] = value;
////				}
//				m++;
//				i++;
//			}
//			String where = this.getWhere(prek,data);
//			System.out.println(SqlBuilder.buildUpdateSql(tableName, columns, values, where));
//			try {
//				getJdbcTemplate().execute(
//						SqlBuilder.buildUpdateSql(tableName, columns, values, where));
//			} catch (Exception e) {
//				//异常日志记录
//				System.out.println(e.toString());
//			}
//
//		}
//
//		getDataSource().destroy();
//		return datas.size();
//	}
	
	private String getWhere(String prek,Map data)
	{
		String where = " 1=1 ";
		if(StringUtils.isBlank(prek))
		{
			return "  1=2 ";
		}
		String[] pks = prek.split(",");
		for(String pk:pks)
		{
			where+=" AND "+pk+"='"+data.get(pk)+"'";
		}
		return where;
	}

	@Override
	public List<String> getTableNames() throws Exception {

		List<String> tableNames = new ArrayList();
		Connection conn = getDataSource().getConnection();
		String username_upper = getDatabase().getDbUser().toUpperCase();
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			String[] types = { "TABLE" };
//			ResultSet rs = dbmd.getTables(null, username_upper, "%", types);
			ResultSet rs = dbmd.getTables(null, null, null, types);
			while (rs.next()) {
				tableNames.add(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getDataSource().destroy();
		return tableNames;
	}

	@Override
	public Date getMaxDate(String tableName, String dateColumn)
			throws Exception {
		String sql = "SELECT MAX(" + dateColumn + ") FROM " + tableName;
		Date date = getJdbcTemplate().queryForObject(sql, Date.class);
		getDataSource().destroy();
		return date;
	}

	//  根据数据库表名查询字段属性
//	public List<Tableinfo> find_tableInfo(String tablename) throws Exception {
//		List<Tableinfo> datas = new ArrayList<Tableinfo>();
//		Connection conn = getDataSource().getConnection();
//		String prekeyname = null;
//		try {
//			ResultSet rs = conn.getMetaData().getPrimaryKeys(null, null,
//					tablename);
//			if (!rs.isAfterLast()) {
//				rs.next();
//				prekeyname = rs.getString("COLUMN_NAME");
//			}
//			DatabaseMetaData dbmd = conn.getMetaData();
//			ResultSet rst = dbmd.getColumns(null, "%", tablename, "%");
//			while (rst.next()) {
//				Tableinfo tbinfo = new Tableinfo();
//				tbinfo.setType(rst.getString("TYPE_NAME"));
//				tbinfo.setColumnname(rst.getString("COLUMN_NAME"));
//				tbinfo.setDatasize(rst.getInt("COLUMN_SIZE"));
//				tbinfo.setNullable(rst.getInt("NULLABLE"));
//				if (prekeyname.equals(rst.getString("COLUMN_NAME"))) {
//					tbinfo.setPk("1");
//				} else {
//					tbinfo.setPk("0");
//				}
//				datas.add(tbinfo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(datas);
//		return datas;
//	}
	
	public List<Tableinfo> find_tableInfo(String tablename) throws Exception {
		List<Tableinfo> datas = new ArrayList<Tableinfo>();
		Connection conn = getDataSource().getConnection();
		String prekeyname = null;
		try {
			
			Map pkMap = new HashMap();
			ResultSet rs = conn.getMetaData().getPrimaryKeys(null, null,
					tablename);
			while(rs.next())
			{
				pkMap.put(rs.getString("COLUMN_NAME"), rs.getString("COLUMN_NAME"));
			}
			
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet rst = dbmd.getColumns(null, "%", tablename, "%");
			while (rst.next()) {
				Tableinfo tbinfo = new Tableinfo();
				tbinfo.setType(rst.getString("TYPE_NAME"));
				tbinfo.setColumnname(rst.getString("COLUMN_NAME"));
				tbinfo.setDatasize(rst.getInt("COLUMN_SIZE"));
				tbinfo.setNullable(rst.getInt("NULLABLE"));
				String column = rst.getString("COLUMN_NAME");
				if(pkMap.get(column)!=null&&StringUtils.isNotBlank(pkMap.get(column).toString()))
				{
					tbinfo.setPk(COLUMN_IS_PK);
				}
				else
				{
					tbinfo.setPk(COLUMN_NOT_PK);
				}
				datas.add(tbinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(datas);
		return datas;
	}
	
	
	
	public List<Tableinfo> findPksByColumns(List<Tableinfo> columns)
	{
		List<Tableinfo> pks = new ArrayList();
		for(Tableinfo column:columns)
		{
			if(column.getPk().equals(COLUMN_IS_PK))
			{
				pks.add(column);
			}
		}
		return pks;
	}

	@Override
	public void insert(String sql) throws Exception {
		getJdbcTemplate().execute(sql);
		getDataSource().destroy();
	}

	@Override
	public List<Tableinfo> findPks(String tablename) throws Exception{
		return this.findPksByColumns(this.find_tableInfo(tablename));
	}
}
