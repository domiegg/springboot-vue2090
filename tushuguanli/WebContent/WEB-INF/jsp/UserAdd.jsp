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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
<title>图书管理系统</title>
<link rel="stylesheet" href="css/css/bootstrap.css" />
<link rel="stylesheet" href="css/css/css.css" />
<script type="text/javascript" src="js/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="js/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/js/sdmenu.js"></script>
<script type="text/javascript" src="js/js/laydate/laydate.js"></script>

</head>

<body>
<!-- 顶部 -->     
            
<div id="middle">
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script>

     <div class="right"  id="mainFrame">
     
     <div class="right_cont">
   
   <div class="title_right"><strong>用户信息</strong></div>
   <div style="width:900px; margin:auto">
   <form action="sys/userAdd" method="post" onsubmit="return check();">
   <input type="hidden" name="id" value="${user['id'] }"/>
	   <table class="table table-bordered" >
	     <tr>
	       <td nowrap="nowrap">用户名：</td>
	       <td colspan="3"><input type="text" name="account" id="account"/></td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">密码：</td>
	       <td colspan="3"><input type="text" name="password" id="password"/></td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">电话：</td>
	       <td colspan="3"><input type="text" name="tel" id="tel"/></td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">邮箱：</td>
	       <td colspan="3"><input type="text" name="email" id="email"/></td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">地址：</td>
	       <td colspan="3"><input type="text" name="address" id="address"/></td>
	     </tr>
	      <input type="hidden" name="type" value="1"></input>
	   </table>
	      <table  class="margin-bottom-20 table  no-border" >
	        <tr>
	     	<td class="text-center"><input type="submit" value="提交" class="btn btn-info " style="width:80px;" /></td>
	     </tr>
	 </table>
   </form>
   </div>  
     </div>     
     </div>
    </div>
    
<!-- 底部 -->
<div id="footer">版权所有：图书管理系统</div>
    
    

 <script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar'});
laydate.skin('molv');
laydate({elem: '#Calendar2'});
}();
 
</script>
 <script>
function check(){
	var account = $("#account").val();
	var password = $("#password").val();
	if(account==null||account==''){
		alert("请输入用户名!");
		return false;
	}
	if(password==null||password==''){
		alert("请输入密码!");
		return false;
	}
	return true;
}
 
</script>



 
</body>
</html>
