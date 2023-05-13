package com.ywp.shoppingcartbackend.service;

import com.ywp.shoppingcartbackend.domain.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author asus
 * @description 针对表【product】的数据库操作Service
 * @createDate 2023-05-13 11:10:48
 */
public interface ProductService extends IService<Product> {

    List<Product> getAllProducts();

    Product getProductById(Integer productId);
}
