<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WIW | Write Review</title>
<link rel="stylesheet" href="../resources/css/review.css"/>
</head>
<body>
	<!-- Nav Bar -->
	<jsp:include page="../common/NavBar.jsp" flush="false" />
	<h1>리뷰 작성하기</h1>
	
	<form class="writeForm" action="${pageContext.request.contextPath }/reviews/write-processing" method="get">
		<!-- <input type="text" name="title" placeholder="제목"/><br> -->
		<p>
			<input type="text" class="input__contentTitle" name="content_title" />
			<button type="button" class="searchBtn">검색</button>
		</p>
		
		<div class="contents__container hide">
			<ul class="contents__list"></ul>
			<button type="button" class="contents__more__btn">view more</button>
		</div>
		
		<img class="writeForm__img__preview">
		<p>직접 올리기 <input type="file" class="input__file"/></p>
	</form>
	<script src="../resources/js/write.js"></script>
</body>
</html>