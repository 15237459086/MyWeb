<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>dicom</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${basePath}js/jquery/jquery.min.js"></script>
	<script language="javascript" for="DICOM3AX_OCX" event="DCMmouseMove(X, Y, Button, Shift)" type="text/javascript">
	
	//document.getElementById("EventTextDiv01").innerHTML="DCMmouseMove(X:" + X + ", Y:" + Y + ", Button:" + Button + ", Shift:" + Shift +")";
	</script>
	<script language="javascript">	
	function OpenDICOMURL(axObject, sFileName)
	{
	  axObject.OpenURL(sFileName);
	}
	$(function(){
		var basePath = $("#basePath").val();
		OpenDICOMURL(DICOM3AX_OCX,"${basePath}I6QH4HEW.dcm");
	})
</script>
  </head>
 <body bgcolor="#ADADAD">
	<div style="text-align: center;">   
	<input type="hidden" id="basePath" value="${basePath }"/>
		<OBJECT classid="CLSID:9A2C58C4-4A44-48B4-B3C4-0756F0F2FA94" id="DICOM3AX_OCX">
			<PARAM NAME="ToolBarVisible" VALUE="false">
			<PARAM NAME="ImageOverlayOn" VALUE="True">
			<PARAM NAME="LicenseCode" VALUE="000520005900051000540005300055">
		</OBJECT>
	</div> 
	<!-- <input name="btAx1OpenDCMFile16" onclick=OpenDICOMURL(DICOM3AX_OCX,"${basePath}I6QH4HEW.dcm") type="button" value="Open CT URL 127"/>
 -->
</body>
</html>
