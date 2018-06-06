<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的商品</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
	//为下架按钮绑定事件
	$(function() {
		$("#xiajia").click(function(){
			var pname = $("#pname").text();
			$.post(
				"${pageContext.request.contextPath}/productAction_deleteByPname",
				{"pname":pname},
				function(data){
					var product = data.result;
					alter(product);
					},
				"JSON"
					)
			});
	});
</script> -->	
</head>
<body>
<c:forEach items="${myproductlist}" var="myproduct">
			<div id="productList">
				<tr>
					<td>商品图片:<img src="${myproduct.pimg}" width="170" height="170" style="display: inline-block;"></td>
					<td id="pname">商品名称:${myproduct.pname}</td>
					<td>商品价格:${myproduct.price}</td>
					<td>上架日期:${myproduct.date}</td>
					<td>商品信息:${myproduct.info}</td>
					<td>商品数量:${myproduct.number}</td>
					<td>浏览量:${myproduct.counts}</td>
					<td id="xiajia"><a href="${pageContext.request.contextPath}/productAction_deleteByPname?pname=${myproduct.pname}">下架</a></td>
				</tr>
			</div>
			</c:forEach>
			<a href="${pageContext.request.contextPath}/addproduct.jsp">上架商品</a>
</body>
</html>