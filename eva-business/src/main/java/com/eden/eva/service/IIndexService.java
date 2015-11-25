
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IIndexDAO;
import com.eden.eva.model.Index;
public interface IIndexService extends IBaseService<IIndexDAO,Index>,IPageService<IIndexDAO,Index>{

}