/* eslint-disable */
import { AxiosPromise} from 'axios'
import Vue from 'vue'
import { UserDTO } from '@/models'

class AuthService extends Vue {
  private URL_API = process.env.VUE_APP_API_URL + '/api/auth';  // Root api 

  public signIn(user: UserDTO): AxiosPromise<UserDTO> {
    return Vue.axios.post<UserDTO>(this.URL_API + '/sign-in', user)
      .then((res: any) => {
        this.axios.prototype.setUserInfo(res.data.token)
        // if (res.data.accessToken) {
        //   localStorage.setItem('user', JSON.stringify(res.data));
        // }
        return res.data;
      })
  }

  public signOut() {
    this.axios.prototype.deleteUserInfo("jwttoken");
  }

  public signUp(user: UserDTO): AxiosPromise<UserDTO> {
    return Vue.axios.post<UserDTO>(this.URL_API + '/sign-up', user);
  }
}

export const authService = new AuthService();