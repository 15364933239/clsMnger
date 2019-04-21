package com.shengsheng.model.wl509;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import com.shengsheng.model.wl509.param.DeviceParameter;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月28日 下午2:04:54
 * <dl>
 * 		<dd>Device</dd>
 * 		<dt>设备实体类:
 *          id、设备名、设备mac、是否被绑定、时间</dt>
 * </dl>
 */

@Entity
@Table(name = "device")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class Device extends DeviceParameter{
    
    /** 主键 设备id*/
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    /** 设备名*/
    @Column(name = "name")
    private String name;
    
    /** 设备mac*/
    @Column(name = "mac")
    private String mac;
    
    /** 设备是否被绑定*/
    @Column(name = "isbound")
    private boolean isBound;
    
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac the mac to set
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * @return the isBound
     */
    public boolean isBound() {
        return isBound;
    }

    /**
     * @param isBound the isBound to set
     */
    public void setBound(boolean isBound) {
        this.isBound = isBound;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Device other = (Device) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.name, other.name)&& Objects.equal(this.mac, other.mac)
                && Objects.equal(this.isBound, other.isBound)&& Objects.equal(this.user, other.user);
    }

    public int hashCode() {
        return Objects.hashCode(this.id, this.mac, this.name, this.isBound,this.user);
    }

    
    
}
