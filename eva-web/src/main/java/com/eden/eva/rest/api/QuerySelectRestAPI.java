
package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.model.QuerySelect;
import com.eden.eva.service.IQuerySelectService;
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
@Path("/queryselect")
public class QuerySelectRestAPI extends BaseRestAPI<IQuerySelectService>{

    @Autowired
    private IQuerySelectService querySelectService;

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BizData4Page<QuerySelect> list(Map<String,Object> map){

        Map<String, Object> conditions = getQueryMap(map);
        PageParam pageParam = getPageParam(map);
        BizData4Page<QuerySelect> pageCtx = doPage(conditions, pageParam);
        return  pageCtx;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QuerySelect save(Map<String,Object> map){

        String editId = (String) map.get("editId");
        QuerySelect querySelect = querySelectService.fetch(editId);
        return querySelect;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QuerySelect save(QuerySelect querySelect){

        if(StringUtils.isBlank(querySelect.getId()))
        {
            querySelectService.add(querySelect);
        }
        else
        {
            querySelectService.update(querySelect);
        }
        return querySelect;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Map<String,Object> map){

        String editId = (String) map.get("editId");
        querySelectService.deleteById(editId);
    }

    protected Map getQueryMap(Map<String,Object> map) {
        Map<String, Object> conditions = new HashMap();
		conditions.put("qryId", (String)map.get("qryId"));	
		conditions.put("tbName", (String)map.get("tbName"));	
		conditions.put("alias", (String)map.get("alias"));	
		conditions.put("col", (String)map.get("col"));	
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
    protected IQuerySelectService getMainService() {
        return querySelectService;
    }
}
