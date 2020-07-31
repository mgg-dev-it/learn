'use strict';

const magjslib = require('mag-js-lib');
const auth = magjslib.auth;

const haval = magjslib.haval_work;

var s = "The quick brown fox jumps over the lazy dog";


console.log("----------");
const h = new haval.Haval();
console.log(h.toString());
console.log("----------");
console.log(haval.Encrypt(""));
console.log(haval.EncryptOld(""));
console.log(h.Encrypt(""));
console.log(h.EncryptOld(""));
console.log("----------");
console.log(haval.Encrypt("a"));
console.log(haval.EncryptOld("a"));
console.log(h.Encrypt("a"));
console.log("----------");
console.log(haval.Encrypt("almafa"));
console.log(haval.EncryptOld("almafa"));
console.log(h.Encrypt("almafa"));
console.log("----------");
console.log(haval.Encrypt("á"));
console.log(haval.EncryptOld("á"));
console.log(h.Encrypt("á"));
console.log("----------");
console.log(haval.Encrypt("ő"));
console.log(haval.EncryptOld("ő"));
console.log(h.Encrypt("ő"));
console.log("----------");
console.log(haval.Encrypt("aáeéiíoóöőuúüűAÁEÉIÍOÓÖŰUÚÜŰ"));
console.log(haval.EncryptOld("aáeéiíoóöőuúüűAÁEÉIÍOÓÖŰUÚÜŰ"));
console.log(h.Encrypt("aáeéiíoóöőuúüűAÁEÉIÍOÓÖŰUÚÜŰ"));
console.log("----------");

/*

console.log(h.Encrypt("a"));
console.log(h.Encrypt("almafa"));
console.log(h.Encrypt("á"));
console.log(h.Encrypt("é"));
console.log(h.Encrypt("ő"));
console.log(h.Encrypt("ű"));
console.log(h.Encrypt("Ő"));
console.log(h.Encrypt("Ű"));
console.log(h.Encrypt("éáőúöüóíÉÁŰÖÜÓŐÚÍ"));
console.log(h.Encrypt("aáeéiíoóöőuúüűAÁEÉIÍOÓÖŰUÚÜŰ"));
console.log("----------");
console.log(h.EncryptOld("á"));
console.log(h.EncryptOld("é"));
console.log(h.EncryptOld("ő"));
console.log(h.EncryptOld("ű"));
console.log(h.EncryptOld("Ő"));
console.log(h.EncryptOld("Ű"));
console.log(h.EncryptOld("éáőúöüóíÉÁŰÖÜÓŐÚÍ"));
console.log(h.EncryptOld("aáeéiíoóöőuúüűAÁEÉIÍOÓÖŰUÚÜŰ"));
*/

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