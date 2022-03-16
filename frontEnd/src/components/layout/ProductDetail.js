import { useParams} from "react-router-dom";
import React, { useEffect, useState } from 'react';
import { Image, Row, message, Space, Button,InputNumber} from 'antd';
import axios from 'axios';
import Cookies from 'js-cookie';


function ProductDetail() {

  const [loginuser, setLoginUser] = useState("");

  useEffect(() => {
    if(Cookies.get("user")) {
      setLoginUser(Cookies.get("user"))
    }
    
},[loginuser]);


    const { product_id } = useParams();

    const[product,setProduct]=useState([]);

    useEffect(()=>{
        axios.get(`http://localhost:9011/product/${product_id}`)
        .then((result)=>{
            setProduct(result.data.data);
        }
      )
      },[product])

      function addCart(e){
        axios.post(`http://localhost:9012/cart/addCart?num=${document.getElementById('num').value}&username=${loginuser}&sku=${product_id}`).then(function (response) {
          if(response.data.flag === true) {
            message.success('Added to cart!');
        
          } else {
            message.error('Try Again!');
          }
        }, err => {
          console.log('err', err)
        })
      }



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
      <InputNumber id="num" min={1} max={10} defaultValue={1}/>
      <div style={{ marginTop: 20 }}>
      <Button type="primary" onClick={addCart}>Add to shopping cart</Button>
      </div>
      </span>
      </Space>

      </Row>

    
    </div>

    </div>

  
  

        
      );


}

export default ProductDetail;
