<template>
  <div class="content">
    <div class="h1">
      <h1>欢迎访问丰富的二维码生成站</h1>
    </div>
    <div>
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="二维码信息:">
          <el-input v-model="form.msg"></el-input>
        </el-form-item>
        <el-form-item label="logo图片:">
          <el-input type="file" v-model="form.logoUrl"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">生成</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="result">结果:{{ imageUrl == '' ? '' : '成功'}}</div>
    <div class="result">
      <img :src="imageUrl">
    </div>
  </div>
</template>
<script>
import indexApi from '@/api/index'
export default {
  name: 'Index',
  data () {
    return {
      // 参数
      form: {
        msg: '',
        logoUrl: ''
      },
      // 返回结果
      content: '',
      imageUrl: ''
    }
  },
  created () {
    // this.fetchData()
  },
  methods: {
    onSubmit () {
      indexApi.getQRCodeAndLogo(this.form).then(response => {
        this.imageUrl = 'data:image/gif;base64,' + response
      })
    }
  }
}
</script>
<style scoped>
.content {
  width: 500px;
  margin: 0 auto;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.h1 {
  display: flex;
  justify-content: center;
}
.result {
  color: rebeccapurple;
  font-size: 48px;
  display: flex;
  justify-content: center;
}
</style>
