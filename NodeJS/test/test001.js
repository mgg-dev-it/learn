//console.log(process.env.DEBUG);
process.env.DEBUG = true;
//console.log(process.env.DEBUG);

//console.log(`process.platform = ${process.platform}`);

//console.log(process.env);

const magjslib = require('mag-js-lib');

//const auth = require('auth');

const auth = magjslib.auth;

const db = magjslib.db;
const db2 = magjslib.db;

console.log("begin");

auth.login("admin", "admin");

db.init("mssql", "tedious", "server", "user", "pass");
db2.init("mssql", "ms", "server", "user", "pass");

console.log("end");