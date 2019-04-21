package com.shengsheng.service.sys;

import com.shengsheng.model.sys.Role;

import core.service.Service;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:28:49
 * <dl>
 * 		<dt>RoleService</dt>
 *		<dd>角色的业务逻辑层的接口</dd>
 * </dl>
 */
public interface RoleService extends Service<Role> {

	// 删除角色
	void deleteSysUserAndRoleByRoleId(Long roleId);

}
