package com.shengsheng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.shengsheng.dao.sys.MailDao;
import com.shengsheng.model.sys.Mail;

import core.dao.BaseDao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 08:56:57
 * <dl>
 * 		<dt>MailDaoImpl</dt>
 *		<dd>邮件的数据持久层的实现类</dd>
 * </dl>
 */
@Repository
public class MailDaoImpl extends BaseDao<Mail> implements MailDao {

	public MailDaoImpl() {
		super(Mail.class);
	}

}
