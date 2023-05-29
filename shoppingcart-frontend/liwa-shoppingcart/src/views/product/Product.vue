<template>
  <div id="product">
    <category-nav-bar class="navbar">
      <div slot="center">丽娃商品</div>
    </category-nav-bar>

    <div class="main">

      <div class="empty+card" v-for="item in records">
        <div class="empty">
          </div>
        <div class="card">
        <div class="content">
            <div>id:{{ item.id }}</div>
            <div>名称:{{ item.name }}</div>
            <div>描述:{{ item.description }}</div>
            <div>价格:{{ item.price }}</div>
            <div>数量:{{ item.quantity }}</div>
            <div>创建时间:{{ item.createdAt }}</div>
            <div>更新时间:{{ item.updatedAt }}</div>
            <div>
            <button class="item-btn" @click="showModal = true;mode='加入购物车';quantity=0;choice_item=item">加入购物车</button>
            <button class="item-btn" @click="showModal = true;mode='立即下单';quantity=0;choice_item=item">立即下单</button>
            </div>
        </div>
        </div>
      </div>

    </div>

    <!-- 这里是弹出框和遮罩层 -->
    <div class="modal" v-if="showModal" @click="showModal = false">
      <div class="dialog" @click.stop>
        <!-- 这里是弹出框的内容 -->
        <div class="cart_order">
          <h1>{{ mode }}</h1>
          <h5>id:{{ choice_item.id }}</h5>
          <h5>名称:{{ choice_item.name }}</h5>
          <h5>描述:{{ choice_item.description }}</h5>
          <h5>价格:{{ choice_item.price }}</h5>
          <h5>数量:{{ choice_item.quantity }}</h5>
          <h5>创建时间:{{ choice_item.createdAt }}</h5>
          <h5>更新时间:{{ choice_item.updatedAt }}</h5>
          <div class="row">
            <h5>选择数量：</h5>
            <input type="text" id="quantity" v-model="quantity" style="width: 50px"/>
          </div>
          <div class="row buttons">
            <button @click="showModal = false" style="width: 100px">取消</button>
            <div style="width: 60px"></div>
            <button @click="confirm" style="width: 100px">确定</button>
          </div>
        </div>

      </div>
    </div>

  </div>
</template>

<script>

import CategoryNavBar from "components/common/navbar/NavBar";
import {getAllProducts} from "@/network/product";
import {addToCart} from "@/network/cart";
import {createOrder} from "@/network/order";
import store from "@/store";

export default {
  name: "Product",
  components: {
    CategoryNavBar,

  },
  data() {
    return {
      showModal: false,
      mode: '', // 加入购物车&立即下单 切换
      quantity: 0,
      choice_item: {},
      records: [
      {
        "id": 1,
        "name": "Apple",
        "description": "Apple",
        "price": 99,
        "quantity": 99,
        "createdAt": "2023-05-20",
        "updatedAt": "2023-05-20"
      },
      {
        "id": 2,
        "name": "Apple",
        "description": "Apple",
        "price": 99,
        "quantity": 99,
        "createdAt": "2023-05-20",
        "updatedAt": "2023-05-20"
      },
	    ]
    };
  },
  created() {
    this.getData();
  },


  methods: {
    getData() {
      getAllProducts().then((res) => {
        this.records = res.records
      });
    },
    getItem(productId) {

    },
    confirm() {
      if(this.mode === "加入购物车"){
        let params = new URLSearchParams();
        params.append('quantity', this.quantity);
        addToCart(this.choice_item.id,params).then((res) => {
          console.log(res)
        });
      }
      if(this.mode === "立即下单"){
        let params = new URLSearchParams();
        params.append('productId',this.choice_item.id)
        params.append('quantity', this.quantity);
        createOrder(params).then((res) => {
          console.log(res)
        });
      }
      this.showModal = false
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

.item-btn {
  color: #13227a;
  margin-left: 55px;
  margin-top: 10px;
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

.cart_order {
  display: flex;
  flex-direction: column;
}

.row {
  display: flex;
  align-items: center;
  height: 40px;
}


</style>
