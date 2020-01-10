const magjslib = require('mag-js-lib');

//const auth = require('auth');

const auth = magjslib.auth;

console.log("begin");

auth.login("admin", "admin");

console.log("end");