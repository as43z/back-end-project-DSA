var inventory = [];
let userId = sessionStorage.getItem('ID');
var userCash = 0;
var mokData = [];

$(document).ready(function(){
  if(userId == null){
      window.location.replace("/");
    }
  var userData;

  //Call for user data, to get the user cash.
  $.ajax({
    url: '/dsaApp/User/' + userId,
    dataType: 'json',
    contentType: 'application/json',
    success: function(x) {
        console.log(x);
        userCash = x.cash;
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
          inventory = [x.bookQuantity,x.calculatorQuantity,x.cheatQuantity,x.coffQuantity,x.compasQuantity,x.glassesQuantity,x.pencilQuantity,x.pillsQuantity,x.puzzleQuantity,x.redbullQuantity,x.ruleQuantity,x.turtleQuantity,x.usbQuantity];
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

  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
    sessionStorage.removeItem("ID");
  });


});

$(document).on('click', '#TurtleClick', function(){
  console.log("buying turtle....");
  if(userCash >= mokData[0].price){
      userCash = userCash - mokData[0].price;
      var turtleVal = inventory[11];
      turtleVal = turtleVal + 1;
      inventory[11] = turtleVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#CoffeeClick', function(){
  console.log("buying coffee....");
  if(userCash >= mokData[1].price){
      userCash = userCash - mokData[1].price;
      var coffeeVal = inventory[3];
      coffeeVal = coffeeVal + 1;
      inventory[3] = coffeeVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#RedBullClick', function(){
  console.log("buying redbull....");
  if(userCash >= mokData[2].price){
      userCash = userCash - mokData[2].price;
      var redbullVal = inventory[9];
      redbullVal = redbullVal + 1;
      inventory[9] = redbullVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#PillsClick', function(){
  console.log("buying pills....");
  if(userCash >= mokData[3].price){
      userCash = userCash - mokData[3].price;
      var pillsVal = inventory[7];
      pillsVal = pillsVal + 1;
      inventory[7] = pillsVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#CalculatorClick', function(){
  console.log("buying calculator....");
  if(userCash >= mokData[4].price){
      userCash = userCash - mokData[4].price;
      var calculatorVal = inventory[1];
      calculatorVal = calculatorVal + 1;
      inventory[1] = calculatorVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#RuleClick', function(){
  console.log("buying rule....");
  if(userCash >= mokData[5].price){
      userCash = userCash - mokData[5].price;
      var ruleVal = inventory[10];
      ruleVal = ruleVal + 1;
      inventory[10] = ruleVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#CompasClick', function(){
  console.log("buying compas....");
  if(userCash >= mokData[6].price){
      userCash = userCash - mokData[6].price;
      var compasVal = inventory[4];
      compasVal = compasVal + 1;
      inventory[4] = compasVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#PencilClick', function(){
  console.log("buying pencil....");
  if(userCash >= mokData[7].price){
      userCash = userCash - mokData[7].price;
      var pencilVal = inventory[6];
      pencilVal = pencilVal + 1;
      inventory[6] = pencilVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#GlassesClick', function(){
  console.log("buying glasses....");
  if(userCash >= mokData[8].price){
      userCash = userCash - mokData[8].price;
      var glassesVal = inventory[5];
      glassesVal = glassesVal + 1;
      inventory[5] = glassesVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#PuzzleClick', function(){
  console.log("buying puzzle....");
  if(userCash >= mokData[9].price){
      userCash = userCash - mokData[9].price;
      var puzzleVal = inventory[8];
      puzzleVal = puzzleVal + 1;
      inventory[8] = puzzleVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#BookClick', function(){
  console.log("buying book....");
  if(userCash >= mokData[10].price){
      userCash = userCash - mokData[10].price;
      var bookVal = inventory[0];
      bookVal = bookVal + 1;
      inventory[0] = bookVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#USBClick', function(){
  console.log("buying usb....");
  if(userCash >= mokData[11].price){
      userCash = userCash - mokData[11].price;
      var usbVal = inventory[12];
      usbVal = usbVal + 1;
      inventory[12] = usbVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});

$(document).on('click', '#CheatSheetClick', function(){
  console.log("buying cheatsheet....");
  if(userCash >= mokData[12].price){
      userCash = userCash - mokData[12].price;
      var cheatVal = inventory[2];
      cheatVal = cheatVal + 1;
      inventory[2] = cheatVal;
      var obj = {turtleQuantity: inventory[11], coffQuantity: inventory[3], redbullQuantity: inventory[9], pillsQuantity: inventory[7], calculatorQuantity: inventory[1], ruleQuantity: inventory[10], compasQuantity: inventory[4], pencilQuantity: inventory[6], glassesQuantity: inventory[5], puzzleQuantity: inventory[8], bookQuantity: inventory[0], usbQuantity: inventory[12], cheatQuantity: inventory[2], id: ""}
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
        },
        error: function(xhr,resp,text){
          console.log(xhr,resp,text);
          alert("There is a problem.");
        }
      });

      var obj = {cash: userCash};
      var myJSON = JSON.stringify(obj);

      $.ajax({
        type: 'PATCH',
        headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
        url: '/dsaApp/User/'+userId+'/UpdateCash',
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
      $('#coins').html('<p>You have: ' + userCash + '€</p>');
  }
  else{
    alert("You don't have enough money.")
  }
});