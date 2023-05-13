package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User information is incomplete.");
        }

        // 检查用户名是否已存在
        if (getByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists: " + user.getUsername());
        }

        // 否则，将用户信息保存到数据库
        this.save(user);
        return user;
    }
    private User getByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return this.getOne(queryWrapper);
    }
    @Override
    @Transactional
    public User login(String username, String password) {
        User user = getByUsername(username);
        // 检查用户名和密码是否正确
        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Username or password is incorrect.");
        }

        // 否则，返回用户信息
        return user;
    }

    @Override
    @Transactional
    public User updateLocation(Integer userId, String location) {
        // 更新用户的地址信息
        User user = this.getById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id: " + userId);
        }
        user.setLocation(location);
        this.updateById(user);
        return user;
    }
}
