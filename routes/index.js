var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  if(req.session.email)
    res.render('index', { login: 'true', name: req.session.name });
  else  
    res.render('index', { login: 'false',name:'' });
});

router.get('/login', function(req, res, next) {
  if(!req.session.email)
    res.render('login',{success:'true', login: 'false'})
  else
    res.redirect('/')
});

router.get('/signup', function(req, res ,next) {
  res.render('signup',{login: 'false'})
})


router.get('/cropSuggestion',function(req,res,next){
  res.render('cropsuggestion',{success:'false',result:''})
})

module.exports = router;
