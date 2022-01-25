import React from 'react';
import { Carousel } from 'antd';

class Content extends React.Component {

    render() {
        return (
            <div>
            <nav style={navStyle}>Some information about foods</nav>
              <Carousel autoplay>
                <div>
                  <h3 style={contentStyle}>
                    <img src="image/pet.jpg" alt='logo'></img>
                  </h3>
                </div>
                <div>
                  <h3 style={contentStyle}>
                  <img src="image/newyear.jpg" alt='logo'></img>
                  </h3>
                </div>
                <div>
                  <h3 style={contentStyle}>
                  <img src="image/3.jpg" alt='logo'></img>
                  </h3>
                </div>
                <div>
                  <h3 style={contentStyle}>
                  <img src="image/4.jpg" alt='logo'></img>
                  </h3>
                </div>
              </Carousel>
            </div>
        );
    }
}

const contentStyle = {
    height: '160px',
    color: '#fff',
    lineHeight: '160px',
    textAlign: 'center',
    background: '#364d79',
};

const navStyle = {
    height: '40px',
    lineHeight: '40px',
    color: '#fff',
    textAlign: 'center',
    background: '#282c34',
}
  

export default Content;