"use strict";

const port = 3000,
  express = require("express"),
  app = express();

app.use((req, res, next) => {
  console.log(`request made to: ${req.url}`);
  next();
});

const goodtoken = process.env.TOKEN || "secretkey";

app.set("token", goodtoken);

function verifyToken (req, res, next) {
	//console.log(req.query);
	//if (typeof req.query.token != "undefined" && req.query.token === goodtoken) next();
	//if (req.query.token && req.query.token === goodtoken) next();
	if (req.query.token === goodtoken) next();
	//else next (new Error ("Invalid token!"));
	else res.status(500).send('Try again ...!')
}

app.use(verifyToken);

app.get("/items/:vegetable", (req, res) => {
  let veg = req.params.vegetable;
  res.send(`This is the page for ${veg}`);
});

app.use(function (req, res, next) {
  res.status(404).send("Sorry can't find that!")
})

app.use(function (err, req, res, next) {
  console.error(err.stack)
  res.status(500).send('Something broken!')
})

app.listen(port, () => {
  console.log(`Server running on port: ${port}`);
});
