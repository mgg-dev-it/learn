"use strict";

const port = 3000,
  express = require("express"),
  app = express();


//------------------------------------------------------------------------------

var birdsrouter = express.Router()

// middleware that is specific to this router
birdsrouter.use(function timeLog (req, res, next) {
  console.log('Time: ', Date.now())
  next()
})
// define the home page route
birdsrouter.get('/', function (req, res) {
  res.send('Birds home page')
})
// define the about route
birdsrouter.get('/about', function (req, res) {
  res.send('About birds')
})

//------------------------------------------------------------------------------


app.use((req, res, next) => {
  console.log(`request made to: ${req.url}`);
  next();
});

app.use('/birds', birdsrouter)

app.get("/items/:vegetable", (req, res) => {
  let veg = req.params.vegetable;
  res.send(`This is the page for ${veg}`);
});

app.listen(port, () => {
  console.log(`Server running on port: ${port}`);
});
