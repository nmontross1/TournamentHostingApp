
<template>
  <form autocomplete="off" class="form" @submit.prevent="createTournament">
    <div class="control">
      <img
        class="img"
        src="http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png"
        alt="testlogo"
      />
    </div>
    <div class="control block-cube block-input">
      <input
        v-model="tournament.tournamentName"
        name="tournamentName"
        placeholder="*Tournament Name"
        type="text"
        required
      />
      <div class="bg-top">
        <div class="bg-inner"></div>
      </div>
      <div class="bg-right">
        <div class="bg-inner"></div>
      </div>
      <div class="bg">
        <div class="bg-inner"></div>
      </div>
    </div>
    <div class="control block-cube block-input">
      <input
        name="description"
        placeholder="Description"
        type="text"
        v-model="tournament.tournamentDescription"
      />
      <div class="bg-top">
        <div class="bg-inner"></div>
      </div>
      <div class="bg-right">
        <div class="bg-inner"></div>
      </div>
      <div class="bg">
        <div class="bg-inner"></div>
      </div>
    </div>
    
    <div class="control block-cube block-input">
      
      <input
        name="image"
        placeholder="Image URL"
        type="url"
        v-model="tournament.image"
      />
      <div class="bg-top">
        <div class="bg-inner"></div>
      </div>
      <div class="bg-right">
        <div class="bg-inner"></div>
      </div>
      <div class="bg">
        <div class="bg-inner"></div>
      </div>
    </div>
    <div class="control block-cube block-input">
      <Datepicker
        v-model="tournament.tournamentDate"
        class="datePicker"
        format="yyyy-MM-dd"
        placeholder="*Date"
        required
      ></Datepicker>
      <div class="bg-top">
        <div class="bg-inner"></div>
      </div>
      <div class="bg-right">
        <div class="bg-inner"></div>
      </div>
      <div class="bg">
        <div class="bg-inner"></div>
      </div>
    </div>
    <div class="control block-cube block-input">
      <label for ="size"></label>
      <select name="size" class = "selectme" v-model="tournament.bracketSize" required>
        <option disabled value="">* Select Bracket Size</option>
        <option>4</option>
        <option>8</option>
        <option>16</option>
        <option>32</option>
        <option>64</option>
      </select>
      
    </div>
    <br>
    <button
      @click.prevent="createTournament"
      class="btn block-cube block-cube-hover"
      type="button"
    >
      <div class="bg-top">
        <div class="bg-inner"></div>
      </div>
      <div class="bg-right">
        <div class="bg-inner"></div>
      </div>
      <div class="bg">
        <div class="bg-inner"></div>
      </div>
      <div class="text">Create Tournament</div>
    </button>
    <br />
  </form>
  <!-- <body>
    <form v-on:submit.prevent="createTournament()">
      <div class="image">
        <img
          src="http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png"
          alt="testlogo"
        />
      </div>

      <div class="container">
        <div class="field">
          <label for="tournamentName"> * Tournament Name: </label>
          <p></P>
          <input
            id="tournamentName"
            type="text"
            v-model="tournament.tournamentName"
          />
        </div>
        <span class="field">
          <label for="tournamentDescription"> Tournament Description: </label>
          <p style="white-space: pre-line">{{ tournamentDescription }}</p>
          <textarea
            id="tournamentDescription"
            v-model="tournament.tournamentDescription"
            placeholder="add tournament description"
          ></textarea>
        </span>
        <div class="field">
          <label for="bracketSize"> * Bracket Size: </label>
        </div>
        <select v-model="tournament.bracketSize">
          <option disabled value=""> Select Bracket Size </option>
          <option>4</option>
          <option>8</option>
          <option>16</option>
          <option>32</option>
          <option>64</option>
        </select>
        <div class="field">
          <label for="image"> Tournament Image URL: </label>
          <br />
          <input type="text" id="image" v-model="tournament.image" />
        </div>
        <div class="field">
          <label for="tournamentDate"> * Tournament Start Date: </label>
          <Datepicker
            v-model="tournament.tournamentDate"
            class="datePicker"
            format="yyyy-MM-dd"
          ></Datepicker>
        </div>
        <p>
          <button type="submit" class="btnCreate"> Create Tournament </button>
        </p>
        <div class="required"> * = Required Field </div>
      </div>
    </form>
  </body> -->
</template>

<script>
import Datepicker from "vuejs-datepicker";
import TournamentService from "../services/TournamentService";

