<template>
<div>
<div class ="buttons"><button @click="submitWinners(winners)">Submit Winners</button>
  <button @click="revert()">Cancel Submitting Winners</button></div>
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

    <li class="game game-top winner">{{users[16].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[17].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[18].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[19].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top ">{{users[20].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom winner">{{users[21].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[22].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[23].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[24].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[25].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[26].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[27].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[28].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[29].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[30].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[31].username}}</li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">{{users[32].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[33].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[34].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[35].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top ">{{users[36].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom winner">{{users[37].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[38].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[39].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[40].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[41].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[42].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[43].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[44].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[45].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[46].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[47].username}}/li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">{{users[48].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[49].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[50].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[51].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top ">{{users[52].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom winner">{{users[53].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[54].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[55].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[56].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[57].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[58].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[59].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[60].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[61].username}}</li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">{{users[62].username}}</li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">{{users[63].username}}</li>

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
    
     <li class="game game-top winner">
      <select v-model="winners[8]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(16,18)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[9]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(18,20)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[10]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(20,22)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[11]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(22,24)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

     <li class="game game-top winner">
      <select v-model="winners[12]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(24,26)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[13]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(26,28)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[14]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(28,30)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[15]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(30,32)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    <li class="game game-top winner">
      <select v-model="winners[16]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(32,34)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[17]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(34,36)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[18]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(36,38)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[19]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(38,40)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

     <li class="game game-top winner">
      <select v-model="winners[20]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(40,42)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[21]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(42,44)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[22]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(44,46)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[23]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(46,48)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
     <li class="game game-top winner">
    <select v-model="winners[24]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(48, 50)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[25]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(50,52)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[26]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(52, 54)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[27]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(54, 56)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

     <li class="game game-top winner">
      <select v-model="winners[28]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(56, 58)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[29]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(58,60)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[30]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(60, 62)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[31]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(62, 64)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
  </ul>
  <ul class="round round-3">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[32]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(0,4)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[33]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(4,8)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[34]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(8,12)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[35]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(12,16)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[36]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(16,20)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[37]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(20,24)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[38]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(24, 28)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[39]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(28, 32)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
    <li class="game game-top winner">
      <select v-model="winners[40]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(32, 36)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[41]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(36, 40)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[42]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(40,44)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[43]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(44, 48)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[44]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(48, 52)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[45]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(52, 56)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[46]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(56, 60)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    <li class="game game-spacer">&nbsp;</li>
    <li class="game game-bottom ">
      <select v-model="winners[47]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(60, 64)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="spacer">&nbsp;</li>
  </ul>
   <ul class="round round-4">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[48]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(0,8)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom ">
      <select v-model="winners[49]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(8, 16)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[50]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(16, 24)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom ">
      <select v-model="winners[51]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(24, 32)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[52]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(32, 40)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom ">
      <select v-model="winners[53]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(40 , 48)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[54]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(48, 56)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

    <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom ">
      <select v-model="winners[55]" name="winner" id="winner">
      <option value="">TBA</option>
 <option v-for="user in users.slice(56, 64)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

  </ul>

  <ul class="round round-4">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[56]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(0,16)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
  <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom winner">
      <select v-model="winners[57]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(16, 32)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
      <li class="spacer">&nbsp;</li>

    <li class="game game-top winner">
      <select v-model="winners[58]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(32, 48)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom winner">
      <select v-model="winners[59]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(48, 64)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>

  </ul>
    <ul class="round round-4">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[60]" name="winner" id="winner">
      <option value="">TBA</option>
     <option v-for="user in users.slice(0,32)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>

      <li class="game game-spacer">&nbsp;</li>

    <li class="game game-bottom winner">
      <select v-model="winners[61]" name="winner" id="winner">
      <option value="">TBA</option>
  <option v-for="user in users.slice(32, 64)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
    </li>
    
    <li class="spacer">&nbsp;</li>
    </ul>
  <ul class="round round-4">
    <li class="spacer">&nbsp;</li>
    
    <li class="game game-top winner">
      <select v-model="winners[62]" name="winner" id="winner">
      <option value="">TBA</option>
<option v-for="user in users.slice(0,64)" :value="user.username" :key="user.id">{{ user.username}}</option>
      </select>
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
      winners: []
    }
  },
  name: 'edit-sixtyfour-team-bracket',
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