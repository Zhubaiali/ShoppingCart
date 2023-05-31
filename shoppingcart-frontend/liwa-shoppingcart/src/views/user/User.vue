<template>
  <div class="user">
    <nav-bar class="navbar">
      <div slot="center">用户</div>
    </nav-bar>
  <div class="container">


    <div class="row-border row-main">
      <h4 style="margin-top:10px;">ID: {{ userData.id }}</h4>
      <h4 style="margin-top:10px;">昵称: {{ userData.username }}</h4>

      <h4 style="margin-top:10px;">地址:</h4>
      <h4 style="margin-top:10px;margin-bottom: 10px;">{{ userData.location }}</h4>

    </div>

    <div class="row-border" @click="showAddressFix = true;fixed_address = userData.location;">
      <h4>修改地址</h4>
    </div>
    <div class="row-border" @click="showModal = true;mode = '登录';">
      <h4>登录</h4>
    </div>
    <div class="row-border" @click="showModal = true;mode = '注册';">
      <h4>注册</h4>
    </div>


    <!-- 这里是弹出框和遮罩层 -->
    <div class="modal" v-if="showModal" @click="showModal = false">
      <div class="dialog" @click.stop>
        <!-- 这里是弹出框的内容 -->
        <div class="login_register">
          <h1>{{ mode }}</h1>
          <div class="row">
            <label for="nickname">昵称：</label>
            <input type="text" id="nickname" v-model="nickname" />
          </div>
          <div class="row">
            <label for="password">密码：</label>
            <input type="password" id="password" v-model="password" />
          </div>
          <div class="row buttons">
            <button @click="showModal = false">取消</button>
            <div class="empty"></div>
            <button @click="confirm">确定</button>
          </div>
        </div>

      </div>
    </div>


    <!-- 地址修改弹出框和遮罩层 -->
    <div class="modal" v-if="showAddressFix" @click="showAddressFix = false">
      <div class="dialog" @click.stop>
        <!-- 这里是弹出框的内容 -->
        <div class="address_fix" style="display: flex;align-items: center;justify-content: center;flex-direction: column;">
          <h1 style="margin: 10px 0 10px 0">地址修改</h1>

            <input type="text" v-model="fixed_address" style="margin: 20px 0 20px 0"/>

          <div style="flex-direction: row">
            <button @click="showAddressFix = false" style="width: 90px;margin-right: 10px">取消</button>
            <button @click="updateLocation" style="width: 90px">确定</button>
          </div>
        </div>

      </div>
    </div>
    <!--地址修改弹出框底部-->


  </div>
  </div>
</template>

<script>
import NavBar from "components/common/navbar/NavBar";
import { login,register } from "@/network/user.js";
import {updateLocation} from "@/network/user";
import {addToCart} from "@/network/cart";
export default {
  components: {
    NavBar,
  },
  data() {
    return {
      showModal: false,
      mode: '', // 登陆&注册 切换
      nickname: '',
      password: '',
      userData: {
        id: 1,
        username: "杨婉平",
        password: "123456",
        location: "bei",
        createdAt: "z",
        updatedAt: "z"
      },
      showAddressFix: false,
      fixed_address: "",
    };
  },
  created() { //缺少id获取用户数据的接口
  },
  methods: {
    updateLocation() {
      let params = new URLSearchParams();
      params.append('location', this.fixed_address);
      updateLocation(params).then((res) => {
        console.log(res)
        this.userData = res
        this.showAddressFix = false;
      });
    },
    confirm() {
      // do something when confirm
      let requestData = {
        id: 0,
        username: this.nickname,
        password: this.password,
        location: "新用户未填写地址",
        createdAt: "",
        updatedAt: "",
      }
      if(this.mode === "登录"){
        login(requestData).then((res) => {
          this.userData = res
          this.$store.commit("SET_USER_ID", res.id)
        });
      }
      if(this.mode === "注册"){
        register(requestData).then((res) => {
          console.log(res)
          this.userData = res
          this.$store.commit("SET_USER_ID", res.id)
        });
      }

      this.showModal = false
    },
  },
};
</script>

<style scoped>
.container {
  width: 100%;
  height: 100%;
  align-items: center;
  flex-direction: column;
  display: flex;
}


.navbar {
  color: #fff;
  font-weight: bold;
  letter-spacing: 2px;
}

.row-border {
  margin-top: 10px;
  flex-direction: column;
  align-items: center;
  display: flex;
  width: 350px;
  height: auto;
  padding: 10px;
  border: 1.5px solid #13227a;
  border-radius: 5px;
  color: #13227a;
}

.row-main {
  margin-top: 40px;
  padding: 20px;
  margin-bottom: 40px;
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

.login_register {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.row {
  display: flex;
  margin-bottom: 20px;
}

label {
  margin-right: 10px;
}

button {
  padding: 5px;
}

.empty {
  margin-left: 25px;
  margin-right: 25px;
}


</style>
