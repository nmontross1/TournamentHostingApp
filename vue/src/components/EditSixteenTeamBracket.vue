<template>
<div>
<div class ="buttons"><button class ="editbtn" @click="submitWinners(winners)">Submit Winners</button>
  <button class="editbtn" @click="revert()">Cancel Submitting Winners</button></div>
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
    
    <li class="game game-top winner">{{users[8].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[9].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[10].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[11].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[12].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[13].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[14].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[15].username}}</li>


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
      <select v-model="winners[1]" name="winner" id="winner">
      <option value="">TBA</option>
      <option v-for="user in users.slice(2,4)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[2]" name="winner" id="winner">
      <option value="">TBA</option>
      <option v-for="user in users.slice(4,6)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[3]" name="winner" id="winner">
      <option value="">TBA</option>
   <option v-for="user in users.slice(6,8)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

     <li class="game game-top winner">
      <select v-model="winners[4]" name="winner" id="winner">
      <option value="">TBA</option>
    <option v-for="user in users.slice(8,10)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[5]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(10,12)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[6]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(12,14)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[7]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(14,16)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
  </ul>

    <ul class="round round-3">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[8]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(0,4)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[9]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(4,8)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[10]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(8,12)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[11]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(12,16)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
  </ul>

  <ul class="round round-4">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[12]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(0,8)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom ">
      <select v-model="winners[13]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(8,16)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

  </ul>
    <ul class="round round-4">    
    <!-- <li class="spacer">&nbsp;</li> -->

     <li class="game game-top winner">
      <select v-model="winners[14]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(0,16)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <!-- <li class="spacer">&nbsp;</li> -->
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
      winners: []
    }
  },
  name: 'edit-sixteen-team-bracket',
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