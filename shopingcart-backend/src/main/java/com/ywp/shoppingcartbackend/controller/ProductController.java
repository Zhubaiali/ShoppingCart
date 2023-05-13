package com.ywp.shoppingcartbackend.controller;

import com.ywp.shoppingcartbackend.domain.Product;
import com.ywp.shoppingcartbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addToCart/{productId}")
    public ResponseEntity<Product> addToCart(@PathVariable Integer productId, @RequestParam Integer quantity) {
        Product product = productService.addToCart(productId, quantity);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/removeFromCart/{productId}")
    public ResponseEntity<Product> removeFromCart(@PathVariable Integer productId) {
        Product product = productService.removeFromCart(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Product>> getProductsInCart() {
        List<Product> products = productService.getProductsInCart();
        return ResponseEntity.ok(products);
    }

}
