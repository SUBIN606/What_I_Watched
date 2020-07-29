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
	<%@ include file="../common/NavBar.jsp" %>
	
	<h1>리뷰목록 보러왔니</h1>
	<jsp:useBean id="util" class="com.gaemi.wiw.util.UseBeanUtils" />
	
	<div class="reviewList__container">
		<c:forEach items="${reviews }" var="review" varStatus="i">
		<jsp:setProperty property="poster_img" name="util" value="${review.poster_img }"/>		
			<li>
				<img class="posterImg" src="<jsp:getProperty property="poster_img" name="util"/>">
				<div>
					<span>${review.title }</span>
					<span>평점: ${review.rating }</span>
					<span>한줄평: ${review.short_comment }</span>
				</div>				
			</li>	
		</c:forEach>
	</div>


</body>
</html>