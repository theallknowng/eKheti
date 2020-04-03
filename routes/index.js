var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  if(req.session.email)
    res.render('home', { login: 'true', name: req.session.name, healthID: req.session.healthID });
  else  
    res.render('home', { login: 'false',name:'', healthID:'' });
});


// GET login page
router.get('/login', function(req, res, next) {
  if(!req.session.email)
    res.render('login',{success:'true', login: 'false'})
  else
    res.redirect('/')
});



// GET signup page
router.get('/signup', function(req, res ,next) {
  res.render('signup',{login: 'false',name:'',healthID:''})
})

// GET profile page
router.get('/profile', function(req, res ,next) {
  if(req.session.email)
    res.render('profile',{login: 'true',name: req.session.name,healthID:req.session.healthID, profile: req.session})
  else
    res.redirect('/login')
})


// GET healthcard
router.get('/healthcard', function(req, res , next) {
  if(req.session.email){
    if(req.session.healthID)
      res.status(403).render('error403',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
    else
      res.render('healthCard',{ login: 'true',name:req.session.name, healthID: req.session.healthID,  irrigation:req.session.irrigation.toLowerCase() })
  }
  else
    res.redirect('/')
})

router.get('/cropSuggestion',function(req,res,next){
  // res.render('cropsuggestion',{success:'false',result:''})
  if(req.session.email)
    res.status(403).render('error403', { login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.status(403).render('error403', { login: 'false',name:'' , healthID: ''})
})

// GET articles
router.get('/articles', function(req, res, next){
  if(req.session.email)
    res.render('articles', { login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('articles', { login: 'false',name:'' , healthID: ''})
})

// GET Crops
router.get('/Jowar', function(req, res, next) {
  if(req.session.email)
    res.render('Jowar',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('Jowar',{ login: 'false',name:req.session.name, healthID: req.session.healthID })
});


router.get('/Wheat', function(req, res, next) {
  if(req.session.email)
    res.render('Wheat',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('Wheat',{ login: 'false',name:req.session.name, healthID: req.session.healthID })
});


router.get('/Maize', function(req, res, next) {
  if(req.session.email)
    res.render('Maize',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('Maize',{ login: 'false',name:req.session.name, healthID: req.session.healthID })
});


router.get('/Oilseeds', function(req, res, next) {
  if(req.session.email)
    res.render('OilSeeds',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('OilSeeds',{ login: 'false',name:req.session.name, healthID: req.session.healthID })
});


router.get('/Pulses', function(req, res, next) {
  if(req.session.email)
    res.render('Pulses',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('Pulses',{ login: 'false',name:req.session.name, healthID: req.session.healthID })
});


router.get('/Grapes', function(req, res, next) {
  if(req.session.email)
    res.render('Grapes',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('Grapes',{ login: 'false',name:req.session.name, healthID: req.session.healthID })
});


router.get('/Sugarcane', function(req, res, next) {
  if(req.session.email)
    res.render('Sugarcane',{ login: 'true',name:req.session.name, healthID: req.session.healthID })
  else
    res.render('Sugarcane',{ login: 'false',name:req.session.name, healthID: req.session.healthID })
});



module.exports = router;