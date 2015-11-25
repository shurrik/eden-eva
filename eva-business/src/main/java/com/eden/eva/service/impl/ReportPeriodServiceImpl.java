
package com.eden.eva.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.dao.IReportPeriodDAO;
import com.eden.eva.model.ReportPeriod;
import com.eden.eva.service.IReportPeriodService;

@SuppressWarnings("unchecked")
@Service("ReportPeriodServiceImpl")

public class ReportPeriodServiceImpl extends AbstractPageService<IReportPeriodDAO,ReportPeriod> implements IReportPeriodService {

	@Autowired
	private IReportPeriodDAO reportPeriodDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IReportPeriodDAO getDao() {
		return reportPeriodDAO;
	}
}
