<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>用户登录页面</h1>
  <h2><font color="red">${info}</font></h2>
  <form action="${pageContext.request.contextPath }/user/login" method="post">
  用户名称：<input type="text" name="userName"/>
  登录密码：<Input type="password" name="loginPwd"/>
  <input type="submit" value="用户登录"/>
  </form>
</body>
</html>