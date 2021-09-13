module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    port: 8080,
    // proxy: 'http://localhost:8081',
    disableHostCheck: true
  },
  outputDir: '../backend/src/main/resources/dist',
}
