package com.shengsheng.model.wl509.param;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.shengsheng.model.wl509.Device;

import core.support.ExtJSBaseParameter;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月29日 下午4:44:24
 * <dl>
 * 		<dd>RecordParameter</dd>
 * 		<dt>记录参数类</dt>
 * </dl>
 */
public class RecordParameter extends ExtJSBaseParameter {

    
    private Device $eq_device;
    private Date $like_time;
    /**
     * @return the $eq_device
     */
    public Device get$eq_device() {
        return $eq_device;
    }
    /**
     * @param $eq_device the $eq_device to set
     */
    public void set$eq_device(Device $eq_device) {
        this.$eq_device = $eq_device;
    }
    /**
     * @return the $like_time
     */
    public Date get$like_time() {
        return $like_time;
    }
    /**
     * @param $like_time the $like_time to set
     */
    public void set$like_time(Date $like_time) {
        this.$like_time = $like_time;
    }
    
    
}
