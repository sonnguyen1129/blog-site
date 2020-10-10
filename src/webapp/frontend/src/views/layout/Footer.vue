<template>
  <div class="footer">
    <b-button variant="outline-primary">Button</b-button>
  </div>
</template>

<script lang="ts">
/* eslint-disable */
import { Component, Vue } from "vue-property-decorator";

@Component({
  components: {},
})
export default class Footer extends Vue {}
</script>

<style lang='scss'>
.footer {
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0;
  padding: 1rem;
  background-color: white;
  text-align: center;
}
</style>
