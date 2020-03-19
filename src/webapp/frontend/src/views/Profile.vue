<template>
  <div>
    Profile
    <b-row>
      {{test}}
    </b-row>
    <b-row>
      {{test1}}
    </b-row>
    <b-row>
      {{test2}}
    </b-row>
    <b-row>
      {{token}}
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
  private test1: string = 'No data';
  private test2: string = 'No data';
  private test3: string = 'No data';
  private token: string|null = '';

  private created() {
    this.getUserBoard();
    this.getModeratorBoard();
    this.getAdminBoard();
    this.token = localStorage.getItem('jwttoken') ? localStorage.getItem('jwttoken'): 'No token';
  }

  private getUserBoard() {
    userService.getUserBoard()
    .then((res: any) => {
      this.test = res.data;
    })
  }

  private getModeratorBoard() {
    userService.getModeratorBoard()
    .then((res: any) => {
      this.test1 = res.data;
    })
  }

  private getAdminBoard() {
    userService.getAdminBoard()
    .then((res: any) => {
      this.test2 = res.data;
    })
  }

}
</script>

<style lang='scss' scoped>
</style>
