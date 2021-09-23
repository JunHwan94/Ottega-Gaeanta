<template>
  <v-main>
    <v-menu offset-y :close-on-click="false" :close-on-content-click="false" v-model="menuOpen">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" class="mt-5" style="width: 100%"><v-icon class="mx-4">mdi-magnify</v-icon>Search your style..</v-btn> <!-- class에 mt-4 검색창 안눌려서 내림 -->
      </template>
      <v-card>
        <!-- 의류 카테고리 선택 -->
        <h3 class="my-2 mx-2">Category</h3>
        <v-autocomplete
          class="mx-3"
          v-model="categoryValue"
          :items="categoryItems"
          dense
          filled
          :label="categoryValue"
        ></v-autocomplete>

        <!-- 스타일 선택  -->
        <v-main v-if="categoryValue">
          <h3 class="my-2 mx-2">Style</h3>
          <v-divider></v-divider>
          <template>
            <v-sheet
              class="mx-5"
              max-width="80%"
            >
              <v-slide-group
                v-model="styleValue"
                class="px-4"
                show-arrows
              >
                <v-slide-item
                  v-for="n in 8"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :color="active ? '#BBBBBB' : 'white'"
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
                      src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
                      height="70%"
                    ></v-img>

                    <v-card-subtitle 
                      align="center"
                      justify="middle"
                      >
                      
                      <h3>{{ styleItems[n-1] }}</h3>
                    </v-card-subtitle>
                      <v-scale-transition>
                        <v-icon
                          v-if="active"
                          color="white"
                          size="30"
                          
                        ></v-icon>
                      </v-scale-transition>
                    <!-- </v-row> -->
                  </v-card>
                </v-slide-item>
              </v-slide-group>
              <v-divider></v-divider>
              <br>
              <v-expand-transition>
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
                    <h3 class="text-h6">
                      Selected {{ styleItems[styleValue] }}
                    </h3>
                  </v-row>
                </v-sheet>
              </v-expand-transition>
              
            </v-sheet>
          </template>
          
        </v-main>

        <!-- 디자인 선택 (패턴, 색상) -->
        <v-main v-if="styleValue != null">
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
                    :color="active ? '#BBBBBB' : 'white'"
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
                <!-- 여기부터는 패턴들 -->
                <!-- <v-slide-item
                  v-for="n in list"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :color="active ? '#BBBBBB' : 'white'"
                    class=""
                    height="5.5rem"
                    width="4rem"
                    @click="toggle"
                    style="text-align:center;"
                    elevation="0"
                  >
                    <v-avatar
                      
                      size="2rem"
                      @click="toggle"
                      class="ma-3"
                      style="border: 1px solid black"
                    >
                      
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
                </v-slide-item> -->
              </v-slide-group>
              <v-divider></v-divider>
              <br>
              
              <v-expand-transition>
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
              </v-expand-transition>
              
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
          <v-btn v-if="designValue != null" color="primary" @click="save">검색</v-btn>
          <v-btn v-else disabled color="primary" @click="save">검색</v-btn>
        </v-card-actions>
      </v-card>
    </v-menu>
  </v-main>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'SearchItems',
  computed: {
    ...mapState([
      'showSearchDetail',
      'searchItemsBool',
    ])
  },
  methods: {
    ...mapActions([
      'showStyleInfo',
      'showSearchItems',
    ]),
    save() {
      alert(`검색 ㄱㄱ싱!`);
      this.menuOpen = false;
      this.menuOpen = false;
      this.categoryValue = null;
      this.styleValue = null;
      this.designValue = null;
      this.model = null;
    },
    initialization () {
      this.menuOpen = false;
      this.categoryValue = null;
      this.styleValue = null;
      this.designValue = null;
      this.model = null;
    },
  },
  data () {
    return {
      list: [14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31],
      menuOpen: false,
      firstname: "",
      lastname: "",
      categoryItems: ['상의','하의','아우터','원피스'], // 일단 상의만 했습니다
      categoryValue: null,
      model: null,
      styleItems: ['탑', '블라우스', '티셔츠', '니트웨어', '셔츠', '브라탑', '후드티'],
      styleValue: null,
      designItems: [
                    'black','white','grey','red','pink','orange','beige','brown','yellow','green','blue','sky blue','purple',
                    'check','stripe','zigzag','leopard','zebra','dot','camouflage','paisley','argyle','floral','lettering','skull','tiedye','gradation','solid','graphic','houndstouth','gingham'
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

</style>