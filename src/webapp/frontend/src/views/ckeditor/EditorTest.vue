<template>
  <div>
    <div>
      <ckeditor v-model="editorText"></ckeditor>
    <b-button @click="screen()">AA</b-button>
    </div>
  </div>
</template>

<script lang='ts'>
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator' 
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import CKEditor from '@ckeditor/ckeditor5-vue';

@Component({
  components: {
    ClassicEditor
  }
})
export default class EditorTest extends Vue {

  private editorText: any = 'afsdfasdf';

  private mounted() {
    
  }

  private screen() {
    console.log(this.editorText)
  }

}
</script>

<style lang='scss'>
</style>


