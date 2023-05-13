package com.ywp.shppingcartbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shppingcartbackend.domain.Product;
import com.ywp.shppingcartbackend.service.ProductService;
import com.ywp.shppingcartbackend.mapper.ProductMapper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author asus
* @description 针对表【product】的数据库操作Service实现
* @createDate 2023-05-13 11:10:48
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    @Transactional
    public Product addToCart(Integer productId, Integer quantity) {
        // 从数据库中获取商品
        Product product = getById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Invalid product id: " + productId);
        }

        // 更新商品的状态和数量
        product.setInCart(1);
        product.setQuantity(quantity);
        updateById(product);

        return product;
    }

    @Override
    @Transactional
    public Product removeFromCart(Integer productId) {
        // 从数据库中获取商品
        Product product = getById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Invalid product id: " + productId);
        }

        // 更新商品的状态和数量
        product.setInCart(0);
        product.setQuantity(0);
        updateById(product);

        return product;
    }

    @Override
    public List<Product> getProductsInCart() {
        // 使用 MyBatis Plus 的 QueryWrapper 来创建查询条件
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("in_cart", 1);
        // 使用 mapper 的 selectList 方法来执行查询
        return this.list(queryWrapper);
    }
}