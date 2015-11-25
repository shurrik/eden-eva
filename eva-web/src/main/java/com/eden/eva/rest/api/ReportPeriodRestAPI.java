
package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.model.ReportPeriod;
import com.eden.eva.service.IReportPeriodService;
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
@Path("/reportperiod")
public class ReportPeriodRestAPI extends BaseRestAPI<IReportPeriodService>{

    @Autowired
    private IReportPeriodService reportPeriodService;

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BizData4Page<ReportPeriod> list(Map<String,Object> map){

        Map<String, Object> conditions = getQueryMap(map);
        PageParam pageParam = getPageParam(map);
        BizData4Page<ReportPeriod> pageCtx = doPage(conditions, pageParam);
        return  pageCtx;
    }

    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReportPeriod save(Map<String,Object> map){

        String editId = (String) map.get("editId");
        ReportPeriod reportPeriod = reportPeriodService.fetch(editId);
        return reportPeriod;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReportPeriod save(ReportPeriod reportPeriod){

        if(StringUtils.isBlank(reportPeriod.getId()))
        {
            reportPeriodService.add(reportPeriod);
        }
        else
        {
            reportPeriodService.update(reportPeriod);
        }
        return reportPeriod;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Map<String,Object> map){

        String editId = (String) map.get("editId");
        reportPeriodService.deleteById(editId);
    }

    protected Map getQueryMap(Map<String,Object> map) {
        Map<String, Object> conditions = new HashMap();
		conditions.put("repId", (String)map.get("repId"));	
		conditions.put("year", (String)map.get("year"));	
		conditions.put("month", (String)map.get("month"));	
		conditions.put("startDate", (String)map.get("startDate"));	
		conditions.put("endDate", (String)map.get("endDate"));	
		conditions.put("createDate", (String)map.get("createDate"));	
		conditions.put("updateDate", (String)map.get("updateDate"));	
        
        return conditions;
    }

    @Override
    protected IReportPeriodService getMainService() {
        return reportPeriodService;
    }
}
