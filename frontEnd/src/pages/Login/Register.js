import React from 'react';
import "./index.css"

import { apiAddUser, apiLoginUser } from '../../request/api';
import { useLocation, useNavigate } from 'react-router-dom';

import { Form, Input, Button, Tooltip, Space, message, Row, Col, Popover} from 'antd';
import { QuestionCircleOutlined } from '@ant-design/icons';
import Cookies from 'js-cookie';

const content = (
  <div>
    <p>Password must contain at least one digit [0-9].</p>
    <p>Password must contain at least one lowercase Latin character [a-z].</p>
    <p>Password must contain at least one uppercase Latin character [A-Z].</p>
    <p>Password must contain at least one special character like ! @ # $ % ^ & *</p>
    <p>Password must contain a length of at least 8 characters and a maximum of 20 characters.</p>
  </div>
);


export default function Login({Login}) {

  const { state } = useLocation();

  let navigate = useNavigate();

  const onFinish = (values) => {

    const {username, password} = values;

    if(state.status === 1) {
      //login
      apiLoginUser({username, password}).then((res) => {
        if(res.data.flag === true) {
          message.success('Success login!');
          Cookies.set("user", username);
          navigate("/", {state: {username: username}});
        } else {
          message.error('Failed login!');
        }
      }, err => {
        console.log('err', err)
      })
    } else if (state.status === 0) {
      const isValidUser = checkValidUser(username, password);
      console.log('isValidUser', isValidUser)

      if (isValidUser){


        apiAddUser({username, password}).then((res) => {
          console.log(res.data);
          if(res.data.flag === false) {
            message.error('Error: ' + res.data.message);
          } else {
            message.success('Success created!');
            Cookies.set("user", username);
            navigate("/", {state: {username: username}});
          }
        }, err => {
          message.error('Error: failed created!');
          console.log('err', err)
        })

      } else {
        message.error('Error: Invalid Password!');

      }
      
    }
  
  };

  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  const checkValidUser = (username, password) => {

    /*
    Secure Password requirements
    Password must contain at least one digit [0-9].
    Password must contain at least one lowercase Latin character [a-z].
    Password must contain at least one uppercase Latin character [A-Z].
    Password must contain at least one special character like ! @ # $ % ^ & *
    Password must contain a length of at least 8 characters and a maximum of 20 characters.
    */

    if(username.length < 4 || username.length > 8) {
      return false;
    }

    let regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
    let valid = password.match(regularExpression);


    return valid == null ? false : true;

  }

  return (
    <div data-testid="Register-1">
          <div className="register">
            <Row>
              <Col flex="auto"></Col>
              <Col flex="400px">
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
                      <Space>
                        <Form.Item
                          label="Username"
                          name="username"
                          rules={[{ required: true, message: 'Please input!' }]}
                        >
                          <Input style={{ width: 200 }} />
                        </Form.Item>
                      </Space>
                      <Space>
                        <Tooltip className="notice_user"  placement="bottomLeft"  title="4 - 8 characters">
                            <QuestionCircleOutlined />
                        </Tooltip>
                     </Space>


                      <Space>
                        <Form.Item
                          label="Password"
                          name="password"
                          rules={[{ required: true, message: 'Please input!' }]}
                        >
                          <Input.Password style={{ width: 200 }} />
                        </Form.Item>
                      </Space>
                      <Space>
                      <Popover className = "notice" content={content} title="Secure Password requirements">
                      <QuestionCircleOutlined />
                      </Popover>
                     </Space>

                      <Form.Item wrapperCol={{ offset: 4, span: 20 }}>
                        <Button type="primary" htmlType="submit" >
                          <p className = {state && state.status === 1 ? 'showSubmit' :  'hiddenSubmit'}> Submit </p> 
                          <p className = {state && state.status === 0 ? 'showSubmit' :  'hiddenSubmit'}> Register </p>
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