import React, { useState, useEffect } from 'react';
import { Row, Col, Input, Menu, Dropdown, Button } from 'antd';
import { Link } from 'react-router-dom';
// import { useLocation, useNavigate, useParams } from 'react-router-dom';
import Cookies from 'js-cookie';

const { Search } = Input;

const menu = (
    <Menu
    >
        <Menu.Item key="0">
            <Button  type="primary" block>
                <Link to="/login" state={{ status: 1 }}>Sign in</Link>
            </Button>
        </Menu.Item>
        <Menu.Item key="1">
            <Button type="link" block>
                <Link to="/login" state={{ status: 0 }}>New customer? Start here.</Link>
            </Button>
        </Menu.Item>
    </Menu>
)

export default function Header({navigation, route})  {

    const [ name, setName ] = useState()
    useEffect(() => {
        console.log("route", route);
        console.log('username', Cookies.get("user"))
        if(Cookies.get("user")) {
            setName(Cookies.get("user"))
        }
    });

    const onSearch = (value) => {
        console.log(value);
    }

    return (
        <div>
            <Row>
            <Col flex="150px">WATERLOO</Col>
            <Col flex={4}>
                <Search style={{paddingTop: "16px"}} placeholder="Search" allowClear onSearch={onSearch} />
            </Col>
            <Col flex={2}>
                <Row justify="end">
                    <Col span={10}>
                        {
                            !name && 
                        <Dropdown overlay={menu} placement="bottomLeft" arrow>
                            <span>Hello, Sign in</span>
                        </Dropdown>
                        }
                        {
                            <span>Hello, {name}</span>
                        }
                    </Col>
                    <Col span={6}>Orders</Col>
                    <Col span={4}>Cart</Col>
                </Row>
            </Col>
            </Row>
        </div>
    );
}