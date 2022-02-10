import React from 'react';
import "./index.css"

import { apiAddUser, apiLoginUser } from '../../request/api';
import { useLocation, useNavigate } from 'react-router-dom';

import { Form, Input, Button } from 'antd';
import { Row, Col } from 'antd';
import Cookies from 'js-cookie';


export default function Login() {

  const { state } = useLocation();
  let navigate = useNavigate();

  const onFinish = (values) => {

    const {username, password} = values;

    if(state.status === 1) {
      //login
      apiLoginUser({username, password}).then((res) => {
        // console.log('reslogin_______', res);
        if(res.data.flag === true) {
          navigate("/", {state: {username: username}});
          Cookies.set("user", username);
        }
      }, err => {
        console.log('err', err)
      })
    } else if (state.status === 0) {
      // create
      apiAddUser({username, password}).then((res) => {
        console.log('rescreate_______', res);
      }, err => {
        console.log('err', err)
      })
    }
    
  };

  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <div>
          <div className="register">
            <Row>
              <Col flex="auto"></Col>
              <Col flex="350px">
                <div>
                  <div className="register_header">WATERLOO</div>
                  <div className="register_form">
                    <Form
                      name="basic"
                      labelCol={{ span: 8 }}
                      wrapperCol={{ span: 16 }}
                      initialValues={{ remember: true }}
                      autoComplete="off"
                      onFinish={onFinish}
                      onFinishFailed={onFinishFailed}

                    >
                      <Form.Item
                        label="Username"
                        name="username"
                        rules={[{ required: true, message: 'Please input your username!' }]}
                      >
                        <Input />
                      </Form.Item>
                      {/* <Form.Item
                        name="username"
                        label="E-mail"
                        rules={[
                          {
                            type: 'email',
                            message: 'The input is not valid E-mail!',
                          },
                          {
                            required: true,
                            message: 'Please input your E-mail!',
                          },
                        ]}
                      >
                        <Input />
                      </Form.Item> */}
                      <Form.Item
                        label="Password"
                        name="password"
                        rules={[{ required: true, message: 'Please input your password!' }]}
                      >
                        <Input.Password />
                      </Form.Item>

                      {/* <Form.Item name="remember" valuePropName="checked" wrapperCol={{ offset: 4, span: 20 }}>
                        <Checkbox>Remember me</Checkbox>
                      </Form.Item> */}

                      <Form.Item wrapperCol={{ offset: 4, span: 20 }}>
                        <Button type="primary" htmlType="submit">
                          <p className={state.status === 1 ? 'showSubmit' : 'hiddenSubmit'}>Submit</p>
                          <p className={state.status === 0 ? 'showSubmit' : 'hiddenSubmit'}>Register</p>
                        </Button>
                      </Form.Item>
                    </Form>
                  </div>
                </div>
              </Col>
              <Col flex="auto"></Col>
            </Row>
          </div>
    </div>
  )
}
