<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WIW | Register</title>
<link rel="stylesheet" href="../resources/css/register.css"/>
</head>
<body>
	<!-- Nav Bar -->
	<jsp:include page="../common/NavBar.jsp" flush="false" />

<div class="registerWrap">
	<p>회원가입</p>
	<form action="${pageContext.request.contextPath}/users/registerAf" method="post">
		<span>아이디</span>
		<input type="text" name="id" placeholder="ID를 입력하세요." />
		
		<span>비밀번호</span>
		<input type="password" name="password" placeholder="비밀번호를 입력하세요." />
		
		<span>비밀번호 확인</span>
		<input type="password" name="password_confirm" placeholder="동일한 비밀번호를 입력하세요." />
		
		<span>이름</span>
		<input type="text" name="name" placeholder="이름을 입력하세요." />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		<input type="submit" class="btn" value="회원가입"/>
	</form>
</div>


</body>
</html>