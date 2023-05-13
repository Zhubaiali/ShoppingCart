package com.ywp.shoppingcartbackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ywp.shoppingcartbackend.domain.Product;

/**
 * @author asus
 * @description 针对表【product】的数据库操作Service
 * @createDate 2023-05-13 11:10:48
 */
public interface ProductService extends IService<Product> {

    IPage<Product> getAllProducts(int page, int size);

    Product getProductById(Integer productId);
}
