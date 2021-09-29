<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <% out.print((String)session.getAttribute("user")); %></h1>
<form action="./Home" method="post">
    <input type="submit" value="Log out" name="logout"/>
</form>
</body>
</html>