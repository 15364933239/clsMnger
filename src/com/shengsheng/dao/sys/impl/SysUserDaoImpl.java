package com.shengsheng.dao.sys.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shengsheng.dao.sys.SysUserDao;
import com.shengsheng.model.sys.Role;
import com.shengsheng.model.sys.SysUser;

import core.dao.BaseDao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:57:43
 * <dl>
 * 		<dt>SysUserDaoImpl</dt>
 *		<dd>用户的数据持久层的实现类</dd>
 * </dl>
 */
@Repository
public class SysUserDaoImpl extends BaseDao<SysUser> implements SysUserDao {

	public SysUserDaoImpl() {
		super(SysUser.class);
	}

	@Override
	public String getRoleValueBySysUserId(Long sysUserId) {
		Query query = this.getSession().createSQLQuery("select role_value from sysuser_role,role where sysuser_role.role_id = role.id and sysuser_id = :sysUserId");
		query.setParameter("sysUserId", sysUserId);
		String roleValue = (String) query.uniqueResult() == null ? "" : (String) query.uniqueResult();
		return roleValue;
	}

	/* (non-Javadoc)
	 * @see com.shengsheng.dao.sys.SysUserDao#getListByRole(com.shengsheng.model.sys.Role)
	 */
	@Override
	public List<SysUser> getListByRole(Role role) {
		String s = "select u from SysUser u join u.roles r where r = :role ";
		Query query = getSession().createQuery(s);
		query.setParameter("role", role);
		List<SysUser> list = query.list();
		return list;
	}

}
