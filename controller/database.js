var conn = require('../config/database-connection')
var request = require('request-promise');
const dotenv = require('dotenv');
dotenv.config();



  function getUser (email, password, cb) {
    var sql = 'select * from users where email ="' + email + '" and password ="' + password + '"'
    conn.query(sql, function (err, user) {
      cb(err, user[0])
    })
  }

  function newUser (values, cb) {
    var sql = 'INSERT INTO `users`(`email`,`firstname`,`lastname`,`contact`,`region`, `password`, `irrigation`) VALUES(?)'
    conn.query(sql, [values], function (err, result) {
      cb(err, result)
    })
  }

   async function exactHealthCard(values){
    var sql = 'INSERT INTO `healthCard`(`healthID`, `email`, `pHMin`, `pHMax`, `nitrogenMin`, `nitrogenMax`, `phosphorusMin`, `phosphorusMax`, `potassiumMin`, `potassiumMax`, `calciumMin`, `calciumMax`, `magnesiumMin`, `magnesiumMax`, `sulphurMin`, `sulphurMax`, `ironMin`, `ironMax`, `zincMin`, `zincMax`, `manganeseMin`, `manganeseMax`, `copperMin`, `copperMax`, `boronMin`, `boronMax`, `temperatureMin`, `temperatureMax`, `precipitationMin`, `precipitationMax`, `irrigation`, `region`) VALUES(?)'
    conn.query(sql, [values], function (err, result) {
      if (err) throw err;

    })
    
  }
  

  function newHealthCard (values, cb) {
    exactHealthCard(values)
    var sql= 'UPDATE `users` SET healthID ="' +values[0]+ '" where email ="' +values[1]+ '"'
    conn.query(sql, function(err, result){
      cb(err, result)
    })
  }

  function getHealth (healthID, cb) {
    var sql= 'select * from `healthCard` where healthID = "' +healthID+ '"'
    conn.query(sql, function (err, healthCard) {
      cb(err, healthCard[0])
    })
  }
  function callName(region, irrigation,cb ) {
    var sql = 'select * from `actualConditions` where region ="' + region + '" and irrigation ="' + irrigation + '"'
    conn.query(sql, function ( err , result){
    console.log(JSON.stringify(result[0]))
    var options = {
      method: 'POST',
      uri: process.env.hostPython,
      form: {
          data: JSON.stringify(result[0]),
      }
    };
    request(options)
    .then(function (body) {
      cb(err, body)
    })
    .catch(function (err){
      console.log()
    })

  
   
  })
}
  ///home/rahul/Desktop/eKheti/ekheti/controller

  function withoutHealthCard(region, irrigation, cb){
    var sql = 'select * from `actualConditions` where region ="' + region + '" and irrigation ="' + irrigation + '"'
    conn.query(sql, function ( err , result){
    console.log(JSON.stringify(result[0]))
    var options = {
      method: 'POST',
      uri: process.env.hostPython,
      form: {
          data: JSON.stringify(result[0]),
      }
    };
    request(options)
    .then(function (body) {
      cb(err, body)
    })
    .catch(function (err){
    })

  
  })
    // var sql = 'select * from `actualConditions` where region ="' + region + '" and irrigation ="' + irrigation + '"'
    // conn.query(sql, function ( err , result){
    // console.log(JSON.stringify(result[0]))
    // var spawn = require("child_process").spawn; 
    // var process = spawn('python3',["./model.py", JSON.stringify(result[0]) ]);   
    // process.stdout.on('data', function(data,err) { 
    //   console.log(data.toString())
    //   cb(err,data)
    //   }) 
    // })
  }

  function withHealthCard( healthID ,cb){
    var sql= 'select `pHMin`, `pHMax`, `nitrogenMin`, `nitrogenMax`, `phosphorusMin`, `phosphorusMax`, `potassiumMin`, `potassiumMax`, `calciumMin`, `calciumMax`, `magnesiumMin`, `magnesiumMax`, `sulphurMin`, `sulphurMax`, `ironMin`, `ironMax`, `zincMin`, `zincMax`, `manganeseMin`, `manganeseMax`, `copperMin`, `copperMax`, `boronMin`, `boronMax`, `temperatureMin`, `temperatureMax`, `precipitationMin`, `precipitationMax`, `irrigation`, `region` from `healthCard` where healthID ="' + healthID +'" LIMIT 1'
    conn.query(sql, function ( err , result){
      console.log(JSON.stringify(result[0]))
      var options = {
        method: 'POST',
        uri: process.env.hostPython,
        form: {
            data: JSON.stringify(result[0]),
        }
      };
      request(options)
      .then(function (body) {
        cb(err, body)
      })
      .catch(function (err){
      })
  
    })


  }


  function getMarkets (lat, long, crop_name, cb) {
    var sql = 'SELECT markets.id,markets.name,markets.market_lat, markets.market_long, market_crop_rel.crop_name,market_crop_rel.crop_price, ( 3959 * acos( cos( radians(' + lat + ') ) * cos( radians( market_lat ) ) \
  * cos( radians( market_long ) - radians(' + long + ') ) + sin( radians(' + lat + ') ) * sin(radians(market_lat)) ) ) AS distance \
  FROM markets , market_crop_rel where markets.id = market_crop_rel.market_id and market_crop_rel.crop_name = "' + crop_name + '"\
   ORDER BY distance asc'
    conn.query(sql, function (err, markets) {
      cb(err, markets)
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
  
  module.exports = { getUser, newUser, getMarkets, withoutHealthCard , callName, withHealthCard, newHealthCard, getHealth }