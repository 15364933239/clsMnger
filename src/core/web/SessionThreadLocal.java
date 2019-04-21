package core.web;

import com.shengsheng.model.sys.SysUser;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:36:53
 * <dl>
 * 		<dt>SessionThreadLocal</dt>
 *		<dd></dd>
 * </dl>
 */
public class SessionThreadLocal {

	private static ThreadLocal<SysUser> ADMINUSERTHREADLOCAL = new ThreadLocal<SysUser>();

	public static SysUser getThreadSysUser() {
		return ADMINUSERTHREADLOCAL.get();
	}

	public static void setThreadSysUser(SysUser sysUser) {
		ADMINUSERTHREADLOCAL.set(sysUser);
	}

}
