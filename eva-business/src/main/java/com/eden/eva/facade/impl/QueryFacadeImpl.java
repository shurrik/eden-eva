package com.eden.eva.facade.impl;

import com.eden.eva.model.QueryJoin;
import com.eden.eva.model.QuerySelect;
import com.eden.eva.model.QueryTable;
import com.eden.eva.model.QueryWhere;
import com.eden.eva.service.*;
import com.eden.eva.facade.IQueryFacade;
import com.eden.eva.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shurrik on 2015/9/2.
 */
@SuppressWarnings("unchecked")
@Service("QueryFacadeImpl")
public class QueryFacadeImpl implements IQueryFacade{

    private static final int LIMIT = 1000;
    @Autowired
    private IQueryService queryService;
    @Autowired
    private IQueryTableService queryTableService;
    @Autowired
    private IQuerySelectService querySelectService;
    @Autowired
    private IQueryJoinService queryJoinService;
    @Autowired
    private IQueryWhereService queryWhereService;

    @Override
    public String createSql(String qryId,Date startDate,Date endDate,boolean preview) {

        List<QuerySelect> selects = querySelectService.findList("qryId",qryId);
        List<QueryTable> tables = queryTableService.findList("qryId",qryId);
        List<QueryJoin> joins = queryJoinService.findList("qryId",qryId);
        List<QueryWhere> wheres = queryWhereService.findList("qryId",qryId);
        String selectSql = this.createSelect(selects);
        String tableSql = this.createTable(tables);
        String joinSql = this.createJoin(joins);
        String whereSql = this.createWhere(wheres);

        String sql = selectSql + tableSql + joinSql + whereSql;
        if(preview)
        {
            sql+=this.createPreviewLimit();
        }
        else
        {
            sql+=this.createPreviewLimit();
        }
        return sql;
    }

    private String createSelect(List<QuerySelect> selects)
    {
//        SELECT
//        t_sys_user.`user_name`,
//        t_sys_dept.`name`
        StringBuffer sb  = new StringBuffer();
        sb.append(" SELECT ");
        for(QuerySelect select:selects)
        {
            sb.append(select.getTbName()+"."+select.getCol()+",");
        }

        String sql = sb.toString();
        sql = sql.substring(0,sql.length()-1);
        return sql;
    }

    private String createTable(List<QueryTable> tables)
    {
//        FROM
//        `matrix`.`t_sys_user` t_sys_user
//        LEFT JOIN `matrix`.`t_sys_dept` t_sys_dept
        StringBuffer sb  = new StringBuffer();
        sb.append(" FROM ");
        int i = 0;
        for(QueryTable table:tables)
        {
           if(i==0)
           {
               sb.append(table.getTbName()+" "+table.getTbName());
           }
            else
           {
               sb.append(" LEFT JOIN "+table.getTbName()+" "+table.getTbName());
           }
            i++;
        }

        String sql = sb.toString();
//        sql = sql.substring(0,sql.length()-1);
        return sql;
    }

    private String createJoin(List<QueryJoin> joins)
    {
//        ON t_sys_user.`dep_id` = t_sys_dept.`id`
        StringBuffer sb  = new StringBuffer();

        for(QueryJoin join:joins)
        {
            sb.append(" ON "+join.getTbNameL()+"."+join.getColL()+" = "+join.getTbNameR()+"."+join.getColR());
        }

        String sql = sb.toString();
        return sql;
    }

    private String createWhere(List<QueryWhere> wheres)
    {
        StringBuffer sb  = new StringBuffer();
        sb.append(" WHERE 1=1 ");
        String sql =sb.toString();
        return sql;
    }

    private String createPreviewLimit()
    {
        StringBuffer sb  = new StringBuffer();
        sb.append(" limit 0,"+LIMIT+" ");
        String sql =sb.toString();
        return sql;
    }
}
