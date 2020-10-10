<template>
  <div>
    <b-form @submit="onSubmit">
      <b-form-group label="User name" class="font-weight-bold">
        <b-form-input disabled v-model="userProfile.username" class="form-w50"></b-form-input>
      </b-form-group>

      <b-form-group label="Email" class="font-weight-bold">
        <b-form-input disabled v-model="userProfile.email" class="form-w50"></b-form-input>
      </b-form-group>

      <b-button disabled type="submit" variant="primary">Submit</b-button>
    </b-form>
  </div>
</template>

<script lang='ts'>
/* eslint-disable*/
import { Component, Vue } from 'vue-property-decorator'
import { userService } from '@/services';
import { UserProfileDTO } from '@/models';
import { MessageResponse } from '@/common'

@Component({
  components: {
  }
})
export default class UserProfile extends Vue {
  private username: string = '';
  private userProfile: UserProfileDTO = new UserProfileDTO();



  private mounted() {
    this.getUserProfile();
    this.username = this.axios.prototype.getUserName();
  }

  private onSubmit() {

  }

  private getUserProfile() {
    userService.getUserProfile()
    .then((res: any) => {
      if (res.data.status === 200) {
        this.userProfile = res.data.data;
      }
    })
    .catch((err: any) => {
      console.log(err);
      this.$router.push('forbidden').catch(err => {});
    })
  }


}
</script>

<style lang='scss' scoped>
</style>
