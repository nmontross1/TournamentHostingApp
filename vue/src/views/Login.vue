<template>
  <main>
    <form autocomplete="off" class="form" @submit.prevent="login">
      <h1>Tournament Hosting Login</h1>
      <div class="control">
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
        <div class="text">Log In</div>
      </button>
      <br />
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
        <div class="text">Register</div>
      </button>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      ></div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
    </form>
  </main>
</template>



  <!-- <div class="centercontent">
    <body>
      <header>
        <title>Tournament Hosting Login Page</title>
        <h2 class="h3 mb-3 font-weight-normal">Please Log In</h2>
      </header>
      <div class="image">
        <img
          src="http://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/490/2017/02/27215606/626ddd198a3626c2-bracketIcon.png"
          alt="testlogo"
        />
      </div>
      <div id="login" class="text-center">
        <form class="form-signin" @submit.prevent="login">
          <div
            class="alert alert-danger"
            role="alert"
            v-if="invalidCredentials"
          >
            Invalid username and password!
          </div>
          <div
            class="alert alert-success"
            role="alert"
            v-if="this.$route.query.registration"
          >
            Thank you for registering, please sign in.
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
          <div id="log">
            <input type="submit" name="log" id="log" value="Log In" />
            <br /><br />
            <router-link
              :to="{ name: 'register' }"
              tag="button"
              type="submit"
              id="log"
              >Create Account</router-link
            >
          </div>
        </form>
      </div>
    </body>
  </div> -->


<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    register() {
      this.$router.push("/register");
    },
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
            alert("Invalid username and password");
            this.user = {
              username: "",
              password: "",
            };
          }
        });
    },
  },
};
</script>

<style>
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
  padding: 64px 15px 24px;
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

/* .centercontent {
  text-align: center;
}

a {
  text-decoration: none;
}

body {
  margin: 0;
  padding: 0;

  font-family: "Arial";
}

#login {
  width: 382px;
  overflow: hidden;
  margin: auto;
  margin: 20 0 0 450px;
  padding: 80px;
  background: #0d3b66;
  border-radius: 15px;
}

h2 {
  text-align: center;
  color: whitesmoke;
  padding: 20px;
}

label {
  color: whitesmoke;
  font-size: 17px;
}

.sr-only {
  width: 300px;
  height: 30px;
  border: none;
  border-radius: 3px;
}

#log {
  width: 300px;
  height: 30px;
  border: none;
  border-radius: 17px;
  padding-left: 7px;
  color: whitesmoke;
  cursor: pointer;
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
} */

/* .image {
  transform: scale(0.5, 0.5);
  -ms-transform: scale(0.5, 0.5);
  -webkit-transform: scale(0.5, 0.5);
} */
</style>