<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>软件项目信息管理</title>
</head>
<body>
	<h1>软件项目信息管理</h1>
	<a href="#">项目添加</a>
	<form action="delByids">
	<input type="submit" value="批量删除">
	<table border="1" cellspacing = "0" width="70%">
		<tr>
			<td>
				<input type="checkbox" onclick="selectAll()" id="all">全选/全不选
			</td>
			<td>项目编号</td>
			<td>项目名称</td>
			<td>开始日期</td>
			<td>结束日期</td>
			<td>项目经理</td>
			<td>项目进度</td>
		</tr>
		<c:forEach items="${list }" var="p">
			<tr class="code" onmouseover="this.style.background='gray'"onmouseout="this.style.background='white'">
				<td>
					<input type="checkbox" name="ids" value="${p.prjId }">
				</td>
				<td ><c:out value="${p.prjId }" /></td>
				<td><c:out value="${p.prjName }"/></td>
				<td><fmt:formatDate value="${p.prjStartDate }" pattern="yyyy年MM月dd日"/></td>
				<td><fmt:formatDate value="${p.prjEndDate }" pattern="yyyy年MM月dd日"/></td>
				<td><c:out value="${p.prjManager }"/></td>
				<td>
					<c:if test="${p.prjSchedule==1 }">
						未开始
					</c:if>
					<c:if test="${p.prjSchedule==2 }">
						开发阶段
					</c:if>
					<c:if test="${p.prjSchedule==3 }">
						测试阶段
					</c:if>
					<c:if test="${p.prjSchedule==4 }">
						已交付
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	</form>
	<script type="text/javascript">
	//全选与取消全选
	function selectAll(){
		//获取全选节点
		var all = document.getElementById("all");
		//获取所有的选项节点
		var ones = document.getElementsByName("ids");
		for(var i=0;i<ones.length;i++){
			//如果全选被选中，就将所有选项按钮选中
			if(all.checked == true){
				ones[i].checked = true;
			}
			//如果全选状态被取消，就取消所有选项按钮的选中状态
			else{
				ones[i].checked = false;
			}
		}
	}
	</script>
</body>
</html>