$(document).ready(function(){
  let userName = sessionStorage.getItem('Nombre');
  var mokData = [
  { object: "Turtle", desc: 'Descripción de la tortuga', price:'3€', quality: 'Health', quantity: '10', image: 'images/turtle.png'},
  { object: "Calculadora", desc: 'Descripción de la calculadora', price:'3€', quality: 'Stamina', quantity: '2', image: 'images/calculator.png'},
  { object: "Calculadora", desc: 'Descripción de la calculadora', price:'3€', quality: 'Stamina', quantity: '2', image: 'images/calculator.png'},
  { object: "Calculadora", desc: 'Descripción de la calculadora', price:'3€', quality: 'Stamina', quantity: '2', image: 'images/calculator.png'},
  { object: "Calculadora", desc: 'Descripción de la calculadora', price:'3€', quality: 'Stamina', quantity: '2', image: 'images/calculator.png'},
  { object: "Calculadora", desc: 'Descripción de la calculadora', price:'3€', quality: 'Stamina', quantity: '2', image: 'images/calculator.png'},
  { object: "Calculadora", desc: 'Descripción de la calculadora', price:'3€', quality: 'Stamina', quantity: '2', image: 'images/calculator.png'},
  ];

  $.each(mokData, function(i){
    var templateCard = '<div class="col-md-4"> <figure class="card card-product-grid card-lg"> <a href="#" class="img-wrap" data-abc="true"><img src="' + mokData[i].image + '"></a><figcaption class="info-wrap"><div class="row"><div class="col-md-8"> <a href="#" class="title" data-abc="true">' + mokData[i].object + '</a> </div><div class="col-md-4"></div></div></figcaption><div class="bottom-wrap"><div class="price-wrap"><p class="price h5 text-center">'+ mokData[i].price +'</p><br><p> '+ mokData[i].desc +' </p><br><p> '+mokData[i].quality+ ': +' + mokData[i].quantity + 'points' + '</p><br> </div><a href="#" class="btn btn-primary float-right" data-abc="true">Buy Now</a></div></figure></div>';
    $('#testCards').append(templateCard);  });

  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
  });
});
