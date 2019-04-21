package com.shengsheng.app.logic;

import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:49:28
 * @param <BaseRequestBean>
 * @param <BaseResponseBean>
 * <dl>
 * 		<dt>ILogicFace</dt>
 *		<dd>APP接口的业务处理逻辑封装接口</dd>
 * </dl>
 */
public interface ILogicFace<BaseRequestBean, BaseResponseBean> {

	public BaseResponseBean logic(WebApplicationContext wac, BaseRequestBean brb);

}
