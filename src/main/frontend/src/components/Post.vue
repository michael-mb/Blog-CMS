<template>
  <div class="post-preview">
    <i class="fas fa-window-close close" v-if="isLoggedIn & isModerator"></i>
    <RouterLink to="/post">
      <h2 class="post-title">
        {{ title }}
      </h2>
      <h3 class="post-subtitle">
       {{subtitle}}
      </h3>
    </RouterLink>
    <p class="post-meta">Posted by
      <a href="#">{{author}}</a> on
      {{date}}</p>
  </div>
  <hr>
</template>

<script>
export default {
  name: "Post",
  props: {
    title : String,
    subtitle : String,
    author : String,
    date : String,
  },
  computed: {
    isLoggedIn: function () {
      return this.$store.state.user.id !== -1
    },
    isModerator: function () {
      return this.$store.state.userInfos.moderator === true
    },
  },
}
</script>

<style scoped>
.close{
  font-size: 30px;
  color: red;
  right: 5%;
  top: 3%;
  cursor: pointer;
}
</style>