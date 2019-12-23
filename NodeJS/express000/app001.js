"use strict";

const port = 3000,
  express = require("express"),
  app = express();

app.use(express.json()) // for parsing application/json
app.use(express.urlencoded({ extended: true })) // for parsing application/x-www-form-urlencoded

app
  .get("/items/:item", (req, res) => {
    console.log(req.method);
    console.log(req.params);
    console.log(req.body);
    console.log(req.url);
    console.log(req.query);
    console.log('---');
    res.send("Hello, Universe!");
  })
  .post("/items/:item", (req, res) => {
    console.log('method = '+req.method);
    console.log('params = '+JSON.stringify(req.params));
    console.log('body = '+JSON.stringify(req.body));
    console.log('url = '+req.url);
    console.log('query = '+JSON.stringify(req.query));
    console.log('---');
    res.send("Hello, Universe!");
  })
  .listen(port, () => {
    console.log(`The Express.js server has started and is listening on port number: ${port}`);
  });
