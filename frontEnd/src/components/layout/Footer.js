import React from 'react';
import { Row, Col } from 'antd';

class Footer extends React.Component {

    render() {
        return (
            <div>
                <Row justify="space-around">
                    <Col span={6}>Conditions of Use</Col>
                    <Col span={6}>Privacy Notice</Col>
                    <Col span={6}>Interest-Based Ads</Col>
                    <Col span={6}>© 2021-2022, waterloo.com, Inc.</Col>
                </Row>
            </div>
        );
    }
}

export default Footer;