var express = require('express')
var router = express.Router()
var database = require('../controller/database')


router.post('/login', function (req, res) {
    database.getUser(req.body.contact, req.body.password, (err, user) => {
      if (user) {
        res.json({ success: 'true', user: user })
      } else {
        res.json({ success: 'false' })
      }
    })
  })


  module.exports= router;
