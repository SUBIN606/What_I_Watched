<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/style.css"/>
<link rel="stylesheet" href="../resources/css/navbar.css"/>
</head>
<body>
<nav class="navbar">
	<div class="navbar__logo">
		<a class="navbar__logo__text" href="/">
		<img class="navbar__logo__img" src="../resources/image/popcorn.png" alt="logo-img" />
			What I Watched
		</a>
	</div>
	
	<!-- 	
	<div class="navbar__menu">
	
	</div>
	 -->

	
	<div class="navbar__users">
		<sec:authorize access="!isAuthenticated()">
	  		<li>
	  			<button type="button" class="login btn" 
	  					onclick="location.href='${pageContext.request.contextPath}/users/login'">
	  			LOGIN
	  			</button>
	  		</li>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
			<li><sec:authentication property="principal.name"/></li>
			<li>
				<form action="${pageContext.request.contextPath }/users/logout" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" class="logout btn" value="LOGOUT" />
				</form>
			</li>
		</sec:authorize>
	</div>
</nav>
</body>
</html>