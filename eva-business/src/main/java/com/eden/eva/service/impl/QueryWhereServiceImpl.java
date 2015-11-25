
package com.eden.eva.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.dao.IQueryWhereDAO;
import com.eden.eva.model.QueryWhere;
import com.eden.eva.service.IQueryWhereService;

@SuppressWarnings("unchecked")
@Service("QueryWhereServiceImpl")

public class QueryWhereServiceImpl extends AbstractPageService<IQueryWhereDAO,QueryWhere> implements IQueryWhereService {

	@Autowired
	private IQueryWhereDAO queryWhereDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IQueryWhereDAO getDao() {
		return queryWhereDAO;
	}
}
