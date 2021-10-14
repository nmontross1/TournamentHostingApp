<template>
  <div class="main">
    <img v-bind:src="this.$store.state.activeTournament.image" onerror="this.onerror=null; this.src='http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png';" />
    <h1>{{ this.$store.state.activeTournament.tournamentName }} </h1><br /> <br />
    {{ this.$store.state.activeTournament.tournamentDescription }} <br /><br />
     Tournament Size: {{ this.$store.state.activeTournament.bracketSize }}<br /><br />
     Tournament Date: {{this.$store.state.activeTournament.tournamentDate}}<br /><br />
     <!-- <button v-if= "showForm===false" id="invite" v-on:click="showForm = true">Invite Someone to the Tournament</button> -->
      
      <users-invite v-if= "showForm===true"/>
    <!--<button id="join-btn">Join tournament</button>-->
    <edit-four-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 4" />
    <div v-else>
      <edit-eight-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 8" />
      <div v-else>
        <edit-sixteen-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 16" />
        <div v-else>
          <edit-thirty-two-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 32" />
          <div v-else>
            <edit-sixty-four-team-bracket v-if="this.$store.state.activeTournament.bracketSize === 64" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import tournamentService from "../services/TournamentService";
import EditEightTeamBracket from './EditEightTeamBracket.vue';
import EditFourTeamBracket from './EditFourTeamBracket.vue';
import EditSixteenTeamBracket from './EditSixteenTeamBracket.vue';
import EditSixtyFourTeamBracket from './EditSixtyFourTeamBracket.vue';
import EditThirtyTwoTeamBracket from './EditThirtyTwoTeamBracket.vue';
import UsersInvite from './UsersInvite.vue';




export default {
  components: { EditFourTeamBracket, EditEightTeamBracket, EditSixteenTeamBracket, EditThirtyTwoTeamBracket, EditSixtyFourTeamBracket, UsersInvite },
  name: "tournament-edit",
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
  methods: {}
}
</script>

<style scoped>
div.main {
  text-align: center;
}

img {
  border-radius: 30px;
  margin-top: 10px;
}
</style>