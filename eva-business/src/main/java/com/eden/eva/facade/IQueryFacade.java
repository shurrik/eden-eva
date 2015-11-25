package com.eden.eva.facade;

import java.util.Date;

/**
 * Created by shurrik on 2015/9/2.
 */
public interface IQueryFacade {

    String createSql(String queryId,Date startDate,Date endDate,boolean preview);
}
