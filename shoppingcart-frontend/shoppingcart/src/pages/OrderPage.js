import React, { useState, useEffect } from "react";
import axios from "../axios";

const OrderPage = ({ userId }) => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    const fetchOrders = async () => {
      const response = await axios.get(`/user/${userId}/order`);
      setOrders(response.data);
    };

    fetchOrders();
  }, [userId]);

  const deleteOrder = async (orderId) => {
    await axios.delete(`/user/${userId}/order/${orderId}`);
    setOrders((prevOrders) =>
      prevOrders.filter((order) => order.id !== orderId)
    );
  };

  return (
    <div>
      <h1>订单</h1>
      {orders.map((order) => (
        <div key={order.id}>
          <h2>订单 ID: {order.id}</h2>
          <p>商品 ID: {order.productId}</p>
          <p>数量: {order.quantity}</p>
          <button onClick={() => deleteOrder(order.id)}>删除订单</button>
        </div>
      ))}
    </div>
  );
};

export default OrderPage;
