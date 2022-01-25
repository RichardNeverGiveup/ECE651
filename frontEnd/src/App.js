import React from 'react';
import { Layout } from 'antd';
import './App.css';
// import AddUser from './components/AddUser';
import { BrowserRouter as Router } from 'react-router-dom';

import NavHeader from './components/layout/Header';
import NavFooter from './components/layout/Footer';
import NavContent from './components/layout/Content';

const { Header, Footer, Content } = Layout;
class App extends React.Component {
  constructor(props) {
    super(props);

    const items = [];
    for (let i = 0; i < 10; i++) {
      items.push({
          name: i,
      });
    }

    this.state = { liked: false, items};
  }

  handleClick(e) {
    this.setState({ liked: !this.state.liked });
  }

  render() {
    return (
      // <Router>
        <Layout style={{minHeight: '100vh'}}>
          <Header>
            <NavHeader></NavHeader>
          </Header>
          <Content>
            <div>
              <NavContent></NavContent>
            </div>
            {/* <div> 
              <AddUser/>
              {
                this.state.items.map((item, index) => (
                  <p>hello, index</p>
                ))
              }
            </div> */}
          </Content>
          <Footer>
            <NavFooter></NavFooter>
          </Footer>
        </Layout>
      // </Router>
    );
  }
}



export default App;
