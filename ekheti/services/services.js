var express = require('express')
var router = express.Router()
var database = require('../controller/database')


router.post('/login', function (req, res) {
    database.getUser(req.body.email, req.body.pass, (err, user) => {
      if (user) {
         req.session.email=user.firstname+user.lastname
        // console.log(req.session.email)
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



router.post('/user/healthCard', (req,res)=>{
  console.log(req.body)
  res.json({ success: 'true' })
})

  module.exports= router;
