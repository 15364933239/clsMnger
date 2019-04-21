package com.shengsheng.dao.wl509.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shengsheng.dao.wl509.RecordDao;
import com.shengsheng.model.sys.SysUser;
import com.shengsheng.model.wl509.Record;
import com.shengsheng.model.wl509.User;

import core.dao.BaseDao;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月31日 上午9:48:20
 * <dl>
 * 		<dd>RecordDaoImpl</dd>
 * 		<dt>记录的数据持久层的实现类</dt>
 * </dl>
 */
@Repository
public class RecordDaoImpl extends BaseDao<Record> implements RecordDao {

    public RecordDaoImpl() {
        super(Record.class);
    }
     /**得到用户设备在记录表里的所有记录**/
	@Override
	public List<Record> listByUser(User user, Date startTime, Date endTime) {
		/**hql语句拼接**/
		String s = "select o from Record o join o.device d"
				+ " where o.time >= :startTime "
				+ " and o.time <= :endTime "
				+ " and d.user = :user";
		Query query = getSession().createQuery(s);
		query.setParameter("startTime", startTime);
		query.setParameter("endTime", endTime);
		query.setParameter("user", user);
		List<Record> list = query.list();
		return list;
	}

}
