<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Black Party's Question Classifier</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
	
<!-- CSS Libs -->
<link href="<c:url value="/resources/stylesheets/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/animate.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/bootstrap-switch.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/checkbox3.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/jquery.dataTables.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/dataTables.bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/select2.min.css" />"
	rel="stylesheet">
<!-- CSS App -->
<link href="<c:url value="/resources/stylesheets/style.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/stylesheets/flat-blue.css" />"
	rel="stylesheet">


</head>

<body class="flat-blue login-page">
	<div class="container">
		<div class="login-box">
			<div>
				<div class="login-form row">
					<div class="col-sm-12 text-center login-header">
						<i class="login-logo fa fa-connectdevelop fa-5x"></i>
						<h4 class="login-title">Question Classifier</h4>
					</div>
					<div class="col-sm-12">
						<div class="login-body">
							<div class="progress hidden" id="login-progress">
								<div
									class="progress-bar progress-bar-success progress-bar-striped active"
									role="progressbar" aria-valuenow="100" aria-valuemin="0"
									aria-valuemax="100" style="width: 100%">Log In...</div>
							</div>
							<form action="login" method="post">
								<div class="control">
									<input type="text" class="form-control" name="username"value="admin" />
								</div>
								<div class="control">
									<input type="password" class="form-control" name="password" value="123456" />
								</div>
								<div class="login-button text-center">
									<input type="submit" class="btn btn-primary" value="Login">
								</div>
							</form>
						</div>
						<div class="login-footer">
							<span class="text-right"><a href="<c:url value="dashboard"/>" class="color-white">Forgot
									password?</a></span>&nbsp;
									<span class="text-right"><a href="register" class="color-white">Register</a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Javascript Libs -->
	
	<script type="text/javascript" src="<c:url value="/resources/javascripts/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascripts/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascripts/Chart.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/javascripts/bootstrap-switch.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/javascripts/jquery.matchHeight-min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/javascripts/jquery.dataTables.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/javascripts/dataTables.bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascripts/select2.full.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascripts/ace.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascripts/mode-html.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/javascripts/theme-github.js"/>"></script>
	<!-- Javascript -->
	<script type="text/javascript" src="<c:url value="/resources/javascripts/app.js"/>"></script>
</body>

</html>
