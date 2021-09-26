<template>
  <div class="text-center">
    <v-dialog
      v-model="showSearchDetail"
      persistent
      width="70%"
      height="50%"
    >
      <!-- <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="red lighten-2"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Click Me
        </v-btn>
      </template> -->
      <!-- <flipbook class="flipbook" :pages="pages" v-slot="flipbook">
        <button @click="flipbook.flipLeft">Previous Page</button>
        <button @click="flipbook.flipRight">Next Page</button>
      </flipbook> -->

      <!-- 플립북 -->
      <section>
        <v-card>
          <div id="flipbook1">
            <div style="">
              <v-img 
                :src="searchDetailImageURL" 
                alt="image" 
                style="width: 50%; height: 50%; margin-left: 25%; margin-top: 10%"
              >
              </v-img>
              <h1 style="margin-top: 10%">상세보기 -> </h1>
            </div>
          </div>
          <div id="flipbook2">
            
            <h1>옷 정보</h1>
            <h1>스타일 : 아방가르드</h1>
            <br>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Soluta consequatur inventore quasi consequuntur in ipsam cum, non quam optio libero iure vel, dolore totam amet vero incidunt iusto suscipit voluptatibus.</p>
            
          </div>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="secondary"
              text
              @click="showStyleInfo({showSearchDetail})"
            >
              <h1>X</h1>
            </v-btn>
          </v-card-actions>
        </v-card>
      </section>

      <!-- 플립북 테스트 끝 -->

      <!-- <v-card>
        <v-card-title class="text-h5 grey lighten-2">
          코디 정보
        </v-card-title>
        
        <div class="d-flex">
          <v-img :src="searchDetailImageURL" alt="image" style="width: 25%; height: 70%;"></v-img>
          <v-card-text>
            <h1>스타일 : 아방가르드</h1>
            <br>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Soluta consequatur inventore quasi consequuntur in ipsam cum, non quam optio libero iure vel, dolore totam amet vero incidunt iusto suscipit voluptatibus.</p>
          </v-card-text>
        </div>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="primary"
            text
            @click="showStyleInfo({showSearchDetail})"
          >
            닫기
          </v-btn>
        </v-card-actions>
      </v-card> -->
    </v-dialog>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
// import Flipbook from 'flipbook-vue'

export default {
  name: 'SearchDetail',
  // props: {
  //   showSearchDetail: {
  //     type: Boolean,
  //   }
  // },
  components: { 
    // Flipbook 
  },
  data () {
    return {
      dialog: false,
      pages: ['@/assets/1.jpg',
              '@/assets/2.jpg',
              '@/assets/3.jpg',
              ]
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail',
      'searchDetailImageURL'
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
section{
  
  position: relative;
  width: 100vw;
  height: 80vh;
  perspective: 300vh;
}
#flipbook1 {
  margin:5% auto;
  position:absolute;
  left: 50%;
  width: 33vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #FFFFFF;
  transform-origin: left center;
  transition: 2s;
  z-index:5;
}

#flipbook2{
  margin:5% auto;
  position:absolute;
  left: 50%;
  width: 33vw; height: 70vh;
  text-align: center;
  box-shadow: 5px 5px 15px #333;
  background: #cba;
  transform-origin: left center;
  transition: 2s;   
  z-index: 4;
}
#flipbook1:hover{
  transform: rotateY(-180deg);
  background: #DDDDDD;
  
}

</style>