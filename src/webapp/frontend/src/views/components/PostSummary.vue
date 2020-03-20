<template>
  <div class="post-sum">
    <b-row>
      <b-img src="https://picsum.photos/300/150/?image=41" fluid alt="Fluid image"></b-img>
    </b-row>
    <b-row>
      <a href="">Donec rutrum congue leo eget malesuada.</a>
    </b-row>
    <b-row>
      Curabitur aliquet quam id dui posuere blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
    </b-row>
    <b-row>
      Pellentesque in ipsum id orci porta dapibus. Vivamus suscipit tortor eget felis porttitor volutpat. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Quisque velit nisi, pretium ut lacinia in, elementum id enim.
    </b-row>
    <b-row>
      <b-col lg="3">
        66/66/6666
      </b-col>
      <b-col lg="2">
        70
      </b-col>
      <b-col lg="7">
        Posted By: Muhammad Subel
      </b-col>
    </b-row>
  </div>
</template>

<script lang="ts">
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator'
import { PostDTO } from '@/models'

@Component
export default class PostSummary extends Vue {
  private Post: PostDTO = new PostDTO();

  private mounted() {

  }

}
</script>

<style lang='scss'>
.post-sum {
  background: white;
}
</style>
