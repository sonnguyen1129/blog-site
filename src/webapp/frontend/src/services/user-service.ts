/* eslint-disable */
import Vue from 'vue';
import { AxiosPromise } from 'axios';
import { UserProfileDTO } from '@/models';

class UserService extends Vue {
  private ROOT_API = process.env.VUE_APP_API_URL + '/api/user';  // Root api 

  public getPublicContent(): AxiosPromise<any> {
    return Vue.axios.get<any>( this.ROOT_API + '/all');
  }

  // public getUserById(userid: string): AxiosPromise<String> {
  //   return Vue.axios.get<String>( this.ROOT_API + '/current-user/' + userid , {headers: authHeader()});
  // }

  public getUserProfile(): AxiosPromise<UserProfileDTO> {
    return Vue.axios.get<UserProfileDTO>(this.ROOT_API + '/profile');
  }

}
export const userService = new UserService();