
package com.eden.eva.service.impl;
import com.eden.eva.dao.IQueryDAO;
import com.eden.eva.service.IQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.Query;

@SuppressWarnings("unchecked")
@Service("QueryServiceImpl")

public class QueryServiceImpl extends AbstractPageService<IQueryDAO,Query> implements IQueryService {

	@Autowired
	private IQueryDAO queryDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IQueryDAO getDao() {
		return queryDAO;
	}
}
