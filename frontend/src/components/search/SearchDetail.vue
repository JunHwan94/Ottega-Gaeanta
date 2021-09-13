<template>
  <div class="text-center">
    <v-dialog
      v-model="showSearchDetail"
      persistent
      width="500"
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

      <v-card>
        <v-card-title class="text-h5 grey lighten-2">
          코디 정보
        </v-card-title>
        
        <div class="d-flex">
          <v-img src="@/assets/logo.png" alt="image"></v-img>
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
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'SearchDetail',
  // props: {
  //   showSearchDetail: {
  //     type: Boolean,
  //   }
  // },
  data () {
    return {
      dialog: false,
    }
  },
  computed: {
    ...mapState([
      'showSearchDetail'
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

</style>