import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  user_id: 1,
}

const mutations = {
  // 改变user_id
  SET_USER_ID: (state, new_id) => {
    state.user_id = new_id;
  }
}

const actions = {
  // 触发user_id改变
  changeUserId: (context, new_id) => {
    // 可以在这里执行一些业务逻辑，比如验证user_id是否合法
    context.commit('SET_USER_ID', new_id);
  }
}

const store = new Vuex.Store({
  state,
  mutations,
  actions,
})


export default store;
