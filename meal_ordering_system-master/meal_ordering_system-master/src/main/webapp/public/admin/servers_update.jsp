<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.example.meal_ordering_system.dao.TypesDao"%>
<%@page import="com.example.meal_ordering_system.entity.Types"%>
<%@page import="com.example.meal_ordering_system.entity.Server"%>
<%@ page import="com.example.meal_ordering_system.dao.ServerDao" %>
<%@page import="java.util.*"%>
<%@ page import="com.example.meal_ordering_system.controller.MenusController" %>
<%@ page import="com.example.meal_ordering_system.service.MenusService" %>
<%@ page import="com.example.meal_ordering_system.service.impl.MenusServiceImpl" %>
<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
<link href="../public/admin/css/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>
<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="17" valign="top" background="../public/admin/images/mail_leftbg.gif"><img
					src="../public/admin/images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="../public/admin/images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">修改服务员信息</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top" background="../public/admin/images/mail_rightbg.gif"><img
					src="../public/admin/images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle" background="../public/admin/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<p>&nbsp;</p>
				<div align="center">
					<form action="/server/update" method="post"
						name="form1" onSubmit="return check11()">
						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">编号:</span></td>
								<td class="line_table" height="25" width="70%"><input
									type="text" name="SerNo" size="45" value="${server.serNo}" readonly></td>
							</tr>

							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">姓名:</span></td>
								<td class="line_table" height="25" width="80%"><input
									type="text" name="SerName" size="45"
									value="${server.serName}" ></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">性别:</span></td>
								<td height="25" width="80%"><input type="text" name="SerSex"
									size="45" value="${server.serSex}" ></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">年龄:</span></td>
								<td height="25" width="80%"><input type="text"
									name="SerAge" size="45" value="${server.serAge}"></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="right" width="20%"><span
									class="left_bt2">密码:</span></td>
								<td class="line_table" height="25" width="80%"><textarea
										rows="12" name="SerPwd" cols="100">${server.serPwd}</textarea></td>
							</tr>


							<tr>
								
								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="修改">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</td>

			<td background="images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom" background="../public/admin/images/mail_leftbg.gif"><img
					src="../public/admin/images/buttom_left2.gif" width="17" height="17" /></td>
			<td background="../public/admin/images/buttom_bgs.gif"><img
					src="../public/admin/images/buttom_bgs.gif" width="17" height="17"></td>
			<td valign="bottom" background="../public/admin/images/mail_rightbg.gif"><img
					src="../public/admin/images/buttom_right2.gif" width="16" height="17" /></td>
		</tr>
	</table>


</body>
</html>
