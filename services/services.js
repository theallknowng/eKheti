var express = require('express')
var router = express.Router()
var database = require('../controller/database')


router.post('/login', function (req, res) {
    database.getUser(req.body.email, req.body.pass, (err, user) => {
      if (user) {
         req.session.name=user.firstname+' '+user.lastname
         req.session.email=user.email
         req.session.region=user.region
         req.session.contact=user.contact
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

router.post('/healthcard', (req,res)=>{
  if (req.session.email){
    var values=[req.body.health_card_number,req.session.email, req.body.pH_min, req.body.pH_max, req.body.N_min, req.body.N_max, req.body.Phosphorous_min, req.body.Phosphorous_max, req.body.K_min, req.body.K_max, req.body.Ca_min, req.body.Ca_max, req.body.Mg_min, req.body.Mg_max, req.body.sulphur_min, req.body.sulphur_max, req.body.Fe_min, req.body.Fe_max, req.body.Zn_min, req.body.Zn_max, req.body.Mn_min, req.body.Mn_max, req.body.Cu_min, req.body.Cu_max, req.body.B_min, req.body.B_max, req.body.Temp_min, req.body.Temp_max, req.body.ppt_min, req.body.ppt_max, req.body.irrigation,  req.session.region]
    database.newHealthCard(values, (err, result)=>{
      if (err){
        console.log(err)
        console.log(result)
        res.render('healthCard',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
      }
      else{
        req.session.healthID=req.body.health_card_number
        res.redirect('/')
        
      }
    })
  }

})

router.post('/suggestCrops', (req,res)=>{
  if(req.session.email){
    if(req.session.healthID==null){
      database.withoutHealthCard(req.session.region,req.session.irrigation, function(err, data){
        data=data.toString().slice(1,-1)
 
        dataArray=data.split(" ")
        console.log(dataArray)

        result={"region":req.session.region,"Crop1":getCrop(dataArray[6]),"Crop2":getCrop(dataArray[5]),"Crop3":getCrop(dataArray[4]),"Crop4":getCrop(dataArray[3]),"Crop5":getCrop(dataArray[2]),"Crop6":getCrop(dataArray[1]),"Crop7":getCrop(dataArray[0]),}
        console.log(result)
        res.render('cropsuggestion',{success:'true',login: 'true', name: req.session.name,healthID: req.session.healthID,result: result})
        // res.render('test',{success:'true',result: result,login: 'true',name: req.session.name})
      })
    }
    else {
      database.withHealthCard(req.session.healthID, function(err, data){
        data=data.toString().slice(1,-1)

        dataArray=data.split(" ")
        console.log(dataArray)

        result={"region":req.session.region,"Crop1":getCrop(dataArray[6]),"Crop2":getCrop(dataArray[5]),"Crop3":getCrop(dataArray[4]),"Crop4":getCrop(dataArray[3]),"Crop5":getCrop(dataArray[2]),"Crop6":getCrop(dataArray[1]),"Crop7":getCrop(dataArray[0]),}
        console.log(result)
        res.render('cropsuggestion',{success:'true',login: 'true', name: req.session.name,healthID: req.session.healthID,result: result})

      })

    }


  }
  else{
    res.redirect('/login')
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



// AJAX Routes

router.post('/ajax/fetch', (req, res)=>{
  database.getHealth(req.body.query, (err, healthCard)=> {
    if(healthCard){
      res.json({ success: 'true', health: healthCard})
    } else {
      res.json({ success: 'false' })
    }
  })
})


  module.exports= router;