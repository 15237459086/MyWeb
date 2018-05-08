<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'select2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=basePath %>css/select2/select2.min.css" />

	<script type="text/javascript" src="<%=basePath %>js/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/select2/select2.min.js"></script>
	<script type="text/javascript">

	
	$(document).ready(function() {
		var basePath = $("#basePath").val();
		$("#select2").val("OR").select2();
	
		var data = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];
		$("#c01-select").select2({
		  data: data,
		  placeholder:'请选择',
		  allowClear:true
		}).val('2');
		
		
		$("#c01-select1").select2({
		placeholder:'请选择',
		  ajax: {
		    url: basePath+"select2AjaxServlet",
		    dataType: 'json',
		    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		    delay: 250,
		    data: function (params) {
		      return {
		        q: params.term,
		      };
		    },
		    processResults: function (data) {
			    var datas =[];
			    for(var i in data){
					var d=data[i];
					datas[i]={ id: i, text: d };
				}
			    return {
			      results: datas
			    };
		    },
		    cache: true
		  },
		  escapeMarkup: function (markup) { return markup; }, 
		  minimumInputLength: 1/* ,
		  templateResult: formatRepo, 
		  templateSelection: formatRepoSelection  */
		});
	});
	
	function btn_Click(){
		alert($("#c01-select1").val());
	}
	
	</script>
  </head>
  
  <body>
  	<input type="hidden" id="basePath" value="${basePath }"/>
  	 <div class="pages">
		 <select id="c01-select">
		 </select>
	     <select id="select2" class="js-example-basic-single">	       
		    <option value="AK">Alaska</option>
		    <option value="HI">Hawaii</option>
		    <option value="CA">California</option>
		    <option value="NV">Nevada</option>
		    <option value="OR">Oregon</option>
		    <option value="WA">Washington</option>
		    <option value="AZ">Arizona</option>
		    <option value="CO">Colorado</option>
		    <option value="ID">Idaho</option>
		    <option value="MT">Montana</option>
		    <option value="NE">Nebraska</option>
		    <option value="NM">New Mexico</option>
		    <option value="ND">North Dakota</option>
		    <option value="UT">Utah</option>
		    <option value="WY">Wyoming</option>
		    <option value="AL">Alabama</option>
		    <option value="AR">Arkansas</option>
		    <option value="IL">Illinois</option>
		    <option value="IA">Iowa</option>
		    <option value="KS">Kansas</option>
		    <option value="KY">Kentucky</option>
		    <option value="LA">Louisiana</option>
		    <option value="MN">Minnesota</option>
		    <option value="MS">Mississippi</option>
		    <option value="MO">Missouri</option>
		    <option value="OK">Oklahoma</option>
		    <option value="SD">South Dakota</option>
		    <option value="TX">Texas</option>
		    <option value="TN">Tennessee</option>
		    <option value="WI">Wisconsin</option>
		    <option value="CT">Connecticut</option>
		    <option value="DE">Delaware</option>
		    <option value="FL">Florida</option>
		    <option value="GA">Georgia</option>
		    <option value="IN">Indiana</option>
		    <option value="ME">Maine</option>
		    <option value="MD">Maryland</option>
		    <option value="MA">Massachusetts</option>
		    <option value="MI">Michigan</option>
		    <option value="NH">New Hampshire</option>
		    <option value="NJ">New Jersey</option>
		    <option value="NY">New York</option>
		    <option value="NC">North Carolina</option>
		    <option value="OH">Ohio</option>
		    <option value="PA">Pennsylvania</option>
		    <option value="RI">Rhode Island</option>
		    <option value="SC">South Carolina</option>
		    <option value="VT">Vermont</option>
		    <option value="VA">Virginia</option>
		    <option value="WV">West Virginia</option>
		</select>
		<select id="c01-select1" style="width: 200px" class="js-example-basic-single">
		
		</select>
		 <input type="button" id="btnClick" onclick="btn_Click()" value="点击"/>
    </div>
	
  </body>
</html>
