package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shoppingcartbackend.domain.User;
import com.ywp.shoppingcartbackend.mapper.UserMapper;
import com.ywp.shoppingcartbackend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author asus
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-05-13 20:39:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Transactional
    public User register(User user) {
        // 检查用户名是否已存在
        // 如果用户名存在，抛出异常
        // 否则，将用户信息保存到数据库
    }

    @Override
    @Transactional
    public User login(String username, String password) {
        // 检查用户名和密码是否正确
        // 如果用户名或密码错误，抛出异常
        // 否则，返回用户信息
    }

    @Override
    @Transactional
    public User updateLocation(Integer userId, String location) {
        // 更新用户的地址信息
    }
}
