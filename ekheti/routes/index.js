var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  if(req.session.email)
    res.render('index', { login: 'true' });
  else  
    res.render('index', { login: 'false' });

});

router.get('/login', function(req, res, next) {
  if(!req.session.email)
    res.render('login',{success:'true'})
  else
    res.redirect('/')
});

router.get('/cropSuggestion',function(req,res,next){
  res.render('cropsuggestion')
})

module.exports = router;
