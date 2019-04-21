package com.shengsheng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.shengsheng.dao.sys.DictDao;
import com.shengsheng.model.sys.Dict;

import core.dao.BaseDao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:56:21
 * <dl>
 * 		<dt>DictDaoImpl</dt>
 *		<dd>字典的数据持久层的实现类</dd>
 * </dl>
 */
@Repository
public class DictDaoImpl extends BaseDao<Dict> implements DictDao {

	public DictDaoImpl() {
		super(Dict.class);
	}

}
