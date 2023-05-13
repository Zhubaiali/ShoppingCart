package com.ywp.shppingcartbackend.service;

import com.ywp.shppingcartbackend.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author asus
* @description 针对表【product】的数据库操作Service
* @createDate 2023-05-13 11:10:48
*/
public interface ProductService extends IService<Product> {
    /**
     * 将商品添加到购物车
     *
     * @param productId 商品ID
     * @param quantity 商品数量
     * @return 更新后的Product
     */
    Product addToCart(Integer productId, Integer quantity);

    /**
     * 从购物车中移除商品
     *
     * @param productId 商品ID
     * @return 更新后的Product
     */
    Product removeFromCart(Integer productId);
    

}
