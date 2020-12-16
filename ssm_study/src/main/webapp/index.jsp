<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#testJson")
				.click(
						function() {
							//ajax method1:
							//通过ajax请求springMVC
							/* 
							$.post("${pageContext.request.contextPath}/springmvc/testJson",
							//{"name":"zs"}//{"name":"zs","age":23}表示请求所带的参数
							function(result) {//服务器处理完毕后的回调函数，返回值List<Student> students 已经被转为json数组的格式
								
								可以用eval来解析了这个json格式的字符串。
								它解析json格式的字符串，就在原来的字符串左右两边加上小括号，它就会把我们的json字符串解析成为一个json对象。
								然后我们通过对象的属性的访问形式，就可以取到里面的值。
								var txt = "{'userid':11,'name':'liyi'}";
								var txtObj = eval("("+txt+")"); 
								document.write(txtObj.userid);
								https://www.cnblogs.com/sunliyuan/p/6099828.html 
								for (var i = 0; i < result.length; i++) {
									alert(result[i].id+"-"+result[i].name+"-"+result[i].age);
								}
							});
							 */

							//ajax method2:
							//发送AJAX请求
							
									$.ajax({
										url : "${pageContext.request.contextPath}/springmvc/testJson",
										type : "POST",
										contentType : "application/json", //(默认: “application/x-www-form-urlencoded”) 发送信息至服务器时内容编码类型。默认值适合大多数应用场合。
										data : {},//data不需要传值的时候，data:{},就可以了。也可以不写，但为了规范，最好还是写上
										//发送到服务器的数据。将自动转换为请求字符串格式。可用data: {"channelOrgCode":channelOrgCode}/data: {channelOrgCode:channelOrgCode}
										//data:"page="+page+"&size="+size+"&startDate="+startDate+"&endDate="+endDate
										//https://www.cnblogs.com/tu-0718/p/8370925.html
										dataType : "json",//预期服务器返回的数据类型
										success : function(data) {//由服务器返回，并根据 dataType 参数进行处理后的数据；描述状态的字符串。
											for (var i = 0; i < data.length; i++) {
												alert(data[i].id + "-"
														+ data[i].name + "-"
														+ data[i].age);
											}
										}
									});

						});
	});
</script>
</head>
<body>

	<a href="handler/testExceptionHandler">testExceptionHandler</a>

	<!-- https://study.163.com/course/courseLearn.htm?courseId=1005999006#/learn/video?lessonId=1053366206&courseId=1005999006
 -->
	<input type="button" value="testJson" id="testJson" />

	<form action="springmvc/testUpload" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file" /> Desc:<input type="text" name="desc" />
		<input type="submit" value="上传" />
	</form>
	<br />
	<form action="springmvc/testDateTimeFormat" method="post">
		编号:<input type="text" name="id" value="31" /> <br> 姓名:<input
			type="text" name="name" /> <br> 出生日期:<input type="text"
			name="birthday" /> <br> <input type="submit" value="submit" />
	</form>
	<form action="springmvc/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1" /> username:<input
			type="text" name="username" value="tom" /> <br> email:<input
			type="text" name="email" value="123@qq" /> <br> age:<input
			type="text" name="age" value="13" /> <br> <input type="submit"
			value="submit" />
	</form>
	<br>
	<br>

	<a href="springmvc/testInterceptor">testInterceptor</a>
	<br>
	<br>
	<a href="springmvc/testI18n">testI18n</a>
	<br>
	<br>
	<a href="springmvc/testSessionAttributes">testSessionAttributes</a>
	<br>
	<br>

	<a href="springmvc/testModel">testModel</a>
	<br>
	<br>
	<a href="springmvc/testMap">testMap</a>
	<br>
	<br>
	<a href="springmvc/testModelMap">testModelMap</a>
	<br>
	<br>
	<a href="springmvc/testModelAndView">testModelAndView</a>
	<br>
	<br>

	<a href="springmvc/testServletAPI">testServletAPI</a>
	<br>
	<br>

	<form action="springmvc/testPojo" method="post">
		username:<input type="text" name="username" /> <br> password:<input
			type="password" name="password" /> <br> email:<input
			type="text" name="email" /> <br> age:<input type="text"
			name="age" /> <br> city:<input type="text" name="address.city" />
		<br> province:<input type="text" name="address.province" /> <br>
		<input type="submit" value="submit" />
	</form>
	<br>
	<br>

	<a href="springmvc/testRequestHeader">testRequestHeader</a>
	<br>
	<br>

	<a href="springmvc/testRequestParam?username=atguigu&age=11">testRequestParam</a>
	<br>
	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="testRest PUT" />
	</form>
	<br>
	<br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="testRest DELETE" />
	</form>
	<br>
	<br>

	<form action="springmvc/testRest" method="post">
		<input type="submit" value="testRest post">
	</form>
	<br>
	<br>

	<a href="springmvc/testRest/1">testRest get</a>
	<br>
	<br>

	<a href="springmvc/testPathVariable/1">testPathVariable</a>
	<br>
	<br>

	<a href="springmvc/testAntPath/mnxyz/abc">testAntPath</a>
	<br>
	<br>

	<a href="springmvc/testParamAndHeaders?username=atguigu&age=11">testParamAndHeaders</a>
	<br>
	<br>

	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="submit">
	</form>

	<br>
	<br>
	<a href="springmvc/testMethod">Test Method</a>
	<br>
	<br>
	<a href="springmvc/testRequestMapping">Test RequestMapping</a>
	<br>
	<br>
	<a href="helloworld">Hello World</a>
</body>
</html>