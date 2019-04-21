package com.shengsheng.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.sys.MailDao;
import com.shengsheng.model.sys.Mail;
import com.shengsheng.service.sys.MailService;

import core.service.BaseService;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:25:44
 * <dl>
 * 		<dt>MailServiceImpl</dt>
 *		<dd>邮件的业务逻辑层的实现</dd>
 * </dl>
 */
@Service
public class MailServiceImpl extends BaseService<Mail> implements MailService {

	private MailDao mailDao;

	@Resource
	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
		this.dao = mailDao;
	}

}
