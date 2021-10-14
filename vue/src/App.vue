<template>
<body>
  

  <div class = "main" id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"><button>Home</button></router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"><button>Logout</button></router-link>
      <router-link v-bind:to="{ name: 'add-tournament' }" v-if="$store.state.token != ''"><button>Add Tournament</button></router-link>
      <router-link v-bind:to="{ name: 'my-tournaments' }" v-if="$store.state.token != ''"><button>My Tournaments</button></router-link>
    </div>
    <router-view />

    <footer class="footer">
      <p class="copyright">© Tournament Hosting Tech Elevator 2021</p>
    </footer>

  </div>
  </body>
</template>

<script>


export default {};
</script>

<style>
body {
  background-image: url("https://www.knoxalliance.store/wp-content/uploads/2017/05/light-color-background-images-for-website-top-hd-images-for-free-background-for-website-in-light-color-1-1024x640.jpg");
  background-repeat: no-repeat;
  background-size: cover;
}
.main{
font-family: "Tahoma";
 
}
#nav {

  grid-template-columns: 1fr 1fr 1fr 1fr;
  align-content: space-around;
  width: 100%;
  grid-template-areas: 
  "button button button button";
}

#nav button {
  font-family: "Comic Sans";
  font-size: 25px;
  background-color: #8f8f8f;
  border-radius: 10px;
  margin-left:5px;
  margin-right:5px;
}

footer {
        position: relative;
        height: 300px;
        width: 100%;
        color: black;
        
}

</style>