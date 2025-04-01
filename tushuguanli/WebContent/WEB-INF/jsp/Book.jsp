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
   
   <div class="title_right"><strong>图书资料</strong></div>
   <div style="width:900px; margin:auto">
   <table class="table table-bordered" >
     <tr>
       <td nowrap="nowrap">书籍名称：${book['bookName'] }</td>
     </tr>
     <tr>
       <td nowrap="nowrap">书籍类型：${book['bookType'] }</td>
     </tr>
     <tr>
       <td nowrap="nowrap">书籍作者：${book['bookWriter'] }</td>
     </tr>
     <tr>
       <td nowrap="nowrap">出版社：${book['bookHouse'] }</td>
     </tr>
     <tr>
       <td nowrap="nowrap">库存：${book['bookNumber'] }</td>
     </tr>
   </table>
      <table  class="margin-bottom-20 table  no-border" >
        <tr>
     	<td class="text-center"><a href="sys/book/query"><input type="button" value="返回" class="btn btn-info " style="width:80px;" /></a></td>
     </tr>
 </table>
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



 
</body>
</html>
