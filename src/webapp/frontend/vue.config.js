// vue.config.js
module.exports = {
  lintOnSave: false,
  devServer: {
    port: 8089
  },
  // Change build paths to make them Maven compatible
  // see https://cli.vuejs.org/config/
  outputDir: '../../main/resources/public',
  assetsDir: 'static'
}
