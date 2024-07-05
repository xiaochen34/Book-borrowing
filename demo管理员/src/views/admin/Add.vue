<template>
    <div style="width: 80%">
        <div style="margin-bottom:30px">新增管理员（默认密码123）</div>
<el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" label-width="100px">
  <el-form-item label="用户名 " prop="username">
    <el-input v-model="form.username" placeholder="请输入姓名"></el-input>
  </el-form-item>
  <el-form-item label="联系方式" prop="phone">
    <el-input v-model="form.phone" placeholder="请输入联系方式"></el-input>
  </el-form-item>
   <el-form-item label="邮箱">
    <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
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
  name: 'AddAdmin',
  data(){
      const checkPhone = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('手机号不能为空'));
        }
        callback();
        ;
      };
    return{
        form:{
          sex:'男'
        },rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          phone:[
            {
              validator: checkPhone, trigger: 'blur'
            }
          ]
        }
    }
  },
  methods:{
    save() {
      this.$refs['ruleForm'].validate((valid) => {
        if(valid){
            request.post('http://localhost:9000/admin/save',this.form).then(res=>{
                if(res.code ==='200'){
                    this.$notify.success('新加')
                    this.form={
                      sex:'男'
                    }
                }
                else{
                    this.$notify.error(res.msg)
                }
            })
        }
      })
            
    }
  }
}
</script>
