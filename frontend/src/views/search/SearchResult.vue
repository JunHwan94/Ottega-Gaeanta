<template>
  <div>
    <div class="d-flex col">
      <p class="col-2"></p>
      <!-- 검색창 -->
      <div class="col-8 mx-4" style="z-index: 3;">
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
              <v-img :src="images[number[index-1]]"></v-img>
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

import SearchDetail from '@/components/search/SearchDetail'
import SearchItems from '@/components/search/SearchItems'
import { mapActions, mapState } from 'vuex'



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
  mounted() {
    this.repaint();
  },
  watch: {
    images: function() {
      this.repaint();
    }
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
    repaint() {
      setTimeout(() => this.$redrawVueMasonry(), 500);
    }
  },
}
</script>

<style>

</style>