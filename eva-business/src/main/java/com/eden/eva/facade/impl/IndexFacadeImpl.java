package com.eden.eva.facade.impl;

import com.eden.eva.facade.IIndexFacade;
import com.eden.eva.facade.IQueryFacade;
import com.eden.eva.model.Index;
import com.eden.eva.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by shurrik on 2015/9/2.
 */
@SuppressWarnings("unchecked")
@Service("IndexFacadeImpl")
public class IndexFacadeImpl implements IIndexFacade {
    @Autowired
    private IQueryFacade queryFacade;
    @Autowired
    private IIndexService indexService;

    @Override
    public String createIndexSql(String qryId,Date startDate,Date endDate) {
        Index index = indexService.findOne("qryId", qryId);
//        String querySql = queryFacade.createSql(qryId);

        String selectSql = this.createSelect(index);
        String fromSql = this.createFrom(index,startDate,endDate,false);
        String groupSql = this.createGroup(index);

        String sql = selectSql+fromSql+groupSql;

        return sql;
    }

    @Override
    public String createIndexSqlPreview(String qryId) {
        Index index = indexService.findOne("qryId", qryId);
//        String querySql = queryFacade.createSql(qryId);

        String selectSql = this.createSelect(index);
        String fromSql = this.createFrom(index,null,null,true);
        String groupSql = this.createGroup(index);

        String sql = selectSql+fromSql+groupSql;

        return sql;
    }

    private String  createSelect(Index index)
    {
//        SELECT
//        datatable.name repKey,
//        COUNT(datatable.user_name) repVal
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT datatable."+index.getIndexX()+" repKey,");
        sb.append(index.getFunc()+"(datatable."+index.getIndexY()+") repVal");
        String sql = sb.toString();
        return sql;
    }

    private String createFrom(Index index,Date startDate,Date endDate,boolean preview)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(" FROM ( "+queryFacade.createSql(index.getQryId(),startDate,endDate,preview)+" ) datatable");
        String sql = sb.toString();
        return sql;
    }

    private String createGroup(Index index)
    {
//        GROUP BY datatable.name
        StringBuffer sb = new StringBuffer();
        sb.append(" GROUP BY datatable."+index.getIndexX());
        String sql = sb.toString();
        return sql;
    }
}
