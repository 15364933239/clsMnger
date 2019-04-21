package com.shengsheng.dao.wl509.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shengsheng.dao.wl509.UserDao;
import com.shengsheng.model.wl509.User;

import core.dao.BaseDao;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月30日 下午3:13:24
 * <dl>
 * 		<dd>UserDaoImpl</dd>
 * 		<dt>用户的数据持久层的实现类</dt>
 * </dl>
 */
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao{

    public UserDaoImpl() {
        super(User.class);
    }


}
