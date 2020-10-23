<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Welcome</title>
</head>

<body>
<div style="text-align: center;">
   Welcome ${user.getUsername()}
</div><br>

<form action="${pageContext.request.contextPath}/logout">
   <input type="submit" value="Logout">
</form>

</body>
