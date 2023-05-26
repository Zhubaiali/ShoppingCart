import React, { useState, useEffect } from "react";
import { getProducts } from '../utils/api';
import LoginPage from "./LoginPage";

const ProductsPage = () => {
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(1);  // 初始化分页为第1页
  const size = 10;  // 每页显示10个产品

  useEffect(() => {
    getProducts(page, size)
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error('Failed to fetch products', error);
      });
  }, [page]);

  return (
    <div>
      {products.map((product) => (
        <div key={product.id}>
          <h2>{product.name}</h2>
          <p>{product.description}</p>
        </div>
      ))}
      <button onClick={() => setPage(page + 1)}>Next Page</button>
    </div>
  );
};

export default ProductsPage
