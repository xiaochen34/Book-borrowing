<template>
  <div>
    <div style="margin-bottom:20px">

    </div>
    <el-table :data="tableData" stripe row-key="id"  default-expand-all>
      <el-table-column prop="id" label="编号" width="80"></el-table-column>
      <el-table-column prop="bookName" label="图书名称"></el-table-column>
      <el-table-column prop="bookNo" label="图书标准码"></el-table-column>
      <el-table-column prop="userNo" width="200" label="用户id"></el-table-column>
      <el-table-column prop="userName" label="用户名称"></el-table-column>
      <el-table-column prop="borrowstatus2" label="借阅状态"></el-table-column>
      <el-table-column prop="createtime" label="借书时间"></el-table-column>



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
import Cookies from 'js-cookie';
import { MessageBox, Message } from 'element-ui';
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
      request.get('http://localhost:9000/borrow/page',{params:this.admin}).then(res=>{
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
        request.delete("http://localhost:9000/borrow/delete1/"+id).then(res=>{
            if(res.code ==='200'){
                    this.$notify.success('申请还书成功')
                    this.load()
                }
                else{
                    this.$notify.error(res.msg)
                }
        })
    },
    showReviewDialog(id) {
        this.$prompt('请输入评价', '评价', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          request.delete("http://localhost:9000/borrow/delete3/"+id+'/'+value)
          Message.info('成功评价');
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
      }
  }
    
}
</script>