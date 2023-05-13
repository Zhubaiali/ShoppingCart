package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shoppingcartbackend.domain.Order;
import com.ywp.shoppingcartbackend.domain.Product;
import com.ywp.shoppingcartbackend.mapper.OrderMapper;
import com.ywp.shoppingcartbackend.service.OrderService;
import com.ywp.shoppingcartbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ProductService productService;
    @Override
    @Transactional
    public Order createOrder(Integer userId, Integer productId, Integer quantity) {
        // 创建新的订单
        Product product = productService.getById(productId);
        if (product == null || product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Product is unavailable or quantity is insufficient.");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setIsDeleted(0);
        this.save(order);
        return order;
    }

    @Override
    @Transactional
    public void deleteOrder(Integer userId, Integer orderId) {
        // 删除指定的订单
        Order order = this.getById(orderId);
        if (order == null || !order.getUserId().equals(userId)) {
            throw new IllegalArgumentException("Invalid order id: " + orderId);
        }
        order.setIsDeleted(1);
        this.updateById(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        // 获取用户的所有订单
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("is_deleted", 0);
        return this.list(queryWrapper);

    }
}
