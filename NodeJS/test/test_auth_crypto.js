'use strict';

const magjslib = require('mag-js-lib');
const auth = magjslib.auth;

const haval = magjslib.haval;

var s = "The quick brown fox jumps over the lazy dog";


//console.log("111");

//console.log(auth.haval(s));

//console.log(auth.haval(''));

//console.log("222");

// const chilkat = require('@chilkat/ck-node11-win64'); 

console.log(haval.EncryptPwHaval.main(null));


// // Hash using HAVAL
// // There are two additional properties relevant to HAVAL:
// // HavalRounds, and KeyLength.
// // HavalRounds can have values of 3, 4, or 5.
// // KeyLength can have values of 128, 160, 192, 224, or 256
// crypt.HashAlgorithm = "haval";
// crypt.HavalRounds = 5;
// crypt.KeyLength = 256;
// hash = crypt.HashStringENC(s);
// console.log("Haval: " + hash);