<template>
  <div class="userbox" id="userbox">
      <table id="tblUser" class = "center">
          <thead>
              <tr>
                  <th> &nbsp;</th>
                  <button id = "submit" v-on:click=submitUsers()> Click To Send Invites </button>
              </tr>
              <tr>
                  
                  
                  <th>&nbsp;</th>
                  <th>Username</th>
              </tr>
          </thead>
          <tbody>
              <tr>
                  <td>&nbsp;</td>
                  <td>
                      <input type="text" id="userNameFilter" v-model="filter.username"/>
                  </td>
              </tr>
              <tr
              v-for="user in filteredList.slice(0, 8)"
              v-bind:key="user.id">
                  <td>
                      <input type="checkbox" v-bind:id="user.id" v-bind:value="user.id" v-model="selectedUserIDs"/>
                  </td>
                  <td>{{user.username}}</td>
              </tr>
          </tbody>
      </table>
  </div>
  
</template>

<script>
import tournamentService from "../services/TournamentService";
export default {
  components: {},
  name: "users-invite",
  data() {
    return {
      allUsers: [],
      selectedUserIDs: [],
      filter: {
        username: "",
      },
    };
  },
  props: {
    tournamentID: Number,
  },
  created() {
    tournamentService.getUsers().then((usersData) => {
      this.allUsers = usersData.data;
    });
  },
  computed: {
    filteredList() {
      let filteredUsers = this.allUsers;
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      return filteredUsers;
    },
  },
  methods: {
      submitUsers(){
        tournamentService.sendInvites(this.$store.state.user.id, this.selectedUserIDs,this.$route.params.id)
        .then(response => {
        if (response != 0){
            alert("Invites Sent!");
            this.filter.username = "";
            this.selectedUserIDs = [];
            this.$router.push({name: 'my-tournaments'});
        }
        
        })
      }
         
      
  }
};
</script>

<style>
div.userbox {
    text-align: center;
}
.center {
    margin-left: auto;
    margin-right: auto;
}
</style>