package com.shengsheng.model.sys.param;

import java.util.List;

import com.shengsheng.model.sys.Authority;

import core.support.ExtJSBaseParameter;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 09:02:08
 * <dl>
 * 		<dt>AuthorityParameter</dt>
 *		<dd>菜单的参数类</dd>
 * </dl>
 */
public class AuthorityParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 2903229213249813463L;
	private String $eq_menuCode;
	private String $like_menuName;
	private List<Authority> subAuthorityList;

	public String get$eq_menuCode() {
		return $eq_menuCode;
	}

	public void set$eq_menuCode(String $eq_menuCode) {
		this.$eq_menuCode = $eq_menuCode;
	}

	public String get$like_menuName() {
		return $like_menuName;
	}

	public void set$like_menuName(String $like_menuName) {
		this.$like_menuName = $like_menuName;
	}

	public List<Authority> getSubAuthorityList() {
		return subAuthorityList;
	}

	public void setSubAuthorityList(List<Authority> subAuthorityList) {
		this.subAuthorityList = subAuthorityList;
	}

}
