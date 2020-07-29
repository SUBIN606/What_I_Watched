<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WIW | Login</title>
<link rel="stylesheet" href="../resources/css/login.css"/>
</head>
<body>
	<!-- Nav Bar -->
	<%@ include file="../common/NavBar.jsp" %>
	
	<div class="loginWrap">
		<img src="../resources/image/popcorn.png" class="login__logo">
		<form action="${pageContext.request.contextPath}/users/login-processing" method="post"> 
			<input type="text" name="id" placeholder="ID"/> 
			<input type="password" name="password" placeholder="PASSWORD"/> 
			<input type="submit" class="btn" value="LOGIN"/> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		</form>
		<span>아직 회원이 아니신가요? <a href="${pageContext.request.contextPath}/users/register">회원가입</a></span>
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		    <font color="red">
		        Your login attempt was not successful due to <br/>
		        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
		    </font>
		</c:if>
	</div>
	
</body>
</html>