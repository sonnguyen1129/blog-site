import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home.vue'
import Login from '@/views/user/Login.vue'
import AboutMe from '@/views/about/AboutMe.vue'
import UserProfile from '@/views/user/UserProfile.vue'
import UserForbidden from '@/views/UserForbidden.vue'

Vue.use(Router)
/* eslint-disable */
export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '*',
      redirect: { name: 'home' }
    },
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/profile',
      name: 'profile',
      component: UserProfile
    },
    {
      path: '/editor',
      name: 'editor',
      component: () => import('@/views/ckeditor/EditorTest.vue')
    },
    {
      path: '/about-me',
      name: 'about-me',
      component: AboutMe
    },
    {
      path: '/forbidden',
      name: 'forbidden',
      component: UserForbidden
    },
  ]
})
