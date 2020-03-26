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

router.get('/articles', function(req, res, next){
  if(req.session.email)
    res.render('articles', { login: 'true',name:req.session.name })
  else
    res.render('articles', { login: 'false',name:'' })
})

router.get('/Jowar', function(req, res, next) {
  if(req.session.email)
    res.render('Jowar',{ login: 'true',name:req.session.name })
  else
    res.redirect('/')
});

router.get('/Wheat', function(req, res, next) {
  if(req.session.email)
    res.render('Wheat',{ login: 'true',name:req.session.name })
  else
    res.redirect('/')
});

router.get('/Maize', function(req, res, next) {
  if(req.session.email)
    res.render('Maize',{ login: 'true',name:req.session.name })
  else
    res.redirect('/')
});

router.get('/Oilseeds', function(req, res, next) {
  if(req.session.email)
    res.render('OilSeeds',{ login: 'true',name:req.session.name })
  else
    res.redirect('/')
});

router.get('/Pulses', function(req, res, next) {
  if(req.session.email)
    res.render('Pulses',{ login: 'true',name:req.session.name })
  else
    res.redirect('/')
});

router.get('/Grapes', function(req, res, next) {
  if(req.session.email)
    res.render('Grapes',{ login: 'true',name:req.session.name })
  else
    res.redirect('/')
});

router.get('/Sugarcane', function(req, res, next) {
  if(req.session.email)
    res.render('Sugarcane',{ login: 'true',name:req.session.name })
  else
    res.redirect('/')
});



module.exports = router;
