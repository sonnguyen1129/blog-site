/* eslint-disable */
import Vue from 'vue'
import VueI18n from 'vue-i18n'
import enMessage from '@/langs/en.json'
import vnMessage from '@/langs/vn.json'

Vue.use(VueI18n)

const messages = {
  'en': enMessage,
  'vi': vnMessage
};


const i18n = new VueI18n({
  locale: 'vi', // set locale
  fallbackLocale: 'vi', // set fallback locale
  messages, // set locale messages,
  silentTranslationWarn: true
})

export default i18n;