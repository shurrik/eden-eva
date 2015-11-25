
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IReportDAO;
import com.eden.eva.model.Report;
public interface IReportService extends IBaseService<IReportDAO,Report>,IPageService<IReportDAO,Report>{

}