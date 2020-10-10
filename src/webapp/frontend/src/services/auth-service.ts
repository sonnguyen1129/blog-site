/* eslint-disable */
import { AxiosPromise} from 'axios'
import Vue from 'vue'
import { UserDTO } from '@/models'
import router from '@/router';
import EventBus from '@/EventBus';

class AuthService extends Vue {
  private URL_API = process.env.VUE_APP_API_URL + '/api/auth';  // Root api 

  public signIn(user: UserDTO): AxiosPromise<UserDTO> {
    return Vue.axios.post<UserDTO>(this.URL_API + '/sign-in', user)
      .then((res: any) => {
        this.axios.prototype.setUserInfo(res.data.data.token);
        localStorage.setItem('username', res.data.data.username);
        EventBus.$emit('logged', 'User logged');
        return res.data;
      })
  }

  public signOut() {
    EventBus.$emit('logout', 'User log out');
    this.axios.prototype.deleteUserInfo("jwttoken");
  }

  public signUp(user: UserDTO): AxiosPromise<UserDTO> {
    return Vue.axios.post<UserDTO>(this.URL_API + '/sign-up', user);
  }
}

export const authService = new AuthService();