<template>
  <div>
    <div class="d-flex col">
      <p class="col-2">OTTEGA GAEANTA</p>
      <!-- 검색창 -->
      <div class="col-8 mx-4">
        <SearchItems

        />

        <!-- <v-btn style="width: 100%" @click="showSearchItems({searchItemsBool})">
          Search your style
        </v-btn>
        <SearchItems
          :searchItemsBool="searchItemsBool"
        /> -->
      </div>
      
    </div>
    <v-container>
      <v-row v-masonry>
        <v-col v-for="index in 20" :key="index" cols="3">
          <v-hover
            :v-slot="{ hover }"
          >
            <v-card color="grey" @click="showStyleInfo({showSearchDetail, imgURL : images[number[index-1]]})">
              <v-img :src="images[number[index-1]]" @load="this.$redrawVueMasonry()"></v-img>
              <!-- <v-img src="@/assets/logo.png" @load="this.$redrawVueMasonry()"></v-img> -->
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
import Vue from 'vue'
import SearchDetail from '@/components/search/SearchDetail'
import SearchItems from '@/components/search/SearchItems'
import { mapActions, mapState } from 'vuex'
import {VueMasonryPlugin} from 'vue-masonry'

Vue.use(VueMasonryPlugin)


export default {
  components: {
    SearchDetail,
    SearchItems,
  },
  data () {
    return {
      number: [0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2],
      images: [require('@/assets/1.jpg'),
               require('@/assets/2.jpg'),
               require('@/assets/3.jpg'),
              ],
      hover: true,
      // showSearchDetail: false,
      chips: ['Programming', 'Playing video games', 'Watching movies', 'Sleeping'],
      items: ['Streaming', 'Eating'],
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail',
      // 'searchItemsBool'
    ])
  },
  methods: {
    ...mapActions([
      'showStyleInfo',
      // 'showSearchItems'
    ]),
    remove (item) {
      this.chips.splice(this.chips.indexOf(item), 1)
      this.chips = [...this.chips]
    },
  }
}
</script>

<style>

</style>