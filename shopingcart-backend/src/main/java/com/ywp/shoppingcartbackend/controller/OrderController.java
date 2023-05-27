package com.ywp.shoppingcartbackend.controller;

import com.ywp.shoppingcartbackend.domain.Order;
import com.ywp.shoppingcartbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/user/{userId}")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@PathVariable Integer userId, @RequestParam Integer productId, @RequestParam Integer quantity) {
        Order order = orderService.createOrder(userId, productId, quantity);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer userId, @PathVariable Integer orderId) {
        orderService.deleteOrder(userId, orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Integer userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }
}