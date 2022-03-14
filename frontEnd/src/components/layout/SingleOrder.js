import {Link, useParams} from "react-router-dom";
import React, { useEffect, useState } from 'react';
import { Table, Input, Button, Popconfirm, Form,Typography } from 'antd';
import axios from 'axios';
const { Text, Title } = Typography;


function SingleOrder() {

  const columns = [{
    title: 'Product',
    dataIndex: 'name',
    key: 'name',
    width: '20%',
    render: (text, record) => {
       return (
          <div>
           <div>{record.skuId}</div>
           <Link to={'/product/'+ record.skuId }>{record.name}</Link>
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
     }
   ];


    const { order_id } = useParams();

    const[order,setOrder]=useState([]);

    useEffect(()=>{
      axios.get(`http://localhost:9012/orderItem/search?orderId=${order_id}`)
        .then((result)=>{
          setOrder(result.data.data);
        }
      )
      },[order])


      return (
        <div>
        <Title>Order ID - {order_id}</Title>

        <Table
          columns={columns}
          dataSource={order}
          pagination={false}
          bordered
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
                </Table.Summary.Row>
              </>
            );
          }}
        />

        </div>
      );


}

export default SingleOrder;
