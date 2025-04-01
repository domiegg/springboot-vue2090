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
<link href="css/css/layout_login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/js/jquery1.9.0.min.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="/Scripts/DD_belatedPNG.js" ></script>
<script type="text/javascript">   DD_belatedPNG.fix('.leftmenu li a:hover,.topmenu .nav_content li a:hover,.index，.profle')  </script>
<![endif]-->

<script type="text/javascript">
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
<link type="text/css" rel="stylesheet" href="chrome-extension://cpngackimfmofbokmjmljamhdncknpmg/style.css"><script type="text/javascript" charset="utf-8" src="chrome-extension://cpngackimfmofbokmjmljamhdncknpmg/page_context.js"></script></head>
<body class="logincss" screen_capture_injected="true">
    <form name="form1" method="post" action="sys/login" id="form1" onsubmit="return check();">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTY4NzcyMTIyMmQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFCUlCdG5Mb2dpbm/jusprBUwojs/e1g3XddqM0/zA">
</div>

        <div class="logbox">
            <div class="loginbox">
                <table width="282" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tbody><tr>
                        <td>
                            <table width="282" border="0" cellspacing="0" cellpadding="0">
                                <tbody><tr>
                                    <td height="33" style="border: 1px solid #d9d9d9; background: url(image/image/ico_user.gif) no-repeat;
                                        padding-left: 30px; color: #999; font-size: 14px; font-weight: bold">
                                        用户名：
                                        <input name="account" type="text" maxlength="25" id="account" style="ime-mode: disabled;border: 0"></td>
                                </tr>
                            </tbody></table>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding-top: 12px">
                            <table width="282" border="0" cellspacing="0" cellpadding="0">
                                <tbody><tr>
                                    <td height="33" style="border: 1px solid #d9d9d9; background: url(image/image/ico_user.gif) no-repeat;
                                        padding-left: 30px; color: #999; font-size: 14px; font-weight: bold">
                                        密&nbsp;&nbsp;&nbsp;&nbsp;码：
                                        <input type="password" maxlength="50" name="password" id="password" style="ime-mode: disabled;border: 0"></td>
                                </tr>
                            </tbody></table>
                        </td>
                    </tr>
                    <tr>
                        <td height="50" valign="bottom">
                            <table border="0" align="center" cellpadding="0" cellspacing="0">
                                <tbody><tr>
                                    <td>
                                        <input type="image" name="IBtnLogin" id="IBtnLogin" border="0" src="image/image/btn_login.gif" style="border-width:0px;">
                                        
                                    </td>
                                    <td width="80" align="right">&nbsp;</td>
                                </tr>
                                <tr>
                                	<td><font color="red">${messageLogin }</font></td>
                                </tr>
                            </tbody></table>
                        </td>
                    </tr>
                </tbody></table>
            </div>
        </div> 
            <p>
                Copyright <span class="copyright">©</span> 图书管理系统</p>
    
<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWBALtoYu/DwLyj/OQAgK3jsrkBALespa2DzOg2rdbUYhFCjs7WwDEXQDcRCzw">
</div></form>
</body>
<script type="text/javascript">
	function check(){
		var account = $("#account").val();
		var account = $("#password").val();
		if(account==null||account==''){
			alert("请输入用户名和密码!");
			return false;
		}
		return true;
	}
</script>
</html>