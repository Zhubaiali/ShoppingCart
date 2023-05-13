package com.ywp.shppingcartbackend.mapper;

import com.ywp.shppingcartbackend.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author asus
* @description 针对表【product】的数据库操作Mapper
* @createDate 2023-05-13 11:10:48
* @Entity generator.domain.Product
*/
public interface ProductMapper extends BaseMapper<Product> {

    @Select("SELECT * FROM product WHERE in_cart = 1")
    List<Product> selectProductsInCart();

    @Select("SELECT * FROM product WHERE id = #{id}")
    Product selectProductById(@Param("id") Integer id);

    
}




