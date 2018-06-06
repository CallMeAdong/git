<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function ChangeCodeImg(){  
    var img1=document.getElementById("rightcode");  
    img1.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime(); //加时间戳防止缓存  
}  

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- private String uname;//用户名
	private String pwd;//密码
	private String email;//邮箱
	private String school;//学校
	private String depart;//系院
	private String grade;//年纪
	private String qq;//联系qq
	private String phone;//手机号码 -->
<title>注册页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/userAction_regist" method="post">
	用户名<input type="text" name="uname"></br>
	密码<input type="password" name="pwd"></br>
	邮箱<input type="text" name="email"></br>
	学校<input type="text" name="school"></br>
	院系<input type="text" name="depart"></br>
	年龄<input type="text" name="grade"></br>
	联系qq<input type="text" name="qq"></br>
	手机号码<input type="text" name="phone"></br>
	<div class="form-group">
		<label for="date" class="col-sm-2 control-label">验证码</label>
		<div class="col-sm-3">
			<input type="text" class="form-control">
		</div>
		<div class="col-sm-2">
			<img src="./image/captcha.jhtml" />
		</div>

	</div>
	
	<input type="submit" value="现在注册"></br>
	</form>
</body>
</html>