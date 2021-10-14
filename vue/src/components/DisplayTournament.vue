<template>
    <div id = "main">
        <div class="tournamentInfo">
            <div class="tournaments" v-for="tournament in allTheTournaments" :key="tournament.id">
                <img v-bind:src=tournament.image alt = "no image provided" />
                Tournament Name: {{tournament.name}}
                <br />
                Tournament Details: {{tournament.details}}
                <br />
                Tournament Size: {{tournament.size}}
            </div>
        </div>
    </div>
</template>
<script>
import tournamentService from "@/services/TournamentService";


export default {
    data(){
        return {allTheTournaments: []};
    },

    created() {
        tournamentService
        .list()
        .then((tournamentData) => {
            this.allTheTournaments = tournamentData.data;
        })
        .catch(err => {
            console.error(err + "missing tournament");
        });
    },
};
</script>