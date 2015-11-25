
package com.eden.eva.service.impl;
import com.eden.eva.dao.IQueryTimeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.QueryTime;
import com.eden.eva.service.IQueryTimeService;

@SuppressWarnings("unchecked")
@Service("QueryTimeServiceImpl")

public class QueryTimeServiceImpl extends AbstractPageService<IQueryTimeDAO,QueryTime> implements IQueryTimeService {

	@Autowired
	private IQueryTimeDAO queryTimeDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IQueryTimeDAO getDao() {
		return queryTimeDAO;
	}
}
