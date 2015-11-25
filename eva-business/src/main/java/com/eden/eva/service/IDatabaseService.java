
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IDatabaseDAO;
import com.eden.eva.model.Database;
public interface IDatabaseService extends IBaseService<IDatabaseDAO,Database>,IPageService<IDatabaseDAO,Database>{

}