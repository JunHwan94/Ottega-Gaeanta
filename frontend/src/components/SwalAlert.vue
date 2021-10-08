<template>
  <div></div>
</template>

<script>
  import Swal from 'sweetalert2' 
  export default {
    name: 'SwalAlert',
    data: () => ({
    }),
    methods: {
      swalAlert(state, text) {
        if (state == 'error') {
          text = `<span style="color: white;">` + text + `</span>`
        }
        const bgColor = state === 'error' ? '#f27474' : '#a5dc86'
        return Swal.mixin({
          toast: true,
          position: 'top-right',
          iconColor: 'white',
          background: bgColor,
          customClass: {
            popup: 'colored-toast'
          },
          showConfirmButton: false,
          timer: 1500,
          timerProgressBar: true
        })
        .fire({
          icon: state,
          title: text
        })
      }
    }
  }
</script>

<style scoped>
</style>