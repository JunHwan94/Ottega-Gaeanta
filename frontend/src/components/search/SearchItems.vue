<template>
  <v-main class="search-container">
    <v-menu offset-y :close-on-click="false" :close-on-content-click="false" v-model="menuOpen">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" class="" style="width: 100%"><v-icon class="mx-4">mdi-magnify</v-icon>Search your style..</v-btn> <!-- class에 mt-4 검색창 안눌려서 내림 -->
      </template>
      <v-card max-width="100%">
        <!-- 의류 카테고리 선택 -->
        <v-main>
          <h3 class="my-2 mx-2">Category</h3>
          <v-divider></v-divider>
          <template>
            <v-sheet
              class="mx-5"
              max-width="80%"
            >
              <v-slide-group
                v-model="categoryValue"
                class="px-4"
                show-arrows
              >
                <v-slide-item
                  v-for="n in 4"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :style="active ? 'border: 7px solid #FBACCC;' : 'border: 1px solid white;'"
                    class="ma-4"
                    height="10rem"
                    width="7rem"
                    @click="toggle"
                  >
                    <v-img
                      :src="require('@/assets/categories/' + categoryItems[n-1] + '.jpg')"
                      height="70%"
                    ></v-img>

                    <v-card-subtitle 
                      align="center"
                      justify="middle"
                      >
                      
                      <h4>{{ categoryItems[n-1] }}</h4>
                    </v-card-subtitle>
                    <v-scale-transition>
                      <v-icon
                        v-if="active"
                        color="white"
                        size="30"
                        
                      ></v-icon>
                    </v-scale-transition>
                  </v-card>
                </v-slide-item>
              </v-slide-group>
              <v-divider></v-divider>
              <br>
              <!-- <v-expand-transition>
                <v-sheet
                  v-if="categoryValue != null"
                  height="50"
                  tile
                >
                  <v-row
                    class="fill-height"
                    align="center"
                    justify="center"
                  >
                    <h3 class="text-h6">
                      Selected {{ categoryItems[categoryValue] }}
                    </h3>
                  </v-row>
                </v-sheet>
              </v-expand-transition> -->
              
            </v-sheet>
          </template>
        </v-main>


        <!-- <h3 class="my-2 mx-2">Category</h3>
        <v-autocomplete
          class="mx-3"
          v-model="categoryValue"
          :items="categoryItems"
          dense
          filled
          :label="categoryValue"
        ></v-autocomplete> -->

        <!-- 스타일 선택  -->
        <v-main v-if="categoryValue != null">
          <h3 class="my-2 mx-2">Style</h3>
          <v-divider></v-divider>
          <template>
            <v-sheet
              class="mx-5"
              max-width="80%"
            >
              <!-- 상의 -->
              <v-slide-group
                v-model="styleValue"
                class="px-4"
                show-arrows
                v-if="categoryValue === 0"
              >
                <v-slide-item
                  v-for="n in topIndex"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :style="active ? 'border: 7px solid #FBACCC;' : 'border: 1px solid white;'"
                    class="ma-4"
                    height="10rem"
                    width="7rem"
                    @click="toggle"
                  >
                    <v-img
                      :src="require('@/assets/styleCategories/' + styleItems[n-1] + '.jpg')"
                      height="70%"
                    ></v-img>

                    <v-card-subtitle 
                      align="center"
                      justify="middle"
                      >
                      
                      <h4>{{ styleItems[n-1] }}</h4>
                    </v-card-subtitle>
                    <v-scale-transition>
                      <v-icon
                        v-if="active"
                        color="white"
                        size="30"
                        
                      ></v-icon>
                    </v-scale-transition>
                  </v-card>
                </v-slide-item>
              </v-slide-group>

              <!-- 하의 -->
              <v-slide-group
                v-model="styleValue"
                class="px-4"
                show-arrows
                v-if="categoryValue === 1"
              >
                <v-slide-item
                  v-for="n in bottomIndex"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :style="active ? 'border: 7px solid #FBACCC;' : 'border: 1px solid white;'"
                    class="ma-4"
                    height="10rem"
                    width="7rem"
                    @click="toggle"
                  >
                  
                    <!-- <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    > -->
                    <v-img
                      :src="require('@/assets/styleCategories/' + styleItems[n-1] + '.jpg')"
                      height="70%"
                    ></v-img>

                    <v-card-subtitle 
                      align="center"
                      justify="middle"
                      >
                      
                      <h4>{{ styleItems[n-1] }}</h4>
                    </v-card-subtitle>
                    <v-scale-transition>
                      <v-icon
                        v-if="active"
                        color="white"
                        size="30"
                        
                      ></v-icon>
                    </v-scale-transition>
                  </v-card>
                </v-slide-item>
              </v-slide-group>
              
              <!-- 아우터 -->
              <v-slide-group
                v-model="styleValue"
                class="px-4"
                show-arrows
                v-if="categoryValue === 2"
              >
                <v-slide-item
                  v-for="n in outerIndex"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :style="active ? 'border: 7px solid #FBACCC;' : 'border: 1px solid white;'"
                    class="ma-4"
                    height="10rem"
                    width="7rem"
                    @click="toggle"
                  >
                  
                    <!-- <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    > -->
                    <v-img
                      :src="require('@/assets/styleCategories/' + styleItems[n-1] + '.jpg')"
                      height="70%"
                    ></v-img>

                    <v-card-subtitle 
                      align="center"
                      justify="middle"
                      >
                      
                      <h4>{{ styleItems[n-1] }}</h4>
                    </v-card-subtitle>
                    <v-scale-transition>
                      <v-icon
                        v-if="active"
                        color="white"
                        size="30"
                        
                      ></v-icon>
                    </v-scale-transition>
                  </v-card>
                </v-slide-item>
              </v-slide-group>

              <!-- 원피스 -->
              <v-slide-group
                v-model="styleValue"
                class="px-4"
                show-arrows
                v-if="categoryValue === 3"
               >
                <v-slide-item
                  v-for="n in dressIndex"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :style="active ? 'border: 7px solid #FBACCC;' : 'border: 1px solid white;'"
                    class="ma-4"
                    height="10rem"
                    width="7rem"
                    @click="toggle"
                  >
                    <v-img
                      :src="require('@/assets/styleCategories/' + styleItems[n-1] + '.jpg')"
                      height="70%"
                    ></v-img>

                    <v-card-subtitle 
                      align="center"
                      justify="middle"
                      >
                      
                      <h4>{{ styleItems[n-1] }}</h4>
                    </v-card-subtitle>
                    <v-scale-transition>
                      <v-icon
                        v-if="active"
                        color="white"
                        size="30"
                        
                      ></v-icon>
                    </v-scale-transition>
                  </v-card>
                </v-slide-item>
              </v-slide-group>

              <v-divider></v-divider>
              <br>
              <!-- <v-expand-transition>
                <v-sheet
                  v-if="styleValue != null"
                  height="50"
                  tile
                >
                  <v-row
                    class="fill-height"
                    align="center"
                    justify="center"
                  >
                    <h3 class="text-h6" v-if="categoryValue === 0">
                      Selected {{ styleItems[topIndex[styleValue]-1] }}
                    </h3>
                    <h3 class="text-h6" v-if="categoryValue === 1">
                      Selected {{ styleItems[bottomIndex[styleValue]-1] }}
                    </h3>
                    <h3 class="text-h6" v-if="categoryValue === 2">
                      Selected {{ styleItems[outerIndex[styleValue]-1] }}
                    </h3>
                    <h3 class="text-h6" v-if="categoryValue === 3">
                      Selected {{ styleItems[dressIndex[styleValue]-1] }}
                    </h3>
                  </v-row>
                </v-sheet>
              </v-expand-transition> -->
              
            </v-sheet>
          </template>
        </v-main>

        <!-- 디자인 선택 (패턴, 색상) -->
        <v-main v-if="styleValue != null" id="design-overflow">
        <h3 class="my-2 mx-2">Design</h3>
        <v-divider></v-divider>
          <template>
            <v-sheet
              class="mx-5"
              max-width="80%"
            >
              <v-slide-group
                v-model="designValue"
                class="px-4"
                show-arrows
              >
                <v-slide-item
                  v-for="n in 31"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :color="active ? '#FBACCC' : 'white'"
                    class=""
                    height="5.5rem"
                    width="4rem"
                    @click="toggle"
                    style="text-align:center;"
                    elevation="0"
                  >
                    <v-avatar
                      :color="designRGBs[n-1]"
                      size="2rem"
                      @click="toggle"
                      class="ma-3"
                      style="border: 1px solid black"
                    >
                      <v-img :src="require('@/assets/designpatterns/' + designItems[n-1] + '.jpg')" v-if="n > 13"></v-img>
                      <v-scale-transition>
                        <v-icon
                          v-if="active"
                          color="white"
                          size="4rem"
                          
                        ></v-icon>
                      </v-scale-transition>
                    </v-avatar>
                    <div style="text-align:center;">
                      <span 
                        class="black--text"
                        style="font-size:0.8rem"
                      >
                        {{ designItems[n-1] }}
                      </span>
                    </div>
                  </v-card>
                </v-slide-item>
              </v-slide-group>
              <v-divider></v-divider>
              <br>
              
              <!-- <v-expand-transition>
                <v-sheet
                  v-if="designValue != null"
                  height="50"
                  tile
                >
                  <v-row
                    class="fill-height"
                    align="center"
                    justify="center"
                  >
                    <h3 class="text-h6">
                      Selected {{ designItems[designValue] }}
                    </h3>
                  </v-row>
                </v-sheet>
              </v-expand-transition> -->
              
            </v-sheet>
          </template>
          <v-divider></v-divider>
        </v-main>
        <!-- <v-card-text>
          <v-text-field label="First Name" v-model="firstname"></v-text-field>
          <v-text-field label="Last Name" v-model="lastname"></v-text-field>
        </v-card-text>-->
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="grey darken-2" @click="initialization()" dark>닫기</v-btn>
          <v-btn v-if="designValue != null" color="#FBACCC" @click="save">검색</v-btn>
          <v-btn v-else disabled color="#FBACCC" @click="save">검색</v-btn>
        </v-card-actions>
      </v-card>
    </v-menu>
  </v-main>
