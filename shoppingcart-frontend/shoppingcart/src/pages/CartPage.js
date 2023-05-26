import React, { useState, useEffect } from "react";
import axios from "../axios";

const CartPage = () => {
  const [cart, setCart] = useState([]);

  // useEffect(() => {
  //   getCart()
  //     .then((response) => {
  //       setCart(response.data);
  //     })
  //     .catch((error) => {
  //       console.error('Failed to fetch cart', error);
  //     });
  // }, []);

  // 在此处添加 addToCart 和 deleteFromCart 的函数实现



  return (
    <div>
      {cart.map((item) => (
        <div key={item.id}>
          <h2>{item.product.name}</h2>
          <p>{item.product.description}</p>
          <button>Remove</button>
        </div>
      ))}
      {/* 添加到购物车的输入和按钮在此处实现 */}
    </div>
  );
};

export default CartPage;
