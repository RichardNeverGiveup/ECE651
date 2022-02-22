import React, { useEffect, useState } from 'react';
import { Carousel, Card, Col, Row} from 'antd';
import './main.css';
const {Meta} = Card;


// class Content extends React.Component {

//     render() {
//         return (
//             <div>
//               {/* <nav style={navStyle}>Some information about foods</nav>
//                 <Carousel autoplay>
//                   <div>
//                     <h3 style={contentStyle}>
//                       <img src="image/pet.jpg" alt='logo'></img>
//                     </h3>
//                   </div>
//                   <div>
//                     <h3 style={contentStyle}>
//                     <img src="image/newyear.jpg" alt='logo'></img>
//                     </h3>
//                   </div>
//                   <div>
//                     <h3 style={contentStyle}>
//                     <img src="image/3.jpg" alt='logo'></img>
//                     </h3>
//                   </div>
//                   <div>
//                     <h3 style={contentStyle}>
//                     <img src="image/4.jpg" alt='logo'></img>
//                     </h3>
//                   </div>
//                 </Carousel> */}
//             </div>
//         );
//     }
// }

// const contentStyle = {
//     height: '160px',
//     color: '#fff',
//     lineHeight: '160px',
//     textAlign: 'center',
//     background: '#364d79',
// };

// const navStyle = {
//     height: '40px',
//     lineHeight: '40px',
//     color: '#fff',
//     textAlign: 'center',
//     background: '#282c34',
// }
  

// export default Content;


export default function Content()  {
  const[products,setProducts]=useState([])

    useEffect(()=>{
        fetch("http://192.168.1.3:9011/product")
        .then(res=>res.json())
        .then((result)=>{
            setProducts(result.data);
        }
      )
      },[])

      return (
        <div className="site-card-wrapper">

      <Row gutter={[16, 24]}>
            {products.map(product=>(
              <Col className="gutter-row" span={4} key = {product.sku}>
            <Card hoverable style={{ height: 400 }} bordered={false} key = {product.sku} cover={<img alt={product.name} src={product.image} />}>
            <Meta title={ product.name } />
             ${product.price/100}/{product.unit}
            </Card>
            </Col>
            ))}
    </Row>
   
        </div>

      )


}


