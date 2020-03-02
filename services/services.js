var express = require('express')
var router = express.Router()
var database = require('../controller/database')


router.post('/login', function (req, res) {
    database.getUser(req.body.email, req.body.pass, (err, user) => {
      if (user) {
         req.session.name=user.firstname+' '+user.lastname
         req.session.email=user.email
         req.session.region=user.region
         req.session.healthID=user.healthID
         req.session.irrigation=user.irrigation
         console.log(req.session)
         res.redirect('/')
        //res.json({ success: 'true', user: user })
      } else {
        res.render("login",{ success: 'false' })
      }
    })
  })


router.get('/logout', (req,res)=>{
  req.session.destroy(function(err){
    res.redirect('/')
  })
})


router.post('/register', (req,res)=>{
  var values = [req.body.email_id,req.body.FName,req.body.LName,req.body.contact,req.body.village, req.body.password, req.body.irrigation]
  database.newUser(values,(err, result)=>{
    if (err){
      console.log(err)
      console.log(result)
      res.render('signup',{success:'false',login:'false'})
    }
    else{
      res.redirect('/')
    }
  })
})

router.post('/suggestCrops', (req,res)=>{
  if(req.session.email){
    if(req.session.healthID==null){
      database.withoutHealthCard(req.session.region,req.session.irrigation, function(err, data){
        data=data.toString().slice(1,-1)
 
        dataArray=data.split(" ")
        console.log(dataArray)

        result={"Crop1":getCrop(dataArray[6]),"Crop2":getCrop(dataArray[5]),"Crop3":getCrop(dataArray[4]),"Crop4":getCrop(dataArray[3]),"Crop5":getCrop(dataArray[2]),"Crop6":getCrop(dataArray[1]),"Crop7":getCrop(dataArray[0]),}
        console.log(result)
        res.render('suggestcrop',{success:'true',result: result})

      })
    }
    else {
      database

    }


  }
})



// router.post('/suggest', (req,res)=>{           // For testing purpose
//   database.callName("barshi","yes",(err , data)=>{
//     console.log(data.slice(1,-1))
//     dataarr=data.slice(1,-1).split(" ")
//     console.log(dataarr)
//     res.send(data)
//   });
// })

function getCrop(code){
  switch(code) {
    case '0':
      return 'Wheat'
    break;
    case '1':
      return 'Jowar'
    break;
    case '2':
      return 'Maize'
    break;
    case '3':
      return 'Pulses'
    break;
    case '4':
      return 'Oil Crop'
    break;
    case '5':
      return 'SugarCane'
    break;
    case '6':
      return 'Grapes'
    break;
    default:
      return "Invalid"
  }


}







// Andoid routes

router.post('/user/login', function (req, res) {
  database.getUser(req.body.email, req.body.pass, (err, user) => {
    if (user) {
       res.json({success:'true',user:user})
      //res.json({ success: 'true', user: user })
    } else {
      res.json({ success: 'false' })
    }
  })
})


router.post('/user/withoutHealthCard', function (req,res){
    database.withoutHealthCard("barshi","yes", function(err, data){
    data=data.toString().slice(1,-1)

    dataArray=data.split(" ")
    console.log(dataArray)
    result={"Crop1":getCrop(dataArray[6]),"Crop2":getCrop(dataArray[5]),"Crop3":getCrop(dataArray[4]),"Crop4":getCrop(dataArray[3]),"Crop5":getCrop(dataArray[2]),"Crop6":getCrop(dataArray[1]),"Crop7":getCrop(dataArray[0]),}
    res.json({ success: 'true',result: result})
  })
})


router.post('/user/register', (req,res)=>{
  var values = [req.body.email_id,req.body.firstname,req.body.lastname,req.body.contact,req.body.region, req.body.password, req.body.irrigation]
  database.newUser(values,(err, result)=>{
    if (err){
      console.log(err)
      console.log(result)
      res.json({success:'false'})
    }
    else{
      res.json({success:'true'})
    }
  })
})

router.post('/user/markets', function (req, res) {
  database.getMarkets(req.body.lat, req.body.long, req.body.name, (err, markets) => {
    if (markets) {
      res.json({ success: 'true', markets: markets })
    } else {
      res.json({ success: 'false' })
    }
  })
})




router.post('/user/healthCard', (req,res)=>{
  console.log(req.body)
  res.json({ success: 'true' })
})



  module.exports= router;
