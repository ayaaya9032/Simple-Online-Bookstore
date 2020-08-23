import Vue from 'vue'
import App from './App.vue'

import VueRouter from 'vue-router'
import {defaultRouter} from './routes' // 一定要{}

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

const router = new VueRouter({
  mode: 'history',
  routes: defaultRouter
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
