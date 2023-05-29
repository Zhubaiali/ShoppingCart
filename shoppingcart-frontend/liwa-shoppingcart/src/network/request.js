import axios from 'axios'

export function request(config) {
  //1.创建axios实例
  const instance = axios.create({
    /* 接口地址在这里更改 */

    baseURL: 'http://192.168.0.82:8088',
    timeout: 5000,
    headers: {
      'Content-Type': 'application/json'
    }
  })

  //2.axios拦截器
  //请求拦截
  instance.interceptors.request.use(config => {
    return config
  }, err => {
    console.log(err)
  })

  //相应拦截
  instance.interceptors.response.use(res => {
    return res.data
  }, err => {
    console.log(err)
  })

  //3.发送真正的网络请求
  return instance(config)
}
