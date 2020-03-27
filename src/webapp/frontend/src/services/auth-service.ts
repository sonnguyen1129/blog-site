/* eslint-disable */
import { AxiosPromise} from 'axios'
import Vue from 'vue'
import { UserDTO } from '@/models'
import EventBus from '@/common/EventBus';

class AuthService extends Vue {
  private URL_API = process.env.VUE_APP_API_URL + '/api/auth';  // Root api 

  public signIn(user: UserDTO): AxiosPromise<UserDTO> {
    return Vue.axios.post<UserDTO>(this.URL_API + '/sign-in', user)
      .then((res: any) => {
        this.axios.prototype.setUserInfo(res.data.token);
        localStorage.setItem('username', res.data.username);
        EventBus.$emit('logged', 'Logged success');
        return res.data;
      })
  }

  public signOut() {
    this.axios.prototype.deleteUserInfo("jwttoken");
    EventBus.$emit('logout', 'Logout success');
    this.$router.push('home');
  }

  public signUp(user: UserDTO): AxiosPromise<UserDTO> {
    return Vue.axios.post<UserDTO>(this.URL_API + '/sign-up', user);
  }
}

export const authService = new AuthService();