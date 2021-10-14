<template>
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
    
    <li class="game game-top ">{{users[4].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom winner">{{users[5].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[6].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[7].username}}</li>

    <li class="spacer">&nbsp;</li>
  </ul>
  <ul class="round round-2">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{winners[0]}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{winners[1]}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{winners[2]}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{winners[3]}}</li>

    <li class="spacer">&nbsp;</li>
  </ul>
  <ul class="round round-3">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{winners[4]}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{winners[5]}}</li>

    <li class="spacer">&nbsp;</li>
  </ul>
  <ul class="round round-4">    
    <li class="game game-top winner">{{winners[6]}} 🏆</li>
  </ul>   
</main>
</template>

<script>
import tournamentService from '@/services/TournamentService.js';
export default {
  data() {
    return{
      users: [],
      winners: []
    }
  },
  name: 'eight-team-bracket',
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
    }),
    tournamentService.getTournamentWinners(this.$store.state.activeTournament.tournamentID)
    .then((winnerData) => {
      this.winners = winnerData.data;
       while (this.winners.length < this.$store.state.activeTournament.bracketSize-1){
      this.winners.push("")
    }
    })
  }
}
</script>

<style>
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