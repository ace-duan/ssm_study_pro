<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
  <!-- 给员工编号的输入框添加一个失去焦点的事件处理代码 -->
  <script type="text/javascript">
    $(function(){
    	$("#empid").blur(function(){
    		var empId=$(this).val();
    		//发送AJAX请求
    		$.ajax({
    			url:"${pageContext.request.contextPath}/emp/json",
    			type:"POST",
    			contentType:"application/json",
    			data:JSON.stringify({"empId":empId}),//发送到服务器的数据将自动转换为请求字符串格式。用JSON.stringify(）把js对象转化为json字符串。https://www.cnblogs.com/tu-0718/p/8370925.html
    			dataType:"json",//预期服务器返回的数据类型
    			success:function(data){//由服务器返回，并根据 dataType 参数进行处理后的数据；描述状态的字符串。
    				//alert(data.msg+","+data.status);
    				if(data.status){
    					$("#empId").css("color","green");
    				}else{
    					$("#empId").css("color","red");
    				}
    				$("#empId").html(data.msg);
    			}
    		});
    	});
    })
  </script>
</head>
<body>
   <h1>员工添加页面</h1>
<%--   modelAttribute="employee" 等价于 commandName ="employee" 如果什么都不写会默认从名为command的request域中取值--%>
    <form:form action="${pageContext.request.contextPath }/emp/add" modelAttribute="employee" method="POST">
      <table border="1" width="75%">
        <tr><td>员工编号:</td><td><form:input path="empId" id="empid" /><span id="empId"><form:errors path="empId" cssStyle="color:red"></form:errors></span></td></tr>
        <tr><td>员工姓名:</td><td><form:input path="name"/><span><form:errors path="name" cssStyle="color:red"></form:errors></span></td></tr>
        <tr><td>员工性别:</td><td><form:radiobuttons path="gender" items="${gender }"/></td></tr>
        <tr><td>入职日期:</td><td><input type="date" name="hireDate"><span><form:errors path="hireDate" cssStyle="color:red"></form:errors></span></td></tr>
        <tr><td>员工工资:</td><td><form:input path="salary"/><span><form:errors path="salary" cssStyle="color:red"></form:errors></span></td></tr>
        <tr><td>所在部门：</td><td>
          <select name="dept.id">
            <c:forEach items="${depts }" var="dept">
              <option value="${dept.id }">${dept.name }</option>
            </c:forEach>
          </select>
        </td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="添加用户"></td></tr>
      </table>
    </form:form>
</body>
</html>