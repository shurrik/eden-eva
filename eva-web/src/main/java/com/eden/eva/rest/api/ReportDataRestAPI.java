package com.eden.eva.rest.api;

import com.eden.eva.facade.IReportDataFacade;
import com.eden.eva.model.*;
import com.eden.eva.facade.IIndexFacade;
import com.eden.eva.jdbc.service.JdbcSqlService;
import com.eden.eva.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by shurrik on 2015/8/27.
 */
@Path("/reportdata")
public class ReportDataRestAPI extends BaseRestAPI<IReportDataService>{

    @Autowired
    private IReportDataService reportDataService;
	@Autowired
	private IReportPeriodService reportPeriodService;
	@Autowired
	private IIndexFacade indexFacade;
	@Autowired
	private IDatabaseService databaseService;
	@Autowired
	private IQueryService queryService;
	@Autowired
	private IReportDataFacade reportDataFacade;


	@POST
	@Path("/getbyperoid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportData> getByPeroid(Map<String,Object> map){

		ReportPeriod reportPeriod = null;
		if(map.get("year")!=null&& map.get("month")!=null)
		{
			reportPeriod = reportPeriodService.queryOne(map);
		}

		List<ReportData> list = null;
		if(reportPeriod!=null)
		{
			list = reportDataService.findList("periodId",reportPeriod.getId());
		}

		return  list;
	}

	@POST
	@Path("/preview")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<String, Object>> preview(Map<String,Object> param) throws Exception {

		String repId = (String) param.get("repId");

		reportDataFacade.addByLastMonth(repId);

		Query query = queryService.findOne("repId", repId);
		Database db = databaseService.fetch(query.getDbId());
		JdbcSqlService sqlService = JdbcSqlService.newInstance(db);
		String sql = indexFacade.createIndexSqlPreview(query.getId());
		List<Map<String, Object>> list  = sqlService.queryForList(sql);


		return  list;
	}

	@Override
	protected IReportDataService getMainService() {
		return reportDataService;
	}
}
