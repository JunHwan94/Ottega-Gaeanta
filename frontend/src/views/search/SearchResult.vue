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
    </div>
    <v-container id="container-height">
      <v-row id="searchRow" v-masonry>
        <v-col v-for="(image, index) in images" :key="index" cols="2" class="list-complete-item">
          <v-hover :v-slot="{ hover }">
            <v-card id="card-img" @click="showStyleInfo({showSearchDetail, idx : index, imgURL : image})" @mouseover="splitImageUrl(image)">
              <v-img :src="image"></v-img>
              <!-- <v-img src="@/assets/logo.png" @load="this.$redrawVueMasonry()"></v-img> -->
              <div class="overlay">
                <div class="text">
                  <h2>{{ imageStyleInfo }}</h2>
                  <br>
                  <h5>상세보기 클릭</h5>
                </div>
              </div>
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
import { mapActions, mapMutations, mapState } from 'vuex'
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
      hover: true,
      // showSearchDetail: false,
      page : 1,
      showDesc: false,
      imageStyleInfo: [],
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
    this.$store.commit('SAVE_CHOOSE_STYLE_MENU_STATE', true)
    setTimeout(() => {this.repaint()}, 1000)
  },
  created() {
    console.log('검색화면')
    window.addEventListener('scroll', this.infiniteHandler)
    let searchReq = {
      category: "",
      cloth: "",
      color: "",
      page: 0,
      print: "",
      style: []
    }
    searchReq.style = this.$store.getters['getSelectedUserStyle']

    this.$store.commit('setSearchReq', searchReq)

    this.$store.dispatch('showSearchItems', searchReq)
      .then((result) => {
          console.log(result.data)
          // store에 있는 이미지 배열에 저장
          this.$store.commit('setImages', result.data);
          this.$store.commit('searchStart')
          this.repaint()
        })
    this.repaint()
  },
  watch: {
    images: function() {
      this.repaint();
    }
  },
  destroyed() {
    window.removeEventListener('scroll', this.infiniteHandler)
    this.$store.commit('SAVE_CHOOSE_STYLE_MENU_STATE', false)
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
    },
    splitImageUrl (image) {
      this.imageStyleInfo = image.split('/')[3]
    },
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
  border: 5px solid white;
  transition: 0.5s;
}
.list-complete-item #card-img .overlay {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    height: 100%;
    width: 100%;
    opacity: 0;
    transition: .5s ease;
    background-color: #FDBDCC;
}
.list-complete-item #card-img:hover .overlay {
    opacity: 0.8;
}
.list-complete-item #card-img .text {
    color: white;
    font-size: 1.0rem;
    position: absolute;
    top: 50%;
    left: 50%;
    -webkit-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    text-align: center;
    font-family: Cafe24Ssurround;
}
</style>