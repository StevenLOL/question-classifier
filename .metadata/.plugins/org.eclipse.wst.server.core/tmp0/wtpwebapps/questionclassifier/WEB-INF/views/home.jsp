<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${message }
	<h1>Hello ${user_object.getUsername()}</h1>
	<form method="POST" enctype="multipart/form-data" action="feed">
		File to upload: 
		<input type="file" name="file"><br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>
	<a href="display_questions">
		<button value="Display Questions">Display Questions</button>
	</a>
	<a href="test">
		<button value="Test">Test prototype</button>
	</a>
	
</body>
</html>