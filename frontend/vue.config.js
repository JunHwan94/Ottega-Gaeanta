const path = require('path');
module.exports = {
  lintOnSave: false,
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    port: 8080,
    proxy: 'https://localhost:443',
    disableHostCheck: true
  },
  configureWebpack: {
    resolve: {
      alias: {
        '@': path.join(__dirname, 'src/')
      }
    },
  },
  outputDir: '../backend/src/main/resources/dist',
}
