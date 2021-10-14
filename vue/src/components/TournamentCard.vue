<template>
  <router-link
    v-bind:to="{
      name: 'tournament-details',
      params: { id: tournament.tournamentID }
    }"
  >
    <div class="card" id="card" v-bind:class="{ 'card-host': tournament.tournamentHostID === this.$store.state.user.id}">
      <img class="card_Image" v-bind:src="tournament.image" onerror="this.onerror=null; this.src='http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png';" />
      <div id="name">
        <h1 class="tournament-name">{{ tournament.tournamentName }}</h1> 
      </div>  
      <div id="description">
        <h3 v-if="tournament.tournamentDescription.length<150">{{ tournament.tournamentDescription }}</h3>
        <h3 v-else>{{ tournament.tournamentDescription.substring(0,150)+".." }}</h3> 
      </div>
      <br>
      <p id="host" v-if="tournament.tournamentHostID === this.$store.state.user.id">Hosted by you</p>
    </div>
  </router-link>
</template>

<script>
export default {
  name: "tournament-card",
  props: {
    tournament: Object,
  },

  methods: {},
};
</script>
<style>
#host {
  position: absolute;
  bottom: 0;
  right: 0;
  padding-right:5px;
  font-family: "Arial";
  color: white;
}
.tournament-name {
  color: white;
  line-height: 100%;
}
.card_Image {
  grid-area: img;
  width: 230px;
  height: 130px;
  border-radius: 10px;
  margin-top: 10px;
  
  background-size: 80%;
  background-repeat: no-repeat;
  background-position: 50%, 50%;
}
#host {
  display: flex;
  color:black;
  flex-wrap: wrap;
  flex-direction: column-reverse;
  align-self: flex-start;
  
}
.card {
  position:relative;
  background-color:#0d3b66;
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 400px;
  margin: 20px;
}
.card-host {
  background-color: #692636;
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 400px;
  margin: 20px;
}

.card .tournament-name {
  grid-area: name;
  font-size: 1.5rem;
  padding: 0px;
}

.card #description {
  grid-area: description;
  font-size: 0.7rem;
}

#description {
    color: white;
    font-size: 100%;
    width: 100%;
    margin: auto;
}

#name {
    width: 100%;
    margin: auto;
}
</style>