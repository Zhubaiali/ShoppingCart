package com.ywp.shoppingcartbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ywp.shoppingcartbackend.domain.Order;

import java.util.List;

/**
 * @author asus
 * @description 针对表【order】的数据库操作Service
 * @createDate 2023-05-13 20:46:08
 */
public interface OrderService extends IService<Order> {
    Order createOrder(Integer userId, Integer productId, Integer quantity);

    void deleteOrder(Integer userId, Integer orderId);

    List<Order> getOrdersByUserId(Integer userId);
}
