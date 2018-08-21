<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- private int pid;//商品id
	private int uid;//卖家id
	private String pname;//商品名字
	private double price;//商品价格
	private String pimg;//商品图片
	private String kinds;//商品类型
	private Date date;//上架日期
	private Boolean issale;//是否卖出
	private String info;//商品描述
	private double counts;//点击数量
	private double number;//商品数量
	private String uphone;//卖家电话 -->
<title>添加商品页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/productAction_addProduct" method="post" enctype="multipart/form-data">
	商品名称<input type="text" name="pname"></br>
	商品价格<input type="text" name="price"></br>
	商品图片<input type="file" name="pimg"></br>
	商品类型<select name="kinds">
				<option value="学习资料" >学习资料</option>
				<option value="体育器材" >体育器材</option>
			</select></br>
	描述一下你的宝贝<input type="text" name="info"></br>
	商品数量<input type="text" name="numbers"></br>
	您的电话<input type="text" name="uphone">
	
	<input type="submit" value="上架"></br>
	</form>
</body>
</html>