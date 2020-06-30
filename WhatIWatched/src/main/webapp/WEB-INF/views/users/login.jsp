<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 페이지 ㅎㅎ</h1>
	<h1>Login Page</h1> 
	<h2>${error}</h2> 
	<h2>${logout}</h2> 
	<form action="${pageContext.request.contextPath}/users/login-processing" method="post"> 
		<div> <input type="text" name="id" /> </div> 
		<div> <input type="password" name="password" /> </div> 
		<div> <input type="submit"/> </div> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	</form>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	    <font color="red">
	        Your login attempt was not successful due to <br/>
	        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
	    </font>
	</c:if>

</body>
</html>