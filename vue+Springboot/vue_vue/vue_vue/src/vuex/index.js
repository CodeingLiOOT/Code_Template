import Vue from 'vue'

import Vuex from 'vuex'
Vue.use(Vuex)

const store = new Vuex.Store({
  state:{
    user:undefined
  },
  mutations:{
    login(state,payload){
      state.user=payload
    },
    logout(state){
      state.user=undefined
    }
  },
  actions:{
    login(context,payload){
      context.commit('login',payload)
    },
    logout(context,payload){
      context.commit('logout',payload)
    }
  }
})

export default store
