let idToken = null;

export const auth = {
  get token() {
    return idToken ?? sessionStorage.getItem("id_token");
  },

  set token(token) {
    idToken = token;
    if (token) sessionStorage.setItem("id_token", token);
    else sessionStorage.removeItem("id_token");
  },

  clear() {
    this.token = null;
    console.log("clearing...");
    console.log(this.token);
    console.log(idToken);
  },
};
