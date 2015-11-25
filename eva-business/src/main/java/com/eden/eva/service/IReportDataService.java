
package com.eden.eva.service;
import com.eden.common.service.IBaseService;
import com.eden.common.service.IPageService;
import com.eden.eva.dao.IReportDataDAO;
import com.eden.eva.model.ReportData;
public interface IReportDataService extends IBaseService<IReportDataDAO,ReportData>,IPageService<IReportDataDAO,ReportData>{

}