<template>
  <div id="cart">
    <category-nav-bar class="navbar">
      <div slot="center">购物车</div>
    </category-nav-bar>

    <div class="main">

      <div class="empty+card" v-for="item in cart_list">
        <div class="empty">
          </div>
        <div class="card">
        <div class="content">
            <div>id:{{ item.id }}</div>
            <div>产品id:{{ item.productId }}</div>
            <div>数量:{{ item.quantity }}</div>
            <div>创建时间:{{ item.createdAt }}</div>
            <div>更新时间:{{ item.updatedAt }}</div>
        </div>
        </div>
      </div>

    </div>

  </div>
</template>

<script>
import { getCartItems } from "network/cart.js";

import CategoryNavBar from "components/common/navbar/NavBar";

export default {
  name: "Cart",
  components: {
    CategoryNavBar,
  },
  data() {
    return {
      cart_list: [
      {
        "id": 0,
        "userId": 0,
        "productId": 0,
        "quantity": 0,
        "createdAt": "",
        "updatedAt": ""
	    },
      {
        "id": 0,
        "userId": 0,
        "productId": 0,
        "quantity": 0,
        "createdAt": "",
        "updatedAt": ""
	    },
	    ]
    };
  },
  created() {
    this.getData();

  },


  methods: {
    getData() {
      getCartItems().then((res) => {
        this.cart_list = res
      });
    },
  },
};
</script>


<style scoped>
.navbar {
  color: #fff;
  font-weight: bold;
  letter-spacing: 2px;
}

.scroll {
  height: calc(100vh - 44px - 49px);
  overflow: hidden;
}

.card {
  width: 350px;
  height: auto;
  margin: auto;
  padding: 10px;
  border: 1.5px solid #13227a;
  border-radius: 5px;
}
.main {
  width: 100%;
}

.empty {
  height: 10px;
}


</style>
