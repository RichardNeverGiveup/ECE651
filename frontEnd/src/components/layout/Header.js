import React from 'react';
import { Row, Col, Input, Menu, Dropdown, Button } from 'antd';
import { Link } from 'react-router-dom';

const { Search } = Input;
class Header extends React.Component {

    constructor(props) {
        super(props);
        this.handleSignIn = this.handleSignIn.bind(this);
        this.handleNewUser = this.handleNewUser.bind(this);
        this.onSearch = this.onSearch.bind(this);
      }

    handleSignIn() {
        this.props.history.push('/login')
    }

    handleNewUser() {
        console.log('222');
    }

    onSearch(value) {
        console.log(value);
    }

    render() {

        const menu = (
            <Menu
            >
                <Menu.Item key="0">
                    <Button  type="primary" block onClick={this.handleSignIn}>Sign in</Button>
                </Menu.Item>
                <Menu.Item key="1">
                    <Button type="link" block onClick={this.handleNewUser}>
                        {/* New customer? Start here. */}
                        <Link to="/login">New customer? Start here.</Link>
                    </Button>
                </Menu.Item>
            </Menu>
        )

        return (
            <div>
            <Row>
              <Col flex="150px">WATERLOO</Col>
              <Col flex={4}>
                <Search style={{paddingTop: "16px"}} placeholder="Search" allowClear onSearch={this.onSearch} />
              </Col>
              <Col flex={2}>
                <Row justify="end">
                    <Col span={10}>
                    <Dropdown overlay={menu} placement="bottomLeft" arrow>
                        <span>Hello, Sign in</span>
                    </Dropdown>
                    </Col>
                    <Col span={6}>Orders</Col>
                    <Col span={4}>Cart</Col>
                </Row>
              </Col>
            </Row>
            </div>
        );
    }
}

export default Header;