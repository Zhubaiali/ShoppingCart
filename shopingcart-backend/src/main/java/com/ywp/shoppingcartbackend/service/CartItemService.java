package com.ywp.shoppingcartbackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ywp.shoppingcartbackend.domain.CartItem;

/**
 * @author asus
 * @description 针对表【cart_item】的数据库操作Service
 * @createDate 2023-05-13 20:46:21
 */
public interface CartItemService extends IService<CartItem> {

    /**
     * 将指定数量的特定商品添加到指定用户的购物车
     *
     * @param userId    用户ID
     * @param productId 商品ID
     * @param quantity  要添加的商品数量
     * @return 新添加的购物车商品项
     */
    CartItem addToCart(Integer userId, Integer productId, Integer quantity);

    /**
     * 从指定用户的购物车中移除特定商品
     *
     * @param userId    用户ID
     * @param productId 商品ID
     */
    void removeFromCart(Integer userId, Integer productId);

    /**
     * 获取指定用户购物车中的所有商品
     *
     * @param userId 用户ID
     * @return 该用户购物车中的商品列表
     */
    IPage<CartItem> getCartItems(Integer userId, int pageNumber, int pageSize);

    CartItem decreaseQuantity(Integer userId, Integer productId, Integer quantity);

}
