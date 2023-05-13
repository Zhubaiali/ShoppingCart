package com.ywp.shoppingcartbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ywp.shoppingcartbackend.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author asus
 * @description 针对表【order】的数据库操作Mapper
 * @createDate 2023-05-13 20:46:08
 * @Entity com.ywp.shoppingcartbackend.domain.Order
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
