$(document).ready(function(){
  let userId = sessionStorage.getItem('ID');
  var mokData = [];
  var userData;

  var userURL = '/dsaApp/User/' + userId;
  $.ajax({
    url: '/dsaApp/User/' + userId,
    dataType: 'json',
    contentType: 'application/json',
    success: function(x) {
        console.log(x);
        var templateCoins = '<p>You have: ' + x.cash + '€</p>'
        $('#coins').append(templateCoins);
    },
    error: function(xhr,resp,text){
        alert("Error while getting the user cash!");
    }
  })


  $.ajax({
    url: '/dsaApp/Item',
    dataType: 'json',
    contentType: 'application/json',
    success: function(x) {
        mokData = x;
        console.log(mokData);
        $.each(mokData, function(i){
            var templateCard = '<div class="col-md-4"> <figure class="card card-product-grid card-lg"> <a href="#" class="img-wrap" data-abc="true"><img src="' + mokData[i].image + '"></a><figcaption class="info-wrap"><div class="row"><div class="col-md-8"> <a href="#" class="title" data-abc="true">' + mokData[i].name + '</a> </div><div class="col-md-4"></div></div></figcaption><div class="bottom-wrap"><div class="price-wrap"><p class="price h5 text-center">'+ mokData[i].price + '€' +'</p><br><p> '+ mokData[i].description +' </p><br> </div><a href="#" class="btn btn-primary float-right" id="'+ mokData[i].name + 'Click' +'" data-abc="true">Buy Now</a></div></figure></div>';
            $('#testCards').append(templateCard);
        });
      },
      error: function(xhr,resp,text){
        alert("Error while getting the shop items!");
      }
  });



  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
    sessionStorage.removeItem("ID");
  });
});
