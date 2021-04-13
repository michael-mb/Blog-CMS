<template>
  <Header></Header>
  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/post-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-heading">
            <h1>Man must explore, and this is exploration at its greatest</h1>
            <h2 class="subheading">Problems look mighty small from 150 miles up</h2>
            <span class="meta">Posted by
              <a href="#">Start Bootstrap</a>
              on August 24, 2019</span>
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
          <p>Never in all their history have men been able truly to conceive of the world as one: a single sphere, a globe, having the qualities of a globe, a round earth in which all the directions eventually meet, in which there is no center because every point, or none, is center — an equal earth which all men occupy as equals. The airman's earth, if free men make it, will be truly round: a globe in practice, not in theory.</p>

          <p>Science cuts two ways, of course; its products can be used for both good and evil. But there's no turning back from science. The early warnings about technological dangers also come from science.</p>

          <p>What was most significant about the lunar voyage was not that man set foot on the Moon but that they set eye on the earth.</p>

          <p>A Chinese tale tells of some men sent to harm a young girl who, upon seeing her beauty, become her protectors rather than her violators. That's how I felt seeing the Earth for the first time. I could not help but love and cherish her.</p>

          <Stars note="2"></Stars>
          <p>Placeholder text by
            <a href="http://spaceipsum.com/">AUTHOR</a>.
          </p>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <h2>Comments</h2>
          <div class="comment-box">
            <span class="author">Michael Mboni</span>
            <p class="text">A Chinese tale tells of some men sent to harm a young girl who, upon seeing her beauty, become her protectors rather than</p>
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
  components: {Stars, Footer, Header},
  computed: {
    isLoggedIn: function () {
      return this.$store.state.user.id !== -1
    },
    isModerator: function () {
      return this.$store.state.userInfos.moderator === true
    },
  },
  mounted() {
    if(!this.isLoggedIn){
      this.$router.push('/login')
    }
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