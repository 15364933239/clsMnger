package com.shengsheng.dao.wl509;

import java.util.Date;
import java.util.List;

import com.shengsheng.model.sys.SysUser;
import com.shengsheng.model.wl509.Record;
import com.shengsheng.model.wl509.User;

import core.dao.Dao;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月31日 上午9:47:38
 * <dl>
 * 		<dd>RecordDao</dd>
 * 		<dt>记录的数据持久层的接口</dt>
 * </dl>
 */
public interface RecordDao extends Dao<Record> {
	List<Record> listByUser(User user, Date startTime ,Date endTime);
}
