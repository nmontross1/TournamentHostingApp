<template>

    <div class="list">
        <h1>My Tournaments</h1>
        <button @click="showInvites = true" >Click Here To See Your Pending Tournament Invites</button>
        <pending-invites v-if="showInvites === true"/>
        <div class="search-holder">
        <div class="search-holder-banner">
            <div class="hero-header-container">
                <h2 class="hero-header"> Search Tournaments By Name
                </h2>
                <div class="search-bar">
                    <div class="form-holder">
                        <input 
                        class="form-control"
                        type="text" 
                        placeholder="Enter tournament name..."
                        v-model="filter.tournamentName"
                        />
                    </div>
                </div>
            </div>
        </div>
        </div>
        <div id="card-grid">
            <tournament-card
            v-bind:tournament="tournament"
            v-for="tournament in filteredList"
            :key="tournament"
        >
        </tournament-card>
        </div>
            
        
    </div>


</template>

<script>
import pendingInvites from "@/components/PendingInvites.vue";
import tournamentService from "@/services/TournamentService.js";
import tournamentCard from "@/components/TournamentCard.vue";

export default {
    name: "my-tournaments",
    components: {
        tournamentCard,
        pendingInvites,
    },
    data() {
        return {
            myTournaments: [],
            searchText: '',
            showInvites: false,
            filter: {
                tournamentName: "",
            },
        }
    },
    created() {
        console.log('start')
        tournamentService.retrieve(this.$store.state.user.id)
        .then((tournamentData) => {
            this.myTournaments = tournamentData.data;
        })
        .catch((err) => {
            console.error(err + " missing tournament data.");
        }); 
    },
    computed: {
        filteredList() {
            let filteredTournaments = this.myTournaments;
            if (this.filter.tournamentName != "") {
                filteredTournaments = filteredTournaments.filter((tournament) => 
                tournament.tournamentName
                .toLowerCase()
                .includes(this.filter.tournamentName.toLowerCase())
                );
            }
            return filteredTournaments;
        }
    }
};
</script>

<style>
h2.hero-header {
    margin: 0;
    padding: 0;
    padding-bottom: 10px;
}



.banner {
    margin: 0 auto;
    width: 80px;
    padding: 15px;
    text-align: center;
}
.fullBanner {
    margin: 0 auto;
    width: 80px;
    padding: 15px;
    text-align: center;
}
.hero-header {
    margin: 0 0 25;
}

.form-control {
    display: block;
    width: 100%;
    padding: 1px 12px;
}
.search-holder {
    margin-top: 60px; 
}
</style>