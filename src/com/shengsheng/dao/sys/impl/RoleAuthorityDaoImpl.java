package com.shengsheng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.shengsheng.dao.sys.RoleAuthorityDao;
import com.shengsheng.model.sys.RoleAuthority;

import core.dao.BaseDao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:57:11
 * <dl>
 * 		<dt>RoleAuthorityDaoImpl</dt>
 *		<dd>角色权限的数据持久层的实现类</dd>
 * </dl>
 */
@Repository
public class RoleAuthorityDaoImpl extends BaseDao<RoleAuthority> implements RoleAuthorityDao {

	public RoleAuthorityDaoImpl() {
		super(RoleAuthority.class);
	}

}
