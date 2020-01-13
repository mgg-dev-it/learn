//console.log(process.env);
//console.log(process.env.DEBUG);
//process.env.DEBUG = true;
//console.log(process.env.DEBUG);

//console.log(`process.platform = ${process.platform}`);

//console.log(process.env);



const db_test_dbms = process.env.db_test_dbms;
const db_test_driver = process.env.db_test_driver;
const db_test_server = process.env.db_test_server;
const db_test_username = process.env.db_test_username;
const db_test_password = process.env.db_test_password;

const magjslib = require('mag-js-lib');

//const auth = require('auth');

const auth = magjslib.auth;

const db = magjslib.db;
const db2 = magjslib.db;

console.log("begin");

auth.login("admin", "admin");

db.init(db_test_dbms, db_test_driver, db_test_server, db_test_username, db_test_password);
//db2.init("mssql", "ms", "server", "user", "pass");

console.log("end");