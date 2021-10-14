<template>

  <edit-tournament v-bind:tournamentID="parseInt($route.params.id)"/>

</template>

<script>
import EditTournament from '../components/EditTournament.vue';
export default {
  name: "tournament-detail-view",
  components: { EditTournament },
};
</script>

<style>
div.main {
color:black;
  font-family: "calibri";
  font-size: 120%;
  color:black;
}
img {
  border-radius: 30px;
  margin-top: 10px;
  width: 20%;
  height: auto;
}
button {
  font-family: "Comic Sans";
  font-size: 25px;
  background-color: #8f8f8f;
  border-radius: 10px;
  margin-left:5px;
  margin-right:5px;
}
h1 {
  color: black;
}
select {
  border-radius: 5px;
  width: 85px;
}
</style>