import {request} from './request'

export function getCartItems() {
  return request({
    url: '/user/1/cart',
    params: {
      userId: 1,
      pageNum: 1,
      pageSize: 9,
    }
  })
}



