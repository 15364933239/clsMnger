package core.service;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import core.dao.JdbcBaseDao;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:32:05
 * <dl>
 * 		<dt>JdbcBaseService</dt>
 *		<dd></dd>
 * </dl>
 */
@Transactional
public class JdbcBaseService {

	@Resource
	protected JdbcBaseDao jdbcBaseDao;

}
