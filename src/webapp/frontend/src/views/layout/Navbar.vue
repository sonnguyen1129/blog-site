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
            <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
          </b-nav-form>

          <b-nav-item-dropdown text="Lang" right>
            <b-dropdown-item href="#">EN</b-dropdown-item>
            <b-dropdown-item href="#">ES</b-dropdown-item>
            <b-dropdown-item href="#">RU</b-dropdown-item>
            <b-dropdown-item href="#">FA</b-dropdown-item>
          </b-nav-item-dropdown>

          <b-nav-item-dropdown right v-if="userName">
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
  </div>
</template>

<script lang="ts">
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator'
import { authService } from '@/services';

@Component({
  components: {}
})
export default class Home extends Vue {
  private userName: string = '';

  private mounted() {
    this.userName = this.axios.prototype.getUserName();
  }

  private logout() {
    authService.signOut()
  }

  private getCurrentUser() {

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
