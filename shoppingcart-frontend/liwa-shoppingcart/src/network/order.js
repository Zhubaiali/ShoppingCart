import {request} from './request'
import store from '../store/index'

export function getOrdersByUserId() {
  return request({
    url: '/order/user/' + store.state.user_id,
  })
}

export function createOrder(params) {
  return request({
    url: '/order/user/' + store.state.user_id + '/create',
    method: 'post',
    data: params,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}


