<html lang="en"><head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="">
   <meta name="author" content="">
   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
   <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
   <style>
      body{
         background-color: #3e3e3e;
         color: white;
      }
   </style>

<title>Welcome</title>
</head>

   <%! // JSP local variable
      String name;
   %>

   <% //Servlet Code
      name = request.getUserPrincipal().getName();
   %>

<body>
   <div style="text-align: center;">
      <h2>Welcome <%=name%></h2><br>
      <form action="/logout">
         <input type="submit" value="Logout"/>
      </form>
   </div>

</body>
</html>

