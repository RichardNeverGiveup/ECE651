import api from './index';


export const apiAddUser = params => api.post('/user/add', params);

export const apiLoginUser = params => api.post('/user/login', params);

export const apigetProductbyCategory = params => api.post('/product/category', params);
