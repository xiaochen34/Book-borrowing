<template>
  <div>
    <div style="margin-bottom:20px">
      <el-input style="width:240px" placeholder="请输入名称" v-model="params.name"></el-input>
      <el-input style="width:240px;margin-left=5px" placeholder="请输入联系方式" v-model="params.phone" ></el-input>
      <el-button style="margin-left5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>
      <el-table :data="tableData" stripe> 
        <el-table-column prop="id" label="编号" width="80"></el-table-column>
        <el-table-column prop="username" label="会员卡号" width="80"></el-table-column>
          <el-table-column prop="name" label="名称"></el-table-column>
          <el-table-column prop="age" label="年龄"></el-table-column>
          <el-table-column prop="address" label="住址"></el-table-column>
          <el-table-column prop="phone" label="联系方式"></el-table-column>
          <el-table-column prop="sex" label="性别"></el-table-column>
                    <el-table-column prop="createtime" label="创建时间"></el-table-column>
          <el-table-column prop="updatetime" label="更新时间"></el-table-column>

        <el-table-column label="操作">
            <template v-slot="scope">
                <el-button type="primary" @click="$router.push('/editUser?id='+scope.row.id)">编辑</el-button>
                    <el-popconfirm title="您确定删除吗" @confirm="del(scope.row.id)">
                    <el-button type="danger" slot="reference">删除</el-button>
            </el-popconfirm>
            </template>
            
        </el-table-column>
        



      </el-table>
      <!-- 分页 -->
      <div style="margin-top:20px">
        <el-pagination
            :page-size="params.pageSize"
            :current-page="params.pageNum"
            background
            layout="prev, pager, next"
            @current-change="handleCurrentChange"
            :total="total">
          </el-pagination>
      </div>
  </div>
</template>

<script>
import request from "@/untils/request";
export default {
  name: 'HomeView',
  data(){
    return {
      tableData: [],
      total:0,
      params:{
        pageNum:1,
        pageSize:5,
        name:'',
        phone:''
      }
    }
  },
  created(){
    this.load()
  },
  methods:{
    load(){
      // fetch('http://localhost:9000/user/page').then(res=>res.json()).then(res=>{
      //   console.log(res)
      //   this.tableData=res.data.list
      //   this.total=res.data.total
      // })
      request.get('http://localhost:9000/user/page',{params:this.params}).then(res=>{
        if(res.code==='200'){
        this.tableData=res.data.list
        this.total=res.data.total}
      }
      )
    },
    reset(){
      this.params={
         pageNum:1,
        pageSize:5,
        name:'',
        phone:''
      }
      this.load()
    },
    handleCurrentChange(pageNum){
      this.params.pageNum=pageNum
      this.load()

    },
        del(id){
        request.delete("http://localhost:9000/user/delete/"+id).then(res=>{
            if(res.code ==='200'){
                    this.$notify.success('删除成功')
                    this.load()
                }
                else{
                    this.$notify.error(res.msg)
                }
        })
    }
  }
    
}
</script>