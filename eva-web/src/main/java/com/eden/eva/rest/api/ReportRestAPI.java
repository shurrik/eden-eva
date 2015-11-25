package com.eden.eva.rest.api;

import com.eden.common.domain.view.BizData4Page;
import com.eden.eva.model.*;
import com.eden.eva.service.*;
import com.eden.eva.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by shurrik on 2015/8/28.
 */
@Path("/report")
public class ReportRestAPI extends BaseRestAPI<IReportService>{

    @Autowired
    private IReportService reportService;
    @Autowired
    private IQueryService queryService;
    @Autowired
    private IQuerySelectService querySelectService;
    @Autowired
    private IQueryTableService queryTableService;
    @Autowired
    private IQueryJoinService queryJoinService;
    @Autowired
    private IQueryTimeService queryTimeService;
    @Autowired
    private IQueryWhereService queryWhereService;
    @Autowired
    private IIndexService indexService;

    @POST
    @Path("/getall")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getALL(){
        List<Report> list = reportService.findAll();
        return  list;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Report create(Map<String,Object> map){

        String reportName = (String) map.get("reportName");
        String reportRemark = (String) map.get("reportRemark");
        Report report = new Report();
        report.setName(reportName);
        report.setRemark(reportRemark);
        report = reportService.add(report);

        //query
        String database = (String) map.get("database");
        Query query = new Query();
        query.setRepId(report.getId());
        query.setDbId(database);
        query = queryService.add(query);

        //querytable
        List<String> table = (List<String>) map.get("table");
        for(String tbName:table)
        {
            QueryTable queryTable = new QueryTable();
            queryTable.setQryId(query.getId());
            queryTable.setTbName(tbName);
            queryTableService.add(queryTable);
        }
        //queryselect
        String indexX = (String) map.get("indexX");
        String indexY = (String) map.get("indexY");
        String tableX = (String) map.get("tableX");
        String tableY = (String) map.get("tableY");
        QuerySelect selectX = new QuerySelect();
        QuerySelect selectY = new QuerySelect();
        selectX.setQryId(query.getId());
        selectX.setTbName(tableX);
        selectX.setCol(indexX);

        selectY.setQryId(query.getId());
        selectY.setTbName(tableY);
        selectY.setCol(indexY);
        querySelectService.add(selectX);
        querySelectService.add(selectY);


        //queryjoin
        if(map.get("joins")!=null)
        {
            List<Map> joins = (List<Map>) map.get("joins");
            for(Map j:joins)
            {
                QueryJoin join = new QueryJoin();
                join.setQryId(query.getId());
                join.setTbNameL((String) j.get("tbNameL"));
                join.setTbNameR((String) j.get("tbNameR"));
                join.setColL((String) j.get("colL"));
                join.setColR((String) j.get("colR"));
                queryJoinService.add(join);

            }
        }

        //querytime
        QueryTime queryTime = new QueryTime();
        queryTime.setQryId(query.getId());
        queryTime.setTbName((String) map.get("timeTable"));
        queryTime.setCol((String) map.get("timeCol"));
        queryTimeService.add(queryTime);

        //querywhere

        //index
        Index index = new Index();
        index.setQryId(query.getId());
        index.setIndexX((String) map.get("indexX"));
        index.setIndexY((String) map.get("indexY"));
        index.setFunc((String) map.get("func"));
        indexService.add(index);

        return  report;
    }

    @Override
    protected IReportService getMainService() {
        return reportService;
    }
}
