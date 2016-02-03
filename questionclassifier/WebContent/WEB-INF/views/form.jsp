<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>Question Classifier</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
<!-- CSS Libs -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/animate.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/bootstrap-switch.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/checkbox3.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/jquery.dataTables.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/dataTables.bootstrap.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/select2.min.css"/>">
<!-- CSS App -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/stylesheets/flat-blue.css"/>">
</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<nav class="navbar navbar-default navbar-fixed-top navbar-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-expand-toggle">
							<i class="fa fa-bars icon"></i>
						</button>
						<ol class="breadcrumb navbar-breadcrumb">
							<li>Form</li>
							<li class="active">Form Kits</li>
						</ol>
						<button type="button"
							class="navbar-right-expand-toggle pull-right visible-xs">
							<i class="fa fa-th icon"></i>
						</button>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<button type="button"
							class="navbar-right-expand-toggle pull-right visible-xs">
							<i class="fa fa-times icon"></i>
						</button>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false"><i
								class="fa fa-comments-o"></i></a>
							<ul class="dropdown-menu animated fadeInDown">
								<li class="title">Notification <span
									class="badge pull-right">0</span>
								</li>
								<li class="message">No new notification</li>
							</ul></li>
						<li class="dropdown danger"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false"><i class="fa fa-star-half-o"></i> 4</a>
							<ul class="dropdown-menu danger  animated fadeInDown">
								<li class="title">Notification <span
									class="badge pull-right">4</span>
								</li>
								<li>
									<ul class="list-group notifications">
										<a href="#">
											<li class="list-group-item"><span class="badge">1</span>
												<i class="fa fa-exclamation-circle icon"></i> new
												registration</li>
										</a>
										<a href="#">
											<li class="list-group-item"><span class="badge success">1</span>
												<i class="fa fa-check icon"></i> new orders</li>
										</a>
										<a href="#">
											<li class="list-group-item"><span class="badge danger">2</span>
												<i class="fa fa-comments icon"></i> customers messages</li>
										</a>
										<a href="#">
											<li class="list-group-item message">view all</li>
										</a>
									</ul>
								</li>
							</ul></li>
						<li class="dropdown profile"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false">${username} <span class="caret"></span></a>
							<ul class="dropdown-menu animated fadeInDown">
								<li class="profile-img"><img
									src="../../img/profile/picjumbo.com_HNCK4153_resize.jpg"
									class="profile-img"></li>
								<li>
									<div class="profile-info">
										<h4 class="username">${username}</h4>
										<p>emily_hart@email.com</p>
										<div class="btn-group margin-bottom-2x" role="group">
											<button type="button" class="btn btn-default">
												<i class="fa fa-user"></i> Profile
											</button>
											<a href="logout"><button type="button" class="btn btn-default">
												<i class="fa fa-sign-out"></i> Logout
											</button></a>
										</div>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
			<div class="side-menu sidebar-inverse">
				<nav class="navbar navbar-default" role="navigation">
					<div class="side-menu-container">
						<div class="navbar-header">
							<a class="navbar-brand" href="#">
								<div class="icon fa fa-paper-plane"></div>
								<div class="title">Flat Admin V.2</div>
							</a>
							<button type="button"
								class="navbar-expand-toggle pull-right visible-xs">
								<i class="fa fa-times icon"></i>
							</button>
						</div>
						<ul class="nav navbar-nav">
							<li><a href="dashboard"> <span
									class="icon fa fa-tachometer"></span><span class="title">Dashboard</span>
							</a></li>
							<li class="panel panel-default dropdown"><a
								data-toggle="collapse" href="#dropdown-element"> <span
									class="icon fa fa-desktop"></span><span class="title">UI
										Kits</span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-element" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="../ui-kits/grid.html">Grid</a></li>
											<li><a href="../ui-kits/theming.html">Theming</a></li></li>
							<li><a href="../ui-kits/button.html">Buttons</a></li>
							<li><a href="../ui-kits/card.html">Cards</a></li>
							<li><a href="../ui-kits/list.html">Lists</a></li>
							<li><a href="../ui-kits/modal.html">Modals</a></li>
							<li><a href="../ui-kits/alert.html">Alerts & Toasts</a></li>
							<li><a href="../ui-kits/panel.html">Panels</a></li>
							<li><a href="../ui-kits/loader.html">Loaders</a></li>
							<li><a href="../ui-kits/step.html">Tabs & Steps</a></li>
							<li><a href="../ui-kits/other.html">Other</a></li>
						</ul>
					</div>
			</div>
			</li>
			<li class="panel panel-default dropdown"><a
				data-toggle="collapse" href="#dropdown-table"> <span
					class="icon fa fa-table"></span><span class="title">Table</span>
			</a> <!-- Dropdown level 1 -->
				<div id="dropdown-table" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav navbar-nav">
							<li><a href="../table/table.html">Table</a></li>
							<li><a href="../table/datatable.html">Datatable</a></li>
						</ul>
					</div>
				</div></li>
			<li class="active panel panel-default dropdown"><a
				data-toggle="collapse" href="#dropdown-form"> <span
					class="icon fa fa-file-text-o"></span><span class="title">Form</span>
			</a> <!-- Dropdown level 1 -->
				<div id="dropdown-form" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav navbar-nav">
							<li><a href="form">Form UI Kits</a></li>

						</ul>
					</div>
				</div></li>
			<!-- Dropdown-->
			<li class="panel panel-default dropdown"><a
				data-toggle="collapse" href="#component-example"> <span
					class="icon fa fa-cubes"></span><span class="title">Components</span>
			</a> <!-- Dropdown level 1 -->
				<div id="component-example" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav navbar-nav">
							<li><a href="../components/pricing-table.html">Pricing
									Table</a></li>
							<li><a href="../components/chartjs.html">Chart.JS</a></li>
						</ul>
					</div>
				</div></li>
			<!-- Dropdown-->
			<li class="panel panel-default dropdown"><a
				data-toggle="collapse" href="#dropdown-example"> <span
					class="icon fa fa-slack"></span><span class="title">Page
						Example</span>
			</a> <!-- Dropdown level 1 -->
				<div id="dropdown-example" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav navbar-nav">
							<li><a href="../pages/login.html">Login</a></li>
							<li><a href="../pages/index.html">Landing Page</a></li>
						</ul>
					</div>
				</div></li>
			<!-- Dropdown-->
			<li class="panel panel-default dropdown"><a
				data-toggle="collapse" href="#dropdown-icon"> <span
					class="icon fa fa-archive"></span><span class="title">Icons</span>
			</a> <!-- Dropdown level 1 -->
				<div id="dropdown-icon" class="panel-collapse collapse">
					<div class="panel-body">
						<ul class="nav navbar-nav">
							<li><a href="../icons/glyphicons.html">Glyphicons</a></li>
							<li><a href="../icons/font-awesome.html">Font Awesomes</a></li>
						</ul>
					</div>
				</div></li>
			<li><a href="../license.html"> <span
					class="icon fa fa-thumbs-o-up"></span><span class="title">License</span>
			</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
		</nav>
	</div>
	<!-- Main Content -->
	<div class="container-fluid">
		<div class="side-body">
			<div class="page-title">
				<span class="title">Form UI Kits</span>
				<div class="description">A ui elements use in form, input,
					select, etc.</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<div class="card-title">
								<div class="title">Import File</div>
							</div>
						</div>
						<div class="card-body">
							Examples of standard form controls. such as input, textarea,
							select, checkboxes and radios , static control, etc.
							<div class="sub-title">Import PDF</div>
							<div>
								<form method="POST" enctype="multipart/form-data" action="feed">
									File to upload: <input type="file" name="file"><br />
									<input type="submit" value="Upload"> Press here to
									upload the file!
								</form>
								<a href="display_questions">
									<button value="Display Questions">Display Questions</button>
								</a> <a href="test">
									<button value="Test">Test prototype</button>
								</a>
							</div>
							<div class="sub-title">Textarea</div>
							<div>
								<textarea class="form-control" rows="3"></textarea>
							</div>
							<div class="sub-title">
								Checkboxes and radios <span class="description">( with <a
									href="https://github.com/tui2tone/checkbox3">checkbox3</a> )
								</span>
							</div>
							<div>
								<div class="checkbox3 checkbox-round">
									<input type="checkbox" id="checkbox-2"> <label
										for="checkbox-2"> Option one is this and that&mdash;be
										sure to include why it's great </label>
								</div>
								<div class="checkbox3 checkbox-round">
									<input type="checkbox" id="checkbox-3" disabled=""> <label
										for="checkbox-3"> Option two is disabled </label>
								</div>
								<div class="radio3">
									<input type="radio" id="radio1" name="radio1" value="option1">
									<label for="radio1"> Option one is this and
										that&mdash;be sure to include why it's great </label>
								</div>
								<div class="radio3">
									<input type="radio" id="radio2" name="radio1" value="option2">
									<label for="radio2"> Option two can be something else
										and selecting it will deselect option one </label>
								</div>
								<div class="sub-title">Inline</div>
								<div>
									<div
										class="checkbox3 checkbox-inline checkbox-check checkbox-light">
										<input type="checkbox" id="checkbox-fa-light-1" checked="">
										<label for="checkbox-fa-light-1"> Option1 </label>
									</div>
									<div
										class="checkbox3 checkbox-success checkbox-inline checkbox-check checkbox-round  checkbox-light">
										<input type="checkbox" id="checkbox-fa-light-2" checked="">
										<label for="checkbox-fa-light-2"> Option Round </label>
									</div>
									<div
										class="checkbox3 checkbox-danger checkbox-inline checkbox-check  checkbox-circle checkbox-light">
										<input type="checkbox" id="checkbox-fa-light-3" checked="">
										<label for="checkbox-fa-light-3"> Option Circle </label>
									</div>
								</div>
								<div>
									<div class="radio3 radio-check radio-inline">
										<input type="radio" id="radio4" name="radio2" value="option1"
											checked=""> <label for="radio4"> Option 1 </label>
									</div>
									<div class="radio3 radio-check radio-success radio-inline">
										<input type="radio" id="radio5" name="radio2" value="option2">
										<label for="radio5"> Option 2 </label>
									</div>
									<div class="radio3 radio-check radio-warning radio-inline">
										<input type="radio" id="radio6" name="radio2" value="option3">
										<label for="radio6"> Option 3 </label>
									</div>
								</div>
							</div>
							<div class="sub-title">
								Toggle <span class="description">( with <a
									href="https://github.com/nostalgiaz/bootstrap-switch">bootstrap-switch</a>
									)
								</span>
							</div>
							<div>
								<input type="checkbox" class="toggle-checkbox"
									name="my-checkbox" checked>
							</div>
							<div class="sub-title">
								Select <span class="description">( with <a
									href="https://select2.github.io/">select2</a> )
								</span>
							</div>
							<div>
								<select>
									<optgroup label="Alaskan/Hawaiian Time Zone">
										<option value="AK">Alaska</option>
										<option value="HI">Hawaii</option>
									</optgroup>
									<optgroup label="Pacific Time Zone">
										<option value="CA">California</option>
										<option value="NV">Nevada</option>
										<option value="OR">Oregon</option>
										<option value="WA">Washington</option>
									</optgroup>
									<optgroup label="Mountain Time Zone">
										<option value="AZ">Arizona</option>
										<option value="CO">Colorado</option>
										<option value="ID">Idaho</option>
										<option value="MT">Montana</option>
										<option value="NE">Nebraska</option>
										<option value="NM">New Mexico</option>
										<option value="ND">North Dakota</option>
										<option value="UT">Utah</option>
										<option value="WY">Wyoming</option>
									</optgroup>
									<optgroup label="Central Time Zone">
										<option value="AL">Alabama</option>
										<option value="AR">Arkansas</option>
										<option value="IL">Illinois</option>
										<option value="IA">Iowa</option>
										<option value="KS">Kansas</option>
										<option value="KY">Kentucky</option>
										<option value="LA">Louisiana</option>
										<option value="MN">Minnesota</option>
										<option value="MS">Mississippi</option>
										<option value="MO">Missouri</option>
										<option value="OK">Oklahoma</option>
										<option value="SD">South Dakota</option>
										<option value="TX">Texas</option>
										<option value="TN">Tennessee</option>
										<option value="WI">Wisconsin</option>
									</optgroup>
									<optgroup label="Eastern Time Zone">
										<option value="CT">Connecticut</option>
										<option value="DE">Delaware</option>
										<option value="FL">Florida</option>
										<option value="GA">Georgia</option>
										<option value="IN">Indiana</option>
										<option value="ME">Maine</option>
										<option value="MD">Maryland</option>
										<option value="MA">Massachusetts</option>
										<option value="MI">Michigan</option>
										<option value="NH">New Hampshire</option>
										<option value="NJ">New Jersey</option>
										<option value="NY">New York</option>
										<option value="NC">North Carolina</option>
										<option value="OH">Ohio</option>
										<option value="PA">Pennsylvania</option>
										<option value="RI">Rhode Island</option>
										<option value="SC">South Carolina</option>
										<option value="VT">Vermont</option>
										<option value="VA">Virginia</option>
										<option value="WV">West Virginia</option>
									</optgroup>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<div class="card-title">
								<div class="title">Basic example</div>
							</div>
						</div>
						<div class="card-body">
							<form>
								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> <input
										type="email" class="form-control" id="exampleInputEmail1"
										placeholder="Enter email">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label> <input
										type="password" class="form-control"
										id="exampleInputPassword1" placeholder="Password">
								</div>
								<div class="form-group">
									<label for="exampleInputFile">File input</label> <input
										type="file" id="exampleInputFile">
									<p class="help-block">Example block-level help text here.</p>
								</div>
								<div class="checkbox">
									<div class="checkbox3 checkbox-round">
										<input type="checkbox" id="checkbox-1"> <label
											for="checkbox-1"> Check me out </label>
									</div>
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<div class="card-title">
								<div class="title">Inline form</div>
							</div>
						</div>
						<div class="card-body">
							<form class="form-inline">
								<div class="form-group">
									<label for="exampleInputName2">Name</label> <input type="text"
										class="form-control" id="exampleInputName2"
										placeholder="Jane Doe">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail2">Email</label> <input
										type="email" class="form-control" id="exampleInputEmail2"
										placeholder="jane.doe@example.com">
								</div>
								<button type="submit" class="btn btn-default">Send
									invitation</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<div class="card-title">
								<div class="title">Horizontal form</div>
							</div>
						</div>
						<div class="card-body">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="email" class="form-control" id="inputEmail3"
											placeholder="Email">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input type="password" class="form-control"
											id="inputPassword3" placeholder="Password">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<div
											class="checkbox3 checkbox-round checkbox-check checkbox-light">
											<input type="checkbox" id="checkbox-10"> <label
												for="checkbox-10"> Remember me </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-default">Sign in</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<footer class="app-footer">
		<div class="wrapper">
			<span class="pull-right">2.1 <a href="#"><i
					class="fa fa-long-arrow-up"></i></a></span> � 2015 Copyright.
		</div>
	</footer>
	<div>
		<!-- Javascript Libs -->
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/jquery.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/bootstrap.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/Chart.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/bootstrap-switch.min.js"/>"></script>

		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/jquery.matchHeight-min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/jquery.dataTables.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/dataTables.bootstrap.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/select2.full.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/ace/ace.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/ace/mode-html.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/ace/theme-github.js"/>"></script>
		<!-- Javascript -->
		<script type="text/javascript"
			src="<c:url value="/resources/javascripts/app.js"/>"></script>
</body>

</html>
