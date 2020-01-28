//http://tediousjs.github.io/tedious/

const magjslib = require('mag-js-lib');

//var Connection = require('tedious').Connection
var Connection = magjslib.tds_connect
//var Request = require('tedious').Request
var Request = magjslib.tds_request

//var config = require('./cnfg.js').config
var config = {
    authentication: {
        type: "default",
        options: {
            userName: 'sqlszlaApp',
            password: 'kx2Wed89RetszLa'
        }
    },
    server: 'sqlpohu.in.porsche.hu'
}

var connection = new Connection(config)


connection.on('connect', function (err) {
    if (err) {
        console.log(err)
    } else {
        executeStatement()
    }
})

function executeStatement() {
    //request = new Request("select 123, 'hello world'", function (err, rowCount) {
    request = new Request("select ceg, nev1, nev2 from ceg order by ceg", function (err, rowCount) {
        if (err) {
            console.log(err)
        } else {
            console.log(rowCount + ' rows')
        }
        connection.close()
    })

    request.on('row', function (columns) {
        console.log("---");
        columns.forEach(function (column) {
            if (column.value === null) {
                console.log('NULL')
            } else {
                console.log(column.value)
            }
        });
        console.log("+++");
    })

    connection.execSql(request)
}