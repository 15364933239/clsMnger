package com.shengsheng.app.logic;

import org.springframework.web.context.WebApplicationContext;

import com.shengsheng.app.bean.UpdateUserPwdRequestBean;
import com.shengsheng.app.bean.UpdateUserPwdResponseBean;
import com.shengsheng.service.sys.SysUserService;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:51:26
 * <dl>
 * 		<dt>UpdateUserPwdLogicServer</dt>
 *		<dd>APP接口的业务处理逻辑封装接口的实现类（根据用户名更改密码</dd>
 * </dl>
 */
public class UpdateUserPwdLogicServer implements ILogicFace<UpdateUserPwdRequestBean, UpdateUserPwdResponseBean> {

	public UpdateUserPwdResponseBean logic(WebApplicationContext wac, UpdateUserPwdRequestBean brb) {
		SysUserService userService = (SysUserService) wac.getBean("sysUserServiceImpl");
		UpdateUserPwdResponseBean updateUserResponseBean = new UpdateUserPwdResponseBean();
		updateUserResponseBean.setResult(userService.updateSysUser(brb));
		return updateUserResponseBean;
	}

}
