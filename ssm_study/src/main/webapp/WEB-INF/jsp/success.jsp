<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!-- 国际化标签库 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${requestScope.errors}" var="error">
	    ${error.getDefaultMessage()},
	</c:forEach><br/>
		<fmt:message key="resource.welcome"></fmt:message>
		<fmt:message key="resource.exist"></fmt:message>

		<h4>Success Page</h4>
		
		time: ${requestScope.time}
		<br><br>
		
		request names1:${requestScope.names1}
		<br><br>
		request names2:${requestScope.names2}
		<br><br>
		request names3:${requestScope.names3}
		<br><br>
		
		session names1:${sessionScope.names1}
		<br><br>
		session names2:${sessionScope.names2}
		<br><br>
		session names3:${sessionScope.names3}
		<br><br>
		
		request user: ${requestScope.user}
		<br><br>
		session user: ${sessionScope.user}
		<br><br>
		request school: ${requestScope.school}
		<br><br>
		session school: ${sessionScope.school}
		<br><br>
		
</body>
</html>