<template>
  <div class="home">
    <!-- <b-row class="feature text-center">
      NEW
    </b-row>
    <b-row>
      <b-col sm="6">
        <b-row>
          Left
        </b-row>
      </b-col>
      <b-col sm="6">
        Right
      </b-col>
    </b-row> -->
    <!-- <b-row>
      <b-col lg="8">
        <b-row v-for="item in listPosts" v-bind:key="item">
          <b-col lg="6">
            <PostSummary />
          </b-col>
        </b-row>
      </b-col>
      <b-col lg="4">
        b
      </b-col>
    </b-row> -->
  </div>
</template>

<script lang='ts'>
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator'
import { authService } from '@/services'

import PostSummary from '@/views/components/PostSummary.vue'
import WebsocketGreetings from '@/views/websocket/WebsocketGreetings.vue'

@Component({
  components: {
    PostSummary,
    WebsocketGreetings
  }
})
export default class Home extends Vue {
  private listPosts: any = [1,2,3,4];

  private mounted() {
    // if (!this.axios.prototype.getUserName()) {
    //   this.$router.push('login');
    // }
  }

}
</script>

<style lang='scss'>
.feature {
  height: 20rem;
  width: 100%;
}
</style>
