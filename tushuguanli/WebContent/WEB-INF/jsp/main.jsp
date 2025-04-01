<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	 /*
    @Author:Jaylan Zhou
    @Date:
    @projectName:
    @TEL:13166803607
    @QQ:764540631
    */

	/*
	    全路径,形式如下:
	    request.getScheme():获取http协议
	    request.getServerName():获取本地服务器名
	    request.getServerPort():获取服务器端口号
	    path:访问路径
	*/
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
<title>图书管理系统</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="css/css/base.css" />
<link rel="stylesheet" type="text/css" href="css/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> <img height="14" src="image/image/book1.gif" width="20" />&nbsp;欢迎使用图书管理系统。 </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" background="image/image/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="image/image/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr>
  <td bgcolor="#FFFFFF">欢迎您!${sessionScope['User']['account']}</td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="image/image/wbg.gif" class='title'><span>系统基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">您是：</td>
    <c:if test="${sessionScope['User']['type'] eq 1 }">
    <td width="75%" bgcolor="#FFFFFF">学生</td>
    </c:if>
     <c:if test="${sessionScope['User']['type'] eq 2 }">
    <td width="75%" bgcolor="#FFFFFF">管理员</td>
    </c:if>
     <c:if test="${sessionScope['User']['type'] eq 3 }">
    <td width="75%" bgcolor="#FFFFFF">教师</td>
    </c:if>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>您的用户名：</td>
    <td>${sessionScope['User']['account']}</td>
  </tr>
</table>
</body>
</html>