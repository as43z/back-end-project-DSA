$(document).ready(function(){
  let userId = sessionStorage.getItem('ID');
  if(userId == null){
      window.location.replace("/");
    }
  var user = [];


  $.ajax({
      url: '/dsaApp/User/' + userId,
      dataType: 'json',
      contentType: 'application/json',
      success: function(x) {
          console.log(x);
          user = [x.uname, x.email, x.cash, x.idGame, x.ID, x.pswrd];
          var templateUname = '<p>Username: ' + x.uname + '</p>'
          var templateEmail = '<p>Email: ' + x.email + '</p>'
          var templateCash = '<p>Cash: ' + x.cash + '€</p>'
          var templateGame = '<p>Game ID: ' + x.idGame + '</p>'
          $('#username').html(templateUname);
          $('#email').html(templateEmail);
          $('#cash').html(templateCash);
          $('#game').html(templateGame);
          $('#userForm').append('<input id="userNameFromForm" class="form-control" type="text" value="'+x.uname+'">');
          $('#emailForm').append('<input id="emailFromForm" class="form-control" type="email" value="'+x.email+'">');
          $('#passwordForm').append('<input id="passwordFromForm"class="form-control" type="password" value="'+x.pswrd+'">');
          $('#confirmPasswordForm').append('<input id="confPasswordFromForm" class="form-control" type="password" value="'+x.pswrd+'">');
      },
      error: function(xhr,resp,text){
          alert("Error while getting the user info!");
      }
    });

  $.ajax({
    url: '/dsaApp/User/' + userId + '/Inventory',
    dataType: 'json',
    contentType: 'application/json',
    success: function(x) {
        console.log(x);
        $('#inventoryTable').append('<tbody><tr><td>Turtle: '+ x.turtleQuantity +' items.</td></tr><tr><td>Coffee: '+ x.coffQuantity +' items.</td></tr><tr><td>RedBull: '+ x.redbullQuantity +' items.</td></tr><tr><td>Pills: '+ x.pillsQuantity +' items.</td></tr><tr><td>Calculator: '+ x.calculatorQuantity +' items.</td></tr><tr><td>Rule: '+ x.ruleQuantity +' items.</td></tr><tr><td>Compas: '+ x.compasQuantity +' items.</td></tr><tr><td>Pencil: '+ x.pencilQuantity +' items.</td></tr><tr><td>Glasses: '+ x.glassesQuantity +' items.</td></tr><tr><td>Puzzle: '+ x.puzzleQuantity +' items.</td></tr><tr><td>Book: '+ x.bookQuantity +' items.</td></tr><tr><td>USB: '+ x.usbQuantity +' items.</td></tr><tr><td>Cheat sheet: '+ x.cheatQuantity +' items.</td></tr></tbody>');
    },
    error: function(xhr,resp,text){
        alert("Error while getting the inventory info!");
    }
  });
  $.ajax({
      url: '/dsaApp/User/' + userId + '/Achievements',
      dataType: 'json',
      contentType: 'application/json',
      success: function(x) {
          console.log(x);
          var calc = "Not passed :(";
          var electro = "Not passed :(";
          var comms = "Not passed :(";
          var oesc = "Not passed :(";
          var dsa = "Not passed :(";
          var aero = "Not passed :(";
          var tfg = "Not passed :(";

          if(x.calcAch == 1){
            calc = "Passed!";
          }
          if(x.aeroAch == 1){
            aero = "Passed!";
          }
          if(x.commsAch == 1){
            comms = "Passed!";
          }
          if(x.dsaAch == 1){
            dsa = "Passed!";
          }
          if(x.electronicsAch == 1){
            electro = "Passed!";
          }
          if(x.oescAch == 1){
            oesc = "Passed!";
          }
          if(x.tfgAch == 1){
            tfg = "Passed!";
          }

          $('#achievementsTable').append('<tbody><tr><td>Calculus: '+ calc +'</td></tr><tr><td>Electronics: '+ electro +'</td></tr><tr><td>Communications: '+ comms +'</td></tr><tr><td>OESC: '+ oesc +'</td></tr><tr><td>DSA: '+ dsa +'</td></tr><tr><td>Aerodynamics: '+ aero +'</td></tr><tr><td>Final Work: '+ tfg +'</td></tr></tbody>');
      },
      error: function(xhr,resp,text){
          alert("Error while getting the inventory info!");
      }
    });


  $('#buttonChanges').click(function(){
    const user = $("#userNameFromForm").val();
    const mail = $("#emailFromForm").val();
    const pwd = $("#passwordFromForm").val();
    const confPwd = $("#confPasswordFromForm").val();

    if(pwd == confPwd){
        var obj = { uname: user, pswrd: pwd, email: mail, ID: userId};
        var myJSON = JSON.stringify(obj);
        console.log(myJSON);
        $.ajax({
              type: 'PATCH',
              headers: {"Access-Control-Allow-Origin": "*", "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE"},
              url: '/dsaApp/User/UpdateUser',
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


  });
  $('#logout').click(function() {
    sessionStorage.removeItem("Nombre");
    sessionStorage.removeItem("ID");
  });
});
