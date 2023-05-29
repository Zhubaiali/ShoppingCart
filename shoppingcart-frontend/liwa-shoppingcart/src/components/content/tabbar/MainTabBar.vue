<template>
  <div>
    <tab-bar>
      <tab-bar-item path='/cart' colorActive='var(--color-high-text)'>
        <img slot='item-icon' src="~assets/img/tabbar/cart.svg" alt="" />
        <img slot='item-active' src="~assets/img/tabbar/cart-active.svg" alt="" />
        <div slot='item-text'>购物车</div>
      </tab-bar-item>
      <tab-bar-item path='/product' colorActive='var(--color-high-text)'>
        <img slot='item-icon' src="~assets/img/tabbar/goods.svg" alt="" />
        <img slot='item-active' src="~assets/img/tabbar/goods-active.svg" alt="" />
        <div slot='item-text'>商品</div>
      </tab-bar-item>
      <tab-bar-item path='/order' colorActive='var(--color-high-text)'>
        <img slot='item-icon' src="~assets/img/tabbar/order.svg" alt="" />
        <img slot='item-active' src="~assets/img/tabbar/order-active.svg" alt="" />
        <div slot='item-text'>订单</div>
      </tab-bar-item>
      <tab-bar-item path='/user' colorActive='var(--color-high-text)'>
        <img slot='item-icon' src="~assets/img/tabbar/user.svg" alt="" />
        <img slot='item-active' src="~assets/img/tabbar/user-active.svg" alt="" />
        <div slot='item-text'>用户</div>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>

<script>
import TabBar from "components/common/tabbar/TabBar";
import TabBarItem from "components/common/tabbar/TabBarItem";

export default {
  name: "MainTabBar",
  components: {
    TabBar,
    TabBarItem,
  },
};
</script>

<style>
</style>
