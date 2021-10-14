<template>
  <div class="home">
    <h1>Team Beard's Tournament Hoster</h1>
    <tournament-list />
    
    <router-link v-bind:to="{ name: 'login' }">
      <button>Log In</button></router-link>
    
    <router-view />
  </div>
</template>

<script>
import TournamentList from "@/components/TournamentList.vue";

export default {
  name: "home",
  components: { TournamentList },
};
</script>


<style scoped>
div.home {
  text-align: center;
}
h1 {
  color: black;
}
</style>