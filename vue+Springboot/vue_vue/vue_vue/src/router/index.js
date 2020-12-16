import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/Home"
import index from '../components/index'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name:'Home',
      component: ()=>import("../components/Home")
    },
    {
      path: '/index',
      name: 'index',
      component: ()=>import("../components/index")
    },
    {
      path: '/login',
      name:'login',
      component: ()=>import("../components/login")
    },
    {
      path: '/register',
      name:'register',
      component: ()=>import("../components/Register")
    }
  ]
})
