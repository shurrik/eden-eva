
package com.eden.eva.service.impl;
import com.eden.eva.dao.IQueryJoinDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.QueryJoin;
import com.eden.eva.service.IQueryJoinService;

@SuppressWarnings("unchecked")
@Service("QueryJoinServiceImpl")

public class QueryJoinServiceImpl extends AbstractPageService<IQueryJoinDAO,QueryJoin> implements IQueryJoinService {

	@Autowired
	private IQueryJoinDAO queryJoinDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IQueryJoinDAO getDao() {
		return queryJoinDAO;
	}
}
