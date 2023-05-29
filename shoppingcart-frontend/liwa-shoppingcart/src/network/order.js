import {request} from './request'
import store from '../store/index'

export function getOrdersByUserId() {
  return request({
    url: '/order/user/' + store.state.user_id,
  })
}



