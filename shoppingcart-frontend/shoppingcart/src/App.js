import React, { useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Redirect } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import CartPage from './pages/CartPage';
import OrderPage from './pages/OrderPage';
import ProductPage from './pages/ProductPage';
// 引入其他页面组件...

const App = () => {
    const [user, setUser] = useState(null);

    const handleLogin = (userData) => {
        setUser(userData);
    };

    return (
        <Router>
            <Switch>
                <Route path="/login">
                    {user ? <Redirect to="/cart" /> : <LoginPage onLogin={handleLogin} />}
                </Route>
                <Route path="/cart">
                    {user ? <CartPage userId={user.id} /> : <Redirect to="/login" />}
                </Route>
                <Route path="/orders">
                    {user ? <OrderPage userId={user.id} /> : <Redirect to="/login" />}
                </Route>
                <Route path="/products">
                    <ProductPage />
                </Route>
                {/* 添加其他路由... */}
            </Switch>
        </Router>
    );
};

export default App;
