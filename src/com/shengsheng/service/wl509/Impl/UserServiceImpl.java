package com.shengsheng.service.wl509.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shengsheng.dao.wl509.UserDao;
import com.shengsheng.model.wl509.User;
import com.shengsheng.service.wl509.UserService;

import core.service.BaseService;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月30日 下午3:05:22
 * <dl>
 * 		<dd>UserServiceImpl</dd>
 * 		<dt>用户的业务逻辑层的实现</dt>
 * </dl>
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService{

    private UserDao userDao;
    
    /**
     * @param userDao the userDao to set
     */
    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        this.dao = userDao;
    }



    @Override
    public List<User> queryUserWithSubList(List<User> resultList) {
        List<User> userList = new ArrayList<User>();
        for (User entity : resultList) {
            User user = new User();
            user.setId(entity.getId());
            user.setUsername(entity.getUsername());
            user.setPassword(entity.getPassword());
            user.setNumber(entity.getNumber());
            user.setName(entity.getUsername());
            user.setGrade(entity.getGrade());
            user.setDuty(entity.getDuty());
            user.setSex(entity.getSex());
            user.setPhone(entity.getPhone());
            user.setMail(entity.getMail());
            user.setDescription(entity.getDescription());
            user.setHeadPortrait(entity.getHeadPortrait());
            user.setState(entity.getState());
            user.setDevices(entity.getDevices());
            user.setaAttendance(entity.getaAttendance());
            userList.add(user);
        }
        return userList;
    }

}
