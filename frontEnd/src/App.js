import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import Home from './pages/Home'
import Login from './pages/Login/Register'
import Test from './pages/Test'
class App extends React.Component {

  render() {
    return (
      <Router>
        <Routes>
            <Route path="/" exact element={<Home/>}></Route>
            <Route path="/login" element={<Login/>}></Route>
            <Route path="/test" element={<Test/>}></Route>
        </Routes>
      </Router>
    );
  }
}



export default App;
