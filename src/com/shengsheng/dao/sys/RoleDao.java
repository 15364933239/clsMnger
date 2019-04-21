package com.shengsheng.dao.sys;

import com.shengsheng.model.sys.Role;

import core.dao.Dao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 09:00:13
 * <dl>
 * 		<dt>RoleDao</dt>
 *		<dd>角色的数据持久层的接口</dd>
 * </dl>
 */
public interface RoleDao extends Dao<Role> {

	// 删除角色
	void deleteSysUserAndRoleByRoleId(Long roleId);

	// 根据菜单编码删除按钮权限
	void deleteRolePermissionByMenuCode(String menuCode);

	// 保存按钮权限
	void saveRolePermission(Long roleId, String permissions);

}
