import {request} from './request'
import store from "@/store";

export function register(data) {
  return request({
    url: '/user/register',
    method: 'post',
    data:data
  })
}

export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data:data
  })
}

export function updateLocation(params) {
  return request({
    url: '/user/' + store.state.user_id + '/location',
    method: 'patch',
    data: params,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}




