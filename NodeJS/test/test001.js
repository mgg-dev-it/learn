//console.log(process.env.DEBUG);
process.env.DEBUG = true;
//console.log(process.env.DEBUG);

//console.log(`process.platform = ${process.platform}`);

//console.log(process.env);

const magjslib = require('mag-js-lib');

//const auth = require('auth');

const auth = magjslib.auth;

const db = magjslib.db;

console.log("begin");

auth.login("admin", "admin");

db.init("mssql", "server", "user", "pass");

console.log("end");