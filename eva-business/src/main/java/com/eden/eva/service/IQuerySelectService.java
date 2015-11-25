
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IQuerySelectDAO;
import com.eden.eva.model.QuerySelect;
public interface IQuerySelectService extends IBaseService<IQuerySelectDAO,QuerySelect>,IPageService<IQuerySelectDAO,QuerySelect>{

}