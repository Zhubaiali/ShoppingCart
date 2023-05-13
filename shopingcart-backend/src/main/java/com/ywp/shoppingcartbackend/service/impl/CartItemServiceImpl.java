package com.ywp.shoppingcartbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ywp.shoppingcartbackend.domain.CartItem;
import com.ywp.shoppingcartbackend.domain.Product;
import com.ywp.shoppingcartbackend.mapper.ProductMapper;
import com.ywp.shoppingcartbackend.service.CartItemService;
import com.ywp.shoppingcartbackend.mapper.CartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author asus
 * @description 针对表【cart_item】的数据库操作Service实现
 * @createDate 2023-05-13 20:46:21
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    privave CartItemMapper cartItemMapper;

    private CartItem getCartItem(Integer userId, Integer productId) {
        QueryWrapper<CartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("product_id", productId);
        return cartItemMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional
    public CartItem addToCart(Integer userId, Integer productId, Integer quantity) {
        // 检查商品是否存在
        Product product = productMapper.selectById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Invalid product id: " + productId);
        }

        // 检查商品库存量是否足够
        if (product.getQuantity() < quantity) {
            return null; // 如果库存量不足，返回null
        }

        // 更新商品库存量
        product.setQuantity(product.getQuantity() - quantity);
        productMapper.updateById(product);

        // 查询购物车中是否已经存在该商品
        QueryWrapper<CartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("product_id", productId);
        CartItem existingCartItem = this.getOne(queryWrapper);

        if (existingCartItem != null) {
            // 如果购物车中已经存在该商品，更新数量
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
            this.updateById(existingCartItem);
            return existingCartItem;
        } else {
            // 否则，创建一个新的购物车项目
            CartItem newCartItem = new CartItem();
            newCartItem.setUserId(userId);
            newCartItem.setProductId(productId);
            newCartItem.setQuantity(quantity);
            this.save(newCartItem);
            return newCartItem;
        }
    }

    @Override
    @Transactional
    public void removeFromCart(Integer userId, Integer productId) {
        // 查询购物车中是否存在该商品
        QueryWrapper<CartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("product_id", productId);
        CartItem existingCartItem = this.getOne(queryWrapper);

        // 如果购物车中存在该商品，删除
        if (existingCartItem != null) {
            this.removeById(existingCartItem.getId());
        }
        // 如果商品不在购物车中，我们不做任何操作
    }

    @Override
    public IPage<CartItem> getCartItems(Integer userId, int pageNumber, int pageSize) {
        // 查询该用户购物车中的所有商品，并分页返回结果
        QueryWrapper<CartItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        Page<CartItem> page = new Page<>(pageNumber, pageSize);
        return this.page(page, queryWrapper);
    }

    @Override
    @Transactional
    public CartItem decreaseQuantity(Integer userId, Integer productId, Integer quantity) {
        // 从购物车中获取指定的商品
        CartItem cartItem = getCartItem(userId, productId);
        if (cartItem == null) {
            throw new IllegalArgumentException("Product is not in the cart: " + productId);
        }

        // 减少商品的数量
        int newQuantity = cartItem.getQuantity() - quantity;
        if (newQuantity <= 0) {
            // 如果商品的数量减少为0或者负数，那么从购物车中移除该商品
            cartItemService.removeById(cartItem.getId());
            return null;
        } else {
            cartItem.setQuantity(newQuantity);
            cartItemService.updateById(cartItem);
            return cartItem;
        }
    }

}
