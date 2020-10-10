<template>
  <div>
    <b-form>
      <h6 class="mess-login-fail">{{messageShow}}</h6>
      <b-form-group label="User name" class="font-weight-bold">
        <b-form-input required v-model="userDTO.username"></b-form-input>
      </b-form-group>

      <b-form-group label="Password" class="font-weight-bold">
        <b-form-input required type="password" v-model="userDTO.password"></b-form-input>
      </b-form-group>

      <b-button @click="onClickLogin" variant="primary">Login</b-button>
      <b-button @click="cancel()">Cancel</b-button>
    </b-form>
  </div>
</template>

<script lang='ts'>
/* eslint-disable*/
import { Component, Vue } from 'vue-property-decorator'
import { UserDTO } from '@/models'

import { authService } from '@/services'

@Component({
  components: {

  }
})
export default class Login extends Vue {
  private userDTO: UserDTO = new UserDTO();
  private isLoading: boolean = false;
  private messageLoginIncorrect: string = 'Incorrect username or password';
  private messageLoginEmpty: string = 'Username or password is empty';
  private messageShow: string = '';

  private mounted() {
  }

  private onClickLogin() {
    this.messageShow = '';
    if (this.userDTO.username && this.userDTO.password && this.userDTO.username.trim() && this.userDTO.password.trim()) {
      authService.signIn(this.userDTO)
      .then((res: any) => {
        if (res.status === 200) {
          // location.reload();
          this.$store.dispatch('setUsername', res.data.username);
          this.$store.dispatch('setRole', res.data.roles[0]);
          this.$router.push('/home').catch(err => {})
          this.cancel();
        }
      })
      .catch((err: any) => {
        this.messageShow = this.messageLoginIncorrect;
      })
      .finally(() => {
      })
    }
    else {
      this.messageShow = this.messageLoginEmpty;
    }
  }

  private cancel() {
    this.$emit('cancel');
  }

}
</script>
<style lang='scss' scoped>
.mess-login-fail {
  color: red;
  text-align: center;
}
</style>
