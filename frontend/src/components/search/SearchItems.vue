<template>
  <v-main>
    <v-menu offset-y :close-on-click="false" :close-on-content-click="false" v-model="menuOpen">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" class="mt-4" style="width: 100%"><v-icon class="mx-4">mdi-magnify</v-icon>Search your style..</v-btn> <!-- class에 mt-4 검색창 안눌려서 내림 -->
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
              max-width="100%"
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
                    :color="active ? 'primary' : 'grey lighten-1'"
                    class="ma-4"
                    height="100"
                    width="70"
                    @click="toggle"
                  >
                  
                    <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    >
                      <h5>{{ styleItems[n-1] }}</h5>
                      <v-scale-transition>
                        <v-icon
                          v-if="active"
                          color="white"
                          size="30"
                          
                        ></v-icon>
                      </v-scale-transition>
                    </v-row>
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
              max-width="800"
            >
              <v-slide-group
                v-model="designValue"
                class="px-4"
                show-arrows
              >
                <v-slide-item
                  v-for="n in 8"
                  :key="n"
                  v-slot="{ active, toggle }"
                  
                >
                  <v-card
                    :color="active ? 'primary' : 'grey lighten-1'"
                    class="ma-4"
                    height="100"
                    width="70"
                    @click="toggle"
                  >
                    <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    >
                      <h3>{{ designItems[n-1] }}</h3>
                      <v-scale-transition>
                        <v-icon
                          v-if="active"
                          color="white"
                          size="30"
                          
                        ></v-icon>
                      </v-scale-transition>
                    </v-row>
                  </v-card>
                </v-slide-item>
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
    }
  },
  data () {
    return {
      menuOpen: false,
      firstname: "",
      lastname: "",
      categoryItems: ['상의','하의','아우터','원피스'], // 일단 상의만 했습니다
      categoryValue: null,
      model: null,
      styleItems: ['탑', '블라우스', '티셔츠', '니트웨어', '셔츠', '브라탑', '후드티'],
      styleValue: null,
      designItems: ['Black','white','grey','red','beige','purple','mint','yellow'],
      designValue: null,
    }
  }
}
</script>

<style>

</style>