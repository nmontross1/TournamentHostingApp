
<template>
  <div class="main">
    <img v-bind:src="this.$store.state.activeTournament.image" onerror="this.onerror=null; this.src='http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png';" />
    <h1>{{ this.$store.state.activeTournament.tournamentName }} </h1><br /> <br />
    {{ this.$store.state.activeTournament.tournamentDescription }} <br /><br />
     Tournament Size: {{ this.$store.state.activeTournament.bracketSize }}<br /><br />
     Tournament Date: {{this.$store.state.activeTournament.tournamentDate}}<br /><br />
     <button v-if= "showForm===false && this.$store.state.activeTournament.tournamentHostID === this.$store.state.user.id"  id="invite" v-on:click="showForm = true">Invite Users To Tournament</button>
     <button v-if="this.$store.state.activeTournament.tournamentHostID === this.$store.state.user.id" @click="editTournament()" >Edit Tournament Results</button>
      
      <users-invite v-if= "showForm===true"/>
    <!--<button id="join-btn">Join tournament</button>-->
    <four-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 4" />
    <div v-else>
      <eight-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 8" />
      <div v-else>
        <sixteen-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 16" />
        <div v-else>
          <thirty-two-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 32" />
          <div v-else>
            <sixty-four-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 64" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import tournamentService from "../services/TournamentService";
import EightTeamBracket from './EightTeamBracket.vue';
import FourTeamBracket from './FourTeamBracket.vue';
import SixteenTeamBracket from './SixteenTeamBracket.vue';
import SixtyFourTeamBracket from './SixtyFourTeamBracket.vue';
import ThirtyTwoTeamBracket from './ThirtyTwoTeamBracket.vue';
import UsersInvite from './UsersInvite.vue';




export default {
  components: { FourTeamBracket, EightTeamBracket, SixteenTeamBracket, ThirtyTwoTeamBracket, SixtyFourTeamBracket, UsersInvite },
  name: "tournament-detail",
  props: {
    "tournamentID": Number,
  },
  data(){
    return {
      showForm: false
    }
  },
  created() {
    tournamentService.get(this.$route.params.id).then((tournamentData) => {
      this.$store.commit("SET_ACTIVE_TOURNAMENT", tournamentData.data);
    
    });
  },
  methods: {
    editTournament(){
      this.$router.push(`/tournament/${this.tournamentID}/edit-tournament`);
    }
  }
}
</script>

<style scoped>
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
div.main {
  text-align: center;
  font-family: "calibri";
  font-size: 150%;
  color:black;
}
img {
  border-radius: 30px;
  margin-top: 10px;
  width: 20%;
  height: auto;
}
</style>
