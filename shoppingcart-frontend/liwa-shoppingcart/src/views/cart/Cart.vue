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
            <button style="float:right;" @click="removeFromCart(item.productId)">移除</button>
            <button style="float:right;margin-right: 10px" @click="showModal=true;choice_item=item;fix_number=item.quantity;">调整</button>
            <div>id:{{ item.id }}</div>
            <div>产品id:{{ item.productId }}</div>
            <div>数量:{{ item.quantity }}</div>
            <div>创建时间:{{ item.createdAt }}</div>
            <div>更新时间:{{ item.updatedAt }}</div>
          <div style="height: 20px">
            <button style="float:right;" @click="createOrder(item)">下单</button>
          </div>
        </div>
        </div>
      </div>

      <!-- 这里是弹出框和遮罩层 -->
      <div class="modal" v-if="showModal" @click="showModal = false">
        <div class="dialog" @click.stop>
          <!-- 这里是弹出框的内容 -->
          <div class="cart_fix">
            <h1 style="margin: 10px 0 10px 0">调整数量</h1>
            <div style="color: #13227a;display: flex;align-items: center;justify-content: center;">
              <img @click="decreaseNumber" src="~assets/img/cart/arrow-left-filling.png" style="width: 20px;height: 20px">
              <span id="quantity_number" style="margin: 20px 20px 20px 20px;color: #13227a;font-size: 20px">{{fix_number}}</span>
              <img @click="increaseNumber" src="~assets/img/cart/arrow-right-filling.png" style="width: 20px;height: 20px">
            </div>
            <div class="row buttons">
              <button @click="showModal = false" style="width: 100px">取消</button>
              <div style="width: 60px"></div>
              <button @click="confirm" style="width: 100px">确定</button>
            </div>
          </div>

        </div>
      </div>
      <!--      弹出框底部-->

    </div>

  </div>
</template>

<script>
import {getCartItems} from "@/network/cart";
import {removeFromCart} from "@/network/cart";
import {decreaseQuantity} from "@/network/cart";
import {createOrder} from "@/network/order";

import CategoryNavBar from "components/common/navbar/NavBar";

export default {
  name: "Cart",
  components: {
    CategoryNavBar,
  },
  data() {
    return {
      showModal: false,
      fix_number: 100,
      choice_item: {},
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
    createOrder(item) {
      let params = new URLSearchParams();
      params.append('productId',item.productId)
      params.append('quantity', item.quantity);
      createOrder(params).then((res) => {
        console.log(res)
        alert("下单成功! " + " 下单商品id：" + item.productId + " 共 " + item.quantity + " 件")
      });
    },
    removeFromCart(productId) {
      removeFromCart(productId).then((res) => {
        console.log(res)
      });
      this.$router.go(0)
    },
    decreaseNumber() {
      if(this.fix_number === 1)return;
      this.fix_number--;
    },
    increaseNumber() {
      if(this.fix_number === this.choice_item.quantity)return;
      this.fix_number++;
    },
    confirm() {
      let decreaseNumber = this.choice_item.quantity - this.fix_number;
      let params = new URLSearchParams();
      params.append('quantity', String(decreaseNumber));
      decreaseQuantity(this.choice_item.productId,params).then((res) => {
        console.log(res)
      });
      this.$router.go(0)
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


.modal {
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}

.dialog {
  width: 80%;
  max-width: 300px;
  background-color: white;
  border-radius: 10px;
  padding: 20px;
}

.row {
  display: flex;
  align-items: center;
  height: 40px;
}


</style>
