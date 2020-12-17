$(document).ready(function(){
  $("#btnSignUp").click(function(){
    window.location.replace("register.html")
  });

  $('#btnLogIn').click(function() {
    event.preventDefault();
    /*const json = serialize_form(this);*/
    const user = $("#inputUser").val();
    const password = $("#inputPassword").val();
    var obj = { uname: user, pswrd: password};
    var myJSON = JSON.stringify(obj);

    console.log(myJSON);
    $.ajax({
      type: 'POST',
      headers: {"Access-Control-Allow-Origin": "*"},
      url: '/dsaApp/Authentication/Login',
      dataType: 'json',
      data: myJSON,
      contentType: 'application/json',
      success: function(x) {
        console.log(x.uname);
        console.log(x.pswrd);
        alert("Logging in as: " + x.uname);
        sessionStorage.setItem('Nombre', x.uname);
        let firstName = sessionStorage.getItem('Nombre');
        console.log("Hola, en sessionStorage está " + firstName);
        window.location.replace("mainmenu.html");
      },
      error: function(xhr,resp,text){
        console.log(xhr,resp,text);
        alert("There is a problem. You are not able to log in");
      }
    });
  });
});
