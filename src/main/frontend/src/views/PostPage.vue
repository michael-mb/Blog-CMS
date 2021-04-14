<template>
  <Header></Header>
  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/post-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-heading">
            <h1>{{article.title}}</h1>
            <h2 class="subheading">{{article.subtitle}}</h2>
            <span class="meta">Posted by
              <a href="#">{{article.author}}</a>
              on {{article.date}}</span>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Post Content -->
  <article>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <p>{{article.text}}</p>
          <Stars :note="article.note"></Stars>
          <p>Placeholder text by
            <a href="#">{{article.author}}</a>.
          </p>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <h2>Comments</h2>
          <div v-for="comment in article.comments" :key="comment.id" class="comment-box">
            <span class="author">{{comment.authorName}}</span>
            <p class="text">{{comment.comment}}</p>
          </div>
          <form name="sentMessage" id="contactForm" v-if="isLoggedIn">
            <div class="control-group">
              <div class="form-group floating-label-form-group controls">
                <label>Message</label>
                <textarea rows="5" class="form-control" placeholder="Message" id="message" required data-validation-required-message="Please enter a message."></textarea>
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <br>
            <div id="success"></div>
            <button type="submit" class="btn btn-primary" id="sendMessageButton">Send</button>
          </form>
        </div>
      </div>
    </div>
  </article>

  <hr>

  <Footer></Footer>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import Stars from "@/components/Stars";
export default {
  name: "PostPage",
  props:['id'],
  data () {
    return {
    }
  },
  components: {Stars, Footer, Header},
  computed: {
    isLoggedIn: function () {
      return this.$store.state.user.id !== -1
    },
    isModerator: function () {
      return this.$store.state.userInfos.moderator === true
    },
    article: function (){
      return this.$store.state.article
    }
  },
  mounted() {
    if(!this.isLoggedIn){
      this.$router.push('/login')
    }
    this.$store.dispatch('getArticle' , this.id)
  }
}
</script>

<style scoped>
.author{
  font-size: 16px;
}
.text{
  margin-top: 15px;
  margin-bottom: 15px ;
}
.comment-box{
  min-width: 500px;
  color: white;
  float: left;
  height: auto;
  font-size: 17px;
  border: 1px solid #CCC;
  background-color: #4c4c4c;
  margin-top: 15px;
  padding: 6px 8px;
  border-radius: 15px;
}
</style>