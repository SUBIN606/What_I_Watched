<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WIW | ReviewList</title>
<link rel="stylesheet" href="../resources/css/review.css"/>
</head>
<body>
	<!-- Nav Bar -->
	<jsp:include page="../common/NavBar.jsp" flush="false" />
<h1>리뷰목록 보러왔니</h1>
<jsp:useBean id="util" class="com.gaemi.wiw.util.UseBeanUtils" />

<c:forEach items="${reviews }" var="review" varStatus="i">
	<jsp:setProperty property="poster_img" name="util" value="${review.poster_img }"/>
	
	<li>
		<img class="posterImg" src="<jsp:getProperty property="poster_img" name="util"/>">
		<div>${review.title }</div>
		<div>${review.rating }</div>
		<div>${review.short_comment }</div>
	</li>

</c:forEach>

</body>
</html>