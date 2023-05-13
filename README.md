# ShoppingCart

1.数据库设计

数据库 huas-project-yangwp
ORM 框架：mybaits + mybatis plus


表结构：

![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/9b9970a9-02e1-4d01-ac29-95ed34ef82aa)


![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/ed5f3df8-4ba8-4951-b8ec-f3974c533015)


![image](https://github.com/Zhubaiali/ShoppingCart/assets/69970253/37bf93c6-a1d7-4ec6-bb58-390c42fc960d)



2. Restful api 接口设计

这个项目的 RESTful API 接口设计包含以下的三个主要接口：

1. `POST /product/addToCart/{productId}`: 这个接口用于将一个商品添加到购物车。它接收两个参数：`productId`（路径参数）和 `quantity`（请求参数）。`productId` 是你想添加到购物车的商品的 ID，`quantity` 是你想添加的数量。这个接口返回一个 `Product` 对象，表示被添加到购物车的商品。

2. `POST /product/removeFromCart/{productId}`: 这个接口用于从购物车移除一个商品。它接收一个参数：`productId`（路径参数），是你想从购物车移除的商品的 ID。这个接口返回一个 `Product` 对象，表示被移除的商品。

3. `GET /product/cart`: 这个接口用于获取购物车中的所有商品。它不接收任何参数。这个接口返回一个 `Product` 对象的列表，表示购物车中的所有商品。


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











