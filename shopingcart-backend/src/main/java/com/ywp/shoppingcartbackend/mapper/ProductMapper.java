package com.ywp.shoppingcartbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ywp.shoppingcartbackend.domain.Product;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author asus
 * @description 针对表【product】的数据库操作Mapper
 * @createDate 2023-05-13 11:10:48
 * @Entity com.ywp.shoppingcartbackend.domain.Product
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
