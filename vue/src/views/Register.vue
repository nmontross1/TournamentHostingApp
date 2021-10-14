
<template>
  <form autocomplete="off" class="form">
    <div class="control">
      <h1>Create A New Account</h1>
      <img
        class="img"
        src="http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png"
        alt="testlogo"
      />
    </div>
    <div class="control block-cube block-input">
      <input
        v-model="user.username"
        name="username"
        placeholder="Username"
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
        name="password"
        placeholder="Password"
        type="password"
        v-model="user.password"
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
        name="password"
        placeholder="Confirm Password"
        type="password"
        v-model="user.confirmPassword"
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
    <button
      @click.prevent="register"
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
      <div class="text">Create Account</div>
    </button>
    <br />
    <button
      @click.prevent="login"
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
      <div class="text">Have An Account?</div>
    </button>
    <br />
    <div
      class="alert alert-danger"
      role="alert"
      v-if="registrationErrors"
    ></div>
  </form>
</template>
  <!-- <div class="centercontent">
    <body>
      <header>
        <title>Tournament Hosting Register Page</title>
        <h2 class="h3 mb-3 font-weight-normal">Create Account</h2>
      </header>
      <div class="image">
        <img
          src="http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png"
          alt="testlogo"
        />
      </div>
      <div id="register" class="text-center">
        <form class="form-register" @submit.prevent="register">
          <div
            class="alert alert-danger"
            role="alert"
            v-if="registrationErrors"
          >
            {{ registrationErrorMsg }}
          </div>
          <label for="username" class="sr-only"><b>Username: </b></label>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
          <br /><br />
          <label for="password" class="sr-only"><b>Password: </b></label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
          <br /><br />
          <label for="password" class="sr-only"><b>Password: </b></label>
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
          <br /><br />
          <div id="log">
            <input type="submit" name="log" id="log" value="Create Account" />
            <br /><br />
            <router-link
              :to="{ name: 'login' }"
              tag="button"
              type="submit"
              id="log"
              >Have An Account?</router-link
            >
          </div>
        </form>
      </div>
    </body>
  </div> -->

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    login() {
      this.$router.push("/login");
    },
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
        alert("Passwords did not match");
        this.user = {
          username: "",
          password: "",
          confirmPassword: "",
          role: "user",
        };
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              alert("New User created, please sign in");
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
::placeholder {
  color: white;
}
.img {
  display: block;
  width: 200px;
  margin-left: auto;
  margin-right: auto;
}
h1 {
  text-align: center;
}
.centercontent {
  text-align: center;
}

a {
  text-decoration: none;
}

body {
  margin: 0;
  padding: 0;
  background-color: #add8e6;
  font-family: "Comic Sans";
}

#register {
  width: 382px;
  overflow: hidden;
  margin: auto;
  margin: 20 0 0 450px;
  padding: 80px;
  background: #191970;
  border-radius: 15px;
}

h2 {
  text-align: center;
  color: black;
  padding: 20px;
}

label {
  color: black;
  font-size: 17px;
}

.sr-only {
  width: 300px;
  height: 30px;
  border: none;
  border-radius: 3px;
  padding-left: 8px;
}

#log {
  width: 300px;
  height: 30px;
  border: none;
  border-radius: 17px;
  padding-left: 7px;
  color: black;
  cursor: pointer;
  background-color: #add8e6;
  text-align: center;
  margin: auto;
}

p.copyright {
  position: absolute;
  width: 100%;
  color: black;
  line-height: 40px;
  font-size: 0.7em;
  text-align: center;
  bottom: 0;
}

img {
  border-radius: 30px;
  margin-top: 10px;
  width: 20%;
  height: auto;
}
</style>
