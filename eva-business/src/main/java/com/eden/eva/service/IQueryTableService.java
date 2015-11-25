
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IQueryTableDAO;
import com.eden.eva.model.QueryTable;
public interface IQueryTableService extends IBaseService<IQueryTableDAO,QueryTable>,IPageService<IQueryTableDAO,QueryTable>{

}