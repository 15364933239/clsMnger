package com.shengsheng.model.sys.param;

import core.support.ExtJSBaseParameter;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:03:54
 * <dl>
 * 		<dt>DictParameter</dt>
 *		<dd>字典的参数类</dd>
 * </dl>
 */
public class DictParameter extends ExtJSBaseParameter {

	private String $eq_dictKey;
	private String $like_dictValue;

	public String get$eq_dictKey() {
		return $eq_dictKey;
	}

	public void set$eq_dictKey(String $eq_dictKey) {
		this.$eq_dictKey = $eq_dictKey;
	}

	public String get$like_dictValue() {
		return $like_dictValue;
	}

	public void set$like_dictValue(String $like_dictValue) {
		this.$like_dictValue = $like_dictValue;
	}

}
