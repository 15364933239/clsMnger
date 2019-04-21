package com.shengsheng.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.sys.RoleDao;
import com.shengsheng.model.sys.Role;
import com.shengsheng.service.sys.RoleService;

import core.service.BaseService;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:26:08
 * <dl>
 * 		<dt>RoleServiceImpl</dt>
 *		<dd>角色的业务逻辑层的实现</dd>
 * </dl>
 */
@Service
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

	private RoleDao roleDao;

	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		this.dao = roleDao;
	}

	public void deleteSysUserAndRoleByRoleId(Long roleId) {
		roleDao.deleteSysUserAndRoleByRoleId(roleId);
	}

}
