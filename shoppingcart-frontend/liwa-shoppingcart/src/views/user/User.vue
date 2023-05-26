<template>
  <div id="user">
    <category-nav-bar class="navbar">
      <div slot="center">用户</div>
    </category-nav-bar>
  
    <div class="main">


    </div>
  
  </div>
</template>

<script>
import CategoryNavBar from "components/common/navbar/NavBar";

export default {
  name: "User",
  components: {
    CategoryNavBar,
  },
  data() {
    return {
      categories: [],
      categoryData: [],
      currentIndex: -1,
      records: [
    
	    ]
    };
  },
  created() {
    this.getData();
    
  },


  methods: {

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