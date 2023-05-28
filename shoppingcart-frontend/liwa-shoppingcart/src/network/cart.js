import {request} from './request'
import store from '../store/index'

export function getCartItems() {
  return request({
    url: '/cart/user/' + store.state.user_id,
  })
}



