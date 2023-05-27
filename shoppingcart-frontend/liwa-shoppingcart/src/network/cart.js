import {request} from './request'

export function getCartItems() {
  return request({
    url: '/cart/user/1',
    params: {
      userId: 1,
      pageNum: 1,
      pageSize: 9,
    }
  })
}



