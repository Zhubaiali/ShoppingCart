import {request} from './request'

export function getCartItems() {
  return request({
    url: '/cart_list'
  })
}



