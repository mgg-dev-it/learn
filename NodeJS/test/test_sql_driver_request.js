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
    do_request();
    //db.disconnect();
    //console.log(`db.status = ${db.getStatus()}`);
}

function do_on_error(err) {
    console.log("connection failed ...");
    console.log("err.message = " + err.message);
    console.log("err.code = " + err.code);
    console.log(`db.status = ${db.getStatus()}`);
    db.disconnect();
    console.log(`db.status = ${db.getStatus()}`);
}

function do_request() {
    //db.request("select 42, 'Hello World!'", do_on_request, do_on_request_completed);
    //db.request("select 42, 'Hello World!' union select 84, 'Hello Universe!'", do_on_request, do_on_request_completed);
    db.request("execute testMultipleRecordset", do_on_request, do_on_request_completed);
}

function do_on_request(err, rowCount, rows) {
    if (err) {
        console.log("do_on_request err");
        console.log(err);
    } else {
        console.log("do_on_request success");
        //console.log(rowCount + ' rows');
        //console.log(rows);

        rows.forEach(function (row) {
            console.log(row);
        });


    }
    db.disconnect();
    console.log(`db.status = ${db.getStatus()}`);
}

function do_on_request_completed() {
    let rscount = db.getResultSetCount();
    console.log(`resultset count = ${rscount}`);
    for (var i=0; i<rscount; i++){
        console.log(`metadata [${i}]:`);
        console.log(db.getMetadata(i));
    }
}