<template>
<div >
<img  src="@/assets/启动.png" style="width:90%">
    </div>
</template>
<script>
import Cookies from 'js-cookie'
import request from "@/untils/request";
export default{
    data(){
        return{
        admin:Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}
        }
    },
    created(){
    //    request.get('http://localhost:9000/admin/'+this.admin.id).then(res=>{
    //     this.admin=res.data
    // })
    }
    }
</script>
<style>
.item{
    margin: 10px 0
}
</style>
