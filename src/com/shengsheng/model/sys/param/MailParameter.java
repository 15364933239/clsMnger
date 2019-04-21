package com.shengsheng.model.sys.param;

import core.support.ExtJSBaseParameter;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:04:33
 * <dl>
 * 		<dt>MailParameter</dt>
 *		<dd>邮件的参数类</dd>
 * </dl>
 */
public class MailParameter extends ExtJSBaseParameter {

	private String $like_subject;

	public String get$like_subject() {
		return $like_subject;
	}

	public void set$like_subject(String $like_subject) {
		this.$like_subject = $like_subject;
	}

}
