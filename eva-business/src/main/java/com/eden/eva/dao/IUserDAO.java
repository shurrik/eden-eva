package com.eden.eva.dao;

import java.util.List;

import com.eden.common.dao.IBaseDAO;
import com.eden.eva.model.User;


public interface IUserDAO extends IBaseDAO<User>{

	public	List<User> findRoleUser();

}
