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
            <v-card :height="number[index-1]" color="blue" @click="showStyleInfo({showSearchDetail})">
              <!-- <v-card-title>{{item.title}}</v-card-title> -->
              <v-img src="@/assets/logo.png" @load="this.$redrawVueMasonry()" :height="number[index-1]"></v-img>
              <!-- <v-card-text>{{item.text}}</v-card-text> -->
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
    </v-container>
    <SearchDetail
      :showSearchDetail="showSearchDetail"
    />
  </div>
</template>

<script>
import SearchDetail from '@/components/search/SearchDetail'
import { mapActions, mapState } from 'vuex'

export default {
  components: {
    SearchDetail,
  },
  data () {
    return {
      number: [100,150,200,250,300,100,200,300,400,200,100,150,140,140,150,100,200,130,140,150],
      hover: true,
      showSearchDetail: false,
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail'
    ])
  },
  methods: {
    ...mapActions([
      'showStyleInfo'
    ])
  }
}
</script>

<style>

</style>