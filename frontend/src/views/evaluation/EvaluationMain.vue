<template>
  <div class="eval-container">
    <v-container>
      <v-row class="mb-12 intro" justify="center" no-gutters>
        상의, 하의, 원피스 이미지를 업로드하시면 가상으로 스타일링해드립니다.
      </v-row>
    </v-container>
    <div class="card">
      <!-- <v-for key="" -->
      <v-row class="menu-container" justify="center">
        <div class="menu">
          사진 촬용
        </div>
      </v-row><br>
      <v-row class="menu-container" justify="center">
        <div class="menu">
          이미지 업로드
        </div>
      </v-row><br>
      <v-row class="menu-container" justify="center">
        <div class="menu">
          색 조합표
        </div>
      </v-row>
      <!-- 이미지로 버튼 눌림 효과 -->
      <!-- <v-row justify="center" no-gutters>
        <div class="photo">
          <img src="https://s-media-cache-ak0.pinimg.com/736x/06/d1/5f/06d15fc8a69e2ab67143e5357a4184d7.jpg"
            style="width: 100px; height: 100px;" />
          <div class="glow-wrap">
            <i class="glow"></i>
          </div>
        </div>
      </v-row> -->
    </div>
  </div>
</template>

<script>
  export default {
    data: () => ({
      menus: [
        { name: '사진 촬영'},
        { name: '이미지 업로드'}, 
        { name: '색 조합표'},
      ]
    }),
    mounted() {
      const menu = document.querySelector('.menu')
      // const card = document.querySelector('.card')
      menu.onmouseover = function() {
        // alert('test')
        // card.style.backgroundImage = url('https://webisfree.com/static/uploads/2019/0153_images886.jpg')
      }
    }
  }
</script>

<style scoped>
  .eval-container {
    padding-top: 4rem;
    height: 100vh;
    width: 100vw;
    background: linear-gradient(to bottom right, skyblue, white);

    /* background-image: '@/assets/main.png'; */
  }

  .intro {
    font-family: HSYuji-Regular;
  }

  .card {
    width: 80vw;
    height: 60vh;
    background-color: rgb(255, 255, 255);
    border: 1px solid white;
    border-radius: 10px;
    margin: 0 auto;
    /* opacity: 0.6; */
    padding: 50px;
  }
  .menu-container {
    height: 10vh;
    margin-top: 3vh;
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
    display: block;
    transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
    margin-top: -10px;
    background-color: hotpink;
    border-radius: 8px;
    cursor: pointer;
    font-family: HSYuji-Regular;;
    /* margin-bottom: 20px; */
  }

  .menu:hover {
    box-shadow: 1px 1px 10px 0 rgba(0, 0, 0, .1);
    margin-top: 0;
  }

  /* 이미지로 버튼 눌림 효과 css */
  /* .photo {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: block;
  }

  .photo img {
    width: 200px;
    height: 280px;
    object-fit: cover;
    filter: grayscale(100%) contrast(120%);
    box-shadow: 10px 15px 25px 0 rgba(0, 0, 0, .2);
    display: block;
    transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
    margin-top: -10px;
  }

  .photo:hover img {
    box-shadow: 1px 1px 10px 0 rgba(0, 0, 0, .1);
  }

  .photo .glow-wrap {
    overflow: hidden;
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    margin-top: -10px;
  }

  .photo .glow {
    display: block;
    position: absolute;
    width: 40%;
    height: 200%;
    background: rgba(255, 255, 255, .2);
    top: 0;
    filter: blur(5px);
    transform: rotate(45deg) translate(-450%, 0);
    transition: all .5s cubic-bezier(0.645, 0.045, 0.355, 1);
  }

  .photo:hover .glow {
    transform: rotate(45deg) translate(450%, 0);
    transition: all 1s cubic-bezier(0.645, 0.045, 0.355, 1);
  }

  .photo:hover img,
  .photo:hover .glow-wrap {
    margin-top: 0;
  } */
</style>