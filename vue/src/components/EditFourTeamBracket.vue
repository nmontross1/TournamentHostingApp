<template>
<div>
<div class = "buttons"><button  @click="submitWinners(winners)">Submit Winners</button>
  <button  @click="revert()">Cancel Submitting Winners</button></div>
<main id="tournament">
  
  <ul class="round round-1">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[0].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[1].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[2].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[3].username}}</li>

    <li class="spacer">&nbsp;</li>
  </ul>
  <ul class="round round-2">
    <li class="spacer">&nbsp;</li>
    
    
    <li class="game game-top winner">
      <select v-model="winners[0]" name="winner" id="winner">
      <option value="">TBA</option>
      <option v-for="user in users.slice(0,2)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[1]"  name="winner" id="winner">
      <option value="">TBA</option>
     <option v-for="user in users.slice(2,4)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
  </ul>
  <ul class="round round-3">
    
    <li class="spacer">&nbsp;</li>
    <li class="game game-top winner">
      <select v-model="winners[2]" name="winner" id="winner">
      <option value="">TBA</option>
      <option v-for="user in users" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="spacer">&nbsp;</li>
  </ul>  
</main>
</div>
</template>

<script>
import tournamentService from '@/services/TournamentService.js';
export default {
  data() {
    return{
      users: [],
      winners: [],
    }
  },
  name: 'edit-four-team-bracket',
  props: {
    tournamentID: Number,
  },
  created() {
    tournamentService.getTournamentUsers(this.$store.state.activeTournament.tournamentID)
    .then((userData) =>{
    this.users=userData.data;
    while(this.users.length < this.$store.state.activeTournament.bracketSize){
      this.users.push({
        id: this.users.length-1,
        username: "TBA"
      })
    }
    })
    tournamentService.getTournamentWinners(this.$store.state.activeTournament.tournamentID)
    .then((winnerData) => {
      this.winners = winnerData.data;
       while (this.winners.length < this.$store.state.activeTournament.bracketSize-1){
      this.winners.push("")
    }
    })
   
      },
      methods: {
        submitWinners(winners){
          tournamentService.assignWinners(this.$store.state.activeTournament.tournamentID, winners)
          this.$router.push({name: 'tournament-details', params: {id: this.$store.state.activeTournament.tournamentID}})
          this.$router.go();
          this.winners = [];
        },
        revert(){
          this.winners = []
           this.$router.push({name: 'tournament-details', params: {id: this.$store.state.activeTournament.tournamentID}})
          this.$router.go();
        }
      }
}
</script>

<style>
.buttons{
  display: flex;
  justify-content: center;
  text-align: center;
}
main{
  display:flex;
  flex-direction:row;
}
.round{
  display:flex;
  flex-direction:column;
  justify-content:center;
  width:200px;
  list-style:none;
  padding:0;
}
  .round .spacer{ flex-grow:1; }
  .round .spacer:first-child,
  .round .spacer:last-child{ flex-grow:.5; }

  .round .game-spacer{
    flex-grow:1;
  }

  body{
  font-family:sans-serif;
  font-size:small;
  padding:10px;
  line-height:1.4em;
}

li.game{
  padding-left:20px;
}

  /* li.game.winner{
    font-weight:bold;
  } */
  li.game span{
    float:right;
    margin-right:5px;
  }

  li.game-top{ border-bottom:1px solid rgb(0, 0, 0); }

  li.game-spacer{ 
    border-right:1px solid rgb(0, 0, 0);
    min-height:40px;
  }
  li.game-bottom{ 
    border-top:1px solid rgb(0, 0, 0);
  }
</style>