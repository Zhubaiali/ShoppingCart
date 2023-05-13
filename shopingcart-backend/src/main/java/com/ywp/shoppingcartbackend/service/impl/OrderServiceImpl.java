package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shoppingcartbackend.domain.Order;
import com.ywp.shoppingcartbackend.service.OrderService;
import com.ywp.shoppingcartbackend.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author asus
 * @description 针对表【order】的数据库操作Service实现
 * @createDate 2023-05-13 20:46:08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    @Transactional
    public Order createOrder(Integer userId, Integer productId, Integer quantity) {
        // 创建新的订单
    }

    @Override
    @Transactional
    public void deleteOrder(Integer userId, Integer orderId) {
        // 删除指定的订单
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        // 获取用户的所有订单
    }
}
