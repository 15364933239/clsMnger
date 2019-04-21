package com.shengsheng.service.wl509;

import java.util.Date;
import java.util.List;

import com.shengsheng.model.sys.SysUser;
import com.shengsheng.model.wl509.Record;
import com.shengsheng.model.wl509.User;

import core.service.Service;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月31日 上午9:39:42
 * <dl>
 * 		<dd>RecordService</dd>
 * 		<dt>记录的业务逻辑层的接口</dt>
 * </dl>
 */
public interface RecordService extends Service<Record> {

    List<Record> queryUserWithSubList(List<Record> resultList);
    
    List<Record> listByUser(User user, Date startTime ,Date endTime);

    
}
