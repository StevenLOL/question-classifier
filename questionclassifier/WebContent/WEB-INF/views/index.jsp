<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>${message}</h5>
	<p>Input = ${input}</p>
	<p>Returned value = ${returned_input}</p>
	
	<form action="relational_dependency" method="post">
		<textarea rows="5" cols="50" name = "message"></textarea><br>
		<input type="submit" value="Display Relational Dependency">
	</form>
	<form action="pos_tag" method="post">
		<textarea rows="5" cols="50" name = "message"></textarea><br>
		<input type="submit" value="Display POS Tags">
	</form>
</body>
</html>