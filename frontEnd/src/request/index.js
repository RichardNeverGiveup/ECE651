import axios from 'axios';
// import QS from 'qs';
import { message } from 'antd'

const service = axios.create({
  baseURL: 'http://127.0.0.1:8080/',
  timeout: 5000,
  headers:{"Content-Type":"application/json"},
});

// Add a request interceptor

service.interceptors.request.use(config => {

  // before request is sent
  // const token = window.localStorage.getItem('userToken') || window.sessionStorage.getItem('userToken');

  // config.data = Object.assign({}, config.data, {
  //   token: token,
  // });

  // // config.headers = {
  // //   'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
  // // }

  console.log('config____', config)

  config.data = JSON.stringify(config.data);

  console.log('config', config)
  
  return config;
}, error => {

  // request error
  return Promise.reject(error);
  // return error;
});



service.interceptors.response.use(response => {

  // Any status code that lie within the range of 2xx cause this function to trigger
  // Do something with response data
  if (response.code) {
    switch (response.code) {
      case 200:
        return response.data;
      case 401:
        //未登录处理方法
        break;
      case 403:
        //token过期处理方法
        break;
      default:
        message.error(response.data.msg)
    }
  } else { 
    return response;
  }
}, error => {
  return Promise.reject(error);
})
//最后把封装好的axios导出
export default service