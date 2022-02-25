import React, { useState } from 'react';

import NavHeader from '../components/layout/Header';
import NavFooter from '../components/layout/Footer';
import NavContent from '../components/layout/Content';
import NavSider from '../components/layout/Sider';
import { Layout } from 'antd';
const { Header, Footer, Content,Sider } = Layout;


function Home() {

  const [category, setCategory] = useState('0');
  const [searchparam, setSearchparam] = useState("");
  const [key, setKey] = useState("");

  const passCategoryID = (childdata) => {
    setCategory(childdata);
    setKey(`${childdata}_${searchparam}`);
  }

  const passSearchparam = (childdata) => {
    setSearchparam(childdata);
    setKey(`${category}_${childdata}`);
  }


        return (
            <div>
              <Layout style={{minHeight: '100vh'}}>
                <Header>
                  <NavHeader searchparam = {passSearchparam}/>
                </Header>
                <Layout>
                <Sider>
                <NavSider category_id = {passCategoryID}/>
                </Sider>
                <Content>
                  <NavContent category_id={category} product_search={searchparam} key={key}/>
                </Content>
                </Layout>
                <Footer>
                  <NavFooter></NavFooter>
                </Footer>
              </Layout>
            </div>
        );
    
}

export default Home;