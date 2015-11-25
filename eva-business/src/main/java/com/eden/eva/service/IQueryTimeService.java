
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IQueryTimeDAO;
import com.eden.eva.model.QueryTime;
public interface IQueryTimeService extends IBaseService<IQueryTimeDAO,QueryTime>,IPageService<IQueryTimeDAO,QueryTime>{

}