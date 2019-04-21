package com.shengsheng.service.sys;

import java.util.List;

import com.shengsheng.app.bean.UpdateUserPwdRequestBean;
import com.shengsheng.model.sys.Role;
import com.shengsheng.model.sys.SysUser;

import core.service.Service;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:29:34
 * <dl>
 * 		<dt>SysUserService</dt>
 *		<dd>用户的业务逻辑层的接口</dd>
 * </dl>
 */
public interface SysUserService extends Service<SysUser> {
	
	List<SysUser> getListByRole(Role role);


	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd> 获取用户信息（将数据库查询出来的信息再处理，
	 * 增加字段的中文意思）</dd>
	 * </dl>
	 * @param resultList
	 * @return
	 */
	List<SysUser> querySysUserCnList(List<SysUser> resultList);

	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>获取个人资料信息（将数据库查询出来的信息再
	 * 处理，增加头像）</dd>
	 * </dl>
	 * @param sysuser
	 * @return
	 */
	SysUser getSysUserWithAvatar(SysUser sysuser);

	String updateSysUser(UpdateUserPwdRequestBean brb);

}
