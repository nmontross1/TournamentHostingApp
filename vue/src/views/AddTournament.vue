<template>
  <div class="main">
    <h1>Tournament Bracket Creator</h1>
    <add-tournament-comp />
  </div>
</template>


<script>
import AddTournamentComp from "@/components/AddTournamentComp";

export default {
  name: "add-tournaments-view",
  components: {
    AddTournamentComp,
  },
};
</script>

<style scoped>
div.main {
  text-align: center;
}
</style>