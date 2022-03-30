import React, { useState, useEffect } from 'react';
import { Row, Col, Input, Menu, Dropdown, Button, Badge, Avatar } from 'antd';
import { Link } from 'react-router-dom';
import { ShoppingCartOutlined } from '@ant-design/icons';

// import { useLocation, useNavigate, useParams } from 'react-router-dom';
import Cookies from 'js-cookie';

const { Search } = Input;

export default function Header({navigation, route, searchparam})  {
    let [ name, setName ] = useState()

    useEffect(() => {
        if(Cookies.get("user")) {
            setName(Cookies.get("user"))
        }
        
    });

    const signOut = () => {
        setName("");
        Cookies.remove("user");
    }


    const onSearch = (value) => {
        searchparam(value);
    }

    const menu_out = (
        <Menu
        >
            <Menu.Item key="2">
                <Button type="primary" block>
                    <div onClick={signOut}>Sign out</div>
                </Button>
            </Menu.Item>
        </Menu>
    )

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
    
    return (
        <div>
            <Row>
            <Col flex="150px"><Link to={'/' } >WATERLOO</Link></Col>
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
                           name && 
                           <Dropdown overlay={menu_out} placement="bottomLeft" arrow>
                                <span>Hello, {name}</span>
                          </Dropdown>
                        }
                    </Col>
                    <Col span={6}><Link to={'/order'}>Orders</Link></Col>
                    <Col span={4}> 
                    <Badge>
                    <Link to={'/cart' } >
                        <Avatar shape="square" style={{ backgroundColor: '#87d068' }}  icon={<ShoppingCartOutlined />} /></Link>
                    </Badge>
                        </Col>
                </Row>
            </Col>
            </Row>
        </div>
    );
}