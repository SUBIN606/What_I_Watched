<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<!-- Nav Bar -->
	<%@ include file="common/NavBar.jsp" %>
	
	
	<h1>Welcome Home</h1>
	<a href="${pageContext.request.contextPath }/reviews/write">글쓰기</a><br>
	<a href="${pageContext.request.contextPath }/reviews/list">글목록</a>
	
</body>
</html>
