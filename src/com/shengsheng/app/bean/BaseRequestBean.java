package com.shengsheng.app.bean;
/**
 * 
 * @author zhangsheng
 * 2019-02-25 20:00:35
 * <dl>
 * 		<dt>BaseRequestBean</dt>
 *		<dd>APP接口的实体Bean的请求端的父类</dd>
 * </dl>
 */
public class BaseRequestBean {

	private String actionCode; // Key（唯一）

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

}
