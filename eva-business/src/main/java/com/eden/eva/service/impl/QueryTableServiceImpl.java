
package com.eden.eva.service.impl;
import com.eden.eva.dao.IQueryTableDAO;
import com.eden.eva.service.IQueryTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.QueryTable;

@SuppressWarnings("unchecked")
@Service("QueryTableServiceImpl")

public class QueryTableServiceImpl extends AbstractPageService<IQueryTableDAO,QueryTable> implements IQueryTableService {

	@Autowired
	private IQueryTableDAO queryTableDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IQueryTableDAO getDao() {
		return queryTableDAO;
	}
}
