package com.shengsheng.dao.sys;

import java.util.List;

import com.shengsheng.model.sys.Role;
import com.shengsheng.model.sys.SysUser;

import core.dao.Dao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 09:00:33
 * <dl>
 * 		<dt>SysUserDao</dt>
 *		<dd>用户的数据持久层的接口</dd>
 * </dl>
 */
public interface SysUserDao extends Dao<SysUser> {

	String getRoleValueBySysUserId(Long sysUserId);
	
	List<SysUser> getListByRole(Role role);

}
