$(document).ready(function(){
  $("#btnSignUp").click(function(){
    window.location.replace("register.html")
  });

  $('#login_form').on('submit', function(event) {
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
      url: 'http://147.83.7.208:8080/dsaApp/Authentication/Login',
      dataType: 'json',
      data: myJSON,
      contentType: 'application/json',
      success: function(data) {
        alert(data)
      },
      error: function(xhr,resp,text){
        console.log(xhr,resp,text);
      }
    });
  });
});
