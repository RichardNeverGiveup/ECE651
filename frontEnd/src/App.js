import React from 'react';
import { Layout, Row, Col, Input, Carousel } from 'antd';
import './App.css';
import AddUser from './components/AddUser';

const { Header, Footer, Content } = Layout;
const { Search } = Input;


const onSearch = value => console.log(value);
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
    // const text = this.state.liked ? 'like' : 'haven\'t liked';
    return (
      // <div>
      <Layout style={{minHeight: '100vh'}}>
        <Header>
          <Row>
            <Col flex="150px">WATERLOO</Col>
            <Col flex={4}>
            <Search style={{paddingTop: "16px"}} placeholder="Search" allowClear onSearch={onSearch} />
            </Col>
            <Col flex={2}>
            {/* style={{border:"1px solid red"}} */}
              <Row justify="end">
                <Col span={10}>Hello, sign in</Col>
                <Col span={6}>Orders</Col>
                <Col span={4}>Cart</Col>
              </Row>
            </Col>
          </Row>
        </Header>
        <Content>
          <nav style={navStyle}>Some information about foods</nav>
          <div>
            <Carousel autoplay>
              <div>
                <h3 style={contentStyle}>
                  <img src="image/pet.jpg" alt='logo'></img>
                </h3>
              </div>
              <div>
                <h3 style={contentStyle}>
                <img src="image/newyear.jpg" alt='logo'></img>
                </h3>
              </div>
              <div>
                <h3 style={contentStyle}>
                <img src="image/3.jpg" alt='logo'></img>
                </h3>
              </div>
              <div>
                <h3 style={contentStyle}>
                <img src="image/4.jpg" alt='logo'></img>
                </h3>
              </div>
            </Carousel>
          </div>
          <div> 
            <AddUser/>
            {
              this.state.items.map((item, index) => (
                <p>hello, index</p>
              ))
            }
          </div>
        </Content>
        <Footer>
        <Row justify="space-around">
          <Col span={6}>Conditions of Use</Col>
          <Col span={6}>Privacy Notice</Col>
          <Col span={6}>Interest-Based Ads</Col>
          <Col span={6}>© 2021-2022, waterloo.com, Inc.</Col>
        </Row>
        </Footer>
      </Layout>
      // </div>
      // <p onClick={this.handleClick.bind(this)}>
      //     You {text} this. Click to toggle.
      // </p>
    );
  }
}


const contentStyle = {
  height: '160px',
  color: '#fff',
  lineHeight: '160px',
  textAlign: 'center',
  background: '#364d79',
};

const navStyle = {
  height: '40px',
  lineHeight: '40px',
  color: '#fff',
  textAlign: 'center',
  background: '#282c34',
}

export default App;
