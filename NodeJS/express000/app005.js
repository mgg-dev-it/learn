"use strict";

const port = 3000,
  express = require("express"),
  app = express();

const jwt = require("jsonwebtoken");

app.use(express.json()) // for parsing application/json
app.use(express.urlencoded({ extended: true })) // for parsing application/x-www-form-urlencoded

app.use((req, res, next) => {
  console.log(`request made to: ${req.url}`);
  next();
});

//const goodtoken = process.env.TOKEN || "secretkey";

//app.set("token", goodtoken);
const secretKey = "secretkey";

app.post("/login", (req, res) => {
  console.log(req.body);
  if (req.body.username && req.body.password){
	  if (req.body.username == "admin" && req.body.password == "secret"){
		  //console.log("success");
		  let jwtToken = jwt.sign({data:"admin", role: "role_admin", exp: new Date().setDate(new Date().getDate()+1)}, secretKey);
		  res.json({success:true, token: jwtToken});
	  }
  }
  res.json({success:false, message: "Login failed"});
  //res.send("Login failed");
});


function verifyToken (req, res, next) {
	//if (req.query.token === goodtoken) next();
	//else res.status(500).send('Try again ...!')
	//if (req.body.token){
	//	console.log(req.body.token);
	//}
	if (req.headers.token){
		console.log(req.headers.token);
		jwt.verify(req.headers.token, secretKey, (err, decoded) => {
			if (decoded){
				console.log(decoded);
				console.log(new Date(decoded.exp));
				console.log(new Date(decoded.iat));
			}
			if (err){
				console.log(err);
			}
		});
	}
	next();
}

app.use(verifyToken);


app.get("/items/:vegetable", (req, res) => {
  let veg = req.params.vegetable;
  res.send(`This is the page for ${veg}`);
});

app.use(function (req, res, next) {
  res.status(404).send("404")
})

app.use(function (err, req, res, next) {
  console.error(err.stack)
  res.status(500).send('500')
})

app.listen(port, () => {
  console.log(`Server running on port: ${port}`);
});
