const path = require('path');
module.exports = {
  lintOnSave: false,
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    port: 8080,
    // proxy: 'https://j5b206.p.ssafy.io:443',
    proxy: {
      '/search': {
        target : 'https://j5b206.p.ssafy.io:443',
      },
      '/eval': {
        target : 'https://j5b206.p.ssafy.io:443',
      },
      '/fpti': {
        target : 'https://j5b206.p.ssafy.io:443',
      }
    },
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
