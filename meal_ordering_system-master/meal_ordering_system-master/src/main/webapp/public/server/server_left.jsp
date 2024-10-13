<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="${pageContext.request.contextPath}/public/admin/js/prototype.lite.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/public/admin/js/moo.fx.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/public/admin/js/moo.fx.pack.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/public/admin/css/left.css" rel="stylesheet" type="text/css" />
</head>

<body>

<table width="100%" height="280" border="0" cellpadding="0"
	   cellspacing="0" bgcolor="#EEF2FB">
	<tr>
		<td width="182" valign="top"><div id="container">
			<h1 class="type">
				<a href="javascript:void(0)">菜单管理</a>
			</h1>
			<div class="content">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><img src="${pageContext.request.contextPath}/public/admin/images/menu_topline.gif" width="182"
								 height="5" /></td>
					</tr>
				</table>
				<ul class="MM">
					<%--li><a href="<c:url value="/menus/toAddPage"/>" target="main">添加新菜单</a></li--%>
					<li><a href="<c:url value="/menus/allMenus"/>" target="main">菜单信息列表</a></li>
				</ul>
			</div>
			<h1 class="type">
				<a href="javascript:void(0)">餐桌管理</a>
			</h1>
			<div class="content">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><img src="${pageContext.request.contextPath}/public/admin/images/menu_topline.gif" width="182"
								 height="5" /></td>
					</tr>
				</table>
				<ul class="MM">

					<li><a href="<c:url value="/Tables/queryAll"/>" target="main">餐桌信息列表</a></li>

				</ul>
			</div>

			<h1 class="type">
				<a href="javascript:void(0)">销售订单管理</a>
			</h1>
			<div class="content">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td><img src="${pageContext.request.contextPath}/public/admin/images/menu_topline.gif" width="182"
								 height="5" /></td>
					</tr>
				</table>
				<ul class="MM">
					<li><a href="<c:url value="/orders/orderchangestatus"/>" target="main">修改订单状态</a></li>
					<li><a href="<c:url value="/orders/ordergetall"/>" target="main">全部订单</a></li>
					<%--li><a href="<c:url value="/orders/order_search"/>" target="main">销售订单查询</a></li>
					<li><a href="<c:url value="/orders/order_statistic"/>" target="main">本日销售额统计</a></li--%>
				</ul>
			</div>
		</div>


			<h1 class="type">
				<a href="/server/logout" target="_top" >注销退出</a>
			</h1></td>
	</tr>
</table>
<script type="text/javascript">
	var contents = document.getElementsByClassName('content');
	var toggles = document.getElementsByClassName('type');
	var myAccordion = new fx.Accordion(toggles, contents, {
		opacity : true,
		duration : 500
	});
	myAccordion.showThisHideOpen(contents[0]);
</script>

</body>
</html>
