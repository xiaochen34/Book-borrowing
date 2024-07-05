<template>
  <div>
    <!-- 头部 -->
    <div style="height:60px; line-height:60px; background-color:white;margin-bottom:2px;display:flex">
      <div>
                 <img  src="@/assets/logo1.png" style="width:40px;position:relative;top:10px;left28px">
          <span style="margin-left:25px;font-size=24px">图书管理系统</span>
      </div>
      <div style="flex:1;text-align:right;padding-right:20px">
        <el-dropdown size="medium">
          <span class="el-dropdown-link" style="cursor:pointer">
            {{admin.name}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown" style="margin-top:-5px">  
            <el-dropdown-item> <div style="width:70px;text-align:center" @click="logout">退出登录</div></el-dropdown-item>
            <el-dropdown-item> <div style="width:100px;text-align:center" @click="save">申请注销账号</div></el-dropdown-item>
          </el-dropdown-menu>
          </el-dropdown> 
      </div>
    </div>

    <!-- 侧边栏和主体 -->
    <div style="display:flex">
      <!-- 侧边栏 -->
       <div style="width:200px;min-height:calc(100vh-62px);overflow:hidden;margin-right:2px;background-color:white">
        <el-menu :default-active="$router.path" router class="el-menu-demo">
        <el-menu-item index="home">
        <i class="el-icon-eleme"></i>
        <span>首页</span>
        </el-menu-item>
               <el-submenu index="a" >
          <template slot="title"><i class="el-icon-collection"></i>个人信息</template>
   <el-menu-item index="editUser">个人信息</el-menu-item>
       </el-submenu>

                              <el-submenu index="adm" >
          <template slot="title"><i class="el-icon-collection"></i>图书</template>
   <el-menu-item index="bookList">图书列表</el-menu-item>
    <el-menu-item index="bookAdd">上传图书</el-menu-item>
   <el-menu-item index="bookList2">上传列表</el-menu-item>
       </el-submenu>
                                        <el-submenu index="ad" >
          <template slot="title"><i class="el-icon-toilet-paper"></i>借还</template>
          <el-menu-item index="borrowAdd">申请借书</el-menu-item>
            <el-menu-item index="borrowList">借书列表</el-menu-item>
            <el-menu-item index="borrowList2">还书列表</el-menu-item>
          </el-submenu>
        </el-menu>
        
        
       </div>
        <!-- 主体 -->
      <div style="flex:1;background-color:white padding:10px">
        
            
    <router-view/>


       </div>
    </div>


  </div>
</template>
<script>
import Cookies from 'js-cookie'
import { ColorPicker } from 'element-ui'
import request from "@/untils/request";
export default {
  name:"Layout",
  data(){
    return{
        admin:Cookies.get('admin')?JSON.parse(Cookies.get('admin')):{},
        form:{
        }
    }
  },
  methods:{
    logout(){
      Cookies.remove('admin')
      this.$router.push('/login')
    },
    save(){
            request.put('http://localhost:9000/user/update2/'+this.admin.name).then(res=>{
                if(res.code ==='200'){
                    this.$notify.success('成功')
                    location.reload();
                }
                else{
                    this.$notify.error(res.msg)
                }
            })
            
    },
  }
}
</script>
