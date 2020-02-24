var conn = require('../config/database-connection')
var request = require('request-promise');




function getUser (email, password, cb) {
    var sql = 'select * from users where email ="' + email + '" and password ="' + password + '"'
    conn.query(sql, function (err, user) {
      cb(err, user[0])
    })
  }
  
  function newUser (values, cb) {
    var sql = 'INSERT INTO `users`(`email_id`, `password`, `home_location_lat`, `home_location_long`, `name`) VALUES(?)'
    conn.query(sql, [values], function (err, result) {
      cb(err, result)
    })
  }


  function callName(req, cb) { 
    var sql = 'select * from `TABLE 1` where region ="' + req.body.region + '" and irrigation ="' + req.body.irrigation + '"'
    conn.query(sql, function (err, data) {
    console.log(JSON.stringify(data))
    var spawn = require("child_process").spawn; 
  
    var process = spawn('python3',["./model.py", JSON.stringify(data[0]) ]); 
  
    process.stdout.on('data', function(err,data) { 
      console.log(data)
      cb(err,data)
      }) 
    })
  }
  ///home/rahul/Desktop/eKheti/ekheti/controller

  function withoutHealthCard(region, irrigation, cb){
    var sql = 'select * from `actualConditions` where region ="' + region + '" and irrigation ="' + irrigation + '"'
    conn.query(sql, function ( err , result){
    console.log(JSON.stringify(result[0]))
    var spawn = require("child_process").spawn; 
    var process = spawn('python3',["./model.py", JSON.stringify(result[0]) ]);   
    process.stdout.on('data', function(data,err) { 
      console.log(data)
      cb(err,data)
      }) 
    })
  }





function weather(req,res){  //isme update ke zarurat hai like location tag wagera aur response yehi se jara hai use services se bhejna hoga
    var data=1;
    request({url:url, qs:propertiesObject}, function(err, response, body) {
      
      // var data=[]
      if(err) { console.log(err); return; }
      console.log("Get response: " + response.statusCode);
      // data=[{"body":body}]
      // console.log("data")
      data=JSON.parse(body);
    })
    .then(()=>{
    // console.log(data)
    // res.send(data)
    res.send({'minTemp':data.DailyForecasts[0].Temperature.Minimum.Value,'maxTemp':data.DailyForecasts[0].Temperature.Maximum.Value, 'text':data.Headline.Text })
    })
  }
  
  module.exports = { getUser, newUser,withoutHealthCard }