package com.ywp.shoppingcartbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ywp.shoppingcartbackend.domain.CartItem;
import com.ywp.shoppingcartbackend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/user/{userId}/cart")
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<CartItem> addToCart(@PathVariable Integer userId, @PathVariable Integer productId,
            @RequestParam Integer quantity) {
        CartItem cartItem = cartItemService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok(cartItem);
    }

    @PostMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable Integer userId, @PathVariable Integer productId) {
        cartItemService.removeFromCart(userId, productId);
    }

    @GetMapping("")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "0") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        Page<CartItem> page = new Page<>(pageNum, pageSize);
        QueryWrapper<CartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        Page<CartItem> result = cartItemService.page(page, queryWrapper);
        return ResponseEntity.ok(result.getRecords());
    }
}
