<template>
    <div class="app-container">
      <el-col :span="12">
        <img :src="img_404" alt="404" class="img-style">
      </el-col>
      <el-col :span="12">
        <div style="">
          <h1 style="">oops!</h1>
          <h2 style="">很抱歉，页面不见了</h2>
          <div style="">请检查你输入的网址是否正确</div>
        </div>
      </el-col>
    </div>
</template>

<script>
    export default {
        name: ""
    }
</script>

<style scoped>

  .app-container{
    width: 80%;
    margin: 120px auto;
  }

  .img-style{
    width:auto;
    height: auto;
    max-width: 100%;
    max-height: 100%;
  }
</style>
