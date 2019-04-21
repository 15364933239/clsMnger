package com.shengsheng.service.wl509.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.wl509.DeviceDao;
import com.shengsheng.model.wl509.Device;
import com.shengsheng.service.wl509.DeviceService;

import core.service.BaseService;
/**
 * 
 * @version:
 * @author LiPeiTong
 * 2019年3月31日 下午12:23:31
 * <dl>
 * 		<dd>DeviceDao</dd>
 * 		<dt>记录的业务逻辑层的实现</dt>
 * </dl>
 */
@Service
public class DeviceServiceImpl extends BaseService<Device> implements DeviceService {

    private DeviceDao deviceDao;

    /**
     * @param deviceDao the deviceDao to set
     */
    @Resource
    public void setDeviceDao(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
        this.dao = deviceDao;
    }
    
    
    
    
    
}
