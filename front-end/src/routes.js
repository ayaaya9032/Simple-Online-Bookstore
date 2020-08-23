import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login.vue'
import Home from './components/Home.vue'
import Join from './components/Join.vue'

Vue.use(Router)

export const defaultRouter = [
  {
    path: '/',
    component: Home
  },
  {
    path: '/home',
    name: 'home',
    component: Home
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/join',
    name: 'join',
    component: Join
  },
  /*{
    path: '/search',
    name: 'search',
    component: Search
  },
  {
    path: '/book/:id',
    component: BookInfo
  },
  {
    path: '/bookstore/:name',
    component: BookstoreInfo
  },
  {
    path: '/user/:name',
    component: UserInfo
  }*/
]
