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
   
   <div class="title_right"><strong>期刊添加</strong></div>
   <div style="width:900px; margin:auto">
   <form action="sys/magazine/add" method="post" onsubmit="return check();">
	   <table class="table table-bordered" >
	     <tr>
	       <td nowrap="nowrap">期刊名称：${book['bookName'] }</td>
	       <td colspan="3"><input type="text" name="bookName" id="bookName" /></td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">期刊类型：${book['bookType'] }</td>
	       <td colspan="3">
		       <select name="bookType" id="bookType">
		       		<c:forEach items="${type }" var="t">
		       			<option value="${t['typeName'] }">${t['typeName'] }</option>
		       		</c:forEach>
		       </select>
	       </td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">期刊作者：${book['bookWriter'] }</td>
	       <td colspan="3"><input type="text" name="bookWriter" id="bookWriter"/></td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">出版社：${book['bookHouse'] }</td>
	       <td colspan="3"><input type="text" name="bookHouse" id="bookHouse"/></td>
	     </tr>
	     <tr>
	       <td nowrap="nowrap">库存：${book['bookNumber'] }</td>
	       <td colspan="3"><input type="text" name="bookNumber" id="bookNumber"/></td>
	     </tr>
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
	var bookNumber = $("#bookNumber").val();
	var bookName = $("#bookName").val();
	var bookType = $("#bookType").val();
	var bookWriter = $("#bookWriter").val();
	var bookHouse = $("#bookHouse").val();
	if(bookNumber==null||bookNumber==''){
		alert("请输入库存!");
		return false;
	}
	if(bookName==null||bookName==''){
		alert("请输入书籍名称!");
		return false;
	}
	if(bookType==null||bookType==''){
		alert("请输入书籍类型!");
		return false;
	}
	if(bookWriter==null||bookWriter==''){
		alert("请输入书籍作者!");
		return false;
	}
	if(bookHouse==null||bookHouse==''){
		alert("请输入出版社!");
		return false;
	}
	return true;
}
 
</script>



 
</body>
</html>
