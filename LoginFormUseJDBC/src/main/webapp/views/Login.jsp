<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="../Home" method="post">
		<div>
			Username: <input type="text" name="username" placeholder="Username"
				required>
		</div>
		<div>
			Password: <input type="password" name="password"
				placeholder="Password" required>
		</div>
		<div>
			<button type="submit">LOG IN</button>
		</div>

	</form>
</body>
</html>