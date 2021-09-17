const path = require('path');
module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    port: 8080,
    // proxy: 'http://localhost:8081',
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
