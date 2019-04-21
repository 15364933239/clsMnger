package core.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:31:33
 * <dl>
 * 		<dt>JdbcBaseDao</dt>
 *		<dd></dd>
 * </dl>
 */
public class JdbcBaseDao extends JdbcDaoSupport {

	@Resource(name = "dataSource")
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}

}
