import { Link } from 'react-router-dom';
import React, { useContext, useState, useEffect, useRef } from 'react';
import { Table, Input, Button, Popconfirm, Form,Typography, message } from 'antd';
import { FormInstance } from 'antd/lib/form';
import axios from 'axios';
import Cookies from 'js-cookie';

const { Text, Title } = Typography;



function ShoppingCart() {

  const [loginuser, setLoginUser] = useState("");

  useEffect(() => {
    if(Cookies.get("user")) {
      setLoginUser(Cookies.get("user"))
    }
    
},[loginuser]);



  const[cart,setCarts]=useState([])

  useEffect(()=>{
    axios.get(`http://localhost:9012/cart/showCart?username=${loginuser}`)
    .then((result)=>{
      setCarts(result.data.data);
    }
  )
  },[cart])




    const columns = [{
        title: 'Product',
        dataIndex: 'name',
        key: 'name',
        width: '20%',
        render: (text, record) => {
           return (
            <div>
            <img src={record.image} style={{height: '30%', width: '30%' }}/>
              <div>
               <div>{record.sku}</div>
               <Link to={'/product/'+ record.sku }>{record.name}</Link>
               </div>
            </div>
          );},
        }, 
       {
        title: 'Price/Unit',
        dataIndex: 'price', 
        key: 'price',  
        render: (text, record) => {
            return (
             <div>
                 ${(record.price/100).toFixed(2)}
             </div>
           );},
         }, 
       {
        title: 'Number',
        dataIndex: 'num', 
        key: 'num',
       },
       {
        title: 'Total',
        dataIndex: 'total', 
        key: 'total',  
        render: (text, record) => {
            return (
             <div>
                 ${(record.num*record.price/100).toFixed(2)}
             </div>
           );},
         },
         {
            title: 'operation',
            dataIndex: 'operation',
            render: (_, record) => {
                return (
                    <Popconfirm onConfirm={() => deleteSingleItem(record.sku)} title="Sure to delete?">
                  <a>Delete</a>
                </Popconfirm>
                  );},
          },
       ];


       function deleteSingleItem(sku) {
        axios.delete(`http://localhost:9012/cart/deleteSingle?username=${loginuser}&sku=${sku}`).then(function (response) {
          if(response.data.flag === true) {
            message.success('Item removed!');
        
          } else {
            message.error('Try Again!');
          }
        
        }, err => {
          console.log('err', err)
        })
       
      }
    

    

    return (
        <div>
        <Title>Shopping Cart </Title>


        <Table
          columns={columns}
          dataSource={cart}
          pagination={false}
          bordered
          rowKey="sku" 
          summary={pageData => {
            let totalpayment = 0;
    
            pageData.forEach(({price, num}) => {
                totalpayment += price * num/100;
            });
    
            return (
              <>
                <Table.Summary.Row>
                <Table.Summary.Cell></Table.Summary.Cell>
                <Table.Summary.Cell></Table.Summary.Cell>
                  <Table.Summary.Cell>Total</Table.Summary.Cell>
                  <Table.Summary.Cell>
                    <Text strong type="danger">${(totalpayment).toFixed(2)}</Text>
                  </Table.Summary.Cell>
                  <Table.Summary.Cell><Button type="primary" shape="round" size={'large'}>
                Check Out
              </Button></Table.Summary.Cell>
                </Table.Summary.Row>
              </>
            );
          }}
        />

        </div>
      );


}

export default ShoppingCart;