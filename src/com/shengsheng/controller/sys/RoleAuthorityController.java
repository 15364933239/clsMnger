package com.shengsheng.controller.sys;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shengsheng.core.JavaEEFrameworkBaseController;
import com.shengsheng.model.sys.RoleAuthority;
import com.shengsheng.service.sys.RoleAuthorityService;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:53:29
 * <dl>
 * 		<dt>RoleAuthorityController</dt>
 *		<dd>角色权限的控制层</dd>
 * </dl>
 */
@Controller
@RequestMapping("/sys/roleauthority")
public class RoleAuthorityController extends JavaEEFrameworkBaseController<RoleAuthority> {

	@Resource
	private RoleAuthorityService roleAuthorityService;

	// 保存角色权限
	@RequestMapping(value = "/saveRoleAuthority")
	public void saveRoleAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roleKey = request.getParameter("roleKey");
		String menuCode = request.getParameter("menuCode");
		roleAuthorityService.deleteByProperties("roleKey", roleKey);
		String[] menuCodesValue = menuCode.split(",");
		for (int i = 0; i < menuCodesValue.length; i++) {
			RoleAuthority roleAuthority = new RoleAuthority();
			roleAuthority.setRoleKey(roleKey);
			roleAuthority.setMenuCode(menuCodesValue[i]);
			roleAuthorityService.persist(roleAuthority);
		}
		writeJSON(response, "{success:true}");
	}

}
