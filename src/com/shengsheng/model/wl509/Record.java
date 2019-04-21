package com.shengsheng.model.wl509;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import com.shengsheng.model.sys.Dict;
import com.shengsheng.model.wl509.param.RecordParameter;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月28日 下午2:09:17
 * <dl>
 * 		<dd>Record</dd>
 * 		<dt>记录实体类：记录每个设备的每条记录 </dt>
 * </dl>
 */
@Entity
@Table(name = "record")
@Cache(region="all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class Record extends RecordParameter {
    
    /** 主键 日记录id*/
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    /** 外键 设备*/
    @ManyToOne
    @JoinColumn(name="device")
    private Device device;
    
    /** 时间*/
    @Column(name="time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    /** 批次 */
    @Column(name = "batch")
    private int batch;
    
	

	/**
	 * @return batch
	 */
	public int getBatch() {
		return batch;
	}

	/**
	 * @param batch 要设置的 batch
	 */
	public void setBatch(int batch) {
		this.batch = batch;
	}

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
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }
    
   /* public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Record other = (Record) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.device, other.device)&& Objects.equal(this.time, other.time)&& Objects.equal(this.batch, other.batch)&& Objects.equal(this.attencetime, other.attencetime);
    }*/

    /*public int hashCode() {
        return Objects.hashCode(this.id, this.device, this.time,this.batch,this.attencetime);
    }*/
    
}
