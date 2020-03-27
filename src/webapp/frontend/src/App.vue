<template>
  <div id="app">
    <Navbar/>
    <div class="router-view">
      <router-view />
    </div>
  </div>
</template>

<script lang='ts'>
/* eslint-disable*/
import { Component, Vue } from 'vue-property-decorator'
import Navbar from '@/views/layout/Navbar.vue'
@Component({
  components: {
    Navbar
  }
})
export default class App extends Vue {
  private userName: string = '';
  private created() {
    this.userName = this.$store.state.userName ? this.$store.state.userName : 'Not logged';
  }
}
</script>

<style lang='scss'>
  @import url('styles/style.scss');

  .router-view {
    margin-left: 10%;
    margin-right: 10%;
  }
</style>
