<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<h1 align="center">用户列表</h1>
	<hr>
	<table align="center" width="60%" border="1" cellpadding="5">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>地址</th>
			<th>生日</th>
		</tr>
		<c:choose>
			<c:when test="${empty users }">
				<tr>
					<td align="center" colspan="4">查无数据</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="u" items="${users}">
					<tr>
						<td align="center">${u.id}</td>
						<td align="center">${u.name}</td>
						<td align="center">${u.address}</td>
						<td align="center"><fmt:formatDate value="${u.birthday}"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td align="right" colspan="4"><c:choose>
					<c:when test="${page.currentPage==1 }">上一页</c:when>
					<c:otherwise>
						<a href="javascript:void(0)"
							onclick="changePage(${page.currentPage-1 })">上一页</a>
					</c:otherwise>
				</c:choose> &nbsp;&nbsp;&nbsp; <c:forEach begin="1" end="${page.totalPage }"
					var="vn">
					<c:choose>
						<c:when test="${vn==page.currentPage }">${vn}</c:when>
						<c:otherwise>
							<a href="javascript:void(0)" onclick="changePage(${vn })">${vn }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> &nbsp;&nbsp;&nbsp; <c:choose>
					<c:when test="${page.currentPage==page.totalPage }">下一页</c:when>
					<c:otherwise>
						<a href="javascript:void(0)"
							onclick="changePage(${page.currentPage+1 })">下一页</a>
					</c:otherwise>
				</c:choose> 
				&nbsp;&nbsp;&nbsp; 
					共${page.totalPage}页				
				&nbsp;&nbsp;&nbsp; 
				跳到第<select onchange="changeSel(this)">
					<c:forEach begin="1" end="${page.totalPage }" var="vn">
						<c:choose>
							<c:when test="${vn==page.currentPage}">
								<option value="${vn}" selected="selected">${vn}</option>
							</c:when>
							<c:otherwise>
								<option value="${vn}">${vn}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select></td>
		</tr>

	</table>
</body>
<script type="text/javascript">
	function changePage(pageNum) {
		window.location.href="${pageContext.request.contextPath}/user/queryAllUser?currPage="+pageNum;
	}
	function changeSel(obj) {
		var pageNum = obj.value;
		changePage(pageNum);
	}
</script>
</html>

