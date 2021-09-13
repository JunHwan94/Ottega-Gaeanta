<template>
  <div>
    <div class="d-flex justify-content-center text-align-center">
      <v-btn>
        검색 임시
      </v-btn>
    </div>
    <v-container>
      <v-row v-masonry>
        <v-col v-for="index in 20" :key="index" cols="3">
          <v-hover
            :v-slot="{ hover }"
          >
            <v-card :height="number[index-1]" color="blue">
              <!-- <v-card-title>{{item.title}}</v-card-title> -->
              <v-img src="@/assets/logo.png" @load="this.$redrawVueMasonry()" :height="number[index-1]"></v-img>
              <!-- <v-card-text>{{item.text}}</v-card-text> -->
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  data () {
    return {
      number: [100,150,200,250,300,100,20,30,40,50,10,20,30,40,50,10,20,30,40,50],
      hover: true,
    }
  },
  methods: {
    
  },
  computed: {
    
  },
}
</script>

<style>

</style>