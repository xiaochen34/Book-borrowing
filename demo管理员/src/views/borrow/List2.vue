<template>
    <div>
      <div style="margin-bottom:20px">
        <el-input style="width:240px" placeholder="请输入图书名称" v-model="params.bookName"></el-input>
        <el-input style="width:240px" placeholder="请输入图书编码" v-model="params.bookNo"></el-input>
         <el-input style="width:240px" placeholder="请输入用户名称" v-model="params.userName"></el-input>
            <el-button style="margin-left5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
        <el-button style="margin-left5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
      </div>
         <el-table :data="tableData" stripe row-key="id"  default-expand-all>
        <el-table-column prop="id" label="编号" width="80"></el-table-column>
        <el-table-column prop="bookName" label="图书名称"></el-table-column>
        <el-table-column prop="bookNo" label="图书标准码"></el-table-column>
        <el-table-column prop="userNo" width="200" label="用户id"></el-table-column>
        <el-table-column prop="userName" label="用户名称"></el-table-column>
        <el-table-column prop="createtime" label="借书时间"></el-table-column>
        <el-table-column prop="borrowstatus2" label="借阅状态"></el-table-column>
          <el-table-column label="操作">
              <template v-slot="scope">
                      <el-popconfirm title="您确定通过申请吗" @confirm="del(scope.row.id)">
                      <el-button style="margin-left:5px" type="danger" slot="reference" v-if="scope.row.borrowstatus2 === '申请借阅中'">确认借阅</el-button>
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
  import Cookies from 'js-cookie'
  export default {
    name: 'HomeView',
    data(){
      return {
        admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {},
        tableData: [],
        total:0,
        params:{
          pageNum:1,
          pageSize:5,
          name:'',
          bookNo:'',
          bookName:'',
          userName:'',
  
        },
  
      }
    },
    created(){
      this.load()
    },
    methods:{
      
      
      load(){
        request.get('http://localhost:9000/borrow/page2',{params:this.params}).then(res=>{
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
          bookName:'',
          bookNo:'',
          userName:'',
        }
        this.load()
      },
      handleCurrentChange(pageNum){
        this.params.pageNum=pageNum
        this.load()
  
      },
          del(id){
          request.delete("http://localhost:9000/borrow/delete4/"+id).then(res=>{
              if(res.code ==='200'){
                      this.$notify.success('确认借书成功')
                      this.load()
                  }
                  else{
                      this.$notify.error(res.msg)
                  }
          })
      },
    }
      
  }
  </script>