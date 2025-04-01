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
<link rel="stylesheet" href="css/css/base.css" type="text/css" />
<link rel="stylesheet" href="css/css/menu.css" type="text/css" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="js/js/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item 1 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>用户操作</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
        <!-- 普通用户 -->
        <c:if test="${sessionScope['User']['type'] eq 1 or sessionScope['User']['type'] eq 3}">
          <ul class='sitemu'>
            <li>
              <div class='items'>
                <div class='fllct'><a href="sys/book/query" target='main'>我要借书</a></div>
              </div>
            </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href="sys/magazine/query" target='main'>期刊查看</a></div>
              </div>
            </li>
            <li><a href="sys/rent/queryNull?customName=${sessionScope['User']['account'] }" target='main'>我要还书</a> </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href="sys/rent/query?customName=${sessionScope['User']['account'] }" target='main'>借书记录</a></div>
              </div>
            </li>
             <c:if test="${sessionScope['User']['type'] eq 3}">
            <li>
              <div class='items'>
                <div class='fllct'><a href='sys/query?type=1' target='main'>学生信息</a></div>
              </div>
            </li>
            </c:if>
          </ul>
          </c:if>
          <!-- 管理员 -->
          <c:if test="${sessionScope['User']['type'] eq 2 }">
          <ul class='sitemu'>
          <li><a href='sys/request/bookAdd' target='main'>图书入库</a> </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='sys/book/manage' target='main'>图书管理</a></div>
              </div>
            </li>
            <li><a href="sys/request/magazineAdd" target='main'>期刊入库</a> </li>
            <li><a href="sys/magazine/manage" target='main'>期刊管理</a> </li>
            <li><a href="sys/day/query?adminName=${sessionScope['User']['account'] }" target='main'>日常打卡</a> </li>
            <li><a href='sys/type/query' target='main'>类别管理</a> </li>
            <li><a href='sys/query?type=3' target='main'>教师管理</a> </li>
          </ul>
          </c:if>
          <!-- 后勤 -->
          <!-- <ul class='sitemu'>
          <li><a href='sys/out/query?outStatus=1' target='main'>经费申请</a> </li>
          <li><a href='sys/out/query?outStatus=2' target='main'>审批通过</a> </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='sys/out/query?outStatus=3' target='main'>申请记录</a></div>
              </div>
            </li>
            <li><a href='sys/pay/query' target='main'>账目管理</a> </li>
            <li>
              <div class='items'>
                <div class='fllct'><a href='sys/repair/query' target='main'>线路维修</a></div>
              </div>
            </li>
          </ul> -->
        </dd>
      </dl>
      <!-- Item 1 End -->
      <!-- Item 2 Strat -->
      <!-- Item 2 End -->
	  </td>
  </tr>
</table>
</body>
</html>