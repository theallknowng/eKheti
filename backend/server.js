
var express = require('express'); 
var app = express(); 
var mysql = require("mysql")

var bodyParser = require('body-parser')
var mysql = require('mysql')

var connection = mysql.createConnection({
  host: '127.0.0.1',
  user: 'root',
  password: 'rahul',
  database: 'crop_dataset'
})

connection.connect(function (err) {
  if (err) {
    throw err
  }
})
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

app.listen(3000, function() { 
	console.log('server running on port 3000'); 
} ) 


app.post('/name', callName); 

function callName(req, res) { 
	var sql = 'select * from `TABLE 1` where region ="' + req.body.region + '" and irrigation ="' + req.body.irrigation + '"'
	connection.query(sql, function (err, data) {
console.log(JSON.stringify(data))
	var spawn = require("child_process").spawn; 

	var process = spawn('python3',["./model.py", JSON.stringify(data[0]) ]); 

	process.stdout.on('data', function(data) { 
		res.send(data); 
	} ) 
	})

} 

