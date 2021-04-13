<template>
  <Header back="back"></Header>
  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <div class="add-icon-container">
          <router-link to="/addArticle" v-if="isLoggedIn && isModerator">
            <i class="fas fa-plus-circle add-icon"></i>
          </router-link>
        </div>
        <Post v-for="post  in posts" :key="post.id" :subtitle="post.subtitle" :date="post.date" :text="post.text" :title="post.title"></Post>
      </div>
    </div>
  </div>
</template>

<script>
import Post from "@/components/Post";
import Header from "./Header";
export default {
  name: "Posts",
  components: {Header, Post},
  data(){
    return{
      posts: []
    }
  },
  computed: {
    isLoggedIn: function () {
      return this.$store.state.user.id !== -1
    },
    isModerator: function () {
      return this.$store.state.userInfos.moderator === true
    },
  },
  created() {
    this.posts = [
      {
        id:1,
        title: 'Man must explore, and this is exploration at its greatest',
        subtitle: 'Problems look mighty small from 150 miles up',
        date: 'September 24, 2019',
        text: 'Never in all their history have men been able truly to conceive of the world as one: a single sphere, a globe, having the qualities of a globe, a round earth in which all the directions eventually meet, in which there is no center because every point, or none, is center — an equal earth which all men occupy as equals. The airman\'s earth, if free men make it, will be truly round: a globe in practice, not in theory',
      },
      {
        id:2,
        title: 'Man must explore, and this is exploration at its greatest',
        subtitle: 'Problems look mighty small from 150 miles up',
        date: 'September 24, 2019',
        text: 'Never in all their history have men been able truly to conceive of the world as one: a single sphere, a globe, having the qualities of a globe, a round earth in which all the directions eventually meet, in which there is no center because every point, or none, is center — an equal earth which all men occupy as equals. The airman\'s earth, if free men make it, will be truly round: a globe in practice, not in theory',
      },
      {
        id:3,
        title: 'Man must explore, and this is exploration at its greatest',
        subtitle: 'Problems look mighty small from 150 miles up',
        date: 'September 24, 2019',
        text: 'Never in all their history have men been able truly to conceive of the world as one: a single sphere, a globe, having the qualities of a globe, a round earth in which all the directions eventually meet, in which there is no center because every point, or none, is center — an equal earth which all men occupy as equals. The airman\'s earth, if free men make it, will be truly round: a globe in practice, not in theory',
      },
    ]
  }
}
</script>

<style scoped>
.add-icon{
  font-size: 35px;
  color: #7dd47d;
  transition: 0.4s;
  cursor: pointer;

}
.add-icon:hover{
  font-size: 40px;
  color: #4fb34f;

}

.add-icon-container{
  padding-top: 30px;
  text-align: center;
}
</style>