<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ page import="com.example.meal_ordering_system.entity.Users" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>输入桌号</title>
    <meta content="" name=keywords />
    <meta content="" name=description />
    <link href="${pageContext.request.contextPath}/public/qiantai/css/common.css" rel="stylesheet" type="text/css" />

</head>


<script type="text/javascript" src="${pageContext.request.contextPath}/public/qiantai/js/common.js"></script>

<script language="JavaScript">
    function check11()
    {
        if (document.form1.TableNo.value == ""  )
        {
            alert("桌号不能为空!");
            document.form1.code.focus();
            return false;
        }
    }
</script>



<body style='background:transparent'>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td align="left" valign="top">


            <jsp:include flush="false" page="top.jsp"/>

        </td>
    </tr>
    <tr >
        <td height="20"></td>

    </tr>

    <tr>
        <td align="center" valign="center" height="450">
            <input type="hidden" value="${user_session}">
            <form action="/users/selectTable" name="form1" method="post" onSubmit="return check11()">
                <%Users user = (Users)session.getAttribute("user_session");%>
                <div align="center"><br>
                    <table border="1" cellspacing="0" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" width="700">
                        <tr>
                            <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
                                <font color="#996633">桌号</font>
                            </td>
                            <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
                                <input class="input7" type="text" name="TableNo" />
                            </td>
                            <td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
                                <font color="red">&nbsp;* </font>请填写您的桌号</td>
                        </tr>
                        <tr><input type="hidden" name="id" value="<%=user.getId() %>">
                            <td colspan="3" align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
                                <input type="submit" value="提交" />
                            </td>
                        </tr>

                    </table>
                </div>
            </form>



        </td>
    </tr>
    <tr>
        <td height="10">&nbsp;</td>
    </tr>
    <tr>
        <td height="50" align="center" valign="middle">&nbsp;

            <jsp:include flush="false" page="copyright.jsp"/>
        </td>
    </tr>

</table>



</body>
</html>