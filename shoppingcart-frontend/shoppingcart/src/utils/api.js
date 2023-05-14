// src/utils/api.js
import axios from 'axios';

const API_URL = 'http://localhost:9998'; // 你的后端API地址

export const getProducts = (page, size) => axios.get(`${API_URL}/products?page=${page}&size=${size}`);
export const getCart = () => axios.get(`${API_URL}/cart`);
export const addToCart = (productId) => axios.post(`${API_URL}/cart`, { productId });
export const deleteFromCart = (productId) => axios.delete(`${API_URL}/cart/${productId}`);
export const getOrders = (page, size) => axios.get(`${API_URL}/orders?page=${page}&size=${size}`);
export const getUserInfo = () => axios.get(`${API_URL}/user`);
export const updateUserInfo = (userInfo) => axios.put(`${API_URL}/user`, userInfo);
