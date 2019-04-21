package com.shengsheng.model.wl509.param;

import java.util.Date;

import com.shengsheng.model.wl509.Device;

import core.support.ExtJSBaseParameter;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年4月2日 上午9:35:34
 * <dl>
 * 		<dd>DeviceParameter</dd>
 * 		<dt>设备参数类</dt>
 * </dl>
 */
public class DeviceParameter extends ExtJSBaseParameter{
    private Device $eq_mac;
    private Date $like_name;
    /**
     * @return the $eq_mac
     */
    public Device get$eq_mac() {
        return $eq_mac;
    }
    /**
     * @param $eq_mac the $eq_mac to set
     */
    public void set$eq_mac(Device $eq_mac) {
        this.$eq_mac = $eq_mac;
    }
    /**
     * @return the $like_name
     */
    public Date get$like_name() {
        return $like_name;
    }
    /**
     * @param $like_name the $like_name to set
     */
    public void set$like_name(Date $like_name) {
        this.$like_name = $like_name;
    }

    
}
