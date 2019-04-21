package com.shengsheng.app.bean;

/**
 * 
 * @author zhangsheng
 * 2019-02-25 20:01:25
 * <dl>
 * 		<dt>UpdateUserPwdResponseBean</dt>
 *		<dd>APP接口的实体Bean的请求端（根据用户名更新密码）</dd>
 * </dl>
 */
public class UpdateUserPwdResponseBean extends BaseResponseBean {

	private String result; // 返回结果

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
