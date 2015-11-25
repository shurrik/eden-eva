package com.eden.eva.facade;

import java.util.Date;

/**
 * Created by shurrik on 2015/9/2.
 */
public interface IIndexFacade {

    public String createIndexSql(String queryId,Date startDate,Date endDate);

    public String createIndexSqlPreview(String queryId);
}

