package com.ywp.shoppingcartbackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ywp.shoppingcartbackend.domain.CartItem;
import com.ywp.shoppingcartbackend.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart/user/{userId}")
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<CartItem> addToCart(@PathVariable Integer userId, @PathVariable Integer productId,
            @RequestParam Integer quantity) {
        CartItem cartItem = cartItemService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok(cartItem);
    }

    @PostMapping("/decrease/{productId}")
    public ResponseEntity<CartItem> decreaseQuantity(@PathVariable Integer userId, @PathVariable Integer productId,
                                                     @RequestParam Integer quantity) {
        CartItem cartItem = cartItemService.decreaseQuantity(userId, productId, quantity);
        if (cartItem == null) {
            // 如果 cartItem 为 null，表示商品数量已经减少到 0，返回 HTTP 204 No Content 响应
            return ResponseEntity.noContent().build();
        } else {
            // 否则，返回包含更新后的 cartItem 的 200 OK 响应
            return ResponseEntity.ok(cartItem);
        }
    }

    @PostMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable Integer userId, @PathVariable Integer productId) {
        cartItemService.removeFromCart(userId, productId);
    }

    @GetMapping("")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "0") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        IPage<CartItem> cartItems = cartItemService.getCartItems(userId, pageNum, pageSize);
        return ResponseEntity.ok(cartItems.getRecords());
    }
}
