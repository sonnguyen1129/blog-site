<template>
  <div>
    <b-row>
      <b-col lg="2">
        <b-input type="text" v-model="userLogin.username" />
        <b-input type="password" v-model="userLogin.password" />
        <b-button @click="onClickLogin">Login</b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script lang='ts'>
/* eslint-disable*/
import { Component, Vue } from 'vue-property-decorator'
import { UserDTO } from '@/models'

import { authService } from '@/services'
import EventBus from '@/common/EventBus';

@Component({
  components: {

  }
})
export default class Login extends Vue {
  private userLogin: UserDTO = new UserDTO();
  private isLoading: boolean = false;
  private isLogged: boolean = false;

  private mounted() {
  }

  private onClickLogin() {
    this.isLoading = true;
    if (this.userLogin.username && this.userLogin.password) {
      authService.signIn(this.userLogin)
      .then((res: any) => {
        this.$router.push('home');
      })
      .catch((err: any) => {
      })
    }
  }

}
</script>
<style lang='scss' scoped>

</style>
