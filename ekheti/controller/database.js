var conn = require('../config/database-connection')
var request = require('request-promise');




function getUser (contact, password, cb) {
    var sql = 'select * from users where contact ="' + contact + '" and password ="' + password + '"'
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
  
  module.exports = { getUser, newUser }