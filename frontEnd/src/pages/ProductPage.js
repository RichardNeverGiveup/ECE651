import React from 'react';

import NavHeader from '../components/layout/Header';
import NavFooter from '../components/layout/Footer';
import NavContent from '../components/layout/ProductDetail';
import { Layout } from 'antd';
const { Header, Footer, Content } = Layout;


class ProductPage extends React.Component {
    render() {
        return (
            <div>
              <Layout style={{minHeight: '100vh'}}>
                <Header>
                  <NavHeader></NavHeader>
                </Header>
                <Content>
                  <NavContent></NavContent>
                </Content>
                <Footer>
                  <NavFooter></NavFooter>
                </Footer>
              </Layout>
            </div>
        );
    }
}

export default ProductPage;