package com.shengsheng.dao.wl509.Impl;

import org.springframework.stereotype.Repository;

import com.shengsheng.dao.wl509.DeviceDao;
import com.shengsheng.model.wl509.Device;

import core.dao.BaseDao;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月31日 下午12:22:56
 * <dl>
 * 		<dd>DeviceDaoImpl</dd>
 * 		<dt>设备的数据持久层的实现类</dt>
 * </dl>
 */
@Repository
public class DeviceDaoImpl extends BaseDao<Device> implements DeviceDao{

    public DeviceDaoImpl() {
        super(Device.class);
    }

}
