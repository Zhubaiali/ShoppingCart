package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shoppingcartbackend.domain.Product;
import com.ywp.shoppingcartbackend.service.ProductService;
import com.ywp.shoppingcartbackend.mapper.ProductMapper;

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
    public List<Product> getAllProducts() {
        // 获取所有的商品
    }

    @Override
    public Product getProductById(Integer productId) {
        // 获取指定id的商品
    }
}