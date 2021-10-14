<template>
  <div class="list">
    <div class="search-holder">
      <div class="search-holder-banner">
        <div class="hero-header-container">
          <h2 class="hero-header">Search Tournaments By Name</h2>
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
      <tournament-card class = "maincard"
        v-bind:tournament="tournament"
        v-for="tournament in computedList"
        :key="tournament.tournamentID"
      >
      </tournament-card>
    </div>
    <button @click="limit = limit + 4">View More Tournaments</button>
  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js";
import TournamentCard from "@/components/TournamentCard.vue";

export default {
  name: "tournament-list",
  components: {
    TournamentCard,
  },
  data() {
    return {
      allTournaments: [],
      limit: 4,
      searchText: "",
      filter: {
        tournamentName: "",
      },
    };
  },
  created() {
    TournamentService.list()
      .then((tournamentData) => {
        this.allTournaments = tournamentData.data;
      })
      .catch((err) => {
        console.error(err + " missing tournament data.");
      });
  },
  computed: {
    filteredList() {
      let filteredTournaments = this.allTournaments;
      if (this.filter.tournamentName != "") {
        filteredTournaments = filteredTournaments.filter((tournament) =>
          tournament.tournamentName
            .toLowerCase()
            .includes(this.filter.tournamentName.toLowerCase())
        );
      }
      return filteredTournaments;
    },
    computedList() {
      return this.limit
        ? this.filteredList.slice(0, this.limit)
        : this.tournament;
    },
  },
};
</script>

<style>
.maincard {
  display: block;
  height: 100%;
}
h2.hero-header {
  margin: 0;
  padding: 0;
  padding-bottom: 10px;
  font-size: 15px;

}

input.form-control {
  display: inline-block;
  text-align: center;
  width: 400px;
  border-radius: 10px;
}

#card-grid {
  display: grid;
  grid-template-rows: 25% 25% 25% 25%;
  row-gap: 120px;
  justify-items: center;
  justify-content: center;
  grid-template-areas: "card card card card";
}


.card {
  justify-self: center;
  grid-area: card;
}
@media screen and (max-width: 1024px) {
        #card-grid{
            column-gap: 0px;
            grid-template-rows: 1fr 1fr;
            grid-template-areas: 
            "card card"
            "card card"
        }
}
@media screen and (max-width: 520px) {
        #card-grid{
            column-gap: 0px;
            grid-template-columns: 1fr;
            grid-template-areas: 
            "card"
            "card"
            "card"
            "card"
        }
}
</style>