
package com.eden.eva.service.impl;
import com.eden.eva.dao.IQuerySelectDAO;
import com.eden.eva.service.IQuerySelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.QuerySelect;

@SuppressWarnings("unchecked")
@Service("QuerySelectServiceImpl")

public class QuerySelectServiceImpl extends AbstractPageService<IQuerySelectDAO,QuerySelect> implements IQuerySelectService {

	@Autowired
	private IQuerySelectDAO querySelectDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IQuerySelectDAO getDao() {
		return querySelectDAO;
	}
}
