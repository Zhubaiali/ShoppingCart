package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shoppingcartbackend.domain.Product;
import com.ywp.shoppingcartbackend.exception.ResourceNotFoundException;
import com.ywp.shoppingcartbackend.mapper.ProductMapper;
import com.ywp.shoppingcartbackend.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author asus
 * @description 针对表【product】的数据库操作Service实现
 * @createDate 2023-05-13 11:10:48
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public IPage<Product> getAllProducts(int page, int size) {
        // 创建 Page 对象，传入当前页数和每页数量
        Page<Product> productPage = new Page<>(page, size);
        // 使用 MyBatis Plus 的 selectPage 方法进行分页查询
        return this.page(productPage);
    }


    @Override
    public Product getProductById(Integer productId) {
        // 使用 MyBatis Plus 的 getById 方法来获取指定id的商品
        Product product = this.getById(productId);
        if (product == null) {
            throw new ResourceNotFoundException("Product with id " + productId + " not found");
        }
        return product;
    }

}