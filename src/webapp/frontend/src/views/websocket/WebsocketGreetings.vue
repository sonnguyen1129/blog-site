<template>
  <div>
    <div id="main-content" class="container">
      <div class="row">
        <div class="col-md-6">
          <form class="form-inline">
            <div class="form-group">
              <label for="connect">WebSocket connection:</label>
              <button id="connect" class="btn btn-default" type="submit" :disabled="connected == true" @click.prevent="connect">Connect</button>
              <button id="disconnect" class="btn btn-default" type="submit" :disabled="connected == false" @click.prevent="disconnect">Disconnect
              </button>
            </div>
          </form>
        </div>
        <div class="col-md-6">
          <form class="form-inline">
            <div class="form-group">
              <label for="name">What is your name?</label>
              <input type="text" id="name" class="form-control" v-model="send_message" placeholder="Your name here...">
            </div>
            <button id="send" class="btn btn-default" type="submit" @click.prevent="send">Send</button>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <table id="conversation" class="table table-striped">
            <thead>
              <tr>
                <th>Greetings</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in received_messages" :key="item">
                <td>{{ item }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

</template>

<script lang='ts'>
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator'
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";

@Component({
  components: {
  }
})
export default class WebsocketGreetings extends Vue {
  private received_messages: any = [];
  private send_message: any = null;
  private connected: boolean = false;
  stompClient: any;
  socket: any;

  private mounted() {
  }

  private send() {
      console.log("Send message:" + this.send_message);
      if (this.stompClient && this.stompClient.connected) {
        const msg = { name: this.send_message };
        console.log(JSON.stringify(msg));
        this.stompClient.send("/app/hello", JSON.stringify(msg), {});
      }
    }

  private connect() {
      this.socket = new SockJS("http://localhost:8090/gs-guide-websocket");
      this.stompClient = Stomp.over(this.socket);
      this.stompClient.connect(
        {},
        frame => {
          this.connected = true;
          console.log(frame);
          this.stompClient.subscribe("/topic/greetings", tick => {
            console.log(tick);
            this.received_messages.push(JSON.parse(tick.body).content);
          });
        },
        error => {
          console.log(error);
          this.connected = false;
        }
      );
    }

    private disconnect() {
      if (this.stompClient) {
        this.stompClient.disconnect();
      }
      this.connected = false;
    }

    private tickleConnection() {
      this.connected ? this.disconnect() : this.connect();
    }
}
</script>

<style lang='scss'>
</style>
