
package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.model.QueryWhere;
import com.eden.eva.service.IQueryWhereService;
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
@Path("/querywhere")
public class QueryWhereRestAPI extends BaseRestAPI<IQueryWhereService>{

    @Autowired
    private IQueryWhereService queryWhereService;

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BizData4Page<QueryWhere> list(Map<String,Object> map){

        Map<String, Object> conditions = getQueryMap(map);
        PageParam pageParam = getPageParam(map);
        BizData4Page<QueryWhere> pageCtx = doPage(conditions, pageParam);
        return  pageCtx;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryWhere save(Map<String,Object> map){

        String editId = (String) map.get("editId");
        QueryWhere queryWhere = queryWhereService.fetch(editId);
        return queryWhere;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryWhere save(QueryWhere queryWhere){

        if(StringUtils.isBlank(queryWhere.getId()))
        {
            queryWhereService.add(queryWhere);
        }
        else
        {
            queryWhereService.update(queryWhere);
        }
        return queryWhere;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Map<String,Object> map){

        String editId = (String) map.get("editId");
        queryWhereService.deleteById(editId);
    }

    protected Map getQueryMap(Map<String,Object> map) {
        Map<String, Object> conditions = new HashMap();
		conditions.put("qryId", (String)map.get("qryId"));	
		conditions.put("tbName", (String)map.get("tbName"));	
		conditions.put("col", (String)map.get("col"));	
		conditions.put("formula", (String)map.get("formula"));	
		conditions.put("val", (String)map.get("val"));	
		conditions.put("colType", (String)map.get("colType"));	
		conditions.put("createrId", (String)map.get("createrId"));	
		conditions.put("createrName", (String)map.get("createrName"));	
		conditions.put("updaterId", (String)map.get("updaterId"));	
		conditions.put("updaterName", (String)map.get("updaterName"));	
		conditions.put("createDate", (String)map.get("createDate"));	
		conditions.put("updateDate", (String)map.get("updateDate"));	
        
        return conditions;
    }

    @Override
    protected IQueryWhereService getMainService() {
        return queryWhereService;
    }
}
