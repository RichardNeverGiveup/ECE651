import api from './index';


export const apiAddUser = params => api.post('/user/add', params);