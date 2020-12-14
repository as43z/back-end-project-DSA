$(document).ready(function(){
  let userName = sessionStorage.getItem('Nombre');
  $("#user").html(userName);
});
