<template>
  <div>
    Home
    <a href="/profile">Profile</a>
    <b-button @click="logout">Log out</b-button>
  </div>
</template>

<script lang='ts'>
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator'
import { authService } from '../services'

@Component({
  components: {
  }
})
export default class Home extends Vue {
  private logout() {
    authService.signOut()
  }
}
</script>

<style lang='scss'>
</style>
