<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Existing Questions</th>
			</tr>
		</thead>
		<thead>
			<tr>
				<td>Category</td>
				<td>Question</td>
				<td>Type of Question</td>
				<td>Year</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<!-- place your questions here -->
			<tr>
				<td>${question_object.getCategory()}</td>
				<td>${question_object.getOriginalBody()}</td>
				<td>${question_object.getType()}</td>
				<td>${question_object.getYear()}</td>
			</tr>
		</tbody>
	</table>
	<a href="dashboard"><button>Back</button></a>
</body>
</html>