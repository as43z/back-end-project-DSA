$(document).ready(function(){
  let userName = sessionStorage.getItem('Nombre');
  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
    sessionStorage.removeItem("ID");
  });
});
