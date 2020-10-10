<template>
  <div class="nav-bar">
    <b-navbar toggleable="lg" >
      <b-navbar-brand to="/home">Home</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#">Link</b-nav-item>
          <b-nav-item href="#">Link</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
            <b-button size="sm" class="my-2 my-sm-0">Search</b-button>
            <b-button size="sm" class="my-2 my-sm-0 ml-1" @click="onClickSignIn()" v-if="!isLogged">Sign in</b-button>
            <b-button size="sm" class="my-2 my-sm-0 ml-1" @click="onClickSignUp()" v-if="!isLogged">Sign up</b-button>

          </b-nav-form>

          <b-nav-item-dropdown text="Lang" right>
            <b-dropdown-item href="#">EN</b-dropdown-item>
            <b-dropdown-item href="#">JP</b-dropdown-item>
            <b-dropdown-item href="#">VN</b-dropdown-item>
          </b-nav-item-dropdown>

          <b-nav-item-dropdown right v-if="isLogged">
            <!-- Using 'button-content' slot -->
            <template v-slot:button-content>
              <em>{{userName}}</em>
            </template>
            <b-dropdown-item to="profile">Profile</b-dropdown-item>
            <b-dropdown-item href="#" @click="logout">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>

        </b-navbar-nav>
      </b-collapse>
    </b-navbar>

    <b-modal
      title="Log in"
      @hidden="cancel"
      :visible.sync="showModalLogin"
      :hide-footer="true">
      <Login @cancel="cancel"/>

    </b-modal>

    <b-modal
      title="Sign up"
      @hidden="cancel"
      :visible.sync="showModalSignUp"
      :hide-footer="true">
      <SignUp @cancel="cancel"/>

    </b-modal>
  </div>
</template>

<script lang="ts">
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator'
import { authService } from '@/services';
import Login from '@/views/user/Login.vue';
import SignUp from '@/views/user/SignUp.vue';
import EventBus from '@/EventBus'

@Component({
  components: {
    Login,
    SignUp
  }
})
export default class Navbar extends Vue {
  private userName: string = '';
  private showModalLogin: boolean = false;
  private showModalSignUp: boolean = false;
  private isLogged: boolean = false;

  private mounted() {

    EventBus.$on('logged', () => {
      this.getCurrentUser();
    })

    EventBus.$on('logout', () => {
      this.isLogged = false;
    })
  }

  private getCurrentUser() {
    this.userName = this.axios.prototype.getUserName();
    this.isLogged = true;
  }

  private logout() {
    authService.signOut();
    this.$router.push('home').catch((err: any) => {});
  }

  private onClickSignIn() {
    this.showModalLogin = true;
  }

  private onClickSignUp() {
    this.showModalSignUp = true;
  }

  private cancel() {
    this.showModalLogin = false;
    this.showModalSignUp = false;
  }
}
</script>

<style lang='scss'>
  .nav-bar {
    background: white;

    .navbar {
      padding: 2rem 8rem;
    }
  }
</style>
