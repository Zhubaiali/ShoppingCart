<template>
  <div id="order">
    <category-nav-bar class="navbar">
      <div slot="center">订单</div>
    </category-nav-bar>

    <div class="main">

      <div class="empty+card" v-for="item in order_list">
        <div class="empty">
          </div>
        <div class="card">
        <div class="content">
            <button style="float:right;" @click="deleteOrder(item.id)">删除</button>
            <div>订单id:{{ item.id }}</div>
            <div>商品id:{{ item.productId }}</div>
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
import CategoryNavBar from "components/common/navbar/NavBar";
import {getOrdersByUserId} from "@/network/order";
import {deleteOrder} from "@/network/order";
export default {
  name: "Order",
  components: {
    CategoryNavBar,
  },
  data() {
    return {
      categories: [],
      categoryData: [],
      currentIndex: -1,
      order_list: [
        {
          "id": 0,
          "userId": 0,
          "productId": 0,
          "quantity": 0,
          "isDeleted": 0,
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
      getOrdersByUserId().then((res) => {
        this.order_list = res
      });
    },
    deleteOrder(orderId) {
      deleteOrder(orderId).then((res) => {
        console.log(res)
        this.$router.go(0)
      });

    }
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
