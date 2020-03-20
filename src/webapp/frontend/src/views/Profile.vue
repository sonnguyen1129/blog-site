<template>
  <div>
    Profile
    <b-row>
      {{test}}
    </b-row>
    <b-row>
      {{username}}
    </b-row>
  </div>
</template>

<script lang='ts'>
/* eslint-disable*/
import { Component, Vue } from 'vue-property-decorator'
import { userService } from '@/services';

@Component({
  components: {
  }
})
export default class Profile extends Vue {
  private test: string = 'No data';
  private username: string = '';

  private created() {
    this.getUserBoard();
    this.username = this.axios.prototype.getUserName();
  }

  private getUserBoard() {
    userService.getUserBoard()
    .then((res: any) => {
      this.test = res.data;
    })
  }


}
</script>

<style lang='scss' scoped>
</style>
