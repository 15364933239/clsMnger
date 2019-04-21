package com.shengsheng.service.wl509;

import java.util.List;

import com.shengsheng.model.wl509.User;

import core.service.Service;

/**
 * 
 * @version: 1.0
 * @author LiPeiTong
 * 2019年3月30日 下午3:04:22
 * <dl>
 * 		<dd>UserService</dd>
 * 		<dt>用户的业务逻辑层的接口</dt>
 * </dl>
 */
public interface UserService extends Service<User>{

    List<User> queryUserWithSubList(List<User> resultList);
}
