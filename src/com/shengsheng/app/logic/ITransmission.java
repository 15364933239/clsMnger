package com.shengsheng.app.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shengsheng.app.bean.BaseResponseBean;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:50:20
 * <dl>
 * 		<dt>ITransmission</dt>
 *		<dd>APP接口的协议传输接口</dd>
 * </dl>
 */
public interface ITransmission {

	public String resv(HttpServletRequest request);

	public void resp(HttpServletResponse response, BaseResponseBean brb);

}
