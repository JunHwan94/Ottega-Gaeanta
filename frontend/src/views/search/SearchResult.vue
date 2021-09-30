<template>
  <div style="background: #f4f9f9;" id="searchBack">
    <div class="d-flex col">
      <p class="col-2"></p>
      <!-- 검색창 -->
      <div class="col-8 mx-4" style="z-index: 3;">
        <SearchItems/>
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
    <v-container id="container-height">
      <v-row id="searchRow" v-masonry>
        <v-col v-for="(image, index) in images" :key="index" cols="2">
          <v-hover :v-slot="{ hover }">
            <v-card id="card-img" @click="showStyleInfo({showSearchDetail, idx : index, imgURL : image})">
              <v-img :src="image"></v-img>
              <!-- <v-img src="@/assets/logo.png" @load="this.$redrawVueMasonry()"></v-img> -->
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
    </v-container>
    <SearchDetail :showSearchDetail="showSearchDetail"/>
  </div>
</template>

<script>

import SearchDetail from '@/components/search/SearchDetail'
import SearchItems from '@/components/search/SearchItems'
import ChangeStyleModal from '@/components/search/ChangeStyleModal'
import { mapActions, mapGetters, mapMutations, mapState } from 'vuex'
import InfiniteLoading from 'vue-infinite-loading';

// window.onscroll = function(e) {
//   if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
//     console.log(this.number)
//   }
// }
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
      hover: true,
      // showSearchDetail: false,
      chips: ['Programming', 'Playing video games', 'Watching movies', 'Sleeping'],
      items: ['Streaming', 'Eating'],
      page : 1
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail',
      'images',
      'imageInfos',
      'infin',
      'searchReq'
    ]),
  },
  mounted() {
    this.repaint();    
  },
  created() {
    window.addEventListener('scroll', this.infiniteHandler)
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
      setTimeout(() => this.$redrawVueMasonry(), 200);
    },
    async infiniteHandler() {
      if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
            let searchReq = this.$store.getters['getSearchReq']
            if(this.infin) searchReq.page++

            this.$store.commit('setSearchReq', searchReq)

            await this.$store.dispatch('showSearchItems', searchReq)
              .then((result) => {
                console.log(result.data)
                this.$store.commit('addImages', result.data)
                setTimeout(() => {
                  // 스크롤 막는 부분인데 효력 없음. 지우기 무서워서 그냥 둠.
                  $('body').off('scroll touchmove mousewheel');
                  this.repaint()
                  $('body').on('scroll touchmove mousewheel');
                }, 1000);
        })
      }
    }
  },
}
</script>

<style>
#searchBack {
  height: 100%;
  /* overflow: auto; */
}
#searchRow {
  /* overflow: v;  */
  height: 100%;
} 
/* #container-height {
  height: 110vh;
} */
#card-img:hover {
  border: 5px solid #FBACCC;
}
</style>