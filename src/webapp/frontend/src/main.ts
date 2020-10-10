// @ts-ignore
import Vue from 'vue'
import App from '@/App.vue'
import router from '@/router'
import store from '@/store'

import axios from 'axios'
import VueAxios from 'vue-axios'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import i18n from '@/langs/i18n.ts';
import CKEditor from '@ckeditor/ckeditor5-vue';
Vue.use(CKEditor);

import EventBus from '@/EventBus'
Vue.prototype.$bus = EventBus

// element ui
import ElementUI from 'element-ui'
import {
  Select,
  Button
} from 'element-ui'

Vue.component(Select.name, Select)
Vue.component(Button.name, Button)
Vue.use(ElementUI)

//editor

Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(VueAxios, axios)

axios.interceptors.request.use((config) => {
  return config;
}, (error) => {
  return Promise.reject(error);
});

// check if any response if have error
axios.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    if (error.response && (error.response.status === 401 || error.response.status === 403)) {
      // remove authenticate
      axios.prototype.deleteUserInfo();
    }
    return Promise.reject(error);
  },
);

// set authorization when the web is run (global)
axios.prototype.loadHeaderInfo = function () {
  // load user's info
  const jwttoken = localStorage.getItem('jwttoken');
  if (jwttoken) {
    axios.defaults.headers.common.Authorization = jwttoken;
  }
};
axios.prototype.loadHeaderInfo();

axios.prototype.getUserName = function () {
  return localStorage.getItem('username') ? localStorage.getItem('username') : false;
};

// set user infomation
axios.prototype.setUserInfo = function (token: string) {
  const jwttoken = 'Bearer ' + token
  localStorage.setItem('jwttoken', jwttoken)
  axios.defaults.headers.common.Authorization = jwttoken
};

// delete all user information of axios
axios.prototype.deleteUserInfo = function (token: string) {
  localStorage.removeItem('username');
  localStorage.removeItem(token);
  delete axios.defaults.headers.common.Authorization;
}

new Vue({
  router,
  store,
  i18n,
  render: (h) => h(App)
}).$mount('#app')
