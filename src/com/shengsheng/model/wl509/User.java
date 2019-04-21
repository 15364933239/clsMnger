package com.shengsheng.model.wl509;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import com.shengsheng.model.wl509.param.UserParameter;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月28日 下午1:37:34
 * <dl>
 * 		<dd>User</dd>
 * 		<dt>用户实体类：
 *          /id、登录名、登陆密码、学号
 *          /年级、职务、姓名、性别、手机
 *          /邮箱、个人说明、头像、用户状态
 *          /设备集合、考勤记录、所在实验室</dt>
 * </dl>
 */
@Entity
@Table(name = "user")
@Cache(region = "all", usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount", "sortColumns", "cmd", "queryDynamicConditions", "sortedConditions", "dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class User extends UserParameter{
    
    /** 主键 用户id*/
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    
    /** 登录名*/
    @Column(name = "username")
    private String username;
    
    /** 登陆密码*/
    @Column(name = "password")
    private String password;
    
    /** 年级*/
    @Column(name = "grade")
    private String grade;
    
    /** 职务*/
    @Column(name = "duty")
    private String duty;
    
    /** 用户编号 学号工号*/
    @Column(name = "number")
    private String number;
    
    /** 用户姓名*/
    @Column(name = "name")
    private String name;
    
    /** 用户性别 1-男   2-女*/
    @Column(name = "sex")
    private Integer sex;    
    
    /** 用户手机号*/
    @Column(name = "phone")
    private String phone;
    
    /** 用户电子邮箱*/
    @Column(name = "mail")
    private String mail;
    
    /** 用户个人说明*/
    @Column(name = "description")
    private String description;
    
    /** 用户头像*/
    @Column(name = "head_portrait")
    private String headPortrait;
    
    /** 用户状态 离线-在线:true-false*/
    @Column(name = "state")
    private String state;
    
    /** 外键 设备-手机电脑*/
    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL},orphanRemoval=false)
    @JsonIgnoreProperties(value = {"user" })
    private List<Device> devices = new ArrayList<Device>();
    
    /** 员工考勤*/
    @Column(name = "aattendance")
    private String aAttendance;

    
    
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the duty
     */
    public String getDuty() {
        return duty;
    }

    /**
     * @param duty the duty to set
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the nickName
     */
    public String getName() {
        return name;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the headPortrait
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * @param headPortrait the headPortrait to set
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
     * @return the state
     */
//    public boolean isState() {
//        return state;
//    }
//
//    /**
//     * @param state the state to set
//     */
//    public void setState(boolean state) {
//        this.state = state;
//    }

    /**
     * @return the devices
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * @param devices the devices to set
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }


    /**
     * @return the aAttendance
     */
    public String getaAttendance() {
        return aAttendance;
    }

    /**
     * @param aAttendance the aAttendance to set
     */
    public void setaAttendance(String aAttendance) {
        this.aAttendance = aAttendance;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
   /* public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", grade=" + grade + ", duty="
                + duty + ", number=" + number + ", name=" + name + ", sex=" + sex + ", phone=" + phone
                + ", mail=" + mail + ", description=" + description + ", headPortrait=" + headPortrait + ", state="
                + state + ", devices=" + devices + ", aAttendance=" + aAttendance + "]";
    }*/
    
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.username, other.username) && Objects.equal(this.password, other.password) && Objects.equal(this.grade, other.grade)
                && Objects.equal(this.duty, other.duty)&& Objects.equal(this.number, other.number)&& Objects.equal(this.name, other.name)
                && Objects.equal(this.sex, other.sex)&& Objects.equal(this.phone, other.phone)&& Objects.equal(this.mail, other.mail)
                && Objects.equal(this.description, other.description)&& Objects.equal(this.headPortrait, other.headPortrait)&& Objects.equal(this.state, other.state)
                && Objects.equal(this.devices, other.devices)&& Objects.equal(this.aAttendance, other.aAttendance);
    }

    public int hashCode() {
        return Objects.hashCode(this.id, this.username, this.password, this.grade, this.duty,
                this.number,this.name,this.sex,this.phone,this.mail,this.description,this.headPortrait,
                this.state,this.devices,this.aAttendance);
    }

}
