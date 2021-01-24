$(document).ready(function(){
  let userName = sessionStorage.getItem('Nombre');
  if(userName == null){
    window.location.replace("/");
  }
  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
    sessionStorage.removeItem("ID");
  });
});
