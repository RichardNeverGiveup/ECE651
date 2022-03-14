import React, { useState, useEffect } from 'react';

import NavHeader from '../components/layout/Header';
import NavFooter from '../components/layout/Footer';
import NavContent from '../components/layout/OrderDetail';
import { Layout } from 'antd';
import Cookies from 'js-cookie';

const { Header, Footer, Content } = Layout;



function OrderPage(){

  const [loginuser, setLoginUser] = useState("");

  useEffect(() => {
    if(Cookies.get("user")) {
      setLoginUser(Cookies.get("user"))
    }
    
},[loginuser]);


  return(

    <div>
              <Layout style={{minHeight: '100vh'}}>
                <Header>
                  <NavHeader/>
                </Header>
                <Content>
                <NavContent order_user={loginuser}/>
                </Content>
                <Footer>
                  <NavFooter></NavFooter>
                </Footer>
              </Layout>
            </div>

  )



}

export default OrderPage;