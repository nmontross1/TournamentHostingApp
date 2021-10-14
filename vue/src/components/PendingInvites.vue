<template>
  <div class="inviteBox">
    <table id="tblInvites">
      <thead>
        <tr>
          <th>Tournament Name:</th>
          <br><br>
          <th>From:</th>
          <td>&nbsp;</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="invite in modifiedInvites" v-bind:key="invite.id">
          <td>{{ invite.tournamentName }}</td>
          <br><br>
          <td>{{ invite.sender }}</td>
          <td>
            <button
              id="approve"
              v-on:click="
                acceptInvite(
                  invite.inviteID,
                  invite.userID,
                  invite.tournamentID
                )
              "
            >
              Accept
            </button>
            <button id="reject" v-on:click="rejectInvite(invite.inviteID)">
              Reject
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import tournamentService from "../services/TournamentService";
export default {
    name: "pending-invites",
    data() {
        return {
            invites: [],
            modifiedInvites: [],
        }
    },
    created() {
        tournamentService.getInvites(this.$store.state.user.id).then((inviteData) => {
            this.invites = inviteData.data;
               this.invites.forEach(element => {
            
    
          console.log(element.inviteID)
          let invite = {
                    id: element.inviteID,
                    tournamentName: "",
                    sender: null,
                    inviteID: element.inviteID,
                    userID: element.receivedUserID,
                    tournamentID: element.tournamentID
          }
          tournamentService.get(element.tournamentID).then((tournamentData) => {
              invite.tournamentName = tournamentData.data.tournamentName;
          })
          tournamentService.getUser(element.sentUserID).then((userData) => {
             invite.sender = userData.data.username;
          })
          this.modifiedInvites.push(invite);
      })
        });
     

    },
    computed: {},
    methods: {
        acceptInvite(inviteID, userID, tournamentID){
            tournamentService.acceptInvite(inviteID)
            tournamentService.addUserToTournament(userID, tournamentID)
            this.$router.push({name: 'tournament-details', params: {id: tournamentID}} );
            this.$router.go();
        },
        rejectInvite(inviteID){
            tournamentService.rejectInvite(inviteID)
            this.$router.go();
        }
    }
}
</script>

<style>
table{
  margin-left: auto;
  margin-right: auto;
}
</style>