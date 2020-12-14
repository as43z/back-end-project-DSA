var obj;
$(document).ready(function(){
  $("#btnSignUp").click(function() {
    event.preventDefault();
    /*const json = serialize_form(this);*/
    const user = $("#inputUser").val();
    const password = $("#inputPassword").val();
    const mail = $("#inputEmail").val();
    var obj = { uname: user, pswrd: password, email: mail};
    var myJSON = JSON.stringify(obj);
    console.log(myJSON);
    $.ajax({
      type: 'POST',
      headers: {"Access-Control-Allow-Origin": "*"},
      url: '/dsaApp/Authentication/addUser',
      dataType: 'json',
      data: myJSON,
      contentType: 'application/json',
      success: function(x) {
        console.log(x.uname);
        console.log(x.pswrd);
        console.log(x.email);
        alert("Sign up completed correctly! :)");
        window.location.replace("index.html")
      },
      error: function(xhr,resp,text){
        console.log(xhr,resp,text);
        alert("Problems while signing up! :(");
      }
    });

  });
});
