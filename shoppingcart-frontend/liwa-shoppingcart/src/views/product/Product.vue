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
        </div>
        </div>
      </div>

    </div>

  </div>
</template>

<script>

import CategoryNavBar from "components/common/navbar/NavBar";
import {getAllProducts} from "@/network/product";

export default {
  name: "Product",
  components: {
    CategoryNavBar,

  },
  data() {
    return {
      categories: [],
      categoryData: [],
      currentIndex: -1,
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
    getSubData(index) {
      this.currentIndex = index
      const maitKey = this.categories[index].maitKey;
        getSubCategory(maitKey).then((res) => {
          this.categoryData = res.data.list;

        });
    },
    menuItemClick(index) {
      this.getSubData(index);

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
