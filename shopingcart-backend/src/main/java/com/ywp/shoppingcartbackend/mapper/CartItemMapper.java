package com.ywp.shoppingcartbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ywp.shoppingcartbackend.domain.CartItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author asus
 * @description 针对表【cart_item】的数据库操作Mapper
 * @createDate 2023-05-13 20:46:21
 * @Entity com.ywp.shoppingcartbackend.domain.CartItem
 */
@Mapper
public interface CartItemMapper extends BaseMapper<CartItem> {

}
