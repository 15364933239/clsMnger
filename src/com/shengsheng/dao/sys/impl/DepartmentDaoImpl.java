package com.shengsheng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.shengsheng.dao.sys.DepartmentDao;
import com.shengsheng.model.sys.Department;

import core.dao.BaseDao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:56:05
 * <dl>
 * 		<dt>DepartmentDaoImpl</dt>
 *		<dd>部门的数据持久层的实现类</dd>
 * </dl>
 */
@Repository
public class DepartmentDaoImpl extends BaseDao<Department> implements DepartmentDao {

	public DepartmentDaoImpl() {
		super(Department.class);
	}

}
