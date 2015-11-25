
package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.jdbc.service.JdbcSqlService;
import com.eden.eva.model.Database;
import com.eden.eva.model.Tableinfo;
import com.eden.eva.service.IDatabaseService;
import com.eden.eva.util.PageParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shurrik on 2015/9/21.
 */
@Path("/database")
public class DatabaseRestAPI extends BaseRestAPI<IDatabaseService>{

    @Autowired
    private IDatabaseService databaseService;

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BizData4Page<Database> list(Map<String,Object> map){

        Map<String, Object> conditions = getQueryMap(map);
        PageParam pageParam = getPageParam(map);
        BizData4Page<Database> pageCtx = doPage(conditions, pageParam);
        return  pageCtx;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Database save(Map<String,Object> map){

        String editId = (String) map.get("editId");
        Database database = databaseService.fetch(editId);
        return database;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Database save(Database database){

        if(StringUtils.isBlank(database.getId()))
        {
            databaseService.add(database);
        }
        else
        {
            databaseService.update(database);
        }
        return database;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Map<String,Object> map){

        String editId = (String) map.get("editId");
        databaseService.deleteById(editId);
    }

    @POST
    @Path("/findall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Database> findall(Map<String,Object> map){
        return  databaseService.findAll();
    }

    @POST
    @Path("/gettables")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getTables(Map<String,Object> map) throws Exception {
        String dbId = (String) map.get("dbId");
        Database db = databaseService.fetch(dbId);
        JdbcSqlService jdbcSqlService = JdbcSqlService.newInstance(db);
        List<String> tableNames = jdbcSqlService.getTableNames();
        return tableNames;
    }

    @POST
    @Path("/getcols")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tableinfo> getCols(Map<String,Object> map) throws Exception {
        String dbId = (String) map.get("dbId");
        String tbName = (String) map.get("tbName");
        Database db = databaseService.fetch(dbId);
        JdbcSqlService jdbcSqlService = JdbcSqlService.newInstance(db);
        List<Tableinfo> cols = jdbcSqlService.find_tableInfo(tbName);
        return cols;
    }

    protected Map getQueryMap(Map<String,Object> map) {
        Map<String, Object> conditions = new HashMap();
		conditions.put("dbServer", (String)map.get("dbServer"));	
		conditions.put("dbPort", (String)map.get("dbPort"));	
		conditions.put("dbType", (String)map.get("dbType"));	
		conditions.put("dbVersion", (String)map.get("dbVersion"));	
		conditions.put("dbName", (String)map.get("dbName"));	
		conditions.put("tableSpace", (String)map.get("tableSpace"));	
		conditions.put("dbUser", (String)map.get("dbUser"));	
		conditions.put("dbPw", (String)map.get("dbPw"));	
		conditions.put("remark", (String)map.get("remark"));	
		conditions.put("createrId", (String)map.get("createrId"));	
		conditions.put("createrName", (String)map.get("createrName"));	
		conditions.put("updaterId", (String)map.get("updaterId"));	
		conditions.put("updaterName", (String)map.get("updaterName"));	
		conditions.put("createDate", (String)map.get("createDate"));	
		conditions.put("updateDate", (String)map.get("updateDate"));	
        
        return conditions;
    }

    @Override
    protected IDatabaseService getMainService() {
        return databaseService;
    }
}
