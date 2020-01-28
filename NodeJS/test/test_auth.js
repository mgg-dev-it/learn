'use strict';

const magjslib = require('mag-js-lib');
const auth = magjslib.auth;

console.log("begin");

var ldp = new auth.testlogindataprovider();

//console.log(auth.testlogindataprovider);
//console.log(ldp);

//auth.init(auth.testlogindataprovider);
auth.init(ldp);

//console.log(auth.login("admin", "admin"));
console.log(auth.login("admin", "admin", { appId: 5, permID: 874 }));

console.log(auth.login("user", "user", { appId: 5, permID: 874 }));

console.log(auth.login("user", "wrongpw", { appId: 5, permID: 874 }));

console.log("end");
