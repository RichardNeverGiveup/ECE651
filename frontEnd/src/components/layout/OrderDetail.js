import React, { useEffect, useState } from 'react';
import {Table, Typography } from 'antd';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './main.css';

const { Title } = Typography;


function OrderDetail(props)  {


  const[orders,setOrders]=useState([])

  useEffect(()=>{
    axios.get(`http://localhost:9012/order/user?username=${props.order_user}`)
    .then((result)=>{
      setOrders(result.data.data);
    }
  )
  },[orders])

  const columns = [
    {
      title: 'Order ID',
      dataIndex: 'id',
      key: 'id',
      render: (text, record) => {
        return (
           <div>
            <Link to={'/orderById/'+ record.id }>{record.id}</Link>
            </div>
       );},
    },
    {
      title: 'Total Number of Items',
      dataIndex: 'totalNum',
      key: 'totalNum',
    },
    {
      title: 'Total Payment',
      dataIndex: 'totalMoney',
      key: 'totalMoney',
      render: (text, record) => {
        return (
         <div>
             ${(record.totalMoney/100).toFixed(2)}
         </div>
       );},
    },
    {
      title: 'Order Date',
      key: 'created',
      dataIndex: 'created',
      render: (text, record) => {
        return (
         <div>
             {record.created.split(" ")[0]}
         </div>
       );},
    },
  ];

  return (
    <div >
      <Title>Order History</Title>
      <Table columns={columns} dataSource={orders} />

    </div>
  );


}

export default OrderDetail;


