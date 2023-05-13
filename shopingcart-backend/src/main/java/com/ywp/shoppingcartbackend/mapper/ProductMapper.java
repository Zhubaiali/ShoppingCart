package com.ywp.shoppingcartbackend.mapper;

import com.ywp.shoppingcartbackend.domain.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author asus
 * @description 针对表【product】的数据库操作Mapper
 * @createDate 2023-05-13 11:10:48
 * @Entity com.ywp.shoppingcartbackend.domain.Product
 */
public interface ProductMapper extends BaseMapper<Product> {

}
