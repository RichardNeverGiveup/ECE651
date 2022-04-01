import React, { useState } from 'react';
import { Menu } from 'antd';

function Sider({category_id}){
  const [current, setCurent] = useState('0');

  const handleClick = e => {
    setCurent(e.key);
    category_id(e.key);
  };

    return (
      <>
        <br />
        <br />
        <Menu
          theme={"dark"}
          onClick={handleClick}
          style={{ width: 200 }}
          defaultOpenKeys={['sub1']}
          selectedKeys={[current]}
          mode="inline"
        >
            <Menu.Item key="0">All</Menu.Item>
            <Menu.Item key="1">Fruit</Menu.Item>
            <Menu.Item key="2">Vegetables</Menu.Item>
            <Menu.Item key="3">Bakery</Menu.Item>
            <Menu.Item key="4">Dairy & Eggs</Menu.Item>
          
          
        </Menu>
      </>
    );
  
}

export default Sider;