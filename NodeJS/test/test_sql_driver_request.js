'use strict';

const db_test_dbms = process.env.db_test_dbms;
const db_test_driver = process.env.db_test_driver;
const db_test_server = process.env.db_test_server;
const db_test_username = process.env.db_test_username;
const db_test_password = process.env.db_test_password;

const magjslib = require('mag-js-lib');

const db = magjslib.db;

console.log("begin");
db.init(db_test_dbms, db_test_driver, db_test_server, db_test_username, db_test_password);
console.log(`db.status = ${db.getStatus()}`);
db.connect(do_on_success, do_on_error);

console.log("end");

function do_on_success() {
    console.log("connected ...");
    console.log(`db.status = ${db.getStatus()}`);
    db.disconnect();
    console.log(`db.status = ${db.getStatus()}`);
}

function do_on_error(err) {
    console.log("connection failed ...");
    console.log("err.message = " + err.message);
    console.log("err.code = " + err.code);
    console.log(`db.status = ${db.getStatus()}`);
    db.disconnect();
    console.log(`db.status = ${db.getStatus()}`);
}
