import axios from 'axios';
import QS from 'qs';
import Vue from 'vue';

//环境切换时的url设置
if (process.env.NODE_ENV === 'development') {
  axios.defaults.baseURL = 'api';
} else if (process.env.NODE_ENV === 'debug') {
  axios.defaults.baseURL = 'api';
} else if (process.env.NODE_ENV === 'production') {

}

//请求超时时间
axios.defaults.timeout = 10000;



//请求拦截器
axios.interceptors.request.use(
  config => {
      return config;
  },
  error => {
    return Promise.reject(error);
  }
)


//响应拦截器
axios.interceptors.response.use(
  response => {
    if (response.status === 200) {
      return Promise.resolve(response);
    } else {
      return Promise.reject(response);
    }
  }, error => {
    if (error.response.status) {
      switch (error.response.status) {
        /**
         * 401 代表用户名密码错误
         */
        case 401:
          Vue.prototype.$message({
            type: 'error',
            message: '用户用户名或密码错误',
            showClose: true
          })
          break;
        case 404:
          Vue.prototype.$message({
            type:'error',
            message:'服务器请求错误',
            showClose:true
          })
          break;
        case 503:
          Vue.prototype.$message({
            type:'error',
            message:'没有权限访问',
            showClose:true
          })
        default:
          Vue.prototype.$message.$message({
            type: 'error',
            message: error.response.data.msg,
            showClose: true
          })
      }
      return Promise.reject(error.response);
    }
  }
)


/**
 * get方法，对应get请求
 * @param {String} url  [请求的url地址]
 * @param {Object} params  [请求携带的参数]
 */
export function get(url,params){
  return new Promise(((resolve, reject) => {
    axios.get(url,{
      params:params
    })
      .then(res=>{
        resolve(res.data)
      })
      .catch(err=>{
        reject(err.data)
      })
  }));
}

/**
 * post方法，对应post请求
 * @param {String} url  [请求的url地址]
 * @param {Object} params  [请求携带的参数]
 */
export function post(url,params){
  return new Promise(((resolve, reject) => {
    axios.post(url,params)
      .then(res=>{
        resolve(res.data.data)
      })
      .catch(err=>{
        reject(err.data)
      })
  }));
}
