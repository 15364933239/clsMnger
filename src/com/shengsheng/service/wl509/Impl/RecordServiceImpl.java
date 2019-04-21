package com.shengsheng.service.wl509.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.wl509.RecordDao;
import com.shengsheng.model.sys.SysUser;
import com.shengsheng.model.wl509.Record;
import com.shengsheng.model.wl509.User;
import com.shengsheng.service.wl509.RecordService;

import core.service.BaseService;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月31日 上午9:40:47
 * <dl>
 * 		<dd>RecordServiceImpl</dd>
 * 		<dt>记录的业务逻辑层的实现</dt>
 * </dl>
 */
@Service
public class RecordServiceImpl extends BaseService<Record> implements RecordService {

    
    private RecordDao recordDao;

    /**
     * @param recordDao the recordDao to set
     */
    @Resource
    public void setRecordDao(RecordDao recordDao) {
        this.recordDao = recordDao;
        this.dao = recordDao;
    }

    @Override
    public List<Record> queryUserWithSubList(List<Record> resultList) {
        List<Record> records = new ArrayList<Record>();

        for (Record entity : resultList) {
            Record record = new Record();
            record.setId(entity.getId());
            record.setDevice(entity.getDevice());
            record.setTime(entity.getTime());
            record.setBatch(entity.getBatch());
            records.add(record);
        }
        
        return records;
    }

	@Override
	public List<Record> listByUser(User user, Date startTime, Date endTime) {
		
		return this.recordDao.listByUser(user, startTime, endTime);
	}
    
    
    
    
}
