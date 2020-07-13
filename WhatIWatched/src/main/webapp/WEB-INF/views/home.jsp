<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<!-- Nav Bar -->
	<jsp:include page="common/NavBar.jsp" flush="false" />
	
	<h1>Welcome Home</h1>
	<a href="${pageContext.request.contextPath }/reviews/write">글쓰기</a><br>
	<a href="${pageContext.request.contextPath }/reviews/list">글목록</a>
	
</body>
</html>
