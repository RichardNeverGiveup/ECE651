import { useParams} from "react-router-dom";
import React, { useEffect, useState } from 'react';
import { Image, Row, Col, Space, Button,InputNumber} from 'antd';
import axios from 'axios';

function ProductDetail() {


    const { product_id } = useParams();

    const[product,setProduct]=useState([]);

    useEffect(()=>{
        axios.get(`http://localhost:9011/product/${product_id}`)
        .then((result)=>{
            setProduct(result.data.data);
        }
      )
      },[product])


    return (
  
    <div className="space-align-container">
    <div className="space-align-block">
    <Row justify="center">

    <Space align="center">
<span className="mock-block"><Image
    src={product.image}
    /></span>

<span className="mock-block"> <h1>{product.name}</h1>
      <div>{product.sku}</div>
      <div style={{ marginTop: 20 }}>
      <h1>${(product.price/100).toFixed(2)}/{product.unit}</h1>
      </div>
      <InputNumber defaultValue={1} />
      <div style={{ marginTop: 20 }}>
      <Button type="primary">Add to shopping cart</Button>
      </div>
      </span>
      </Space>

      </Row>

    
    </div>

    </div>

  
  

        
      );


}

export default ProductDetail;
