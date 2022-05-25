<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理系统——管理员管理模块</title>
</head>
<body>
	<fieldset>
		<h1>管理员管理</h1>
		<form action="show" method="post">
			真实姓名：<input type="text" name="realName">
			用户状态:<select name="state">
				         <option value="2">全部</option>
				         <option value="0">启用</option>
				         <option value="1">禁用</option>
					</select>
					<input type="submit" value="查询">
		</form>
	</fieldset>
	<table border="1" cellspacing = "0" width="60%">
		<tr>
			<td>用户名称</td>
			<td>真实姓名</td>
			<td>用户类型</td>
			<td>用户状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="admin">
		<form action="changeRealName" method="get">
		<input type="hidden" value="${admin.id }" name="id">
		<tr>
			<td><c:out value="${admin.username }"/></td>
			<td><input type="text" value="${admin.realName }" name="realName"/></td>
			<td><c:out value="${admin.userRole }"/></td>
			<td>
				<c:if test="${admin.userState==0 }">
					启用
				</c:if>
				<c:if test="${admin.userState==1 }">
					禁用
				</c:if>
			</td>
			<td>
			<c:if test="${admin.userRole=='超级管理员' }">
				<input type="submit" value="修改真实姓名" onclick="return confirm('确定修改此数据吗？')">
			</c:if>
			<c:if test="${admin.userRole=='普通用户' }">
				<c:if test="${admin.userState==0 }">
					<input type="submit" value="修改真实姓名" onclick="return confirm('确定修改此数据吗？')">
					<a href="changeState?id=${admin.id }&state=1">禁用</a>
				</c:if>
				<c:if test="${admin.userState==1 }">
					<input type="submit" value="修改真实姓名" onclick="return confirm('确定修改此数据吗？')">
					<a href="changeState?id=${admin.id }&state=0">启用</a>
				</c:if>
			</c:if>
			</td>
		</tr>
		</form>
		</c:forEach>
	</table>
</body>
</html>