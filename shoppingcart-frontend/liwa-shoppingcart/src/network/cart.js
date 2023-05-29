import {request} from './request'
import store from '../store/index'

export function getCartItems() {
  return request({
    url: '/cart/user/' + store.state.user_id,
  })
}

export function addToCart(productId,params) {
  return request({
    url: '/cart/user/' + store.state.user_id + '/add/' + productId,
    method: 'post',
    data: params,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}



