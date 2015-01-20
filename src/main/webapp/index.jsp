<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<script type="text/javascript" src="js/angular.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript" src="js/github.js"></script>
	
	<title>Welcome!</title>
</head>

<body ng-app="gitHubViewer">
	<div ng-controller="MainController">
		<h1>{{message}}</h1>
		
		<div>{{error}}</div>
		
		{{countdown}}
		<form name="searchUser" ng-submit="search()">
			<input type="search" required placeholder="Username to find" ng-model="username" />
			<input type="submit" value="Search"> 
		</form>
		
		<div ng-show="user">
			<jsp:include page="WEB-INF/view/userdetails.jsp"></jsp:include>
		</div>
		
	</div>
</body>

</html>