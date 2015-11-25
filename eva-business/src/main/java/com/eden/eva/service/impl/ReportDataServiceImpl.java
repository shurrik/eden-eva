
package com.eden.eva.service.impl;
import com.eden.eva.dao.IReportDataDAO;
import com.eden.eva.service.IReportDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.ReportData;

@SuppressWarnings("unchecked")
@Service("ReportDataServiceImpl")

public class ReportDataServiceImpl extends AbstractPageService<IReportDataDAO,ReportData> implements IReportDataService {

	@Autowired
	private IReportDataDAO reportDataDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IReportDataDAO getDao() {
		return reportDataDAO;
	}
}
