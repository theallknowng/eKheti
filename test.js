var request = require('request');
request.post({
  headers: {'content-type' : 'application/x-www-form-urlencoded'},
  url:     'http://localhost:5000',
  form:    {'data':'{"pH min":5.7,"pH max":7,"nitrogen min":109,"nitrogen max":146,"phosphorus min":20,"phosphorus max":30,"potasium min":78,"potasium max":115,"calcium min":270,"calcium max":990,"magnesium min":46,"magnesium max":96,"sulphur min":10,"sulphur max":10,"iron min":44,"iron max":46,"zinc min":3.87,"zinc max":5.87,"manganese min":4.81,"manganese max":4.81,"copper min":21,"copper max":26,"boron min":1.25,"boron max":2.25,"temperature min":25,"temperature max":35,"precipitation min":50,"precipitation max":60,"irrigation":"yes ","region":"barshi"}'}
}, function(error, response, body){
  console.log(body);
});