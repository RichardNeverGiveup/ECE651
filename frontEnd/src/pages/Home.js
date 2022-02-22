import React from 'react';

import NavHeader from '../components/layout/Header';
import NavFooter from '../components/layout/Footer';
import NavContent from '../components/layout/Content';
import NavSider from '../components/layout/Sider';
import { Layout } from 'antd';
const { Header, Footer, Content,Sider } = Layout;


class Home extends React.Component {

    render() {
        return (
            <div>
              <Layout style={{minHeight: '100vh'}}>
                <Header>
                  <NavHeader></NavHeader>
                </Header>
                <Layout>
                <Sider>
                <NavSider></NavSider>
                </Sider>
                <Content>
                  <NavContent></NavContent>
                </Content>
                </Layout>
                <Footer>
                  <NavFooter></NavFooter>
                </Footer>
              </Layout>
            </div>
        );
    }
}

export default Home;