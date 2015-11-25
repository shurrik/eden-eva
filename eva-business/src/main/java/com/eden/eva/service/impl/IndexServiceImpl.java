
package com.eden.eva.service.impl;
import com.eden.eva.dao.IIndexDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eden.common.service.impl.AbstractPageService;
import com.eden.eva.model.Index;
import com.eden.eva.service.IIndexService;

@SuppressWarnings("unchecked")
@Service("IndexServiceImpl")

public class IndexServiceImpl extends AbstractPageService<IIndexDAO,Index> implements IIndexService {

	@Autowired
	private IIndexDAO indexDAO;
	@Override
	public boolean getEnableDataPerm() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IIndexDAO getDao() {
		return indexDAO;
	}
}
