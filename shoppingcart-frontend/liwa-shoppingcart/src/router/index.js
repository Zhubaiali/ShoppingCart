import Vue from 'vue'
import VueRouter from 'vue-router'


const Cart = () => import('views/cart/Cart')
const Product = () => import('views/product/Product')
const Order = () => import('views/order/Order')
const User = () => import('views/user/User')



//通过Vue.use安装vue-router插件
Vue.use(VueRouter)

const routes = [
  {
    path: '',
    redirect: '/product'
  },
  {
    path: '/product',
    component: Product
  },
  {
    path: '/cart',
    component: Cart
  },
  {
    path: '/order',
    component: Order
  },
  {
    path: '/user',
    component: User
  },
  
]

//创建VueRouter对象
const router = new VueRouter({
  routes,
  mode: 'history'
}) 

//导出
export default router