</template>

<script>
import { mapActions, mapState, mapGetters } from 'vuex'

export default {
  name: 'SearchItems',
  created() {
    this.$store.commit('initInfin')
  },
  computed: {
    ...mapState([
      'showSearchDetail',
      'searchItemsBool',
    ]),
    ...mapGetters(["getSelectedUserStyle"]),
  },
  methods: {
    ...mapActions([
      'showStyleInfo',
      'showSearchItems',
    ]),
    save() {
      let colorSample = ['블랙','화이트','그레이','레드','핑크','오렌지','베이지','브라운','옐로우','그린','블루','스카이블루','퍼플'];
      
      let searchReq = {}

      if (this.categoryItemsHash[this.categoryItems[this.categoryValue]] === 'top') {
        searchReq = {
          style : '',
          cloth : this.categoryItemsHash[this.categoryItems[this.categoryValue]],
          category : this.styleItems[this.topIndex[this.styleValue]-1],
          color : '',
          print : '',
          page : 0,
        };
      } 
      else if (this.categoryItemsHash[this.categoryItems[this.categoryValue]] === 'bottom') {
        searchReq = {
          style : '',
          cloth : this.categoryItemsHash[this.categoryItems[this.categoryValue]],
          category : this.styleItems[this.bottomIndex[this.styleValue]-1],
          color : '',
          print : '',
          page : 0,
        };
      } 
      else if (this.categoryItemsHash[this.categoryItems[this.categoryValue]] === 'outer') {
        searchReq = {
          style : '',
          cloth : this.categoryItemsHash[this.categoryItems[this.categoryValue]],
          category : this.styleItems[this.outerIndex[this.styleValue]-1],
          color : '',
          print : '',
          page : 0,
        };
      } 
      else {
        searchReq = {
          style : '',
          cloth : this.categoryItemsHash[this.categoryItems[this.categoryValue]],
          category : this.styleItems[this.dressIndex[this.styleValue]-1],
          color : '',
          print : '',
          page : 0,
        };
      } 
      


      // 선호하는 스타일들을 request 객체에 추가 
      searchReq.style = this.getSelectedUserStyle

      // 색인지 무늬인지 구별
      if(!colorSample.includes(this.designItems[this.designValue])){
        searchReq.print = this.designItems[this.designValue];
      } else searchReq.color = this.designItems[this.designValue];

      // store에 있는 searchReq에 저장
      this.$store.commit('setSearchReq', searchReq)

      console.log(this.styleItems[this.outerIndex[this.styleValue]-1], searchReq)

      // action에 있는 백엔드 API 호출 function 실행
      this.$store.dispatch('showSearchItems', searchReq)
        .then((result) => {
          console.log(result.data)
          // store에 있는 이미지 배열에 저장
          this.$store.commit('setImages', result.data);
          this.$store.commit('searchStart')
        })
      
      
      // 메뉴 닫기. (일단 기존 검색 이력은 남겨두고 닫습니다.)
      this.menuOpen = false;
      // this.menuOpen = false;
      // this.categoryValue = null;
      // this.styleValue = null;
      // this.designValue = null;
    },
    initialization () {
      this.menuOpen = false;
      this.categoryValue = null;
      this.styleValue = null;
      this.designValue = null;
    },
  },
  data () {
    return {
      menuOpen: false,
      categoryItemsHash: {'상의': 'top', '하의': 'bottom', '아우터': 'outer', '원피스': 'onepiece'},
      categoryItems: ['상의','하의','아우터','원피스'],
      categoryValue: null,
      styleItems: [
        '탑', '블라우스', '티셔츠', '셔츠', '니트웨어', '후드티', '브라탑',
        '코트', '재킷', '점퍼', '패딩', '짚업', '가디건', '베스트',
        '청바지', '팬츠', '스커트', '레깅스', '조거팬츠',
        '드레스','점프수트'],
      styleValue: null,
      topIndex: [1,2,3,4,5,6,7],
      outerIndex: [8,9,10,11,12,13,14],
      bottomIndex: [15,16,17,18,19],
      dressIndex: [20,21],
      designItems: [
                    '블랙','화이트','그레이','레드','핑크','오렌지','베이지','브라운','옐로우','그린','블루','스카이블루','퍼플',
                    '체크','스트라이프','지그재그','호피','지브라','도트','카무플라쥬','페이즐리','아가일','플로럴','레터링','해골','타이다이','그라데이션','무지','그래픽','하운즈 투스','깅엄'
                    ],
      designRGBs: [
                    '#000000','#FFFFFFF','#808080','#FF0000','#FF00FF','#FFA500','#F5F5DC','#964B00','#FFFF00','#008000','#0000FF','#87CEEB','#800080',
                    '#000000','#FFFFFFF','#808080','#FF0000','#FF00FF','#FFA500','#F5F5DC','#964B00','#FFFF00','#008000','#0000FF','#87CEEB','#800080','#964B00','#FFFF00','#008000','#0000FF','#87CEEB'
                    ],
      designValue: null,
    }
  }
}
</script>

<style>
.search-container {
  z-index: 10;
}
#design-overflow {
  overflow: hidden;
}
</style>