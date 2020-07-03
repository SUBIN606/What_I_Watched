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
	
	<h1>컨텐츠 검색</h1>
	<div class="searchWrap">
		<p>
			<input type="text" class="input__search" name="content_title" />
			<button type="button" class="searchBtn">검색</button>
		</p>
			
		<div class="contents__container hide">
			<ul class="contents__list"></ul>
			<button type="button" class="contents__more__btn hide">view more</button>
		</div>
	</div>
	
	<h1>리뷰 작성하기</h1>
	<form class="writeForm" action="${pageContext.request.contextPath }/reviews/write-processing" method="get">
		<div class="writeForm__row">
		
			<div class="writeForm__col left">
				<img class="posterImg">
				<input type='file' accept='image/jpg,image/png,image/jpeg,image/gif' 
						id='posterImgUpload' class="input__file" />
				<label for='posterImgUpload'>직접 올리기</label>
			</div>
			
			<div class="writeForm__col right">
				<input type="text" class="input__title" name="title" placeholder="제목" readonly="readonly"/><br>
				<input type="range" class="input__rating" name="rating" min="0" max="10"/>
				<span class="raitng__span">5점</span>
				<input type="text" class="input__hageTag" name="hashTag" placeholder="#태그를 입력해보세요!"/>
			</div>
						
		</div>
		
		<textarea rows="10" placeholder="후기를 적어보세요."></textarea>
		
	</form>
	<script src="../resources/js/searchContents.js"></script>
	<script src="../resources/js/review.js"></script>
</body>
</html>