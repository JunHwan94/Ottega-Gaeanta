<template>
  <div class="eval-container">
    <v-container>
      <v-row class="mb-12 intro" justify="center" no-gutters>
        상의, 하의, 원피스 이미지를 업로드하시면 가상으로 스타일링해드립니다.
      </v-row>
    </v-container>
    <div class="card">
      <v-row class="menu-container" justify="center">
        <v-col lg=4>
          <v-row class="menu-container" justify="center" @click="changePage(0)">
            <div class="menu" style="">
              실시간 측정 방식
              <img :src="test" style="vertical-align:middle; width: 50px; height: 50px;"/>
              <!-- <v-icon large color="white darken-5">mdi-selection</v-icon> -->
            </div>
          </v-row><br>
          <v-row class="menu-container" justify="center">
            <div class="menu" @click="toggleModal()">
              사진 업로드 방식
              <img :src="test1" style="vertical-align:middle; width: 50px; height: 50px;"/>
              <!-- <v-icon large color="white darken-5"> mdi-folder-star</v-icon> -->
            </div>
          </v-row><br>
          <v-row class="menu-container" justify="center">
            <div class="menu" @click="toggleColorTableModal()">
              평가 방식 보기
              <img :src="test2" style="vertical-align:middle; width: 50px; height: 50px;"/>
              <!-- <v-icon large color="white darken-5"> mdi-arrow-up-bold-box-outline</v-icon> -->
            </div>
          </v-row>
        </v-col>
      </v-row>
    </div>
    <evaluation-picture-modal v-if="modalVisible" @close="invisibleModal"></evaluation-picture-modal>
    <evaluation-color-table v-if="colorTableVisible" @close="invisibleColorTable"></evaluation-color-table>
  </div>
</template>

<script>
  import EvaluationPictureModal from '@/components/evaluation/EvaluationPictureModal.vue'
  import EvaluationColorTable from '@/components/evaluation/EvaluationColorTable.vue'
  import { mapGetters } from "vuex"
  export default {
    data: () => ({
      pages: ['/evaluationFilm'],
      mainImageUrl: '',
      test: require('@/assets/camerapicture.png'),
      test1: require('@/assets/picture.png'),
      test2: require('@/assets/color.png'),
      modalVisible: false,
      colorTableVisible: false,
    }),
    components: {
      EvaluationPictureModal,
      EvaluationColorTable,
    },
    computed: {
      ...mapGetters(['getColorModalState']),
    },
    mounted() {
      if (this.getColorModalState) {
        this.colorTableVisible = true
      }
    },
    destroyed() {
      this.$store.commit('SAVE_COLOR_MODAL_STATE', false)
    },
    methods: {
      changePage(index) {
        // this.$router.push(this.pages[index])

        this.$router.push({name: 'EvaluationFilm'})
        // EvaluationFilm
      },
      toggleModal () {
        this.modalVisible = !this.modalVisible
      },
      invisibleModal () {
        this.modalVisible = false
      },
      toggleColorTableModal () {
        this.colorTableVisible = !this.colorTableVisible
      },
      invisibleColorTable () {
        this.colorTableVisible = false
      }
    }
  }
</script>

<style scoped>
.eval-container {
  padding-top: 4rem;
  height: 100vh;
  width: 100vw;
  background: linear-gradient(to bottom right, #FBACCC, #F1D1D0, white);
}

.intro {
  font-family: Cafe24Ssurround;
}

.card {
  width: 80vw;
  height: 60vh;
  background-color: #F4F9F9;
  border: 1px solid #F4F9F9;
  border-radius: 10px;
  margin: 0 auto;
  /* opacity: 0.6; */
  padding: 50px;
}

.menu-container {
  height: 10vh;
  margin-top: 3vh;
  font-size: 1.2rem;
}

.menu {
  width: 20vw;
  height: 10vh;
  border: 1px solid hotpink;
  text-align: center;
  line-height: 10vh;
  /* margin-top: 2rem; */
  object-fit: cover;
  /* filter: grayscale(100%) contrast(120%); */
  box-shadow: 10px 15px 25px 0 rgba(0, 0, 0, .2);
  /* display: block; */
  transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
  margin-top: -10px;
  background-color: #F875AA;
  border-radius: 8px;
  cursor: pointer;
  font-family: Cafe24Ssurround;
  ;
  /* margin-bottom: 20px; */
}

.menu:hover {
  box-shadow: 1px 1px 10px 0 rgba(0, 0, 0, .1);
  margin-top: 0;
}

.blur {
  background: black;
  opacity: 0.5;
}
</style>