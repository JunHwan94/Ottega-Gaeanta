<template>
  <div style="background: #f4f9f9;" id="searchBack">
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
      <div class="col-1" style="z-index: 3;">
        <ChangeStyleModal/>
      </div>
    </div>
    <v-container>
      <v-row id="searchRow" v-masonry>        
        <v-col v-for="index in images" :key="index" cols="2">
          <v-hover
            :v-slot="{ hover }"
          >
            <v-card color="grey" @click="showStyleInfo({showSearchDetail, imgURL : images[number[index-1]]})">
              <v-img :src="index"></v-img>
              <!-- <v-img src="@/assets/logo.png" @load="this.$redrawVueMasonry()"></v-img> -->
            </v-card>
          </v-hover>
        </v-col>
        <infinite-loading @infinite="infiniteHandler" spinner="waveDots"></infinite-loading>
      </v-row>      
    </v-container>
    <SearchDetail
      :showSearchDetail="showSearchDetail"
    />
    <infinite-loading @infinite="infiniteHandler" spinner="waveDots"></infinite-loading>
  </div>
</template>

<script>

import SearchDetail from '@/components/search/SearchDetail'
import SearchItems from '@/components/search/SearchItems'
import ChangeStyleModal from '@/components/search/ChangeStyleModal'
import { mapActions, mapGetters, mapState } from 'vuex'
import InfiniteLoading from 'vue-infinite-loading';

export default {
  components: {
    SearchDetail,
    SearchItems,
    ChangeStyleModal,
    InfiniteLoading,
  },
  data () {
    return {
      number: [0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2],
      // images: [require('@/assets/1.jpg'),
      //          require('@/assets/2.jpg'),
      //          require('@/assets/3.jpg'),
      //         ],
      hover: true,
      // showSearchDetail: false,
      chips: ['Programming', 'Playing video games', 'Watching movies', 'Sleeping'],
      items: ['Streaming', 'Eating'],
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail',
      'images'
    ]),
  },
  mounted() {
    this.repaint();
  },
  watch: {
    // images: function() {
    //   this.repaint();
    // }
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
    },
    infiniteHandler() {
      console.log("인피니트")
    }
  },
}
</script>

<style>
/* #searchBack {
  height: 100%;
  overflow: auto;
} */
#searchRow {
  overflow: visible;
}
</style>