export default {
  name: "add-tournament-comp",
  components: {
    Datepicker,
  },
  data() {
    return {
      tournament: {
        tournamentName: "",
        tournamentDescription: "",
        tournamentHostID: this.$store.state.user.id,
        bracketSize: "",
        tournamentDate: "",
        image: "",
      },
    };
  },
  function() {
    return {
      customDate: new Date(),
    };
  },
  methods: {
    createTournament() {
      console.log("Creating Tournament");

      const newTournament = {
        tournamentName: this.tournament.tournamentName,
        tournamentDescription: this.tournament.tournamentDescription,
        tournamentHostID: this.tournament.tournamentHostID,
        bracketSize: this.tournament.bracketSize,
        tournamentDate: this.tournament.tournamentDate,
        image: this.tournament.image,
      };
      TournamentService.create(newTournament)
        .then((response) => {
          if (response != 0) {
            alert("Tournament Added!");
            this.$router.push("/");
            this.tournament = {
              tournamentName: "",
              tournamentDescription: "",
              tournamentHostID: this.$store.state.user.id,
              bracketSize: "",
              tournamentDate: "",
              image: "",
            };
          }
        })
        .catch((err) => {
          console.error(err + " problem adding tournament.");
        });
    },
  },
};
</script>

<style scoped>
*,
::after,
::before {
  box-sizing: border-box;
}
::placeholder {
  color: white;
}
body {
  background-color: #8f8f8f;
  color: #fff;
  font-family: monospace, serif;
  letter-spacing: 0.05em;
}

h1 {
  font-size: 23px;
  text-align: center;
}

.form {
  width: 300px;
  padding: 0px 15px 24px;
  margin: 0 auto;
}
.form .control {
  margin: 0 0 24px;
}
.form .control input {
  width: 100%;
  padding: 14px 16px;
  border: 0;
  background: transparent;
  color: #fff;
  font-family: monospace, serif;
  letter-spacing: 0.05em;
  font-size: 16px;
}
.form .control input:hover,
.form .control input:focus {
  outline: none;
  border: 0;
}
.form .btn {
  width: 100%;
  display: block;
  padding: 14px 16px;
  background: transparent;
  outline: none;
  border: 0;
  color: #fff;
  letter-spacing: 0.1em;
  font-weight: bold;
  font-family: monospace;
  font-size: 16px;
}

.block-cube {
  position: relative;
}
.block-cube .bg-top {
  position: absolute;
  height: 10px;
  background: #020024;
  background: linear-gradient(90deg, #020024 0%, #340979 37%, #00d4ff 94%);
  bottom: 100%;
  left: 5px;
  right: -5px;
  transform: skew(-45deg, 0);
  margin: 0;
}
.block-cube .bg-top .bg-inner {
  bottom: 0;
}
.block-cube .bg {
  position: absolute;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  background: #020024;
  background: linear-gradient(90deg, #020024 0%, #340979 37%, #00d4ff 94%);
}
.block-cube .bg-right {
  position: absolute;
  background: #020024;
  background: #00d4ff;
  top: -5px;
  z-index: 0;
  bottom: 5px;
  width: 10px;
  left: 100%;
  transform: skew(0, -45deg);
}
.block-cube .bg-right .bg-inner {
  left: 0;
}
.block-cube .bg .bg-inner {
  transition: all 0.2s ease-in-out;
}
.block-cube .bg-inner {
  background: #8f8f8f;
  position: absolute;
  left: 2px;
  top: 2px;
  right: 2px;
  bottom: 2px;
}
.block-cube .text {
  position: relative;
  z-index: 2;
}

.block-cube.block-input input {
  position: relative;
  z-index: 2;
}
.block-cube.block-input input:focus ~ .bg-right .bg-inner,
.block-cube.block-input input:focus ~ .bg-top .bg-inner,
.block-cube.block-input input:focus ~ .bg-inner .bg-inner {
  top: 100%;
  background: rgba(255, 255, 255, 0.5);
}
.block-cube.block-input .bg-top,
.block-cube.block-input .bg-right,
.block-cube.block-input .bg {
  background: rgba(255, 255, 255, 0.5);
  transition: background 0.2s ease-in-out;
}
.block-cube.block-input .bg-right .bg-inner,
.block-cube.block-input .bg-top .bg-inner {
  transition: all 0.2s ease-in-out;
}
.block-cube.block-input:focus .bg-top,
.block-cube.block-input:focus .bg-right,
.block-cube.block-input:focus .bg,
.block-cube.block-input:hover .bg-top,
.block-cube.block-input:hover .bg-right,
.block-cube.block-input:hover .bg {
  background: rgba(255, 255, 255, 0.8);
}
.block-cube.block-cube-hover:focus .bg .bg-inner,
.block-cube.block-cube-hover:hover .bg .bg-inner {
  top: 100%;
}
.img {
  display: block;
  width: 200px;
  margin-left: auto;
  margin-right: auto;
}
div.datePicker {
  text-align: center;
  padding: 10px;
}
.selectme {
  width: 150px;
}
/* div.container {
  text-align: center;
}

div.field {
  text-align: center;
  padding: 10px;
}

div.required {
  color: white;
}



div.btnCreate {
  padding: 10px;
}

.container {
  width: 382px;
  overflow: visible;
  margin: auto;
  margin: 20 0 0 400px;
  padding: 60px;
  background: #0d3b66;
  border-radius: 15px;
} */
</style>