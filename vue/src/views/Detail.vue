<template>
  <tournament-detail v-bind:tournamentID="parseInt($route.params.id)"/>
</template>

<script>
import TournamentDetail from "../components/TournamentDetail.vue";
export default {
  name: "tournament-detail-view",
  components: { TournamentDetail },
};
</script>

<style>
</style>