<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${basePath}js/jquery/jquery.min.js"></script>
	<script type="text/javascript">
		function refresh() {  
		    var url = $("#basePath").val() + "captchaServlet?number="+Math.random();  
		    $("#img").attr("src",url);  
		}
	</script>
  </head>
  
  <body>
  	<%-- <input type="hidden" id="basePath" value="${basePath }">
    <img id="img" src="<%=basePath%>captchaServlet" onclick="refresh()">
    <br/>
    <img id="img" src="<%=basePath%>mageWaterMarkServlet" onclick="refresh()">
    
    <object classid="clsid:CA8A9780-280D-11CF-A24D-444553540000"    
     width="990" height="700" border="0" top="-10" name="pdf">    
          <param name="toolbar" value="false">    
          <param name="_Version" value="65539">    
          <param name="_ExtentX" value="20108">    
          <param name="_ExtentY" value="10866">    
          <param name="_StockProps" value="0">  
          <param name="SRC" value="<%=basePath%>pdfServlet">    
   </object> --%>
   <iframe id="reportFrame" width="900" height="400" src="http://localhost:8080/MyWeb/ReportServer?reportlet=WorkBook5.cpt&formlet=aaa"></iframe>
 </body>
  </body>
</html>
