<template>
  <div>
    <b-form>
      <b-form-group label="User name" class="font-weight-bold">
        <b-form-input v-model="userDTO.username" placeholder="Your username"></b-form-input>
      </b-form-group>

      <b-form-group label="Password" class="font-weight-bold">
        <b-form-input type="password" v-model="userDTO.password" placeholder="Your password"></b-form-input>
      </b-form-group>

      <b-form-group label="Comfirm password" class="font-weight-bold">
        <b-form-input type="password" v-model="passwordComfirm" placeholder="Your password"></b-form-input>
      </b-form-group>

      <b-form-group label="Email" class="font-weight-bold">
        <b-form-input type="email" v-model="userDTO.email" placeholder="Your email"></b-form-input>
      </b-form-group>

      <b-button @click="onClickSignUp" variant="primary">Sign up</b-button>
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
export default class SignUp extends Vue {
  private userDTO: UserDTO = new UserDTO();
  private isLoading: boolean = false;
  private passwordComfirm: string = '';

  private mounted() {
  }

  private onClickSignUp() {
    if (this.userDTO.username && this.userDTO.password && this.userDTO.username.trim() && this.userDTO.password.trim() && this.userDTO.email && this.userDTO.email.trim()) {
      authService.signUp(this.userDTO)
      .then((res: any) => {
        if (res.status === 200) {
          console.log(res.data)
          this.cancel();
        }
      })
      .catch((err: any) => {
      })
      .finally(() => {
      })
    }
    else {
    }
  }

  private cancel() {
    this.$emit('cancel');
  }

}
</script>
<style lang='scss' scoped>

</style>
