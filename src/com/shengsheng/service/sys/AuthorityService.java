package com.shengsheng.service.sys;

import java.util.List;

import com.shengsheng.model.sys.Authority;

import core.service.Service;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:26:50
 * <dl>
 * 		<dt>AuthorityService</dt>
 *		<dd>菜单的业务逻辑层的接口</dd>
 * </dl>
 */
public interface AuthorityService extends Service<Authority> {

	public String getPath(Authority auth);
	// 获取多级菜单
	List<Authority> queryAllMenuList(String globalRoleKey);

	// 获取按钮权限数据
	String getAuthorityButtonList(String menuCode);

	// 保存角色权限
	void saveAuthorityButtonList(String checkboxList, String menuCode);

}
