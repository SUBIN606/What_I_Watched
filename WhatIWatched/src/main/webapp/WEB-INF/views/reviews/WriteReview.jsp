<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
	<div class="searchWrap">
		<input type="text" class="input__search" name="content_title" placeholder="컨텐츠 제목을 입력하세요." />
		<button type="button" class="searchBtn">검색</button>	
		
		<div class="contents__container hide">
			<ul class="contents__list"></ul>
			<button type="button" class="viewMoreBtn hide">VIEW MORE</button>
		</div>
	</div>
	
	<div class="writeFormWrap hide">
		<form class="writeForm" 
			  action="${pageContext.request.contextPath }/reviews/write-processing?${_csrf.parameterName}=${_csrf.token}" 
			  method="post" enctype="multipart/form-data">
			
			<div class="writeForm__row">			
				<div class="writeForm__col left">
					<input type="hidden" name="poster_img" class="input__posterImg"/>
					<img class="posterImg">
					<input type='file' accept='image/jpg,image/png,image/jpeg,image/gif' 
							id='posterImgUpload' class="input__file" name="file"/>
					<label for='posterImgUpload'>직접 올리기</label>
				</div>
				
				<div class="writeForm__col right">
					<p>컨텐츠 제목</p>
					<input type="text" class="input__title" name="title" placeholder="제목" readonly="readonly"/>
					<input type="hidden" class="input__subtitle" name="subtitle" />
					
					<p>당신의 점수는 <span class="rating__span">5</span></p>
					<input type="range" class="input__rating" name="rating" min="0" max="10"/>
	
					<p>한줄평</p>
					<input type="text" class="input__comment" name="comment" placeholder="이 컨텐츠는 한 마디로?"/>
				</div>						
			</div>
			
			<div class="writeForm__row">
				<textarea rows="7" placeholder="후기를 적어보세요." name="content"></textarea>
			</div>
			
			<div class="writeForm__row">
				<input type="submit" class="save btn" value="리뷰 저장"/>
			</div>
		</form>
	</div>
	
	<script src="../resources/js/searchContents.js"></script>
	<script src="../resources/js/review.js"></script>
</body>
</html>