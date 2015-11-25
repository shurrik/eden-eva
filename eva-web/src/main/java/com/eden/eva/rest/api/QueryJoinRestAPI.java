
package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.model.QueryJoin;
import com.eden.eva.service.IQueryJoinService;
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
@Path("/queryjoin")
public class QueryJoinRestAPI extends BaseRestAPI<IQueryJoinService>{

    @Autowired
    private IQueryJoinService queryJoinService;

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BizData4Page<QueryJoin> list(Map<String,Object> map){

        Map<String, Object> conditions = getQueryMap(map);
        PageParam pageParam = getPageParam(map);
        BizData4Page<QueryJoin> pageCtx = doPage(conditions, pageParam);
        return  pageCtx;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryJoin save(Map<String,Object> map){

        String editId = (String) map.get("editId");
        QueryJoin queryJoin = queryJoinService.fetch(editId);
        return queryJoin;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QueryJoin save(QueryJoin queryJoin){

        if(StringUtils.isBlank(queryJoin.getId()))
        {
            queryJoinService.add(queryJoin);
        }
        else
        {
            queryJoinService.update(queryJoin);
        }
        return queryJoin;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Map<String,Object> map){

        String editId = (String) map.get("editId");
        queryJoinService.deleteById(editId);
    }

    protected Map getQueryMap(Map<String,Object> map) {
        Map<String, Object> conditions = new HashMap();
		conditions.put("qryId", (String)map.get("qryId"));	
		conditions.put("tbNameL", (String)map.get("tbNameL"));	
		conditions.put("colL", (String)map.get("colL"));	
		conditions.put("tbNameR", (String)map.get("tbNameR"));	
		conditions.put("colR", (String)map.get("colR"));	
		conditions.put("createrId", (String)map.get("createrId"));	
		conditions.put("createrName", (String)map.get("createrName"));	
		conditions.put("updaterId", (String)map.get("updaterId"));	
		conditions.put("updaterName", (String)map.get("updaterName"));	
		conditions.put("createDate", (String)map.get("createDate"));	
		conditions.put("updateDate", (String)map.get("updateDate"));	
        
        return conditions;
    }

    @Override
    protected IQueryJoinService getMainService() {
        return queryJoinService;
    }
}
