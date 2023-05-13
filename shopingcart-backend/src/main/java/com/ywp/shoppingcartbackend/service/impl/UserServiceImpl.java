package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shoppingcartbackend.domain.User;
import com.ywp.shoppingcartbackend.service.UserService;
import com.ywp.shoppingcartbackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author asus
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-05-13 20:39:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}
