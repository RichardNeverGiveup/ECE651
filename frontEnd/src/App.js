import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import Home from './pages/Home'
import Login from './pages/Login/Register'
import ProductPage from './pages/ProductPage'
import ShoppingCartPage from './pages/ShoppingCartPage'
import OrderPage from './pages/OrderPage'
import SingleOrderPage from './pages/SingleOrderPage';


class App extends React.Component {

  render() {
    return (
      <Router>
        <Routes>
            <Route path="/" exact element={<Home/>}></Route>
            <Route path="/login" element={<Login/>}></Route>
            <Route path="/product/:product_id" element={<ProductPage/>}/>
            <Route path="/cart" element={<ShoppingCartPage/>}/>
            <Route path="/order" element={<OrderPage/>}/>
            <Route path="/orderById/:order_id" element={<SingleOrderPage/>}/>
        </Routes>
      </Router>
    );
  }
}



export default App;
