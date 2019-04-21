package com.shengsheng.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.sys.RoleAuthorityDao;
import com.shengsheng.model.sys.RoleAuthority;
import com.shengsheng.service.sys.RoleAuthorityService;

import core.service.BaseService;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:25:57
 * <dl>
 * 		<dt>RoleAuthorityServiceImpl</dt>
 *		<dd>角色权限的业务逻辑层的实现</dd>
 * </dl>
 */
@Service
public class RoleAuthorityServiceImpl extends BaseService<RoleAuthority> implements RoleAuthorityService {

	private RoleAuthorityDao roleAuthorityDao;

	@Resource
	public void setRoleAuthorityDao(RoleAuthorityDao roleAuthorityDao) {
		this.roleAuthorityDao = roleAuthorityDao;
		this.dao = roleAuthorityDao;
	}

}
