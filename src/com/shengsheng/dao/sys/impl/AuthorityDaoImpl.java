package com.shengsheng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.shengsheng.dao.sys.AuthorityDao;
import com.shengsheng.model.sys.Authority;

import core.dao.BaseDao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:55:50
 * <dl>
 * 		<dt>AuthorityDaoImpl</dt>
 *		<dd>菜单的数据持久层的实现类</dd>
 * </dl>
 */
@Repository
public class AuthorityDaoImpl extends BaseDao<Authority> implements AuthorityDao {

	public AuthorityDaoImpl() {
		super(Authority.class);
	}

}
