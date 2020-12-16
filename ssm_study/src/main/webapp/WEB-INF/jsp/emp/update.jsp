<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>员工信息修改页面</h1>
  <form:form action="${pageContext.request.contextPath }/emp/update" modelAttribute="employee" method="POST">
  <table border="1" width="75%">
    <tr><td>员工编号：</td><td><form:input path="empId" disabled="true"/></td></tr>
    <form:hidden path="empId"/>
    <tr><td>员工姓名：</td><td><form:input path="name"/><span><form:errors path="name"></form:errors></span></td></tr>
    <tr><td>员工性别：</td><td><form:radiobuttons path="gender" items="${empSex }"/></td></tr>
     <tr><td>入职日期：</td><td><form:input path="hireDate"/><span><form:errors path="hireDate"></form:errors></span></td></tr>
      <tr><td>员工工资：</td><td><form:input path="salary"/><span><form:errors path="salary"></form:errors></span></td></tr>
       <tr><td>所在部门：</td><td>
         <form:select path="dept.id">
           <form:options items="${depts }" itemLabel="name" itemValue="id"/>
         </form:select>
       </td></tr>
       <tr><td colspan="2" align="center"><input type="submit" value="修改当前员工信息"></td></tr>
  </table>
  </form:form>
</body>
</html>