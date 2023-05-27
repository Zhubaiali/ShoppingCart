import React, { useState, useEffect } from "react";
import { getProducts } from '../utils/api';

const OrdersPage = () => {
  const [orders, setOrders] = useState([]);
  const [page, setPage] = useState(1);
  const size = 10;

  // useEffect(() => {
  //   getOrders(page, size)
  //     .then((response) => {
  //       setOrders(response.data);
  //     })
  //     .catch((error) => {
  //       console.error('Failed to fetch orders', error);
  //     });
  // }, [page]);

  return (
    <div>
      {orders.map((order) => (
        <div key={order.id}>
          <h2>Order #{order.id}</h2>
          {order.items.map((item) => (
            <div key={item.id}>
              <p>{item.product.name} x {item.quantity}</p>
            </div>
          ))}
        </div>
      ))}
      <button onClick={() => setPage(page + 1)}>Next Page</button>
    </div>
  );
};

export default OrdersPage;
