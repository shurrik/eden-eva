
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IQueryWhereDAO;
import com.eden.eva.model.QueryWhere;
public interface IQueryWhereService extends IBaseService<IQueryWhereDAO,QueryWhere>,IPageService<IQueryWhereDAO,QueryWhere>{

}