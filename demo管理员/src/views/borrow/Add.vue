<template>
    <div style="width: 80%">
        <div style="margin-bottom:30px">新增借书记录</div>
        <el-form :inline="true" :rules="rules" ref="ruleForm" :model="form" label-width="100px">
      <el-form-item label="图书标准码" prop="bookNo">
        <el-select v-model="form.bookNo" filterable placeholder="请选择" @change="selBook">
          <el-option
              v-for="item in books"
              :key="item.bookid"
              :label="item.bookNo"
              :value="item.bookNo">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="图书名称" prop="bookName">
        <el-input v-model="form.bookName" ></el-input>
      </el-form-item>
      <br />
      <el-form-item label="用户ID" prop="userId">
        <el-select v-model="form.userNo" filterable placeholder="请选择" @change="selUser">
          <el-option
              v-for="item in users"
              :key="item.id"
              :label="item.username"
              :value="item.username">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="用户名称" prop="userName">
        <el-input v-model="form.userName"></el-input>
      </el-form-item>
        </el-form>
  <div style="text-align:center;margin-top:30px">
    <el-button type="primary" @click="save" size="medium">提交</el-button>

</div>
 </div>

</template>
<script>
import request from "@/untils/request";
export default {
  name: 'AddCategory',
  data(){
    return{
        form:{
        },
        books:[],
        users:[],
      rules: {
        name: [
          { required: true, message: '请输入图书名称', trigger: 'blur'}
        ],
      }
    }
  },
  created(){
    request.get('http://localhost:9000/book/list').then(res=>{
        this.books=res.data
    })
        request.get('http://localhost:9000/user/list').then(res => {
      this.users=res.data
    })
  },
  methods: {
    save() {
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post('http://localhost:9000/borrow/save', this.form).then(res => {
            if (res.code === '200') {
              this.$notify.success('新增成功')
              this.$refs['ruleForm'].resetFields()
            } else {
              this.$notify.error(res.msg)
            }
          })
        }
      })
    },
    selBook() {
      const book = this.books.find(v => v.bookNo === this.form.bookNo)
      request.get('http://localhost:9000/book/' + book.id).then(res => {
        this.$set(this.form, 'bookName', res.data.name)
        this.form.score = res.data.score
        this.form.nums = res.data.nums
      })
    },
    selUser() {
      const user = this.users.find(v => v.username === this.form.userNo)
      this.form.userName=user.name
      
    }
  }
}
</script>