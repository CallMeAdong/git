<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册页面</title>
	<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui/jquery-easyui-1.3.0/locale/easyui-lang-zh_CN.js"></script>
<script>
 
$(function(){
	$("#uname").blur(function(){
		var isExist = true;		
		$.post("${pageContext.request.contextPath}/userAction_isExistUname",
				{"name":$("#uname").val()},
				function(data){	
					if(data=='0'){
						msg = "该用户名已经存在";
						$("#msg").css("color","red");							
						alert("该用户名已经存在");
						$("#save").attr('disabled',"true");
					}else{
						msg = "该用户名可以使用";
						$("#msg").css("color","red");
						$("#save").removeAttr("disabled");
						}
				$("#msg").text(msg); 
				});
		});
	$("#save").click(function(){
		alert("开始提交表单");
		//表单校验，如果通过，提交表单
		var v = $("#saveuserform").validate();
		alert("表单是否校验成功"+v);
		if(v){
			$("#saveuserform").submit();
			alert("保存成功");
			}
				
		});
	var reg = /^1[3|4|5|7|8][0-9]{9}$/;
	//扩展手机号校验规则
	$.extend($.fn.validatebox.defaults.rules, { 
		telephone: { 
			validator: function(value,param){ 
			return reg.test(value);
		}, 
			message: '手机号输入有误！' 
		}
		}); 
	});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<form id="saveuserform" action="${pageContext.request.contextPath}/userAction_regist" method="post">
	用户名<input type="text" name="uname" id="uname"><span id="msg"></span></br>
	密码<input type="password" name="pwd" id="pwd"></br>
	邮箱<input type="text" name="email" id="email"></br>
	学校<input type="text" name="school" id="school"></br>
	院系<input type="text" name="depart" id="depart"></br>
	年龄<input type="text" name="grade" id="grade"></br>
	联系qq<input type="text" name="qq" id="qq"></br>
	手机号码<input type="text" name="phone" id="phone" data-option="validType:'telephone'"
		class="easyui-validatebox" required="true"></br>	
	<input type="submit" value="现在注册" id="save" ></br>
	</form>
</body>
</html>