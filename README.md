# ShoppingCart

这是一个移动端的网页，底部有4个tab栏。第1个tab栏是购物车栏，可以查看购物车商品、添加、删除商品。第2个tab栏是商品栏，显示所有商品（把product的所有内容一条条列出来就行了，需要分页 mybatis plus分页查询）。第3个tab栏是订单栏，显示用户的所有订单（可能也需要分页）。第4个tab栏是用户栏，显示用户的个人信息（id 用户名 地址，地址支持修改）。另外，无论在哪个tab栏，右上角都有一个横幅，显示“欢迎您，xxx”（xxx是当前用户的用户名）。



### 1.数据库设计

1. User 表 (用户表)：
   - id (主键，自增长，唯一)
   - username (用户名，唯一)
   - password (用户密码，加密存储)
   - location (用户地址)

2. Product 表 (商品表)：
   - id (主键，自增长，唯一)
   - name (商品名)
   - description (商品描述)
   - price (商品价格)
   - quantity (商品库存量)

3. CartItem 表 (购物车项表)：
   - id (主键，自增长，唯一)
   - user_id (外键，关联 User 表的 id)
   - product_id (外键，关联 Product 表的 id)
   - quantity (购物车中商品的数量)

4. Order 表 (订单表)：
   - id (主键，自增长，唯一)
   - user_id (外键，关联 User 表的 id)
   - product_id (外键，关联 Product 表的 id)
   - quantity (订单中商品的数量)
   - order_status (订单状态，如：已创建、已付款、已发货、已完成、已取消等)


### 2. Restful API 接口设计

1. **用户相关接口**

   - `POST /user/register` 用户注册
   - `POST /user/login` 用户登录
   - `GET /user/{userId}` 获取用户信息
   - `PUT /user/{userId}/location` 更新用户地址

2. **商品相关接口**

   - `GET /product` 获取所有商品
   - `GET /product/{productId}` 获取单个商品的详细信息

3. **购物车相关接口**

   - `GET /user/{userId}/cart` 获取购物车中的所有商品
   - `POST /user/{userId}/cart/add/{productId}` 将商品添加到购物车
   - `POST /user/{userId}/cart/remove/{productId}` 从购物车中移除商品
   - `POST /user/{userId}/cart/decrease/{productId}` 减少购物车中的商品数量

4. **订单相关接口**

   - `GET /user/{userId}/orders` 获取用户的所有订单
   - `POST /user/{userId}/orders/create` 创建新的订单
   - `DELETE /user/{userId}/orders/{orderId}` 删除指定的订单
---


测试接口：接口返回200，请求成功。添加iPhone14成功。
POST /product/addToCart/{productId}

![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/50d91a18-a028-45e6-b7a1-e0efb8df774f)

![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/58565073-4d67-4e6c-bf1a-f2693396eb58)


POST /product/removeFromCart/{productId}

![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/af3e41e7-566c-456f-a8a0-e0ef8e4f559b)



GET /product/cart
![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/e736f810-0b6c-4422-9d9a-c243f607199b)





前后端联调



![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/06045c8e-175f-40cb-b815-4fe9192c539a)










五、实验总结

这个系统原本打算用2个表。一个product表，一个cart表。但考虑到系统只给一个人用，单独建cart表没必要，改为了在产品表中添加一个字段， in_cart，以表示该产品是否在购物车中。除此之外，我还新增了显示购物车中所有商品的功能。











