import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CartPage = ({ userId }) => {
    const [cartItems, setCartItems] = useState([]);

    useEffect(() => {
        const fetchCartItems = async () => {
            const response = await axios.get(`/user/${userId}/cart`);
            setCartItems(response.data);
        };

        fetchCartItems();
    }, [userId]);

    const addToCart = async (productId, quantity) => {
        const response = await axios.post(`/user/${userId}/cart/add/${productId}`, { quantity });
        setCartItems(prevItems => [...prevItems, response.data]);
    };

    const decreaseQuantity = async (productId, quantity) => {
        const response = await axios.post(`/user/${userId}/cart/decrease/${productId}`, { quantity });
        if (response.status === 204) {
            setCartItems(prevItems => prevItems.filter(item => item.productId !== productId));
        } else {
            setCartItems(prevItems => prevItems.map(item => item.productId === productId ? response.data : item));
        }
    };

    const removeFromCart = async (productId) => {
        await axios.post(`/user/${userId}/cart/remove/${productId}`);
        setCartItems(prevItems => prevItems.filter(item => item.productId !== productId));
    };

    return (
        <div>
            <h1>购物车</h1>
            {cartItems.map(item => (
                <div key={item.id}>
                    <h2>{item.productName}</h2>
                    <p>数量: {item.quantity}</p>
                    <button onClick={() => addToCart(item.productId, 1)}>增加数量</button>
                    <button onClick={() => decreaseQuantity(item.productId, 1)}>减少数量</button>
                    <button onClick={() => removeFromCart(item.productId)}>从购物车移除</button>
                </div>
            ))}
        </div>
    );
};

export default CartPage;
