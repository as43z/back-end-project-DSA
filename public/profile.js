$(document).ready(function(){
  let userName = sessionStorage.getItem('Nombre');
  $("#title").html(userName);
  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
  });
});
