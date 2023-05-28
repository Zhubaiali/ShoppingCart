export default {
  // 触发user_id改变
  changeUserId: (context, new_id) => {
    // 可以在这里执行一些业务逻辑，比如验证user_id是否合法
    context.commit('SET_USER_ID', new_id);
  }
}
