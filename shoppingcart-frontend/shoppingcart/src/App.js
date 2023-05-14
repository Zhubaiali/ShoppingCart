import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import LoginPage from './pages/LoginPage';
import CartPage from './pages/CartPage';
import OrderPage from './pages/OrderPage';
import ProductPage from './pages/ProductPage';
// 引入其他页面组件...

function App() {
  const [user, setUser] = useState(null);

  const handleLogin = (userData) => {
      setUser(userData);
  };

  return (
      <Router>
          <Routes>
              <Route path="/login" element={user ? <Navigate to="/cart" /> : <LoginPage onLogin={handleLogin} />}/>
              <Route path="/cart" element={user ? <CartPage userId={user.id} /> : <Navigate to="/login" />} />
              <Route path="/orders" element={user ? <OrderPage userId={user.id} /> : <Navigate to="/login" />} />
              <Route path="/products" element={<ProductPage />} />
              {/* 添加其他路由... */}
          </Routes>
      </Router>
  );
};

export default App;
