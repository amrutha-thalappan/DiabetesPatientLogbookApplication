function registerUser() {
var userDetails = {
                    'firstName': $("#firstName").val(),
                    'lastName': $("#lastName").val(),
                    'contactNumber': $("#contactNumber").val(),
                    'email': $("#email").val(),
                    'userName': $("#userName").val(),
                    'password': $("#psw").val()
                                  }
   $.ajax({
       type: "POST",
       crossDomain: true,
       url: "http://localhost:8080/users/",
       data: JSON.stringify(userDetails), // our data object
       dataType: "json", // what type of data do we expect back from the server
       contentType: "application/json",
       success: function() {
                //alert("success");
                  window.location.href = "http://localhost:63342/swagger-spring/templates/index.html";
              },
              error: function() {
                  alert('Something went wrong');
              }
   })
   // using the done promise callback
   .done(function (data) {

       // log data to the console so we can see
       console.log(data);
     // here we will handle errors and validation messages
   });
}

function loginUser() {
var loginCredentials = {
                    'username': $("#userName").val(),
                    'password': $("#psw").val()
                    }
   $.ajax({
       type: "POST",
       crossDomain: true,
       url: "http://localhost:8080/login",
       data: JSON.stringify(loginCredentials), // our data object
       dataType: "json", // what type of data do we expect back from the server
       contentType: "application/json",
       success: function() {
                   //alert("success");
                  window.location.href = "http://localhost:63342/swagger-spring/templates/home.html";
              },
              error: function() {
                  alert('Something went wrong');
              }
   })
   // using the done promise callback
   .done(function (data) {

       // log data to the console so we can see
       console.log(data);
     // here we will handle errors and validation messages
   });
}