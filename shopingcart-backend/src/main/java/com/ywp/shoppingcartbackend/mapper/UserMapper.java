package com.ywp.shoppingcartbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ywp.shoppingcartbackend.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author asus
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-05-13 20:39:44
 * @Entity com.ywp.shoppingcartbackend.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
