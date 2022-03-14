import { Link } from 'react-router-dom';
import React, { useContext, useState, useEffect, useRef } from 'react';
import { Table, Input, Button, Popconfirm, Form,Typography } from 'antd';
import { FormInstance } from 'antd/lib/form';
import axios from 'axios';
const { Text, Title } = Typography;



  
  const data = [{"sku":"05004301","name":"Carrot","price":218,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/0/5/050043_1_.jpg","unit":"lb","create_time":null,"update_time":null,"spu_id":null,"category_id":2,"category_name":"Vegetables","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05005201","name":"English Cucumber","price":219,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/0/5/0500520111591000936_1.jpg","unit":"Each","create_time":null,"update_time":null,"spu_id":null,"category_id":2,"category_name":"Vegetables","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05012802","name":"Portobella","price":440,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/aa1fabd47a3f84eab5e6284c3811b7c1/0/5/050128_-_portobella.jpg","unit":"lb","create_time":null,"update_time":null,"spu_id":null,"category_id":2,"category_name":"Vegetables","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05024201","name":"Fresh Banana","price":200,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/0/5/050242-banana.jpg","unit":"lb","create_time":null,"update_time":null,"spu_id":null,"category_id":1,"category_name":"Fruits","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05029601","name":"Orange","price":200,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/5/0/50296-__03.jpg","unit":"lb","create_time":null,"update_time":null,"spu_id":null,"category_id":1,"category_name":"Fruits","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05031401","name":"Pomegranate","price":500,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/0/5/050314_.jpg","unit":"Each","create_time":null,"update_time":null,"spu_id":null,"category_id":1,"category_name":"Fruits","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05034601","name":"Gala Apple","price":300,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/5/0/50346_gala_apple.jpg","unit":"lb","create_time":null,"update_time":null,"spu_id":null,"category_id":1,"category_name":"Fruits","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05044501","name":"Tomato","price":386,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/5/0/50445_copy_1.jpg","unit":"Pack","create_time":null,"update_time":null,"spu_id":null,"category_id":2,"category_name":"Vegetables","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"},{"sku":"05051701","name":"Watermelon","price":769,"num":10,"image":"https://www.tntsupermarket.com/media/catalog/product/cache/3489f2ad89d637baa4f5c5309861a9de/m/i/mini-watermelon.jpg","unit":"Each","create_time":null,"update_time":null,"spu_id":null,"category_id":1,"category_name":"Fruits","brand_name":null,"spec":null,"sale_num":0,"comment_num":0,"status":"1"}]
  


function ShoppingCart() {

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
                    <Popconfirm title="Sure to delete?">
                  <a>Delete</a>
                </Popconfirm>
                  );},
          },
       ];


    

    return (
        <div>
        <Title>Shopping Cart </Title>


        <Table
          columns={columns}
          dataSource={data}
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