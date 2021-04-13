<template>

  <Header back="black"></Header>

  <div class="card">
    <span class="fas fa-window-close close" v-if="isLoggedIn & isAdmin"></span>
    <h1 class="card__title">{{ userInfos.firstname }} {{userInfos.lastname}}</h1>
    <p><span class="header">Nickname:</span> {{userInfos.nickname}}</p>
    <h4>Authorities </h4>
    <ul>
      <li :key="index2" v-for="(auth, index2) in userInfos.grantedAuthorities">
        {{index2}} - {{auth}}
      </li>
    </ul>
    <p><span class="header">Email:</span> {{userInfos.email}}</p>
    <img :src="userInfos.image"/>

    <div class="form-row">
      <button @click="logout" class="button">
        Logout
      </button>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
export default {
name: "ProfilePage",
  components: {Header},
  mounted: function () {
    if(this.$store.state.user.id === -1){
      this.$router.push('/')
    }
  },
  methods:{
    logout(){
      this.$store.commit('logout');
      this.$router.push("/");
    }
  },
  computed: {
    userInfos : function (){
      return this.$store.state.userInfos
    },
    isLoggedIn: function () {
      return this.$store.state.user.id !== -1
    },
    isAdmin: function () {
      return this.$store.state.userInfos.admin === true
    },
  }
}
</script>

<style scoped>

.close{
  font-size: 30px;
  color: red;
  position: absolute;
  right: 5%;
  top: 3%;
  cursor: pointer;
}
.header {
  font-size: 20px;
  font-weight: bold;
}
.form-row {
  display: flex;
  margin: 16px 0;
  gap:16px;
  flex-wrap: wrap;
}

.form-row__input {
  padding:8px;
  border: none;
  border-radius: 8px;
  background:#f2f2f2;
  font-weight: 500;
  font-size: 16px;
  flex:1;
  min-width: 100px;
  color: black;
}

.form-row__input::placeholder {
  color:#aaaaaa;
}

.error{
  color: red;
}

.card {
  position: relative;
  left: 50%;
  transform: translate(-50%, 30%);
  max-width: 100%;
  width: 540px;
  background:white;
  border-radius: 16px;
  padding:32px;
}

.card__title {
  text-align:center;
  font-weight: 800;
}

.card__subtitle {
  text-align: center;
  color:#666;
  font-weight: 500;
}

.button {
  background: #2196F3;
  color:white;
  border-radius: 8px;
  font-weight: 800;
  font-size: 15px;
  border: none;
  width: 100%;
  padding: 16px;
  transition: .4s background-color;
}

.card__action {
  color:#2196F3;
  text-decoration: underline;
}

.card__action:hover {
  cursor:pointer;
}

.button:hover {
  cursor:pointer;
  background: #1976D2;
}

.button--disabled {
  background:#cecece;
  color:#ececec
}
.button--disabled:hover {
  cursor:not-allowed;
  background:#cecece;
}
</style>