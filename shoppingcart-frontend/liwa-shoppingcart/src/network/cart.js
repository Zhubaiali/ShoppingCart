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
export function removeFromCart(productId) {
  return request({
    url: '/cart/user/' + store.state.user_id + '/remove/' + productId,
    method: 'post',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}

export function decreaseQuantity(productId,params) {
  return request({
    url: '/cart/user/' + store.state.user_id + '/decrease/' + productId,
    method: 'post',
    data: params,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}



