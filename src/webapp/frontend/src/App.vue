<template>
  <div id="app">
    <Navbar/>
    <h2>{{userName}}</h2>
    <div class="router-view">
      <router-view />
    </div>
    <Footer />
  </div>
</template>

<script lang='ts'>
/* eslint-disable*/
import { Component, Vue } from 'vue-property-decorator'
import Navbar from '@/views/layout/Navbar.vue'
import Footer from '@/views/layout/Footer.vue'
@Component({
  components: {
    Navbar,
    Footer
  }
})
export default class App extends Vue {
  private userName: string = '';
  private created() {
    // this.userName = this.$store.state.userName ? this.$store.state.userName : 'Not logged';
  }
}
</script>

<style lang='scss'>
  @import url('styles/style.scss');

  .router-view {
    text-align: left;
    margin-left: 10%;
    margin-right: 10%;
    min-height: 80%;
  }
</style>
