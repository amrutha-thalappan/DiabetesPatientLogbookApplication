var userId;

function registerUser() {
    event.preventDefault();
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
                  window.location.href = "http://localhost:8082/CLIENT_war_exploded/index.xhtml";
              },
              error: function() {
                  alert('Your registration is failed');
              }
   })
   // using the done promise callback
   .done(function (data) {
       //userId = data[0].userId;
       //System.out.println(userId);
       // log data to the console so we can see
       console.log(data);
     // here we will handle errors and validation messages
   });
}
