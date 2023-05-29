import {request} from './request'
import store from '../store/index'

export function getAllProducts() {
  return request({
    url: '/product'
  })
}



