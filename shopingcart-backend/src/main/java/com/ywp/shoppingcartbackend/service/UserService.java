package com.ywp.shoppingcartbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ywp.shoppingcartbackend.domain.User;

/**
 * @author asus
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-05-13 20:39:44
 */
public interface UserService extends IService<User> {
    User register(User user);
    User login(String username, String password);
    User updateLocation(Integer userId, String location);
}
