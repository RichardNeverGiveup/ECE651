import axios from 'axios'

const instance = axios.create({
    baseURL: "http://0.0.0.0:8589"
});

export default {

    getHello: () =>
    instance({
        'method':'GET',
        'url':'/hi',
    }),

    getDate: () =>
    instance({
        'method':'GET',
        'url':'/date',
    }),

    getUser: () =>
    instance({
        'method':'GET',
        'url':'/api/getUser',
    }),

    registerUser: () =>
    instance({
        'method':'POST',
        'url':'/api/registerUser',
    }),

    getToken: (info) =>
    instance({
        'method':'POST',
        'url':'/api/getToken',
        'data':info
    }),

    setToken: (token) => {
        if (!instance.defaults.headers.common['Authorization']){
            instance.defaults.headers.common['Authorization'] = token;
        }
    },

    isTokenValid: () =>
    instance({
        'method':'POST',
        'url':'/api/isTokenValid',
    })

}