
package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.model.QueryTable;
import com.eden.eva.service.IQueryTableService;
import com.eden.eva.util.PageParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shurrik on 2015/9/21.
 */
@Path("/querytable")
public class QueryTableRestAPI extends BaseRestAPI<IQueryTableService>{

    @Autowired
    private IQueryTableService queryTableService;

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BizData4Page<QueryTable> list(Map<String,Object> map){

        Map<String, Object> conditions = getQueryMap(map);
        PageParam pageParam = getPageParam(map);
        BizData4Page<QueryTable> pageCtx = doPage(conditions, pageParam);
        return  pageCtx;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryTable save(Map<String,Object> map){

        String editId = (String) map.get("editId");
        QueryTable queryTable = queryTableService.fetch(editId);
        return queryTable;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryTable save(QueryTable queryTable){

        if(StringUtils.isBlank(queryTable.getId()))
        {
            queryTableService.add(queryTable);
        }
        else
        {
            queryTableService.update(queryTable);
        }
        return queryTable;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Map<String,Object> map){

        String editId = (String) map.get("editId");
        queryTableService.deleteById(editId);
    }

    protected Map getQueryMap(Map<String,Object> map) {
        Map<String, Object> conditions = new HashMap();
		conditions.put("qryId", (String)map.get("qryId"));	
		conditions.put("tbName", (String)map.get("tbName"));	
		conditions.put("alias", (String)map.get("alias"));	
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
    protected IQueryTableService getMainService() {
        return queryTableService;
    }
}
