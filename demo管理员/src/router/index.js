import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Layout from '../views/Layout.vue'
import Cookies from 'js-cookie'
Vue.use(VueRouter)
const originalPush = VueRouter.prototype.push
    //修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
        return originalPush.call(this, location).catch(err => err)
    }

const routes = [
  {
    path: '/login',
    name: 'Login',
    component:()=>import('../../src/views/login/Login.vue'),

  },
  
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect:'home',
    children:[
      {
        path: 'home',
        name: 'Home',
        component:()=>import('../../src/views/home/Home.vue'),
    
      },
      {
        path: 'userList',
        name: 'User',
        component:()=>import('../../src/views/user/User.vue'),
    
      },
      {
        path: 'adduser',
        name: 'AddUser',
        component:()=>import('../../src/views/user/AddUser.vue'),
      },
      {
        path: 'editUser',
        name: 'EditUser',
        component:()=>import('../../src/views/user/EditUser.vue'),
      },
      {
        path: 'adminList',
        name: 'Admin',
        component:()=>import('../../src/views/admin/List.vue'),
    
      },
      {
        path: 'addAdmin',
        name: 'AddAdmin',
        component:()=>import('../../src/views/admin/Add.vue'),
      },
      {
        path: 'editAdmin',
        name: 'EditAdmin',
        component:()=>import('../../src/views/admin/Edit.vue'),
      },
      {
        path: 'categoryList',
        name: 'Category',
        component:()=>import('../../src/views/category/List.vue'),
      },
      {
        path: 'categoryEdit',
        name: 'Category',
        component:()=>import('../../src/views/category/Edit.vue'),
      },
      {
        path: 'categoryAdd',
        name: 'Category',
        component:()=>import('../../src/views/category/Add.vue'),
      },
      {
        path: 'bookList',
        name: 'Book',
        component:()=>import('../../src/views/book/List.vue'),
      },
      {
        path: 'bookList2',
        name: 'Book',
        component:()=>import('../../src/views/book/List2.vue'),
      },
      {
        path: 'bookEdit',
        name: 'Book',
        component:()=>import('../../src/views/book/Edit.vue'),
      },
      {
        path: 'bookAdd',
        name: 'Book',
        component:()=>import('../../src/views/book/Add.vue'),
      },
      {
        path: 'borrowList',
        name: 'Borrow',
        component:()=>import('../../src/views/borrow/List.vue'),
      },
      {
        path: 'borrowList2',
        name: 'Borrow',
        component:()=>import('../../src/views/borrow/List2.vue'),
      },
      {
        path: 'borrowAdd',
        name: 'Borrow',
        component:()=>import('../../src/views/borrow/Add.vue'),
      },
    ]
      
    
  },
  {
    path: '*',
    component:()=>import('../../src/views/user/404.vue'),
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to, from, next) => {
  if (to.path === '/login') return next()
  const admin = Cookies.get("admin")
  if (!admin && to.path !== '/login') return next("/login")  // 强制退回到登录页面
  // 访问 /home 的时候，并且cookie里面存在数据，这个时候我就直接放行
  next()
})

export default router
