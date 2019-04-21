package com.shengsheng.model.sys.param;

import core.support.ExtJSBaseParameter;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:04:07
 * <dl>
 * 		<dt>InformationParameter</dt>
 *		<dd>信息发布的参数类</dd>
 * </dl>
 */
public class InformationParameter extends ExtJSBaseParameter {

	private String $like_title;
	private String contentNoHTML;

	public String get$like_title() {
		return $like_title;
	}

	public void set$like_title(String $like_title) {
		this.$like_title = $like_title;
	}

	public String getContentNoHTML() {
		return contentNoHTML;
	}

	public void setContentNoHTML(String contentNoHTML) {
		this.contentNoHTML = contentNoHTML;
	}

}
