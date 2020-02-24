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

router.get('/suggestCrops', (req,res)=>{
  if(req.session.email){
    if(req.session.healthID==null){
      console.log("andar")
      database.withoutHealthCard(req.session.region,req.session.irrigation, function(err, data){
        // data=Array.prototype.slice.call(data,0)
        console.log('HI',data)
        res.send(data)


      })
    }
    else {
      database

    }


  }
})








// Andoid routes

router.post('/user/healthCard', (req,res)=>{
  console.log(req.body)
  res.json({ success: 'true' })
})

  module.exports= router;
