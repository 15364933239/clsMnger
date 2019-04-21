package com.shengsheng.service.sys;

import java.util.List;

import com.shengsheng.model.sys.Department;

import core.service.Service;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:27:02
 * <dl>
 * 		<dt>DepartmentService</dt>
 *		<dd>部门的业务逻辑层的接口</dd>
 * </dl>
 */
public interface DepartmentService extends Service<Department> {

	// 获取包含部门中文名称的列表
	List<Department> queryDepartmentCnList(List<Department> resultList);

}
