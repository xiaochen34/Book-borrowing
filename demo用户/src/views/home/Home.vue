<template>
<div>
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
    }
    }
</script>
<style>
.item{
    margin: 10px 0
}
</style>
