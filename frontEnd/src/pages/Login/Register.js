import React from 'react';
import "./index.css"

import { apiAddUser } from '../../request/api';

import { Form, Input, Button, Checkbox } from 'antd';
import { Row, Col } from 'antd';

class Login extends React.Component {

  formRef = React.createRef()

  onFinish = values => {

    const {username, password} = values

    apiAddUser({username, password}).then((res) => {
      console.log('res_______', res);
    }, err => {
      console.log('err', err)
    })
  }


  onFinishFailed = errorInfo => {
    console.log('Failed:', errorInfo);
  }

  render() {
      return (
          <div className="register">
            <Row>
              <Col flex="auto"></Col>
              <Col flex="350px">
                <div>
                  <div className="register_header">WATERLOO</div>
                  <div className="register_form">
                    <Form
                      ref={this.formRef}
                      name="basic"
                      labelCol={{ span: 8 }}
                      wrapperCol={{ span: 16 }}
                      initialValues={{ remember: true }}
                      autoComplete="off"
                      onFinish={this.onFinish}
                      onFinishFailed={this.onFinishFailed}

                    >
                      <Form.Item
                        label="Username"
                        name="username"
                        rules={[{ required: true, message: 'Please input your username!' }]}
                      >
                        <Input />
                      </Form.Item>

                      <Form.Item
                        label="Password"
                        name="password"
                        rules={[{ required: true, message: 'Please input your password!' }]}
                      >
                        <Input.Password />
                      </Form.Item>

                      <Form.Item name="remember" valuePropName="checked" wrapperCol={{ offset: 4, span: 20 }}>
                        <Checkbox>Remember me</Checkbox>
                      </Form.Item>

                      <Form.Item wrapperCol={{ offset: 4, span: 20 }}>
                        <Button type="primary" htmlType="submit">
                          Submit
                        </Button>
                      </Form.Item>
                    </Form>
                  </div>
                </div>
              </Col>
              <Col flex="auto"></Col>
            </Row>
          </div>
      );
  }
}


export default Login;
