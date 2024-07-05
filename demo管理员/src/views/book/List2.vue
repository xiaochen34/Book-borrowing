<template>
  <div>
    <div style="margin-bottom:20px">
      <el-input style="width:240px" placeholder="请输入图书名称" v-model="params.name"></el-input>
      <el-input style="width:240px" placeholder="请输入图书编码" v-model="params.bookNo"></el-input>
          <el-button style="margin-left5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>
       <el-table :data="tableData" stripe row-key="id"  default-expand-all>
      <el-table-column prop="id" label="编号" width="80"></el-table-column>
      <el-table-column prop="name" label="图书名称"></el-table-column>
      <el-table-column prop="bookNo" label="标准码"></el-table-column>
      <el-table-column prop="description" width="200" label="描述"></el-table-column>
      <el-table-column prop="publishDate" label="出版日期"></el-table-column>
      <el-table-column prop="author" label="作者"></el-table-column>
      <el-table-column prop="publisher" label="出版社"></el-table-column>
      <el-table-column prop="category" label="分类"></el-table-column>
      <el-table-column prop="cover" label="封面">
        <template v-slot="scope">
          <el-image :src="scope.row.cover" :preview-src-list="[scope.row.cover]"></el-image>
        </template>
      </el-table-column>
      <el-table-column prop="upload" label="上传状态"></el-table-column>
      <el-table-column prop="statement" label="驳回理由"></el-table-column>
      <el-table-column label="操作">
            <template v-slot="scope">
                <el-button style="margin-left:5px" type="primary" @click="showReviewDialog(scope.row.id)" v-if="scope.row.upload !== '上传中'" >驳回理由</el-button>
              <el-popconfirm title="您确定上传吗" @confirm="del(scope.row.id)">
                <el-button style="margin-left:5px" type="primary" slot="reference" v-if="scope.row.upload == '上传中'">确认上传</el-button>
              </el-popconfirm>
              <el-popconfirm title="您确定驳回吗" @confirm="del1(scope.row.id)">
                <el-button style="margin-left:5px" type="danger" slot="reference" v-if="scope.row.upload == '上传中'">驳回</el-button>
              </el-popconfirm>
              <!-- <el-button style="margin-left:5px" type="primary" @click="showReviewDialog(scope.row.id)" >驳回理由</el-button> -->
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
      },
      rules: {
        name: [
          {required: true, message: '请输入分类名称', trigger: 'blur'}
        ]
      }

    }
  },
  created(){
    this.load()
  },
  methods:{
    
    
    load(){
      request.get('http://localhost:9000/book/page2',{params:this.params}).then(res=>{
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
        bookNo:'',
      }
      this.load()
    },
    handleCurrentChange(pageNum){
      this.params.pageNum=pageNum
      this.load()

    },
        del(id){
        request.put("http://localhost:9000/book/updateUpload/"+id).then(res=>{
            if(res.code ==='200'){
                    this.$notify.success('上传成功')
                    this.load()
                }
                else{
                    this.$notify.error(res.msg)
                }
        })
    },
    del1(id){
        request.put("http://localhost:9000/book/updateUpload1/"+id).then(res=>{
            if(res.code ==='200'){
                    this.$notify.success('驳回成功')
                    this.load()
                }
                else{
                    this.$notify.error(res.msg)
                }
        })
    },
    showReviewDialog(id) {
  this.$prompt('请输入驳回理由', '原因', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
  })
    .then(({ value }) => {
      request
        .delete("http://localhost:9000/book/delete3/" + id + '/' + value)
        location.reload()
        .catch((error) => {
          this.$message({
            message: '成功填写理由',
          });
        });
    })
    .catch(() => {
      this.$message({
        message: '取消输入',
      });
    });
},
  }
    
}
</script>