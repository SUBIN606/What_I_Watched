<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>What I Watched</h1>
	<P>  The time on the server is ${serverTime}. </P>
	
	<a href="${pageContext.request.contextPath}/users/register">회원가입</a> <br><br>
	
	<a href="${pageContext.request.contextPath}/users/login">로그인</a>
</body>
</html>
