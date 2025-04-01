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
<title>文档管理</title>
<link rel="stylesheet" type="text/css" href="css/css/base.css">
<script language="javascript">
function viewArc(aid){
	if(aid==0) aid = getOneItem();
	window.open("archives.asp?aid="+aid+"&action=viewArchives");
}
function editArc(aid){
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=editArchives";
}
function updateArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=makeArchives&qstr="+qstr+"";
}
function checkArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=checkArchives&qstr="+qstr+"";
}
function moveArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=moveArchives&qstr="+qstr+"";
}
function adArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=commendArchives&qstr="+qstr+"";
}
function delArc(aid){
	var qstr=getCheckboxItem();
	if(aid==0) aid = getOneItem();
	location="archives.asp?aid="+aid+"&action=delArchives&qstr="+qstr+"";
}

//获得选中文件的文件名
function getCheckboxItem()
{
	var allSel="";
	if(document.form2.id.value) return document.form2.id.value;
	for(i=0;i<document.form2.id.length;i++)
	{
		if(document.form2.id[i].checked)
		{
			if(allSel=="")
				allSel=document.form2.id[i].value;
			else
				allSel=allSel+"`"+document.form2.id[i].value;
		}
	}
	return allSel;
}

//获得选中其中一个的id
function getOneItem()
{
	var allSel="";
	if(document.form2.id.value) return document.form2.id.value;
	for(i=0;i<document.form2.id.length;i++)
	{
		if(document.form2.id[i].checked)
		{
				allSel = document.form2.id[i].value;
				break;
		}
	}
	return allSel;
}
function selAll()
{
	for(i=0;i<document.form2.id.length;i++)
	{
		if(!document.form2.id[i].checked)
		{
			document.form2.id[i].checked=true;
		}
	}
}
function noSelAll()
{
	for(i=0;i<document.form2.id.length;i++)
	{
		if(document.form2.id[i].checked)
		{
			document.form2.id[i].checked=false;
		}
	}
}
</script>
</head>
<body leftmargin="8" topmargin="8" background='image/image/allbg.gif'>

<!--  快速转换位置按钮  -->
  
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="image/image/tbg.gif">&nbsp;用户管理&nbsp;<a href="sys/request/userAdd" style="color: blue">添加</a></td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td>用户名</td>
	<td>密码</td>
	<td>电话</td>
	<td>邮箱</td>
	<td>地址</td>
	<td>权限</td>
	<td>操作</td>
</tr>
<c:if test="${message ne null }">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
<td colspan="6">${message }</td>
</c:if>
<c:forEach items="${pager.datas }" var="user" varStatus="vs">
<c:if test="${user['account'] ne sessionScope['User']['account'] }">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td>${user['account'] }</td>
		<td>${user['password'] }</td>
		<td>${user['tel'] }</td>
		<td>${user['email'] }</td>
		<td>${user['address'] }</td>
		<c:if test="${user['type'] eq 1}">
		<td>学生</td>
		</c:if>
		<c:if test="${user['type'] eq 3}">
		<td>教师</td>
		</c:if>
		<td><a href="sys/queryOne?id=${user['id']}">查看</a> | <a href="sys/delete?id=${user['id']}" onclick="return check();">删除</a></td>
	</tr>
</c:if>
</c:forEach>

<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center">
	<c:if test="${pager.pageNow gt 1}">
                <a href="sys/query?pageNow=${pager.pageNow-1 }">上一页</a>
                </c:if>
                <c:if test="${pager.pageNow lt pager.totalPage}">
                <a href="sys/query?pageNow=${pager.pageNow+1 }">下一页</a>
                </c:if>
</td>
</tr>
</table>

</form>

<!--  搜索表单  -->
</body>
<script type="text/javascript">
	var pageNow = $()
</script>
<script type="text/javascript">
	function check(){
		if(window.confirm("您确定删除此用户吗?")){
			return true;
		}
		return false;
	}
</script>
</html>