<template>
  <div style="overflow-x: hidden;">
    <!-- 头部 -->
    <div style="height:60px; line-height:60px; background-color:white;margin-bottom:2px;display:flex">
      <div>
                 <img  src="@/assets/logo1.png" style="width:40px;position:relative;top:10px;left28px">
          <span style="margin-left:25px;font-size=24px">图书管理系统</span>
      </div>
      <div style="flex:1;text-align:right;padding-right:20px">
        <el-dropdown size="medium">
          <span class="el-dropdown-link" style="cursor:pointer">
            {{admin.username}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown" style="margin-top:-5px">  
            <el-dropdown-item> <div style="width:70px;text-align:center" @click="logout">退出登录</div></el-dropdown-item>
            
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
          <el-submenu >
          <template slot="title"><i class="el-icon-coordinate"></i>用户管理</template>
            <el-menu-item index="userList">用户列表</el-menu-item>
            <el-menu-item index="adduser">用户添加</el-menu-item>
          </el-submenu>
                    <el-submenu index="admin" >
          <template slot="title"><i class="el-icon-s-custom"></i>管理员管理</template>
            <el-menu-item index="adminList">管理员列表</el-menu-item>
            <el-menu-item index="addAdmin">管理员添加</el-menu-item>
          </el-submenu>
                              <el-submenu index="admi" >
          <template slot="title"><i class="el-icon-s-data"></i>图书分类管理</template>
            <el-menu-item index="categoryList">图书分类列表</el-menu-item>
            <el-menu-item index="categoryAdd">图书分类添加</el-menu-item>
          </el-submenu>
                              <el-submenu index="adm" >
          <template slot="title"><i class="el-icon-tickets"></i>图书管理</template>
            <el-menu-item index="bookList">图书列表</el-menu-item>
          <el-menu-item index="bookList2">用户上传图书审核</el-menu-item>
          <el-menu-item index="bookAdd">管理员图书上传</el-menu-item>
          </el-submenu>
                                        <el-submenu index="ad" >
          <template slot="title"><i class="el-icon-pie-chart"></i>借还管理</template>
            <el-menu-item index="borrowList">还书确认</el-menu-item>
             <el-menu-item index="borrowList2">借书确认</el-menu-item>
            <el-menu-item index="borrowAdd">借书添加</el-menu-item>
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
export default {
  name:"Layout",
  data(){
    return{
        admin:Cookies.get('admin')?JSON.parse(Cookies.get('admin')):{},
    }
  },
  methods:{
    logout(){
      Cookies.remove('admin')
      this.$router.push('/login')
    },
  }
}
</script>
