<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
   $(function(){
	   //给对应的删除超链接添加点击事件
	   $(".delete").click(function(){
		   if(confirm("你确定要删除该员工信息吗？")){
			  var href=$(this).attr("href");//获取超链接对应的值，作为表单的action属性值
			  $("#delete").attr("action",href).submit();
		   }
		   
		   return false;
	   });
   })
</script>
</head>
<body>

  <h2>员工信息显示页面</h2>
  <table border="1" width="85%">
  <tr>
    <th>#</th><th>员工编号</th><th>员工姓名</th><th>员工性别</th><th>入职日期</th><th>所在部门</th><th>工资</th><th>操作</th>
  </tr>
  <c:choose>
    <c:when test="${!empty(emps) }">
      <c:forEach items="${emps }" var="emp" varStatus="status">
       <tr>
         <td>${status.index+1 }</td>
         <td>${emp.empId }</td>
         <td>${emp.name }</td>
         <td>${emp.gender?'男':'女' }</td>
         <td><fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd"/></td>
         <td>${emp.dept.name }</td>
         <td>${emp.salary }</td>
         <td><a href="${pageContext.request.contextPath }/emp/${emp.empId}">修改</a>&nbsp;|&nbsp;
         <a href="${pageContext.request.contextPath }/emp/${emp.empId}" class="delete">删除</a></td>
       </tr>
      </c:forEach>
    </c:when>
  </c:choose>
  <tr><td colspan="8" align="right"><a href="${pageContext.request.contextPath }/emp/add">添加新员工</a></td></tr>
  </table>
  <form action="" id="delete" method="POST">
    <input type="hidden" name="_method"  value="DELETE"/>
  </form>
</body>
</html>