import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ProductPage = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        const fetchProducts = async () => {
            const response = await axios.get(`/product`);
            setProducts(response.data.records);
        };

        fetchProducts();
    }, []);

    return (
        <div>
            <h1>产品</h1>
            {products.map(product => (
                <div key={product.id}>
                    <h2>产品 ID: {product.id}</h2>
                    <p>产品名称: {product.name}</p>
                    <p>产品描述: {product.description}</p>
                </div>
            ))}
        </div>
    );
};

export default ProductPage;
