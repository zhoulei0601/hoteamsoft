import axios from 'axios'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
// 创建axios实例
const service = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: process.env.VUE_APP_BASE_API,
  // 超时
  timeout: 10000
})

// request拦截器
service.interceptors.request.use(config => {
  
  return config
}, error => {
    console.error(error)
    Promise.reject(error)
})

// 响应拦截器
service.interceptors.response.use(res => {
     // 未设置状态码则默认成功状态
  const code = res.data.code || 200;
  if(res.request.responseType ===  'blob' || res.request.responseType ===  'arraybuffer'){
    return res.data
  }
  if (code == 200) {
    return res.data
  } else {
    console.error(res)
    return Promise.reject('error');
  }
  },
  error => {
    console.error('err' + error)
    return Promise.reject(error)
  }
)

export default service
