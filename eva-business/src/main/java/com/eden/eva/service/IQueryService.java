
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IQueryDAO;
import com.eden.eva.model.Query;
public interface IQueryService extends IBaseService<IQueryDAO,Query>,IPageService<IQueryDAO,Query>{

}