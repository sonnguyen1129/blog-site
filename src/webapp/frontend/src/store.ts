/* eslint-disable */
import { authService } from '@/services'
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// const json: any = localStorage.getItem('user') ? localStorage.getItem('user') : '';
// const user: any = JSON.parse((json));
// const initialState = user 
//   ? { status : { loggedIn: true }, user }
//   : { status : { loggedIn: false }, user: null};

// const namespaced: boolean = true;

export default new Vuex.Store({

  state: {
    username: {},
    role: {},
  },

  mutations: {
    set_username(state, payload) {
      state.username = payload;
    },
    set_role(state, payload) {
      state.role = payload;
    },
  },
  actions: {
    setUsername({ commit }, username) {
      commit('set_username', username);
    },
    setRole({ commit }, role) {
      commit('set_role', role);
    },
  },
  modules: {
  }
})
