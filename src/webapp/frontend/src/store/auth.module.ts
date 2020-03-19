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

export const auth = new Vuex.Store({

  state: {
    user: {},
    namespaced: true,
    status: {
      loggedIn: false
    },
    initialState: {}
  },

  mutations: {

    SET_USER(state, payload) {
      state.user = payload;
    },

    loginSuccess(state, user) {
      state.status.loggedIn = true;
      state.user = user;
    },
    loginFailure(state) {
      state.status.loggedIn = false;
      state.user = {};
    },
    logout(state) {
      state.status.loggedIn = false;
      state.user = {};
    },
    registerSuccess(state) {
      state.status.loggedIn = false;
    },
    registerFailure(state) {
      state.status.loggedIn = false;
    }
  },

  actions: {

    setUser({ commit }, user) {
      commit('SET_USER', user);
    },

    signIn({ commit }, user) {
      return authService.signIn(user)
        .then(user => {
          commit('loginSuccess', user);
          return Promise.resolve(user);
        },
          error => {
            commit('loginFailure');
            return Promise.reject(error);
          })
    },
    signOut({ commit }) {
      authService.signOut();
      commit('logout');
    },
    register({ commit }, user) {
      return authService.signUp(user).then(
        response => {
          commit('registerSuccess');
          return Promise.resolve(response.data);
        },
        error => {
          commit('registerFailure');
          return Promise.reject(error);
        }
      );
    }
  },
  modules: {
  }
})
