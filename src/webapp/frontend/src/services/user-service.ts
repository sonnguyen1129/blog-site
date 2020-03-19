/* eslint-disable */
import Vue from 'vue';
import { AxiosPromise } from 'axios';
// import authHeader from './auth-header';

class UserService extends Vue {
  private ROOT_API = process.env.VUE_APP_API_URL + '/api/test';  // Root api 

  public getPublicContent(): AxiosPromise<any> {
    return Vue.axios.get<any>( this.ROOT_API + '/all');
  }

  // public getUserById(userid: string): AxiosPromise<String> {
  //   return Vue.axios.get<String>( this.ROOT_API + '/current-user/' + userid , {headers: authHeader()});
  // }

  public getUserBoard(): AxiosPromise<any> {
    return Vue.axios.get<any>( this.ROOT_API + '/user');
  }

  public getModeratorBoard(): AxiosPromise<any> {
    return Vue.axios.get<any>( this.ROOT_API + '/mod');
  }

  public getAdminBoard(): AxiosPromise<any> {
    return Vue.axios.get<any>( this.ROOT_API + '/admin');
  }

}
export const userService = new UserService();