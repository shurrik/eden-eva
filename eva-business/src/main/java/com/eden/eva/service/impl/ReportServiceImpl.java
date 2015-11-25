
package com.eden.eva.service.impl;
import com.eden.eva.dao.IReportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.Report;
import com.eden.eva.service.IReportService;

@SuppressWarnings("unchecked")
@Service("ReportServiceImpl")

public class ReportServiceImpl extends AbstractPageService<IReportDAO,Report> implements IReportService {

	@Autowired
	private IReportDAO reportDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IReportDAO getDao() {
		return reportDAO;
	}
}
