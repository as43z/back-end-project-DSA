var inventory = [];
let userId = sessionStorage.getItem('ID');

$(document).ready(function(){
  if(userId == null){
      window.location.replace("/");
    }
  var mokData = [];
  var userData;


  //Call for user data, to get the user cash.
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
        alert("Error getting the user cash!");
    }
  });

  //Call for user inventory
  $.ajax({
      url: '/dsaApp/User/' + userId + '/Inventory',
      dataType: 'json',
      contentType: 'application/json',
      success: function(x) {
          console.log(x);
          inventory = [x.bookQuantity,x.calculatorQuantity,x.cheatQuantity,x.coffQuantity,x.compassQuantity,x.glassesQuantity,x.pencilQuantity,x.pillsQuantity,x.puzzleQuantity,x.redbullQuantity,x.ruleQuantity,x.turtleQuantity,x.usbQuantity];
          },
      error: function(xhr,resp,text){
          alert("Error while getting the inventory info!");
      }
    });


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

  $('TurtleClick').click(function(){
    var turtleVal = inventory[11];
    turtleVal = turtleVal + 1;
    inventory[11] = turtleVal;

  });

  $('CoffeeClick').click(function(){
  });

  $('RedBullClick').click(function(){
  });

  $('PillsClick').click(function(){
  });

  $('CalculatorClick').click(function(){
  });


  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
    sessionStorage.removeItem("ID");
  });


});

function updateInventory(inventory){

    var obj = {turtleQuantity: inventory[], coffQuantity: inventory[], redbullQuantity: inventory[], pillsQuantity: inventory[], calculatorQuantity: inventory[], ruleQuantity: inventory[], compassQuantity: inventory[], pencilQuantity: inventory[], glassesQuantity: inventory[], puzzleQuantity: inventory[], bookQuantity: inventory[], usbQuantity: inventory[], cheatQuantity: inventory[], id: ""}
    var myJSON = JSON.stringify(obj);

    $.ajax({
      type: 'PATCH',
      headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
      url: '/dsaApp/User/'+userId+'/UpdateInventory',
      dataType: 'json',
      data: myJSON,
      contentType: 'application/json',
      success: function(x) {
        console.log(x);
        alert("success");
      },
      error: function(xhr,resp,text){
        console.log(xhr,resp,text);
        alert("There is a problem.");
      }
    });
}