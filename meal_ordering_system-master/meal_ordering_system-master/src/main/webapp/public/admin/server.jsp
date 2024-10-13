<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.meal_ordering_system.entity.Server"%>
<%@ page import="com.example.meal_ordering_system.service.ServerService" %>
<%@ page import="com.example.meal_ordering_system.service.impl.ServerServiceImpl" %>
<%@ page language="java"  pageEncoding="utf-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="../public/admin/css/skin.css" rel="stylesheet" type="text/css" />
</head>
<body class="body">
<table width="100%" height="1" border="0" cellpadding="0"
	   cellspacing="0">
	<tr>
		<td width="17" valign="top" background="../public/admin/images/mail_leftbg.gif"><img
				src="../public/admin/images/left-top-right.gif" width="17" height="29" /></td>
		<td valign="top" background="../public/admin/images/content-bg.gif"><table
				width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
				class="left_topbg" id="table_2">
			<tr>
				<td height="31"><div class="titlebt">服务员信息</div></td>
			</tr>
		</table></td>
		<td width="16" valign="top" background="../public/admin/images/mail_rightbg.gif"><img
				src="../public/admin/images/nav-right-bg.gif" width="16" height="29" /></td>
	</tr>
	<tr>
		<td valign="middle" background="../public/admin/images/mail_leftbg.gif">&nbsp;</td>
		<td valign="top" bgcolor="#F7F8F9">
			<div align="center">
				<table id="table2" class="line_table"
					   style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
					   cellPadding="0">
					<tbody style="margin: 0; padding: 0">
					<tr>
						<td class="line_table" align="center" colspan="11" height="20"><span
								class="left_bt2">服务员信息列表</span></td>
					</tr>
					<tr>
						<td class="line_table" align="center"><span
								class="left_bt2">编号</span></td>
						<td class="line_table" align="center"><span
								class="left_bt2">姓名</span></td>
						<td class="line_table" align="center"><span
								class="left_bt2">性别</span></td>
						<td class="line_table" align="center"><span
								class="left_bt2">年龄</span></td>
						<td class="line_table" align="center"><span
								class="left_bt2">密码</span></td>

						<td class="line_table" align="center"><span
								class="left_bt2">&nbsp;</span></td>
						<td class="line_table" align="center"><span
								class="left_bt2">&nbsp;</span></td>
					</tr>

					<c:forEach items="${Serverlist}" var="s">
					<tr>
						<td class="line_table" align="center"><span
								class="left_txt">${s.serNo}</span></td>
						<td class="line_table" align="center"><span
								class="left_txt">${s.serName}</span></td>
						<td class="line_table" align="center"><span
								class="left_txt">${s.serSex}</span></td>
						<td class="line_table" align="center"><span
								class="left_txt">${s.serAge}</span></td>
						<td class="line_table" align="center"><span
								class="left_txt">${s.serPwd}</span></td>

						<td class="line_table" align="center"><a
								href="/server/toUpdateServer?SerNo=${s.serNo}">修改</a></td>
						<td class="line_table" align="center"><a
								href="/server/delete?SerNo=${s.serNo}">删除</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</td>
		<td background="../public/admin/images/mail_rightbg.gif">&nbsp;</td>
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