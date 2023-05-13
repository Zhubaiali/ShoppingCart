package com.ywp.shoppingcartbackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ywp.shoppingcartbackend.domain.Product;
import com.ywp.shoppingcartbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<IPage<Product>> getAllProducts(@RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        IPage<Product> products = productService.getAllProducts(pageNum, pageSize);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }
}
