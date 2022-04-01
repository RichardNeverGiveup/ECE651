import React, { useEffect, useState } from 'react';
import { Card, Col, Row} from 'antd';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './main.css';
const {Meta} = Card;

function Content(props)  {
  const[products,setProducts]=useState([])


    useEffect(()=>{
      if (props.product_search.length === 0){

        if (props.category_id === '0'){
          axios.get(`http://localhost:9011/product`)
          .then((result)=>{
              setProducts(result.data.data);
          }
        )
        } else {
          axios.get(`http://localhost:9011/product/category?category_id=${parseInt(props.category_id)}`)
        .then((result)=>{
            setProducts(result.data.data);
        }
      )

        }

        

      } else {
        axios.get(`http://localhost:9011/product/name?name=${props.product_search}`)
        .then((result)=>{
            setProducts(result.data.data);
        }
      )

      }
        
      })


      return (
        <div className="site-card-wrapper">

      <Row gutter={[16, 24]}>
            {products.map(product=>(
              <Col className="gutter-row" span={4} key = {product.sku}>
              <Link to={'/product/'+ product.sku } >
            <Card hoverable  bordered={false} key = {product.sku} cover={<img alt={product.name} src={product.image}/>}>
            <Meta title={ product.name } />
             ${product.price/100}/{product.unit}
            </Card>
            </Link>
            </Col>
            
            ))}
    </Row>
   
        </div>

      )


};

export default Content;


